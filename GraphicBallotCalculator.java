//Last updated: 10/2/2019
// This project is functionally complete, but aesthetically incomplete. In other words, it does everything I want it to do but doesn't look the way I want.   

// Accepts input resembling an AMTA ballot and outputs which team won and by how many points (Point Differential)
// AMTA: American Mock Trial Association, a collegiate organization where two teams compete head-to-head and are assigned numeric scores by judges. Each judge assigns 14 numeric scores to each team. Each of those 14 scores is for a different part of the trial (for example: opening statements, direct examination, cross examination, closing statement)
// The winning team is the one with highest score, when summed across all 14 parts of trial

// Graphic should show Instructions centered at top then two columns below it. Left column is piTeam, right column is DeTeam. Each column should have 14 labeled input spots for the scores for each trial.
// Centered at the bottom will be a "Calculate!" button. Upon clicking, the button will trigger the program to calculate and display the winning team and point differential. 
// GUI should be able to accept input changes and recalculate if button clicked again. 

//DONE: Add all ballot sections on each side. 

//DONE: Input filtering. Only accept int inputs between 1 and 10. If 'calculate' button clicked when all inputs not an int between 1 and 10: reject and ask for complete, valid input. SOLVED BY USING JSPINNER

//TODO: Make the GUI pretty in general. Cleaner layout and more readable (i.e bigger) text are priorities.

//TODO: Pi and De are both doing essentially the same thing. Must be a way to write the code once instead of twice? But also the labels for each score need hardcoding?


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicBallotCalculator {
	
	public static JSpinner[] piScores;
	public static JTextField piResult;
	
	public static JSpinner[] deScores;
	public static JTextField deResult;
	
	public static JButton calcButton;
	public static JTextField result;
	
	public static void main(String[] args) {
		
		//LOOK AND FEEL
		//Will cause the UI to mimic the look and feel of whatever system it is running on. 
		try { 
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		
		//GENERAL
		//
		JFrame f = new JFrame("Graphic Ballot Calculator");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(new BorderLayout()); //Consider switching to Grid Bag
		
		//HEADER
		JPanel header = new JPanel();
		header.add(new JLabel("Instructions: Please use the arrow keys to select a number between 1 and 10 for each score."));
		f.getContentPane().add(header, "North");
		
		//PI (plaintiff/ prosecution)
		//Each score field will be represented by a JSpinner which allows inputs between 1 and 10, starting at 5
		piScores = new JSpinner[14];
		for(int i = 0; i < 14; i++) {
			piScores[i] =  new JSpinner(new SpinnerNumberModel(5,1,10,1));
			piScores[i].setEditor(new JSpinner.DefaultEditor(piScores[i]));
		}
		piResult = new JTextField(20); //for displaying sum of piScores
		piResult.setEditable(false);
		
		//Add all pi Scoring sections
		JPanel piScorePanel = new JPanel();
		piScorePanel.setLayout(new GridLayout(14,2));
		piScorePanel.add(new JLabel("P Opening Score:"));
		piScorePanel.add(piScores[0]);
		piScorePanel.add(new JLabel("P Attorney 1 Direct Score:"));
		piScorePanel.add(piScores[1]);
		piScorePanel.add(new JLabel("P Witness 1 Direct Score:"));
		piScorePanel.add(piScores[2]);
		piScorePanel.add(new JLabel("P Witness 1 Cross Score:"));
		piScorePanel.add(piScores[3]);
		piScorePanel.add(new JLabel("P Attorney 2 Direct Score:"));
		piScorePanel.add(piScores[4]);
		piScorePanel.add(new JLabel("P Witness 2 Direct Score:"));
		piScorePanel.add(piScores[5]);
		piScorePanel.add(new JLabel("P Witness 2 Cross Score:"));
		piScorePanel.add(piScores[6]);
		piScorePanel.add(new JLabel("P Attorney 3 Direct Score:"));
		piScorePanel.add(piScores[7]);
		piScorePanel.add(new JLabel("P Witness 3 Direct Score:"));
		piScorePanel.add(piScores[8]);
		piScorePanel.add(new JLabel("P Witness 3 Cross Score:"));
		piScorePanel.add(piScores[9]);
		piScorePanel.add(new JLabel("P Attorney 1 Cross Score:"));
		piScorePanel.add(piScores[10]);
		piScorePanel.add(new JLabel("P Attorney 2 Cross Score:"));
		piScorePanel.add(piScores[11]);
		piScorePanel.add(new JLabel("P Attorney 3 Cross Score:"));
		piScorePanel.add(piScores[12]);
		piScorePanel.add(new JLabel("P Closing Score:"));
		piScorePanel.add(piScores[13]);
		
		JPanel piResultPanel = new JPanel();
		piResultPanel.add(new JLabel("Sum: "));
		piResultPanel.add(piResult);
		
		//put pi on the west or left side of window
		JPanel piPanel = new JPanel();
		piPanel.setLayout(new GridLayout(2,1));
		piPanel.add(piScorePanel);
		piPanel.add(piResultPanel);
		f.getContentPane().add(piPanel, "West");
		
		//DE (Defense)
		//Does the same things as the pi section above
		deScores = new JSpinner[14];
		for(int i = 0; i < 14; i++) {
			deScores[i] = new JSpinner(new SpinnerNumberModel(5,1,10,1));
			deScores[i].setEditor(new JSpinner.DefaultEditor(deScores[i]));
		}
		deResult = new JTextField(20);
		deResult.setEditable(false);
		
		JPanel deScorePanel = new JPanel();
		deScorePanel.setLayout(new GridLayout(14,2));
		deScorePanel.add(new JLabel("D Opening Score:"));
		deScorePanel.add(deScores[0]);
		deScorePanel.add(new JLabel("D Attorney 1 Cross Score:"));
		deScorePanel.add(deScores[1]);
		deScorePanel.add(new JLabel("D Attorney 2 Cross Score:"));
		deScorePanel.add(deScores[2]);
		deScorePanel.add(new JLabel("D Attorney 3 Cross Score:"));
		deScorePanel.add(deScores[3]);
		deScorePanel.add(new JLabel("D Attorney 1 Direct Score:"));
		deScorePanel.add(deScores[4]);
		deScorePanel.add(new JLabel("D Witness 1 Direct Score:"));
		deScorePanel.add(deScores[5]);
		deScorePanel.add(new JLabel("D Witness 1 Cross Score:"));
		deScorePanel.add(deScores[6]);
		deScorePanel.add(new JLabel("D Attorney 2 Direct Score:"));
		deScorePanel.add(deScores[7]);
		deScorePanel.add(new JLabel("D Witness 2 Direct Score:"));
		deScorePanel.add(deScores[8]);
		deScorePanel.add(new JLabel("D Witness 2 Cross Score:"));
		deScorePanel.add(deScores[9]);
		deScorePanel.add(new JLabel("D Attorney 3 Direct Score:"));
		deScorePanel.add(deScores[10]);
		deScorePanel.add(new JLabel("D Witness 3 Direct Score:"));
		deScorePanel.add(deScores[11]);
		deScorePanel.add(new JLabel("D Witness 3 Cross Score:"));
		deScorePanel.add(deScores[12]);
		deScorePanel.add(new JLabel("D Closing Score:"));
		deScorePanel.add(deScores[13]);
		
		JPanel deResultPanel = new JPanel();
		deResultPanel.add(new JLabel("Sum: "));
		deResultPanel.add(deResult);
		
		//Put Defense on the east or right side of window
		JPanel dePanel = new JPanel();
		dePanel.setLayout(new GridLayout(2,1));
		dePanel.add(deScorePanel);
		dePanel.add(deResultPanel);
		f.getContentPane().add(dePanel, "East");	
		
		
		//FOOTER
		calcButton = new JButton("Calculate");
		result = new JTextField(50); //For displaying winning team and point differential
		result.setEditable(false);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(calcButton);
		calcButton.addActionListener(new ButtonListener()); //Triggered when clicked
		
		JPanel resultPanel = new JPanel();
		resultPanel.add(result);
	
		//Puts Footer on the bottom, centered
		JPanel footer = new JPanel();
		footer.setLayout(new GridLayout(2,1));
		footer.add(buttonPanel);
		footer.add(resultPanel);
		f.getContentPane().add(footer, "South");
		
		
		
		//GENERAL
		//Sets initial window size and visibility 
		f.setSize(800,1000);
		f.setVisible(true);
	}
	
	
	public static class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			//Find and display sums for each team
			int piSum = sumScores(piScores);
			piResult.setText("" + piSum);
			int deSum = sumScores(deScores);
			deResult.setText("" + deSum);
			
			//Output Result
			if(piSum == deSum) {
				result.setText("*** The ballot is a tie! ***");
			}else if(piSum > deSum){
				result.setText("*** The P team wins by " + (piSum - deSum) + " point(s)! ***");
			}else {
				result.setText("*** The D team wins by " + (deSum - piSum) + " point(s)! ***");
			}
		}	
		
		public static int sumScores(JSpinner[] scores) {
			//Calculates sum for a given team's score array
			int sum = 0;
			for(int i=0; i < scores.length; i++) {
				sum += (Integer) scores[i].getValue();
			}
			return sum;
		}
		
	}

	
}
