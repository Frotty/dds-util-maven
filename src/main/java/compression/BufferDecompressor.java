package compression;

import ddsutil.ByteBufferedImage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;

public abstract class BufferDecompressor {

	
	protected ByteBuffer uncompressedBuffer;
	protected Dimension dimension;
	
	
	/**
	 * @return
	 */
	public BufferedImage getImage() {
		
		BufferedImage image = new ByteBufferedImage(
				this.dimension.width, 
				this.dimension.height, 
				this.uncompressedBuffer);
		return image;
	}
}
