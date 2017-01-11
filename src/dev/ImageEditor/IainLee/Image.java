package dev.ImageEditor.IainLee;

import java.util.ArrayList;

public class Image {
	
	private static Pixel[][] pixels;
	private int width, height;
	private int col, row;
	
	public Image( int width, int height ) {
		pixels = new Pixel[height][width];
		this.width = width;
		this.height = height;
		col = 0;
		row = 0;
	}
	
	public void addPixel( int red, int green, int blue ) {
		try {
			Pixel pix = new Pixel( red, green, blue );
			pixels[row][col] = pix;
			col++;
			if( col >= width ) {
				row++;
				col = 0;
			}
		} catch( ArrayIndexOutOfBoundsException e ) {
			System.out.println( "the row or col was out of bounds for some reason" );
			e.printStackTrace();
		}
	}
	
	public void grayscale() {
		System.out.println( "gayscale" );
		
	}
	
	public void invert() {
		System.out.println( "invert" );
	}
	
	public void emboss() {
		System.out.println( "emboss" );
	}
	
	public void motionblur( String degree ) {
		System.out.println( "motionblur" );
		int deg = Integer.parseInt( degree );
		
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public ArrayList<String> pixelOut() {
		ArrayList<String> output = new ArrayList<>();
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				output.add( pixels[i][j].toString()  );
			}
		}
		return output;
	}
}
