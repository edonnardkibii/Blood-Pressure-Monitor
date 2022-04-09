// James Edonnard Kibii
// Matrikel-Nr: 296096
// ja571kib@htwg-konstanz.de

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

public abstract class TestControl extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Variables
	protected JLabel Instructions;
	protected JLabel Title;
	protected JButton Cancel;
	protected JButton Continue;
	protected Timer theTimer;
	protected int state;
	
	//Methods
	protected abstract void stateMachine();	//to implement the logic of either Fitness-Test or Schellong-Test procedure
	
	//Teil B) Implementierung
	public void actionPerformed(ActionEvent e) {
		//Aufrufen der Methode stateMachine() durch das Weiter-Button
		if(e.getActionCommand().equals("Continue")) {
			stateMachine();
		}
		
		//"Cancel" Button, zur Beeendung des Timers in jedem Fall
		
		else if(e.getActionCommand().equals("Cancel")) {
			theTimer.stop();
			dispose();
		}
	}
	
	//Make a beep sound
	protected void onTimer() {
		
		theTimer.stop();
		Toolkit.getDefaultToolkit().beep();
		stateMachine();
		Continue.setEnabled(true);
	}
	
	public TestControl() {
		//Design-View
		super((JFrame)null, "TestControl", true);
		
		this.setSize(500, 300);
		this.setLocation(200, 150);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Button-Design ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		JPanel buttonsPane = new JPanel();
		buttonsPane.setLayout(new FlowLayout());
		this.add(buttonsPane, BorderLayout.SOUTH);
		
		//Continue Button
		Continue = new JButton("Continue");
		Continue.setPreferredSize(new Dimension(100, 20));
		Continue.addActionListener(this);
		
		//Cancel Button
		Cancel = new JButton("Cancel");
		Cancel.setPreferredSize(new Dimension(100, 20));
		Cancel.addActionListener(this);
		
		buttonsPane.add(Continue);
		buttonsPane.add(Box.createRigidArea(new Dimension(160, 0)));
		buttonsPane.add(Cancel);
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Label-Design ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		JPanel titlePane = new JPanel();
		this.add(titlePane, BorderLayout.NORTH);
		
		Title = new JLabel();
		Title.setFont(new Font("Calibri", Font.BOLD, 18));
		Title.setText("Start Test");
		titlePane.add(Title);
		
		JPanel instructionsPane = new JPanel();
		this.add(instructionsPane, BorderLayout.CENTER);
		
		Instructions = new JLabel();
		Instructions.setFont(new Font("Calibri", Font.BOLD, 12));
		Instructions.setText("Press 'Continue' to start the test");
		instructionsPane.add(Instructions);
		
		theTimer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				onTimer();
			}
		});
		
	}
	
}
