/**
 * 
 */
package model;

import com.github.memo33.jsquish.Squish;
import compression.DXTBufferCompressor;
import ddsutil.PixelFormats;
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
		Squish.CompressionType compressionType = PixelFormats.getSquishCompressionFormat(pixelformat);
		return this.getDXTCompressedBuffer(compressionType );
	}
	
	/**
	 * @param bi
	 * @param compressionType
	 * @return
	 */
	@Override
	public ByteBuffer compress(final BufferedImage bi, 
			final Squish.CompressionType compressionType) {
		DXTBufferCompressor compi = new DXTBufferCompressor(bi, compressionType);
		return compi.getByteBuffer();
	}

}
