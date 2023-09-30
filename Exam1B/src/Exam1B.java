/**
 * 
 */
//Ayah-Mounina Bouzihay, 09/29/2023, Exam1B, the program will ask the user to input a text and than it will retrieve where a specific character is found for the first time in the program.

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Exam1B {


	
	public static void main(String[] args) {
		//Display welcome message
		JOptionPane.showMessageDialog(null,"Wlcome");
		Scanner Keyboard = new Scanner(System.in);
		String userInput = JOptionPane.showInputDialog("Enter Text");
		int stringLength;
		//Printout the length of the provided input
		stringLength = userInput.length();
		System.out.println("The length of your text is"+ stringLength);
		//Ask user for a character to find in the input
		System.out.println("Enter charcter to find in Text");
		char userCharInput = Keyboard.next().charAt(0);
		int index = userInput.indexOf(userCharInput);
		//Printout the location of the first occurrence of that character
		System.out.println("The first occurance of" +  userCharInput  +  "is at"  +  index);
		//End
		Keyboard.close();
		
		
		
		
		




}

}
