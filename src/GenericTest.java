// James Edonnard Kibii
// Matrikel-Nr: 296096
// ja571kib@htwg-konstanz.de

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Serializable;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane; 

public abstract class GenericTest implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Attributes & Variables
	private String name; 
    protected Date testDate;
    
    public abstract String typeofTest();
    public abstract String analyzeValues();		//abstract method analyzeValues()
    public abstract String nameChanger(String changer);
    
//-------------------------------------------------------------------------------------------------------------------------
   
    //Modul 4: Teil 4 Polymorphie der Struktur der Testklassen
    //Methode startTest (Hier soll nur das Testdatum gesetzt werden)
    		public void startTest() {
    				testDate = new Date();
    		}
    		
//-------------------------------------------------------------------------------------------------------------------------   
//-------------------------------------------------------------------------------------------------------------------------
    //Modul 2: Teil 2 Feld zur Verwaltung der Messwerte
    //Reference of an Array of Type Measurement
    protected Measurement[] Measurements;
    
    public Measurement[] getMeasurements() { 		//Getter for the array 'Measures'
    	return Measurements;
    }
    
    //Method: Read Values
    public void readValues() {
    	JFileChooser selected = new JFileChooser();
    	if(selected.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
    	{
    		try {
    			File file = selected.getSelectedFile();
    			Reader theReader = new FileReader (file);
    			BufferedReader theBufferReader = new BufferedReader(theReader);
    			
    			for(int i=0; i<Measurements.length; i++) {
    				String theLine = theBufferReader.readLine();
    				String[] row = theLine.split(" ");
    				
    				int pulseFile = Integer.parseInt(row[0]);
    				int diastolicFile = Integer.parseInt(row[1]);
    				int systolicFile = Integer.parseInt(row[2]);
    				
    				Measurements[i] = new Measurement(pulseFile, systolicFile,diastolicFile, new Date());
    			}
    			theBufferReader.close();
    			theReader.close();
    		}
    		catch(Exception e) {
    			JOptionPane.showMessageDialog(null,"<html>Could not load results.<br />Please try again</html>");
    		}
    	}	else {
    				return;			
    			}
    }
    
//------------------------------------------------------------------------------------------------------------------------

    //Getter & Setter methods for the name 
    public String getName() { 
    			return name; 
    	} 

    public void setName(String Name) { 
    			this.name = Name; 
    	} 

     //Constructor 
    public GenericTest(String name) { 

        //This Constructor has one parameter, name 

        this.name = name; //Assign specified values to the specified variable 

    } 

     

    //print method : Modified

    // public void print(PrintWriter printWriter) {
     //(PrintStream theStreamWriter) { 

       
    	 //Does not fit to "Modul 5 Teil 2" at all. Needs to be revised again
    	 
    	 /*
    	 //Modul 2: Teil 2 (Reference: tutorials.jenkov.com/java-io/printstream.html)
    	 
    	 theStreamWriter.println("Patient's Name:		 	 		 "+getName()+ "Test Date: 		"+new Date());
    	 theStreamWriter.println("Test Performed:			 		 "+typeofTest());
    	 theStreamWriter.println("Test Results: 					 "+analyzeValues());
    	 theStreamWriter.println("    						 		 ");
    	 
    	 		for(int i=0; i < Measurements.length; i++) {
    	 			
    	 			if(Measurements != null  ) {
    	 				
    	 			theStreamWriter.println(i + 1 + ". Test:");
    	 			Measurements[i].printValues(theStreamWriter);	
    	 		
    	 			}
    	 			else break;
    	 		}
    	 		*/
    	 
    	 
    	
   // }
     
    
     
     
     
     //Production of Test-Values for the App
     
     //Reference: https://www.geeksforgeeks.org/java-math-random-method-examples/
     //			  https://www.cdc.gov/bloodpressure/measure.htm
     public int pulseTest() {								
    	 int pulse = (int) (Math.random()*151)+50;			//Returns values between 50 & 200 mmHg
    	 return pulse;
     }
     
     public int systolicTest() {
    	 int systolic = (int) (Math.random()*21)+110;		//Returns values between 110 & 130 mmHg
    	 return systolic;
     }
     
     public int diastolicTest() {
    	 int diastolic = (int) (Math.random()*11)+80;		//Returns values between 80 & 90 mmHg
    	 return diastolic;
     }
	
    
     
     public void print(PrintWriter printWriter) {
		// TODO Auto-generated method stub
		printWriter.println("<html>Patient's Name:						<br />"+getName()
				 				 +"Test Date:							<br />"+new Date()
				 				 +"Test Performed:						<br />"+typeofTest()
				 				 +"Test Results:						<br />"+analyzeValues()
				 				 +"										</html>");
    	 
    	 		for(int i=0; i < Measurements.length; i++) {
    	 			
    	 			if(Measurements != null  ) {
    	 				
    	 			printWriter.println(i + 1 + ". Test:");
    	 			Measurements[i].printValues(printWriter);	//Finally works
    	 		
    	 			}
    	 			else break;
    	 		}
	}

}
