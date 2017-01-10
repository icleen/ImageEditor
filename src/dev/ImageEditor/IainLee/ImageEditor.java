package dev.ImageEditor.IainLee;

import java.io.FileInputStream;
import java.io.IOException;


public class ImageEditor {
	
	public final static String USAGE = "USAGE: java ImageEditor in-file out-file (grayscale|invert|emboss|motionblur motion-blur-length)";
	
	public static void main( String[] args ) {
		if( args.length != 3) {
			System.out.println( "Incorrect input format" );
			return;
		}
		try {
			FileInputStream in = new FileInputStream( args[0] );
			
			int content = in.read();
			while( content != -1 ) {
				System.out.print( (char) content );
				content = in.read();
			}
			
			in.close();
		} catch (IOException e) {
			System.out.println( "file not found\n" + USAGE );
			e.printStackTrace();
		}
	}
}
