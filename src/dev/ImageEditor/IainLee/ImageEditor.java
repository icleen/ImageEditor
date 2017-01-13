package dev.ImageEditor.IainLee;

import java.io.IOException;


public class ImageEditor {
	
	enum Transform { grayscale, invert, emboss, motionblur };
	
	public final static String USAGE = "USAGE: java ImageEditor in-file out-file (grayscale|invert|emboss|motionblur motion-blur-length)";
	
	private static Image image;
	
	public static void main( String[] args ) {
		if( args.length < 3 || args.length > 4 ) {
			System.out.println( "Incorrect input format\n" + USAGE );
			return;
		}
		try {
			image = ImageReadWrite.read( args[0] );
		} catch (IOException e) {
			System.out.println( "input file not found" );
			e.printStackTrace();
		}
		
		if( args[2].equals("grayscale") ) {
			image.grayscale();
		}else if( args[2].equals("invert") ) {
			image.invert();
		}else if( args[2].equals("emboss") ) {
			image.emboss();
		}else if( args[2].equals("motionblur") ) {
			if( args[3] == null ) {
				System.out.println( "Incorrect input format\n" + USAGE );
				return;
			}
			int check = Integer.parseInt( args[3] );
			if( check <= 0 ) {
				System.out.println( "Incorrect input format\n" + USAGE );
				return;
			}
			image.motionblur( args[3] );
		}else {
			System.out.println( "Incorrect input format\n" + USAGE );
			return;
		}
		
		try {
			ImageReadWrite.write( args[1], image );
		} catch( IOException e ) {
			System.out.println( "output file not found or could not be created" );
			e.printStackTrace();
		}
		
	}
	
}
