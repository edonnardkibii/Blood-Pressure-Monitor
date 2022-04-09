// James Edonnard Kibii
// Matrikel-Nr: 296096
// ja571kib@htwg-konstanz.de



public class SchellongControl extends TestControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Title of the Dialog (Constructor)
	public SchellongControl() {
		super.setTitle("Schellong Test");
	}
	

	@Override
	protected void stateMachine() {
		// TODO Auto-generated method stub
		
		//Procedure for the Schellong Test
		//https://translate.google.de/translate?hl=en&sl=de&u=https://de.wikipedia.org/wiki/Schellong-Test&prev=search
		
		if(state == 0) {
			Title.setText("Welcome to your Schellong Test");
			Instructions.setText("<html>To start this examination, the patient should be in a relaxed lying position for 10 minutes<br />"
					+ "Inform the patient about the respective risks</html>");
			theTimer.setInitialDelay(60000);  //3 minutes, only because 10 minutes would take too long to show the project
			theTimer.start();
			super.Continue.setEnabled(false);
			state++;
		}
		else if(state == 1) {
			Title.setText("Measurement in a horizontal position");
			Instructions.setText("<html>Measure & record the patient's blood pressure and pulse<br />"
					+ "When completed,press 'Continue'</hmtl>");
			state++;
		}
		else if(state == 2) {
			Title.setText("Waiting Period");
			Instructions.setText("Wait for 60 seconds, then press 'Continue' after the signal");
			theTimer.setInitialDelay(60000);
			theTimer.start();
			super.Continue.setEnabled(false);
			state++;
		}
		else if(state == 3) {
			Title.setText("Measurement in a horizontal position");
			Instructions.setText("<html>Measure & record the patient's blood pressure and pulse<br />"
					+ "When completed,press 'Continue'</hmtl>");
			state++;
		}
		else if(state == 4) {
			Title.setText("Measurements in a standing position");
			Instructions.setText("<html>Help the patient stand up & immediately measure their blood pressure and pulse<br />"
					+ "Warning! Be careful with the elderly or patients that were bedridden.<br />Repeatedly doing the test may be challenging<html>");
			state++;
		}
		else if(state == 5) {
			Title.setText("Waiting Period");
			Instructions.setText("Wait for 60 seconds as the patient rests, then press 'Continue' after the signal");
			theTimer.setInitialDelay(60000);
			theTimer.start();
			super.Continue.setEnabled(false);
			state++;
		}
		else if(state == 6) {
			Title.setText("Measurements in a standing position");
			Instructions.setText("Help the patient stand up & immediately measure their blood pressure and pulse");
			state++;
		}
		else if(state == 7) {
			Title.setText("Waiting Period");
			Instructions.setText("Wait for 60 seconds as the patient rests, then press 'Continue' after the signal");
			theTimer.setInitialDelay(60000);
			theTimer.start();
			super.Continue.setEnabled(false);
			state++;
		}
		else if(state == 8) {
			Title.setText("Measurements in a standing position");
			Instructions.setText("Help the patient stand up & immediately measure their blood pressure and pulse");
			state++;
		}
		else if(state == 9) {
			Title.setText("Waiting Period");
			Instructions.setText("Wait for 60 seconds as the patient rests, then press 'Continue' after the signal");
			theTimer.setInitialDelay(60000);
			theTimer.start();
			super.Continue.setEnabled(false);
			state++;
		}
		else if(state == 10) {
			Title.setText("Measurements in a standing position");
			Instructions.setText("Help the patient stand up & immediately measure their blood pressure and pulse");
			state++;
		}
		else if(state == 11) {
			Title.setText("You have reached the end of your test");
			Instructions.setText("To end the test, press 'Continue'");
			state++;
		}
		else {
			dispose();
			state = 0;
		}
	}

}
