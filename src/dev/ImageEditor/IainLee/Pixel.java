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
		red = MAX_COLOR - red;
		green = MAX_COLOR - green;
		blue = MAX_COLOR - blue;
		if( blue < MIN_COLOR || blue > MAX_COLOR || red < MIN_COLOR || red > MAX_COLOR || green < MIN_COLOR || green > MAX_COLOR ) {
			System.out.println( "one of the colors is off" );
		}
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
