package dev.ImageEditor.IainLee;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


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
			InputStream inStream = Files.newInputStream( Paths.get( args[0] ) );
			Reader in = new InputStreamReader( inStream, StandardCharsets.US_ASCII );
			
			List<String> lines = Files.readAllLines( Paths.get(args[0]), StandardCharsets.US_ASCII );
			image = new Image( 1000, 750 );
			int i;
			for( i = 0; i < lines.size(); i++ ) {
				System.out.println( lines.get(i) );
				if( isNum( lines.get(i) ) ) {
					break;
				}
			}
			if( i >= lines.size() ) {
				System.out.println( "this is an invalid file" );
				return;
			}
			
			
			in.close();
		} catch (IOException e) {
			System.out.println( "file not found" );
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
			image.motionblur( args[3] );
		}else {
			System.out.println( "Incorrect input format\n" + USAGE );
			return;
		}
		
//		try {	
//			FileOutputStream out = new FileOutputStream( args[1] );
//			
//			out.write( Integer.parseInt("P3 ") );
//			out.write( image.getWidth() );
//			out.write( Integer.parseInt(" ") );
//			out.write( image.getHeight() );
//			out.write( Integer.parseInt(" ") );
//			
//			out.close();
//		} catch (FileNotFoundException e) {
//			System.out.println( "Cannot find or create the specified file!" );
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println( "Could not write the file out" );
//			e.printStackTrace();
//		}
		
	}

	private static boolean isNum( String s ) {
		char c = s.charAt(0);
		System.out.println( c );
		switch( c ) {
		case '0':
			return true;
		case '1':
			return true;
		case '2':
			return true;
		case '3':
			return true;
		case '4':
			return true;
		case '5':
			return true;
		case '6':
			return true;
		case '7':
			return true;
		case '8':
			return true;
		case '9':
			return true;
		}
		return false;
	}
	
}
