// James Edonnard Kibii
// Matrikel-Nr: 296096
// ja571kib@htwg-konstanz.de


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Dialog extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;			//Input for the patient's name
	private String testType;		//Input for the type of test to be performed
	private boolean close = false;	//When 'OK' is pressed, Dialog Pane should close. ***Fix the current issue***
	
	//Radio Buttons
	//Easier to choose options & change
	JRadioButton FitnessB = new JRadioButton("Fitness Test", true);
	JRadioButton SchellongB = new JRadioButton("Schellong Test");
	
	//Text-Field
	private JTextField text;
	
	//Constructor
	public Dialog() {
		//***under construction***
		super((JFrame)null, "Dialog", true);
		super.setTitle("New Test");
		
		//---------------------------------------------------------------------------------
		//~~~~~~~~~~~~~~~~~~~~~~Design of the 'New'-Dialog Pane~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		setSize(250,150);
		this.setLocation(150,150);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Buttons ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		JPanel buttonSection = new JPanel();
		buttonSection.setLayout(new FlowLayout());
		
		//'OK' Button
		JButton okB = new JButton("OK");
		okB.setPreferredSize(new Dimension(100,20));
		okB.addActionListener(this);
		
		//'Cancel' Button
		JButton cancelB = new JButton("Cancel");
		cancelB.setPreferredSize(new Dimension(100,20));
		cancelB.addActionListener(this);
		
		//Orientation
		buttonSection.add(okB);
		buttonSection.add(cancelB);
		this.add(buttonSection,BorderLayout.SOUTH);
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Text-Field ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		JPanel textfieldSection = new JPanel(); 
		text = new JTextField(20);
		textfieldSection.add(text);
		text.setText("");
		this.add(textfieldSection, BorderLayout.NORTH);
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Radio-Buttons ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		JPanel radioButtonSection = new JPanel();
		
		FitnessB.setText("Fitness Test");
		FitnessB.addActionListener(this);
		
		SchellongB.setText("Schellong Test");
		SchellongB.addActionListener(this);
		
		radioButtonSection.add(FitnessB);
		radioButtonSection.add(SchellongB);
		this.add(radioButtonSection, BorderLayout.CENTER);
		//---------------------------------------------------------------------------------
	}
	
	//Getter methods
	public String getName() {
		return name;
	}
	public String getTesttype() {
		return testType;
	}
	
	public boolean close() {
		return(close);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
			case "Cancel" : dispose(); break;
			case "Fitness Test": SchellongB.setSelected(false); break;
			case "Schellong Test": FitnessB.setSelected(false); break;
			case "OK": if(!(text.getText().equals("")))
							{
								close = true;
								if(FitnessB.isSelected()) {
									testType = "Fitness"; 
								}
								else if(SchellongB.isSelected()) {
									testType = "Schellong";
								}
								else return;
								
								name = text.getText();
								dispose();
							}
						else {
							if(name == null)
							{
								JOptionPane.showMessageDialog(null,"Please type in patient's name to continue");
							}
							else if(testType == null)
							{
								JOptionPane.showMessageDialog(null, "Please select a test to continue");
							}
						}; break;				
					}
	
	}


}
