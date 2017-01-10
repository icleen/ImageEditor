package dev.ImageEditor.IainLee;

import java.io.FileInputStream;
import java.io.IOException;


public class ImageEditor {
	
	enum Transform { grayscale, invert, emboss, motionblur };
	
	public final static String USAGE = "USAGE: java ImageEditor in-file out-file (grayscale|invert|emboss|motionblur motion-blur-length)";
	
	private static Image image;
	
	public static void main( String[] args ) {
		if( args.length < 3 || args.length > 5) {
			System.out.println( "Incorrect input format\n" + USAGE );
			return;
		}
		try {
			FileInputStream in = new FileInputStream( args[0] );
			
			int content = in.read();
			int width = in.read();
			int length = in.read();
			image = new Image( width, length );
			
			content = in.read();
			int r, g, b;
			while( content != -1 ) {
				r = (int) content;
				content = in.read();
				g = (int) content;
				content = in.read();
				b = (int) content;
				content = in.read();
				image.addPixel( r, g, b );
			}
			
			in.close();
		} catch (IOException e) {
			System.out.println( "file not found\n" + USAGE );
			e.printStackTrace();
		}
		
		
		
	}
}
