// James Edonnard Kibii
// Matrikel-Nr: 296096
// ja571kib@htwg-konstanz.de

import java.util.*;
import java.io.PrintWriter;
import java.text.*;

public class Measurement {
	//Attributes 

    //Measurement variables 
	  private int pulse;     
	  private int systolic;     //systolischer Blutdruck 
	  private int diastolic;    //diastolischer Blutdruck 

    //Time of measurement 
	  private Date theTime = new Date(); 
	  
	  SimpleDateFormat datef = new SimpleDateFormat( "dd.MM.yyyy HH:mm" ); 
	  String modifiedDate = datef.format(theTime);
    
	  //Constructor 
    public Measurement(int pulse, int systolic, int diastolic, Date theTime) { 

              this.pulse = pulse; 
              this.systolic = systolic; 
              this.diastolic = diastolic;
              this.theTime = theTime;
    } 

   

  // Getters for all attributes 

  public int getPulse() { 

      return pulse; 

  } 

  public int getSystolic() { 

      return systolic; 

  } 

  public int getDiastolic() { 

      return diastolic; 

  } 
  
  public String getTime() {
  	
  	return modifiedDate;
  	
  }

   

  //printValues method 

  //public void printValues(PrintWriter printWriter) {
  
	  //Have to change this method as well as a result of the PrintStream not working at method print
	  //(PrintStream theStreamer) { 
	 /* 
	  theStreamer.println("Pulse: 					\n"+getPulse()+
			  			  "Systolic:				\n"+getSystolic()+
			  			  "Diastolic:				\n"+getDiastolic()+
			  			  "Date/Time:				\n"+getTime());
	
	theStreamer.println(""							);
  */
	  
	  //corrected
	  
	
	  
 // }

public void printValues(PrintWriter printWriter) {
	// TODO Auto-generated method stub
	printWriter.println("<html>    Pulse:                       <br />"+getPulse()+
						" Systolic:                       <br />"+getSystolic()+
						"Diastolic:                       <br />"+getDiastolic()+
						"Date/Time:                       </html>"+getTime());
	printWriter.println(""                                    );
}

     

}
