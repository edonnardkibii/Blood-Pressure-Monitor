// James Edonnard Kibii
// Matrikel-Nr: 296096
// ja571kib@htwg-konstanz.de



public class FitnessControl extends TestControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Title of the Dialog (Constructor)
	public FitnessControl() {
		super.setTitle("Fitness Test");
	}
	

	@Override
	protected void stateMachine() {
		// TODO Auto-generated method stub
		
		// Procedure for the Fitness Test
		//https://www.mayoclinic.org/healthy-lifestyle/fitness/in-depth/fitness/art-20046433
		//https://stackoverflow.com/questions/1090098/newline-in-jlabel
		
		
		if(state == 0) {
			Title.setText("Welcome to your Fitness Test");
			Instructions.setText("<html>To do your assessment, you'll need: <br />"
					+ "1) A watch that can measure seconds or a stopwatch <br />"
					+ "2) A cloth measuring tape <br />"
					+ "3) A yardstick <br />"
					+ "4) Heavy-duty tape <br />"
					+ "5) A scale <br />"
					+ "6) Someone to help you record your scores and count repetitions</html>");
			state++;
		}
		else if(state == 1) {
			Title.setText("1st Fitness Test");
			Instructions.setText("Get ready for your 1st assessment");
			state++;
		}
		else if(state == 2) {
			Title.setText("Aerobic Fitness: Heart rate at rest");
			Instructions.setText("<html>Place your index and middle fingers on your neck to the side of your windpipe.<br />"
					+ "When you feel your pulse, look at your watch & count the number of beats in 10 seconds</html>");
			theTimer.setInitialDelay(15000);
			theTimer.start();
			state++;
		}
		else if(state == 3) {
			Title.setText("2nd Fitness Test");
			Instructions.setText("Get ready for your 2nd assessment");
			state++;
		}
		else if(state == 4) {
			Title.setText("Aerobic Fitness: Running test");
			Instructions.setText("Run a 100m dash in the shortest time possible & record the time taken");
			state++;
		}
		else if(state == 5) {
			Title.setText("3rd Fitness Test");
			Instructions.setText("Get ready for your 3rd assessment");
			state++;
		}
		else if(state == 6) {
			Title.setText("Muscular strength & endurance: Pushup test");
			Instructions.setText("Try & do as many pushups as possible within 30 seconds");
			theTimer.setInitialDelay(35000);
			theTimer.start();
			super.Continue.setEnabled(false);
			state++;
		}
		else if(state == 7) {
			Title.setText("Last Fitness Test");
			Instructions.setText("Get ready for your 4th & final assessment");
			state++;
		}
		else if(state == 8) {
			Title.setText("Muscular strength & endurance: Situp test");
			Instructions.setText("Try & do as many situps as possible within 30 seconds");
			theTimer.setInitialDelay(35000);
			theTimer.start();
			state++;
		}
		else if(state == 9) {
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
