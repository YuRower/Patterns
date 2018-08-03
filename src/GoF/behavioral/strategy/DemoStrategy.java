package GoF.behavioral.strategy;

import java.net.MalformedURLException;
import java.net.URL;

public class DemoStrategy {
	public static void main(String[] args) throws MalformedURLException {
		URL fileUrl = new URL("image_file_url");
		Convert convertToJpg = new Convert(new ConversionJpg());
		convertToJpg.convert(fileUrl);
		Convert convertToGif = new Convert(new ConversionGif());
		convertToGif.convert(fileUrl);
		Convert convertToPng = new Convert(new ConversionPng());
		convertToPng.convert(fileUrl);
	}
}

class Convert {
	private IConversion conversion;

	public Convert(IConversion conversion) {
		this.conversion = conversion;
	}

	public void convert(URL fileImg) {
		conversion.convert(fileImg);
	}
}

class ConversionPng implements IConversion {
	@Override
	public void convert(URL urlFileImg) {
		System.out.println("PNG Conversion");
	}
}

class ConversionJpg implements IConversion {
	@Override
	public void convert(URL urlFileImg) {
		System.out.println("JPG Conversion");
	}
}

class ConversionGif implements IConversion {
	@Override
	public void convert(URL urlFileImg) {
		System.out.println("GIF Conversion");
	}
}

interface IConversion {
	void convert(URL urlFileImg);
}