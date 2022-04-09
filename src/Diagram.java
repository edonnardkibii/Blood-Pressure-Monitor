// James Edonnard Kibii
// Matrikel-Nr: 296096
// ja571kib@htwg-konstanz.de

import java.awt.*;

import javax.swing.JPanel;

public class Diagram extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MainContent Reference;
	
	//Reference to the main window
	public Diagram (MainContent Reference) {
		this.Reference = Reference;
	}

	//paintComponent-Methode
	//Teil 2: Einfügen einer Zeichenfläche
	public void paintComponent(Graphics axis) {
		super.paintComponent(axis);
		this.setBackground(new Color(205,92,92));	//https://www.rapidtables.com/web/color/RGB_Color.html
		axis.setColor(Color.BLACK);
		
		//Graph-Design
		//~~~~~~~~~~~~~~~~~~~ x-Axis ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		axis.drawLine( 60, 360, 564, 360);
		axis.drawLine(558, 354, 564, 360);
		axis.drawLine(558, 366, 564, 360);
		axis.drawString("Values", 582, 366);
		
		axis.drawLine(156, 354, 156, 366);
		axis.drawString("1", 152, 384);
		
		axis.drawLine(228, 354, 228, 366);
		axis.drawString("2", 224, 384);
		
		axis.drawLine(300, 354, 300, 366);
		axis.drawString("3", 296, 384);
		
		axis.drawLine(372, 354, 372, 366);
		axis.drawString("4", 368, 384);
		
		axis.drawLine(444, 354, 444, 366);
		axis.drawString("5", 440, 384);
		
		axis.drawLine(516, 354, 516, 366);
		axis.drawString("6", 512, 384);
		
		//~~~~~~~~~~~~~~~~~~~ y-Axis ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		axis.drawLine(84, 60, 84, 384);
		axis.drawLine(90, 66, 84, 60);
		axis.drawLine(78, 66, 84, 60);
		axis.drawString("Pulse/Blood Pressure", 50, 36);
		
		axis.drawLine(78, 300, 90, 300);
		axis.drawString("40", 48, 304);
		
		axis.drawLine(78, 240, 90, 240);
		axis.drawString("80", 48, 244);
		
		axis.drawLine(78, 180, 90, 180);
		axis.drawString("120", 42, 184);
		
		axis.drawLine(78, 120, 90, 120);
		axis.drawString("160", 42, 124);
		
		axis.drawLine(78, 60, 90, 60);
		axis.drawString("200", 42, 64);
		
		//Legend for the Graph
		axis.setFont(new Font("Calibri", Font.PLAIN, 15));
		axis.setColor(Color.BLACK);
		axis.drawString("Pulse", 530, 36);
		axis.setColor(Color.BLUE);
		axis.drawString("Systolic", 530, 60);
		axis.setColor(Color.GREEN);
		axis.drawString("Diastolic", 530, 84);
		
	//Teil 3 Zeichnen der Messwerte des aktuellen Tests in das Diagramm
		
		GenericTest actualTest = Reference.getActualTest();
		Measurement[] measure;
		
		if(actualTest != null && actualTest.getMeasurements() != null) {
			measure = actualTest.getMeasurements();
			if(measure[0] != null) {
				for(int i=0; i<measure.length; i++) {
					int pulse = 297 - measure[i].getPulse();
					int systolic = 297 - measure[i].getSystolic();
					int diastolic = 297 - measure[i].getDiastolic();
					
					//****still to be worked on****
					//****do some research on fillOval first****
					
					int drawPoint = 127 + (i*60);
					
					axis.setColor(Color.BLACK);
					axis.fillOval(drawPoint,pulse, 5,5);
					axis.setColor(Color.BLUE);
					axis.fillOval(drawPoint, systolic, 5,5);
					axis.setColor(Color.GREEN);
					axis.fillOval(drawPoint,diastolic,5,5);
					
					repaint();
					invalidate();
				}
			}
			
			
		}
		
	}

}
