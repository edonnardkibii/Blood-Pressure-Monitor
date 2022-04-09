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
import javax.swing.JTextField;

public class NameModifier extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private boolean close = false;
	
	//Text-Field
	JTextField text = new JTextField();
	
	//Constructor
	public NameModifier() {
		super((JFrame)null,"NameModifier",true);
		super.setTitle("Edit Name");
		
		//---------------------------------------------------------------------------------
		//~~~~~~~~~~~~~~~~~~~~~ Design of the Dialog Pane ~~~~~~~~~~~~~~~~~~~~~~~~~~~
		setSize(250,110);
		this.setLocation(400,250);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Buttons ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		JPanel buttonSection = new JPanel();
		buttonSection.setLayout(new FlowLayout());
		this.add(buttonSection,BorderLayout.SOUTH);
				//'OK' Button
				JButton okB = new JButton("OK");
				okB.setPreferredSize(new Dimension(100,20));
				okB.addActionListener(this);
				buttonSection.add(okB);
				
				//'Cancel' Button
				JButton cancelB = new JButton("Cancel");
				cancelB.setPreferredSize(new Dimension(100,20));
				cancelB.addActionListener(this);
				buttonSection.add(cancelB);
				//Orientation
			
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Text-Field ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				JPanel textfieldSection = new JPanel(); 
				this.add(textfieldSection, BorderLayout.CENTER);
				text = new JTextField(20);
				textfieldSection.add(text);
				text.setText("");
				
	}
	
	//Getter Method
	public String getName() {
		return name;
	}
	
	public boolean close() {
		return(close);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
			case "Cancel": dispose(); break; //in the case that you need to cancel your decision
			case "OK": if(!(text.getText().equals(""))){
							close = true;
							name = text.getText();
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Please insert Patient's name to continue");
						}; break;
		}
		
	}
	

}
