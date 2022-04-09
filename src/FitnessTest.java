// James Edonnard Kibii
// Matrikel-Nr: 296096
// ja571kib@htwg-konstanz.de

// Modul 2
// Teil 3 Unterklassen

import java.io.*;
import java.util.*;

public class FitnessTest extends GenericTest implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	
	//Constructor
	public FitnessTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		
		this.name = name;
		Measurements = new Measurement[4];
	}

	//analyzeValues Method
	public String analyzeValues() {
			
		if(Measurements[0] == null) {
			return "No processable data detected";
		}
		else {
			int meanPulse = (Measurements[0].getPulse() + Measurements[1].getPulse() + Measurements[2].getPulse() + Measurements[3].getPulse())/Measurements.length;
			int meanSystolic = (Measurements[0].getSystolic() + Measurements[1].getSystolic() + Measurements[2].getSystolic() + Measurements[3].getSystolic())/Measurements.length;
			int meanDiastolic = (Measurements[0].getDiastolic() + Measurements[1].getDiastolic() + Measurements[2].getDiastolic() + Measurements[3].getDiastolic())/Measurements.length;
			
			//Return Variables
			// return "Fitness";
			
			// pulse<100 		systolic<120		diastolic<80
			if(meanPulse < 100 && meanSystolic < 120 && meanDiastolic < 80) {
				return "In perfect fitness condition";
			}
			// 100<pulse<120		systolic<140		diastolic<85
			else if (meanPulse >= 100 && meanPulse < 120  && meanSystolic < 140 && meanDiastolic < 85) {
				return "Normal Fitness Levels";
			}
			// 120<pulse<140		systolic<160		diastolic<100		
			else if (meanPulse >= 120 && meanPulse > 140 && meanSystolic < 160 && meanDiastolic < 100) {
				return "Patient should attempt to improve their fitness levels";
			}
			else {
				return "Patient should seek medical advice";
				}
		}
		
	}
	
	//Method: startTest()
	
	public void startTest() {
		//Teil 4:
		super.startTest();
		FitnessControl FitnessD = new FitnessControl();
		FitnessD.setVisible(true);
	}

	@Override
	public String typeofTest() {
		// TODO Auto-generated method stub
		return "Fitness Test";
	}
	
	//Method to display type of test, patient name & date/time of taken test in the combobox
	public String toString() {
		 return  "  Fitness Test              " + name + "            " + new Date() ;	
	}

	@Override
	public String nameChanger(String changer) {
		// TODO Auto-generated method stub
		this.name = changer;
		return "";
	}
}
