package dev.ImageEditor.IainLee;

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
			row++;
			col++;
			if( row >= height ) {
				row = 0;
			}if( col >= width ) {
				col = 0;
			}
		} catch( ArrayIndexOutOfBoundsException e ) {
			System.out.println( "the row or col was out of bounds for some reason" );
			e.printStackTrace();
		}
	}
	
	public void grayscale() {
		
	}
	
	public void invert() {
		
	}
	
	public void emboss() {
		
	}
	
	public void motionblur( String degree ) {
		int deg = Integer.parseInt( degree );
		
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
