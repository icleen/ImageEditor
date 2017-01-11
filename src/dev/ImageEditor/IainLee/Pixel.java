package dev.ImageEditor.IainLee;


public class Pixel {
	
	private final int MAX_COLOR = 255;
	private final int MIN_COLOR = 0;
	
	private int red;
	private int green;
	private int blue;
	
	public Pixel( int red, int green, int blue ) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public void grayscale() {
		int avg = (red + green + blue) / 3;
		red = avg;
		green = avg;
		blue = avg;
	}
	
	public void invert() {
		red = 255 - red;
		green = 255 - green;
		blue = 255 - blue;
		if( blue < 0 || blue > 255 || red < 0 || red > 255 || green < 0 || green > 255 ) {
			System.out.println( "one of the colors is off" );
		}
	}
	
	public void emboss() {
		
	}
	
	public void motionblur( int degree ) {
		
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	public String toString() {
		String out = red + "\n" + green + "\n" + blue + "\n";
		return out;
	}
	
}
