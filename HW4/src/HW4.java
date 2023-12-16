import java.io.File;
	import java.io.IOException;
	import java.io.File;
	import java.io.FilenameFilter;
	import java.util.ArrayList;
	import java.util.List;
import java.util.Scanner;
	/**
	 * 
	 */

	/**
	 * @author MJ
	 *
	 */
	public class HW4 {

		/**
		 * @param args
		 */
		public static void main(String[] args) {
		//***********************************************************************************************
			// Keep lines 21 - 27 as is
	        //Location of the data folder which has all csv files
			String directoryPath = "src\\Data"; 
			//String that has the names of all csv files, without the directory.
	        String[] csvFileNames = findCSVFileNames(new File(directoryPath));
	    //***********************************************************************************************
	        //to do:
	        	// 1. print out the array of csv files
	        	// 2. access the array csvFileNames add the directory to each file name. So, the file Ant1.csv should become src/Data/Ant1.csv       	
	        	// 3. print out the array of csv files again after adding directory to each
	        	// 4. Go through the array again (using while / for loop), every time you access a cell, create an object of type Csv2Arff.
	        	// 5. Call the proper method to write the arff file for the current csv file in the loop.
	        	// 6. Ask use for name of a file to look in, and then column number and row number.
	        		// 6.1 Printout the value from that file.
	     // 1. Print the original array
	        PrintArray(csvFileNames);

	        // 2. Modify the array by adding the directory to each element
	        for (int i = 0; i < csvFileNames.length; i++) {
	            String filePath = "src" + File.separator + "Data" + File.separator + csvFileNames[i];
	            File file = new File(filePath);
	            csvFileNames[i] = file.getAbsolutePath();
	        }

	        // 3. Print the modified array
	        PrintArray(csvFileNames);

	        // 4. Iterate through the array and convert each CSV file to ARFF
	        for (String fileName : csvFileNames) {
	            Csv2Arff converter = new Csv2Arff(fileName);
	            converter.Convert2Arff(fileName);  // Pass the filename to the method
	        }
	        

	        // 5. Ask the user for file name, column number, and row number
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the file name: ");
	        String userFileName = scanner.nextLine().replace("(", "_").replace(")", ""); // Update the file name
	        System.out.print("Enter the column number: ");
	        int userColumn = scanner.nextInt();
	        System.out.print("Enter the row number: ");
	        int userRow = scanner.nextInt();

		// Call RetrieveCell and display the value
		String cellValue = Csv2Arff.RetrieveCell(userFileName, userRow, userColumn);
		System.out.println("Value at row " + userRow + ", column " + userColumn + ": " + cellValue);

		scanner.close();}
	
		/**
		 *  You need to code this
		 *  This method simply prints out the content of any given String array
		 * @param array: The array to print
		 */
		public static void PrintArray(String[] array)
		{
		 for(int j =0; j<array.length;j++) {
			 System.out.println(array[j]);
		 }
		
		}

		/**
		 * Keep as is.
		 * This method finds all csv files in a given directory
		 * @param directory: location of all csv files. This is passed from the main
		 * @return: Array of strings, each strring represents the name the location of a csv file
		 */
	    private static String[] findCSVFileNames(File directory) {
	        List<String> csvFileNames = new ArrayList<>();
	        addCSVFileNames(directory, csvFileNames);
	        return csvFileNames.toArray((new String[0]));
	    }

	    /**
	     * Keep as is.
	     * This method is magical. We Do not care what it does.
	     * @param directory
	     * @param csvFileNames
	     */
	    private static void addCSVFileNames(File directory, List<String> csvFileNames) {
	        if (directory.isDirectory()) {
	            // Define a filter for CSV files
	            FilenameFilter csvFilter = (dir, name) -> name.toLowerCase().endsWith(".csv");

	            // List all CSV files in the current directory
	            File[] files = directory.listFiles(csvFilter);
	            if (files != null) {
	                for (File file : files) {
	                    if (file.isFile()) {
	                        csvFileNames.add(file.getName());
	                    }
	                }
	            }

	            // List all directories in the current directory
	            File[] dirs = directory.listFiles(File::isDirectory);
	            if (dirs != null) {
	                for (File dir : dirs) {
	                    addCSVFileNames(dir, csvFileNames); // Recursive call
	                }
	            }
	        }
	    }}


	


