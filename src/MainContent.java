// James Edonnard Kibii
// Matrikel-Nr: 296096
// ja571kib@htwg-konstanz.de

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class MainContent extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Variables ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	JComboBox<GenericTest> ComboBox = new JComboBox <GenericTest>();
	JLabel analyzeValuesView = new JLabel("Test Results: ");		//Label for Test results
	
	private GenericTest[] feld = new GenericTest[10]; 		//A field for 10 Objects
	private int counter = 0; 							// to count the number of tests already performed
	private GenericTest actualTest;
	
	public GenericTest getActualTest() {
		return actualTest;
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//Constructor for the Content-Pane
	public MainContent() {
		
		//Design of the Content-Pane
		this.setLayout(new BorderLayout());
		//Background Color: Crimson-ish color
		//Reference: teaching.csse.uwa.edu.au/units/CITS1001/colorinfo.html
		this.setBackground(new Color(153,0,0));
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Graphical Design ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		//Task-Bar design
		//------------------------------------------------------------------------------------
		
		JMenuBar taskBar = new JMenuBar();
		this.add(taskBar, BorderLayout.NORTH); //Position the Task-Bar at the top
		
		JMenu fileMenu = new JMenu("File");
		taskBar.add(fileMenu);
		JMenu editMenu = new JMenu("Edit");
		taskBar.add(editMenu);
		
		
		//List-Items(File)
		JMenuItem newTest = new JMenuItem("New"); //starts a new test
		fileMenu.add(newTest);
		newTest.addActionListener(this);
		
		JMenuItem openTest = new JMenuItem("Open File"); //Open saved data
		fileMenu.add(openTest);
		openTest.addActionListener(this);
		
		JMenuItem saveTest = new JMenuItem("Save"); //Save Data
		fileMenu.add(saveTest);
		saveTest.addActionListener(this);
		
		JMenuItem printTest = new JMenuItem("Print..."); //Prints out the test in a hard copy
		fileMenu.add(printTest);
		printTest.addActionListener(this);
		
		JMenuItem exit = new JMenuItem("Exit"); //End the Program
		fileMenu.add(exit);
		exit.addActionListener(this);
		
		
		//List-Items(Edit)
		JMenuItem runTest = new JMenuItem("Run Test"); // Starts a test
		editMenu.add(runTest);
		runTest.addActionListener(this);
		
		JMenuItem readValues = new JMenuItem("Read Values"); //Reads the values from the Blood Pressure Gauge
		editMenu.add(readValues);
		readValues.addActionListener(this);
		
		JMenuItem editName = new JMenuItem("Edit File Name"); //edits the Test-File Name
		editMenu.add(editName);
		editName.addActionListener(this);
		
		//-------------------------------------------------------------------------------------
		
		//Button Design
		//-------------------------------------------------------------------------------------
		
		JPanel buttonSection = new JPanel(); 
		buttonSection.setPreferredSize(new Dimension (650,120)); //650 pixels x 120 pixels
		buttonSection.setBackground(new Color(204,0,0)); //sets background color to red
		
		this.add(buttonSection, BorderLayout.SOUTH);  //Position the buttons at the bottom
		
		//Buttons
		JButton startButton = new JButton("Run Test"); // Button to start the test
		startButton.setPreferredSize(new Dimension(120,25));
		//buttonSection.add(Box.createRigidArea(new Dimension(100,0)));  //***spoils the design view***
		buttonSection.add(startButton);
		startButton.addActionListener(this);
		
		JButton readButton = new JButton("Read Values"); // Button to read the values from Blood Pressure Gauge
		readButton.setPreferredSize(new Dimension(120,25));
		buttonSection.add(Box.createRigidArea(new Dimension(100,0)));
		buttonSection.add(readButton);
		readButton.addActionListener(this);
		
		JButton exitButton = new JButton("Exit"); // Button to end the program
		exitButton.setPreferredSize(new Dimension(120,25));
		buttonSection.add(Box.createRigidArea(new Dimension(100,0)));
		buttonSection.add(exitButton);
		exitButton.addActionListener(this);
		
		//-------------------------------------------------------------------------------------
		
		//Combo-Box Design
		//-------------------------------------------------------------------------------------
		buttonSection.add(Box.createRigidArea(new Dimension(100,0)));
		ComboBox.setPreferredSize(new Dimension(580,25)); //580 Pixels x 25 Pixels
		buttonSection.add(ComboBox);
		
		ComboBox.addItemListener(new ItemListener()
				{

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if(e.getStateChange() == ItemEvent.SELECTED) {
							actualTest = (GenericTest)(ComboBox.getSelectedItem());
							editLabel();	
							
							repaint();
							invalidate();
						}
					}
			
				});
		
		//-------------------------------------------------------------------------------------
		
		//Label Design
		//-------------------------------------------------------------------------------------
		
		buttonSection.add(Box.createRigidArea(new Dimension(60,0)));
		buttonSection.add(analyzeValuesView);
		
		//-------------------------------------------------------------------------------------
		
		//Diagram Design
		//-------------------------------------------------------------------------------------
		
		Diagram diagram = new Diagram(this);
		diagram.setPreferredSize(new Dimension(500,300));
		this.add(diagram, BorderLayout.CENTER);
		
		//-------------------------------------------------------------------------------------
	}
	
	public void editLabel() {
		if(actualTest != null) 
		{
			analyzeValuesView.setText("Test Results: "+getActualTest().analyzeValues());
			repaint();
		}
	}
	
	
	//Assign task for the buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()) {
			case "Exit"			 : System.exit(0); 							break;
			case "New"			 : 		newTest(); repaint(); invalidate(); break;
			case "Open File"	 : 	   openFile(); repaint(); invalidate(); break;
			case "Save"			 : 	   saveTest(); repaint(); invalidate(); break;
			case "Print..." 	 : 	  printTest(); repaint(); invalidate(); break;
			case "Run Test" 	 : 		runTest(); repaint(); invalidate(); break;
			case "Read Values"	 : 	   readTest(); repaint(); invalidate(); break;
			case "Edit File Name": editFileName(); repaint(); invalidate(); break;
			
		}
		
	}
	
	// Methods on click
	private void newTest() {
		if (counter < 10) {
			Dialog newTest = new Dialog();
			newTest.setVisible(true);
			if(newTest.close()) {
				switch(newTest.getTesttype()) {
					case "Fitness":   feld[counter] = new FitnessTest(newTest.getName());
									  actualTest = feld[counter];
									  ComboBox.addItem(actualTest);
									  ComboBox.setSelectedItem(actualTest);
									  editLabel();
									  counter++;
									  break;
					
					case "Schellong": feld[counter] = new SchellongTest(newTest.getName());
									  actualTest = feld[counter];
									  ComboBox.addItem(actualTest);
									  ComboBox.setSelectedItem(actualTest);
									  editLabel();
									  counter++;
									  break;
					
					default: JOptionPane.showMessageDialog(null, "Please select a test to continue"); break;
				
				}
			}
		} 
		else {
				JOptionPane.showMessageDialog(null, "<html>Memory is Full.<br />Kindly restart the Application again</html>");
			 }
	}
	
	private void openFile() {
		JFileChooser selected = new JFileChooser();
		if(selected.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			try {
				File file = selected.getSelectedFile();
				FileInputStream openStream = new FileInputStream(file);
				ComboBox.removeAllItems();
				
				ObjectInputStream openObjStream = new ObjectInputStream(openStream);
				feld = (GenericTest[])openObjStream.readObject();
				
				for(int i=0; i<feld.length; i++) {
					if(feld[i] != null) {
						actualTest = feld[i];
						ComboBox.addItem(actualTest);
						ComboBox.setSelectedItem(actualTest);
						editLabel();
					}
					else
					{
						break;
					}
				}
				counter = ComboBox.getItemCount();
				
				openStream.close();
				openObjStream.close();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Could not load data");
			}
		}
		else
		{
			return;
		}
		
	}
	
	private void saveTest(){
		JFileChooser selected = new JFileChooser();
		
		if(selected.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			try {
				File file = selected.getSelectedFile();
				FileOutputStream saver = new FileOutputStream(file);
				
				ObjectOutputStream objectS = new ObjectOutputStream(saver);
				objectS.writeObject(feld);
				
				saver.close();
				objectS.close();
				
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Error: Could not save test");
			}
		}
		else 
		{
			return;
		}
		
	}
	
	private void printTest() {
		
		//Aufgabe zu Modul 5 (Pflicht)
		//Teil 2 Test ausdrucken
		
		JFileChooser selected = new JFileChooser();
		
		if(selected.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			try {
				File file = selected.getSelectedFile();
				PrintWriter printWriter = new PrintWriter(file +".txt");	//An Object of type PrintWriter
				
				printWriter.printf("<html>Kibii Inc.<br />"
								   +"Blood Pressure Monitor<br />"
								   +"Patient's Results</html>", new  Font("Calibri", Font.PLAIN, 30));
				printWriter.println("<html>		<br />"
								   +"----------------------------------------------------------<br />"
								   +"<br/>"
								   +"/html>");
				
				getActualTest().print(printWriter);
				printWriter.close();
				
			}	
			catch(Exception e) 
				{
					JOptionPane.showMessageDialog(null,"Error: Could not print test");
				}
		}else {
			return;
		}
	}
	
	private void runTest() {
		if(counter != 0) {
			getActualTest().startTest();
			editLabel();
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Could not detect test");
		}
	}
	
	private void readTest() {
		if(actualTest != null) {
			actualTest.readValues();
			editLabel();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Could not detect test");
		}
	}
	
	private void editFileName() {
		if(counter == 0) 
			{
				JOptionPane.showMessageDialog(null, "Could not detect test");
			}
		else
		{
			NameModifier modifier = new NameModifier();
			modifier.setVisible(true);
				if(modifier.close()) {
					getActualTest().nameChanger(modifier.getName());
					actualTest = (GenericTest)ComboBox.getSelectedItem();
				}
		}
	}
}
