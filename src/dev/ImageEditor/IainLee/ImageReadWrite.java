package dev.ImageEditor.IainLee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ImageReadWrite {

	public static Image read( String inFile ) throws FileNotFoundException, IOException {
		Scanner scanner = new Scanner(
				new BufferedReader(
						new FileReader( inFile ) ) );
		scanner.useDelimiter( "((#[^\\n]*\\n)|(\\s+))+" );
		
		scanner.nextLine(); // skip line of P3
		
		int width = scanner.nextInt();
		int height = scanner.nextInt();
		Image image = new Image( width, height );
		
		scanner.next(); // skip the 255 color max
		int red, green, blue;
		while( scanner.hasNext() ) {
			red = scanner.nextInt();
			green = scanner.nextInt();
			blue = scanner.nextInt();
			image.addPixel( red, green, blue );
		}
		
		scanner.close();
		return image;
	}
	
	public static void write( String outFile, Image image ) throws IOException {
		PrintWriter writer = new PrintWriter( 
				new BufferedWriter( 
						new FileWriter( outFile ) ) );
		
		writer.println( "P3" );
		writer.println( image.getWidth() + " " + image.getHeight() );
		writer.println( "255" );
		writer.print( image.toString() );
		
		writer.close();
	}

}
