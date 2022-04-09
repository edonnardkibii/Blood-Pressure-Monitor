// James Edonnard Kibii
// Matrikel-Nr: 296096
// ja571kib@htwg-konstanz


// Modul 2
// Teil 1 Graphisches UI
import javax.swing.JFrame;

public class Main {
public static void main (String[] args) {
		
		JFrame Frame = new JFrame();
		Frame.setSize(650, 600);									//Frame work, 650 pixels by 600 pixels
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//once the program is exited, the program closes automatically
		Frame.setTitle("Blood Pressure Monitor");					//Title of the main frame
		
		// Main-Content object as Content-Pane
		MainContent theMainContent = new MainContent();
		Frame.setContentPane(theMainContent);
		Frame.setVisible(true);
		
	}
}
