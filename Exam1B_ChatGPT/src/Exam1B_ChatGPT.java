/**
 * 
 */
// Author:[Your Name]
//Date: [Date]
//Assessment: Exam1B
//Description: This program prompts the user for a text input,

import java.util.Scanner;

/**
 * 
 */
public class Exam1B_ChatGPT {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Display welcome message
		System.out.println("Welcome to Exam1B!");

		    // Ask user for text input
		    System.out.print("Please enter a text: ");
		    Scanner scanner = new Scanner(System.in);
		    String input = scanner.nextLine();

		    // Print out the length of the provided input
		    int length = input.length();
		    System.out.println("The length of the input is: " + length);

		    // Ask user for a character to find in the input
		    System.out.print("Please enter a character to find: ");
		    char character = scanner.next().charAt(0);

		    // Print out the location of the first occurrence of the character
		    int index = input.indexOf(character);
		    System.out.println("The first occurrence of '" + character + "' is at index: " + index);

		    // Close the scanner
		    scanner.close();
		}
	}



