package util;

import javax.imageio.ImageIO;
import java.io.File;

public class ImageIOUtils {

	/**
	 * @param file
	 * @return
	 */
	public static boolean isImageIOSupported(final File file) {
		String[] supportedMIMETypes = ImageIO.getReaderFormatNames();
		for (int j = 0; j < supportedMIMETypes.length; j++) {
			if(FileUtil.getFileSuffix(file).contains(supportedMIMETypes[j]))
				return true;
		}
		return false;
	}
	
}
