package dev.ImageEditor.IainLee;

import java.io.IOException;
import java.io.PrintWriter;
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
			System.out.println( args[0] );
			List<String> lines = Files.readAllLines( Paths.get(args[0]), StandardCharsets.US_ASCII );
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
			String s = lines.get( i++ );
			String[] params = s.split( " " );
			int width, height;
			width = Integer.parseInt( params[0] );
			height = Integer.parseInt( params[1] );
			System.out.println( width + " " + height );
			image = new Image( width, height );
			int r, g, b;
			while( i < lines.size() ) {
				r = Integer.parseInt( lines.get( i++ ) );
				if( i >= lines.size() ) {
					break;
				}
				g = Integer.parseInt( lines.get( i++ ) );
				if( i >= lines.size() ) {
					break;
				}
				b = Integer.parseInt( lines.get( i++ ) );
//				System.out.println( r + " " + g + " " + b);
				image.addPixel( r, g, b );
			}
			
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
			image.motionblur( args[3] );
		}else {
			System.out.println( "Incorrect input format\n" + USAGE );
			return;
		}
		
		try {
			PrintWriter out = new PrintWriter( Files.newBufferedWriter( Paths.get(args[1]), StandardCharsets.US_ASCII ) );
			out.println( "P3" );
			out.println( "# my " + args[2] + " version" );
			System.out.println( "outputting" );
			out.println( image.toString() );
			
			out.close();
		} catch( IOException e ) {
			System.out.println( "output file not found or could not be created" );
			e.printStackTrace();
		}
		
	}

	private static boolean isNum( String s ) {
		char c = s.charAt(0);
//		System.out.println( c );
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
