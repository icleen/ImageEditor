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
		for( int i = 0; i < height; i++ ) {
			for( int j = 0; j < width; j++ ) {
				pixels[i][j].grayscale();
			}
		}
	}
	
	public void invert() {
		System.out.println( "invert" );
		for( int i = 0; i < height; i++ ) {
			for( int j = 0; j < width; j++ ) {
				pixels[i][j].invert();
			}
		}
	}
	
	public void emboss() {
		System.out.println( "emboss" );
		try {
			int reddif, grndif, bludif;
			for( int i = height - 1; i > 0; i-- ) {
				for( int j = width - 1; j > 0; j-- ) {
					reddif = pixels[i][j].getRed() - pixels[i - 1][j - 1].getRed();
					grndif = pixels[i][j].getGreen() - pixels[i - 1][j - 1].getGreen();
					bludif = pixels[i][j].getBlue() - pixels[i - 1][j - 1].getBlue();
					pixels[i][j].setRed( maxDif( reddif, grndif, bludif ) );
					pixels[i][j].setGreen( maxDif( reddif, grndif, bludif ) );
					pixels[i][j].setBlue( maxDif( reddif, grndif, bludif ) );
				}
			}
			for( int j = width - 1; j > 0; j-- ) {
				pixels[0][j].setRed(128);
				pixels[0][j].setGreen(128);
				pixels[0][j].setBlue(128);
			}
			for( int j = height - 1; j >= 0; j-- ) {
				pixels[j][0].setRed(128);
				pixels[j][0].setGreen(128);
				pixels[j][0].setBlue(128);
			}
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println( "it went out of bounds in emboss" );
			e.printStackTrace();
		}
		
	}
	
	private int maxDif( int a, int b, int c ) {
		int v = 0;
		int a2 = a;
		int b2 = b;
		int c2 = c;
		if( a < 0 ) {
			a2 *= -1;
		}if( b < 0 ) {
			b2 *= -1;
		}if( c < 0 ) {
			c2 *= -1;
		}
		if( a2 > b2 && a2 > c2 ) {
			v = a;
		}else if( b2 > c2 && b2 > a2 ) {
			v =  b;
		}else {
			v = c;
		}
		v += 128;
		if( v < 0 ) {
			v = 0;
		}else if( v > 255 ) {
			v = 255;
		}
		return v;
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
