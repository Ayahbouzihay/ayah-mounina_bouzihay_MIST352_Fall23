// Ayha-mounina Bouzihay, mist352-01, HW3,used chatgpt, i just inputed the code from this class, i had to make many adjustments to make the code run to satisfy the requirements for the main, every time i needed to adjust i told chat gpt what i needed to adjust and it would help me but i still had to make a few more adjustment to fine tune it and to make it work properly.//
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author MJ
 *
 */
public class DataSummary {
	private String fileLocation;
	private double averageSalary;
	private String employeeName;
	private String employeeID;
	/**
	 * Keep as is
	 * Constructor. 
	 * @param file
	 * @throws FileNotFoundException 
	 */
	public DataSummary(String file) throws FileNotFoundException
	{
		this.fileLocation = file;
		this.averageSalary = getAverage();
		
	}
	
	/**
	 * You need to code this
	 * This method opens the employee data file and returns the average salary of all employees in the data
	 * @param strFile: Location of the text file from the main
	 * @return dblSum: the Average of all salaries
	 * @throws FileNotFoundException: if file is not found, this is thrown
	 */
	public double getAverage() throws FileNotFoundException
	{
		File myFile = new File(fileLocation);
        Scanner inputFile = new Scanner(myFile);
        double totalSalary = 0;
        int employeeCount = 0;
        while (inputFile.hasNextLine()) {
            String strData2Show = inputFile.nextLine();
            String[] dataParts = strData2Show.split(",");

            if (dataParts.length >= 6) {
                double salary = Double.parseDouble(dataParts[5].trim());
                totalSalary += salary;
                employeeCount++;
                }
	}
        inputFile.close();

        if (employeeCount > 0) {
            return totalSalary / employeeCount;
        } else {
            throw new FileNotFoundException("No valid data found in the file.");
        }
    }

	/**
	 * You need to code this
	 * This method should printout all employees and their IDs to the console.
	 * @throws FileNotFoundException: Thrown if file is not found.
	 */
	public void ViewEmployeeAndIDs() throws FileNotFoundException
	{
		File myFile = new File(fileLocation);
	    Scanner inputFile = new Scanner(myFile);

	    // Display header
	    System.out.println("Employee Information:");

	    while (inputFile.hasNextLine()) {
	        String strData2Show = inputFile.nextLine();
	        String[] dataParts = strData2Show.split(",");

	        if (dataParts.length >= 6) {
	            String employeeName = dataParts[0].trim();
	            String employeeID = dataParts[3].trim();
	            
	            // Display employee information to the console
	            System.out.printf("Name: %-20s ID: %s%n", employeeName, employeeID);
	           
	            
	        }
	    }

	    // Close the file
	    inputFile.close();
	}

    

	
	
	/**
	 * You need to code this
	 * This method accepts an employee name (first, last, or both) and searches for all employee with that name
	 * It should printout all employee's info to a GUI, otherwise, it should printout Not Found
	 * @param strEmployee: Employee name 
	 * @throws FileNotFoundException: Thrown if file is not found.
	 */
	public void SearchEmployee(String strEmployee) throws FileNotFoundException
	{
		File myFile = new File(fileLocation);
	    Scanner inputFile = new Scanner(myFile);

	    boolean employeeFound = false;
	    StringBuilder employeeInfo = new StringBuilder();

	    while (inputFile.hasNextLine()) {
	        String strData2Show = inputFile.nextLine();
	        String[] dataParts = strData2Show.split(",");

	        
	        String employeeName = dataParts[0].trim();

	        if (employeeName.contains(strEmployee)) {
	            // Employee found, append information to StringBuilder
	            employeeInfo.append("Employee Name: ").append(dataParts[0].trim()).append("\n");
	            employeeInfo.append("Date of Birth: ").append(dataParts[1].trim()).append("\n");
	            employeeInfo.append("Position: ").append(dataParts[2].trim()).append("\n");
	            employeeInfo.append("Employee ID: ").append(dataParts[3].trim()).append("\n");
	            employeeInfo.append("Email: ").append(dataParts[4].trim()).append("\n");
	            employeeInfo.append("Salary: ").append(dataParts[5].trim()).append("\n\n");

	            employeeFound = true;
	        }
	    }

	    inputFile.close();

	    if (employeeFound) {
	        // Display employee information in a message dialog
	        JOptionPane.showMessageDialog(null, employeeInfo.toString(), "Employee Information", JOptionPane.INFORMATION_MESSAGE);
	    } else {
	        JOptionPane.showMessageDialog(null, "Employee not found", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	         
	         
	


    
	
	/**
	 * You need to code this
	 * This method accepts an employee role (i.e., position) and views for all employee in that role
	 * It should printout all employee's info to a GUI, otherwise, it should printout Not Found
	 * @param strRole: Employee role 
	 * @throws FileNotFoundException: Thrown if file is not found.
	 */
	public void ViewEmployeeForRole(String strRole) throws FileNotFoundException
	{
		    File myFile = new File(fileLocation);
		    Scanner inputFile = new Scanner(myFile);

		    boolean found = false;
		    StringBuilder resultMessage = new StringBuilder("Employees with Role '" + strRole + "':\n");

		    while (inputFile.hasNextLine()) {
		        String strData2Show = inputFile.nextLine();
		        String[] dataParts = strData2Show.split(",");

		        if (dataParts.length >= 6) {
		            String employeeRole = dataParts[2].trim();

		            if (employeeRole.equalsIgnoreCase(strRole)) {
		                // Employee found with the specified role
		                found = true;
		                resultMessage.append("Name: ").append(dataParts[0].trim()).append("\n");
		                resultMessage.append("DOB: ").append(dataParts[1].trim()).append("\n");
		                resultMessage.append("Role: ").append(dataParts[2].trim()).append("\n");
		                resultMessage.append("ID: ").append(dataParts[3].trim()).append("\n");
		                resultMessage.append("Email: ").append(dataParts[4].trim()).append("\n");
		                resultMessage.append("Salary: ").append(dataParts[5].trim()).append("\n\n");
		            }
		        }
		    }

		    inputFile.close();

		    if (found) {
		        // Display employee information using GUI
		        JOptionPane.showMessageDialog(null, resultMessage.toString());
		    } else {
		        // No employees found with the specified role
		        JOptionPane.showMessageDialog(null, "No employees found with Role '" + strRole + "'.");
		    }
		}


	/**
	 * Keep as is.
	 * This method displays the distinct roles in the text file
	 * @throws FileNotFoundException 
	 */
	public void ViewRoles() throws FileNotFoundException
	{	
		       
		        File myFile = new File(fileLocation);
		        Scanner inputFile = new Scanner(myFile);
		        Set<String> distinctRoles = new HashSet<>();

		        while(inputFile.hasNextLine()) {
		            String strData2Show = inputFile.nextLine();
		            // Splitting the line by comma
		            String[] dataParts = strData2Show.split(",");
		            // The role is the third element in the array (index 2)
		            distinctRoles.add(dataParts[2]);
		        }
		        inputFile.close();
		        String strRole="";
		        // Displaying distinct roles
		        for (String role : distinctRoles) {
		        	strRole = strRole + role + "\n";
		            //System.out.println(role);
		        }
		        JOptionPane.showMessageDialog(null, strRole);
		    }
	
}
