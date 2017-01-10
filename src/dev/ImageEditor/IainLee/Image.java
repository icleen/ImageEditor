package dev.ImageEditor.IainLee;

import java.util.ArrayList;

public class Image {
	
	private static ArrayList<Pixel> pixels;
	private int width, length;
	
	public Image( int width, int length ) {
		pixels = new ArrayList<>();
		this.width = width;
		this.length = length;
	}
	
	public void addPixel( int red, int green, int blue ) {
		Pixel pix = new Pixel( red, green, blue );
		pixels.add(pix);
	}

}
