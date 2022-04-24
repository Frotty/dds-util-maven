/**
 * 
 */
package model;

import compression.DXTBufferCompressor;
import ddsutil.PixelFormats;
import gr.zdimensions.jsquish.Squish.CompressionType;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;



/**
 * Abstract TextureMap
 * @author danielsenff
 *
 */
public abstract class AbstractTextureMap implements TextureMap {

	public AbstractTextureMap() {}
	
	@Override
	public ByteBuffer[] getDXTCompressedBuffer(final int pixelformat) 
			throws Exception {
		CompressionType compressionType = PixelFormats.getSquishCompressionFormat(pixelformat);
		return this.getDXTCompressedBuffer(compressionType );
	}
	
	/**
	 * @param bi
	 * @param compressionType
	 * @return
	 */
	@Override
	public ByteBuffer compress(final BufferedImage bi, 
			final CompressionType compressionType) {
		DXTBufferCompressor compi = new DXTBufferCompressor(bi, compressionType);
		return compi.getByteBuffer();
	}

}
