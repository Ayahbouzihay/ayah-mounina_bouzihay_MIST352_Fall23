import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.PrintWriter;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;
	import java.util.Scanner;
	import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

	/**
	 * This class allows you to convert a csv file to arff file.
	 * @author MJ
	 *
	 */
	public class Csv2Arff {
		private String csvFileLocation;
		
		/**
		 * Keep as is. 
		 * Constructor.
		 * @param Location
		 */
		public Csv2Arff(String Location)
		{
			csvFileLocation=Location;
		}
		
		/**
		 * You need to code this
		 * This method accepts a name of a csv file and it writes an arff file from the csv file
		 * Writing arff file is similar to writing any .txt file. Just make sure the arff file name ends with .arff
		 * @param theLocation: The name and location of any csv file
		 */
		public void Convert2Arff(String Location)
		{ String myLine;
        ArrayList<ArrayList<String>> myList = new ArrayList<>();

        try {
            FileReader fr = new FileReader(Location);
            BufferedReader br = new BufferedReader(fr);

            while ((myLine = br.readLine()) != null) {
                String[] Line = myLine.split(",");
                ArrayList<String> myArray = new ArrayList<>();

                for (int j = 1; j < Line.length; j++) {
                myArray.add(Line[j] + ",");
                }

                myList.add(myArray);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
            return; // Exit the method if an error occurs
        }

        System.out.println(myList.get(1).get(33));

        try {
            PrintWriter writeArrf = new PrintWriter(String.format("C:\\Users\\ayahb\\eclipse-workspace\\HW4\\Data\\%s.arff", Location.substring(0, 13)));

            writeArrf.write(String.format("@relation %s \n", Location));

            for (int i = 1; i < myList.get(0).size() - 3; i++) {
                writeArrf.print(String.format("@attribute %s numeric\n", myList.get(0).get(i)));
            }

            writeArrf.print(String.format("@attribute %s {TRUE,FALSE} \n", myList.get(0).get(31)));
            writeArrf.print(String.format("@attribute %s {TRUE,FALSE} \n", myList.get(0).get(32)));
            writeArrf.print(String.format("@attribute %s {TRUE,FALSE} \n", myList.get(0).get(33)));

            writeArrf.print("@data \n");

            for (int i = 1; i < myList.size(); i++) {
                for (int j = 1; j < myList.get(0).size(); j++) {
                    writeArrf.print(myList.get(i).get(j).toString());
                }
                writeArrf.print("\n");
            }

            writeArrf.close();
        } catch (IOException e) {
            System.out.println("Error writing ARFF file: " + e.getMessage());
        }

        System.out.println("Conversion to ARFF completed for: " + csvFileLocation);
    }

    public static String RetrieveCell1(String theFile, int row, int column) {
        String strData2Return = "";
        int n = 0;
        ArrayList<ArrayList<String>> myList = new ArrayList<>();

        // The rest of the method implementation for RetrieveCell
        // ...
        return strData2Return;
    }

			
		
		/**
		 * This method should red the text file to a two dimensional array of Strings.
		 * This method should return the data given in a specific row and column in the two dimensional array
		 * @param theFile: name of the csv file to open 
		 * @param row: row number in the two dimensional array
		 * @param column: column number in the two dimensional array
		 * @return strData2Return: the data in the [column][row]
		 */
		public static String RetrieveCell(String theFile, int row, int column)
		{
			String strData2Return="";
			 int n=0;
				ArrayList<ArrayList<String>> myList = new ArrayList<>();
				File myarrffile = new File(theFile);
				try {
					Scanner scn =new Scanner( myarrffile);
					scn.hasNextLine();
					while(scn.hasNextLine()) {
						String myLine =scn.next();
						String[] values = myLine.split(",");
						 for(int i=1;i<values.length; i++) {
						 myList.get(n).add(values[i]); 
						 }
						 n ++;
							
						 for(int i= 1; i< myList.size() ; i++) {
							 for(int j=0; j < myList.get(i).size(); j++) { 
							 strData2Return = strData2Return + myList.get(i).get(j);}
						 }
							 
					}
					scn.close();
				}catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			
		}
				return strData2Return;
	}
	}
	 






