package dev.ImageEditor.IainLee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ImageReadWrite {

	public Image read( String fileName ) throws FileNotFoundException {
		File inFile = new File( fileName );
		Scanner scanner = new Scanner(
				new BufferedReader(
						new FileReader( fileName ) ) ).useDelimiter( "((#[^\\n]*\\n)|(\\s+))+" );
		
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
	
	public void write( String fileName ) {
		File outFile = new File( fileName );
		PrintWriter writer = new PrintWriter( 
				new BufferedWriter( 
						new FileWriter( outFile ) ) );
	}

}
