/**
 * 
 */
package model;

import com.github.memo33.jsquish.Squish;
import ddsutil.ByteBufferedImage;

import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;


/**
 * TextureMap without MipMaps
 * @author danielsenff
 *
 */
public class SingleTextureMap extends AbstractTextureMap {

	BufferedImage bi;
	
	/**
	 * @param bi
	 */
	public SingleTextureMap(final BufferedImage bi) {
		super();
		this.bi = bi;
	}
	
	/**
	 * @return 
	 */
	public BufferedImage getData() {
		return this.bi;
	}
	
	/* (non-Javadoc)
	 * @see ddsutil.DDSUtil.AbstractMipMaps#getDXTCompressedBuffer(gr.zdimensions.jsquish.Squish.CompressionType)
	 */
	@Override
	public ByteBuffer[] getDXTCompressedBuffer(final Squish.CompressionType compressionType) {
		ByteBuffer[] buffer = new ByteBuffer[1];
		buffer[0] = super.compress(bi, compressionType);
		return buffer;
	}

	

	/* (non-Javadoc)
	 * @see ddsutil.DDSUtil.AbstractMipMaps#getHeight()
	 */
	@Override
	public int getHeight() {
		return this.bi.getHeight();
	}

	/* (non-Javadoc)
	 * @see ddsutil.DDSUtil.AbstractMipMaps#getWidth()
	 */
	@Override
	public int getWidth() {
		return this.bi.getWidth();
	}

	/* (non-Javadoc)
	 * @see ddsutil.DDSUtil.AbstractTextureMap#getUncompressedBuffer()
	 */
	@Override
	public ByteBuffer[] getUncompressedBuffer() {
		ByteBuffer[] mipmapBuffer = new ByteBuffer[1];
		mipmapBuffer[0] = ByteBuffer.wrap(ByteBufferedImage.convertBIintoARGBArray(this.bi));
		return mipmapBuffer;
	}

}
