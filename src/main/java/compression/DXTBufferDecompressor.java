/**
 * 
 */
package compression;

import com.github.memo33.jsquish.Squish;

import java.awt.*;
import java.nio.ByteBuffer;


/**
 * Decompressor for DXT-Compression
 * @author danielsenff
 *
 */
public class DXTBufferDecompressor extends BufferDecompressor{

	protected Squish.CompressionType compressionType;
	

	/**
	 * @param compressedBuffer
	 * @param width
	 * @param height
	 * @param pixelformat
	 */
	public DXTBufferDecompressor(final ByteBuffer compressedBuffer, 
			final int width, final int height, Squish.CompressionType type) {
		this(compressedBuffer, new Dimension(width, height), type);
	}
	
	
	/**
	 * @param compressedData
	 * @param width
	 * @param height
	 * @param compressionType
	 */
	public DXTBufferDecompressor(byte[] compressedData, int width, int height,
			Squish.CompressionType compressionType) {
		this(ByteBuffer.wrap(compressedData), new Dimension(width, height), compressionType);
	}
	
	/**
	 * @param compressedBuffer
	 * @param dimension
	 * @param type 
	 */
	public DXTBufferDecompressor(final ByteBuffer compressedBuffer, 
			final Dimension dimension, Squish.CompressionType type) {
		this.uncompressedBuffer = 
			squishDecompressBuffer(compressedBuffer, dimension.width, dimension.height, type);
		this.dimension = dimension;
		this.compressionType = type;
		
	}


	/**
	 * Compresses a Byte-Array into a DXT-compressed {@link ByteBuffer}
	 * If the type is null, it returns the uncompressed ByteBuffer.
	 * 
	 * Decompresses a DXT-compressed Byte-Array and returns a byte-Array.
	 * If the {@link Squish.CompressionType} is null, it return the source data.
	 * @param compressedData
	 * @param width
	 * @param height
	 * @param type
	 * @return byte[]
	 * @throws OutOfMemoryError
	 */
	public static byte[] squishDecompressToArray(final byte[] compressedData, final int width, final int height,
			final Squish.CompressionType type) throws OutOfMemoryError {

		//Use JSquish to decompress images. Then bind as normal. 
		if (type != null) {
			byte[] decompressedData = Squish.decompressImage(null, width, height, compressedData, type);
			return decompressedData;
		}
		
		return compressedData;
		
	} 
	

	
	/**
	 * Decompresses a DXT-compressed Byte-Array and returns a ByteBuffer
	 * If the {@link Squish.CompressionType} is null, it return the source data
	 * @param compressedData
	 * @param width
	 * @param height
	 * @param type
	 * @return
	 * @throws OutOfMemoryError
	 */
	public static ByteBuffer squishDecompress(final byte[] compressedData, final int width, final int height,
			final Squish.CompressionType type) throws OutOfMemoryError {
		
		return ByteBuffer.wrap(squishDecompressToArray(compressedData, width, height, type));
	} 
	
	
	
	/**
	 * Decompresses a DXT-compressed {@link ByteBuffer} 
	 * @param byteBuffer
	 * @param width
	 * @param height
	 * @param type
	 * @return
	 * @throws OutOfMemoryError
	 */
	private static ByteBuffer squishDecompressBuffer(final ByteBuffer byteBuffer, 
			final int width, final int height,
			final Squish.CompressionType type) throws OutOfMemoryError {
		
		byte[] data = new byte[byteBuffer.capacity()]; 
		byteBuffer.get(data); 
		 
		return squishDecompress(data, width, height, type);
	} 
	
}
