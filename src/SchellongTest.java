// James Edonnard Kibii
// Matrikel-Nr: 296096
// ja571kib@htwg-konstanz.de

import java.io.Serializable;
import java.util.Date;

// Modul 2
// Teil 3 Unterklassen

public class SchellongTest extends GenericTest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public SchellongTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		
		this.name = name;
		Measurements = new Measurement[6];
	}
	
	public String analyzeValues() {
		if(Measurements[0] == null) {
			return "Values not detected";
		}
		else {
				int schellongPulse = ((Measurements[0].getPulse() + Measurements[1].getPulse() + Measurements[2].getPulse())-(Measurements[3].getPulse() + Measurements[4].getPulse() + Measurements[5].getPulse()))/Measurements.length;
				int schellongSystolic =((Measurements[0].getSystolic() + Measurements[1].getSystolic() + Measurements[2].getSystolic())-(Measurements[3].getSystolic() + Measurements[4].getSystolic() + Measurements[5].getSystolic()))/Measurements.length;
				int schellongDiastolic=((Measurements[0].getDiastolic() + Measurements[1].getDiastolic() + Measurements[2].getDiastolic())-(Measurements[3].getDiastolic() + Measurements[4].getDiastolic() + Measurements[5].getDiastolic()))/Measurements.length;
				
				//Return Variables
				//return "Schellong";
				if(schellongPulse >= 10 && schellongPulse < 20 && Math.abs(schellongSystolic) < 5 && Math.abs(schellongDiastolic) < 5) {
					return "<html>Test results ok.<br />"
							+ "No abnormalities detected</html>";
				}
				else if(Math.abs(schellongPulse) < 5 && schellongSystolic < -5 && schellongDiastolic < -5) {
					return "Asympathetic orthostatic hypotension";
				}
				else if(schellongPulse > 20 && schellongSystolic < -5 && schellongDiastolic < -5) {
					return "Sympatikotonic orthostatic hypotension";
				}
				else if(schellongPulse > 30 && schellongSystolic > -5 && schellongDiastolic > -5) {
					return "Vasovagal Dysfunction";
				}
				else return "<html>Results could not be categorized<br />"
						  + "Patient should seek medical advice</html>";
			
		}
	}
	
	//Method: startTest()
		public void startTest() {
			//Teil 4:
			super.startTest();
			SchellongControl SchellongD = new SchellongControl();
			SchellongD.setVisible(true);
			
		}


	@Override
	public String typeofTest() {
		// TODO Auto-generated method stub
		return "Schellong Test";
	}
	
	//Method to properly display text in the Combo-Box
		public String toString() {
			 return  "  Schellong Test              " + name + "            " + new Date() ;	
		}

		@Override
		public String nameChanger(String changer) {
			// TODO Auto-generated method stub
			this.name = changer;
			return "";
		}

}
