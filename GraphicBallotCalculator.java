// Accepts AMTA Ballot input and outputs which team won and by how many points (Point Differential)
// AMTA: American Mock Trial Association, a collegiate organization where two teams compete head-to-head and are assigned numeric scores by judges. Each judge assigns 14 numeric scores to each team. Each of those 14 scores is for a different part of the trial (for example: opening statements, direct examination, cross examination, closing statement)
// The winning team is the one with highest score, when summed across all 14 parts of trial

// Graphic should show Instructions centered at top then two columns below it. Left column is piTeam, right column is DeTeam. Each column should have 14 labeled input spots for the scores for each trial.
// Centered at the bottom will be a "Calculate!" button. Upon clicking, it should open results pane below it displaying the winning team and point differential. 
// GUI should be able to accept input changes and recalculate if button clicked again. 

//DONE: Add other 12 ballot sections on each side. 

//TODO: Input filtering. Only accept int inputs between 1 and 10. If 'calculate' button clicked when all inputs not an int between 1 and 10: reject and ask for complete, valid input. 

//TODO: Make the GUI pretty in general. Cleaner layout and more readable (i.e bigger) text are priorities.


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicBallotCalculator {
	
	public static JTextField[] piScores;
	public static JTextField piResult;
	
	public static JTextField[] deScores;
	public static JTextField deResult;
	
	public static JButton calcButton;
	public static JTextField result;
	
	public static void main(String[] args) {
		//GENERAL 0
		JFrame f = new JFrame("Graphic Ballot Calculator");
		f.getContentPane().setLayout(new BorderLayout());
		
		//HEADER
		JPanel header = new JPanel();
		header.add(new JLabel("Instructions: Please enter a whole number between 1 and 10 for every score."));
		f.getContentPane().add(header, "North");
		
		//PI (plaintiff/ prosecution)
		piScores = new JTextField[14];
		for(int i = 0; i < 14; i++) {
			piScores[i] = new JTextField(5);
		}
		piResult = new JTextField(20);
		piResult.setEditable(false);
		
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
		
		JPanel piPanel = new JPanel();
		piPanel.setLayout(new GridLayout(3,1));
		piPanel.add(new JLabel("Prosecution"));
		piPanel.add(piScorePanel);
		piPanel.add(piResultPanel);
		f.getContentPane().add(piPanel, "West");
		
		//DE (Defense)
		deScores = new JTextField[14];
		for(int i = 0; i < 14; i++) {
			deScores[i] = new JTextField(5);
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
		
		JPanel dePanel = new JPanel();
		dePanel.setLayout(new GridLayout(3,1));
		dePanel.add(new JLabel("Defense"));
		dePanel.add(deScorePanel);
		dePanel.add(deResultPanel);
		f.getContentPane().add(dePanel, "East");		
		
		
		//FOOTER
		calcButton = new JButton("Calculate");
		result = new JTextField(50);
		result.setEditable(false);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(calcButton);
		calcButton.addActionListener(new ButtonListener());
		
		JPanel resultPanel = new JPanel();
		resultPanel.add(result);
		
		JPanel footer = new JPanel();
		footer.setLayout(new GridLayout(2,1));
		footer.add(buttonPanel);
		footer.add(resultPanel);
		f.getContentPane().add(footer, "South");
		
		//GENERAL 1
		f.setSize(700,800);
		f.setVisible(true);
	}
	
	public static class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String input;
			int inputNum;
			
			int piSum = 0;
			for(int i=0; i < piScores.length; i++) {
				input = piScores[i].getText();
				inputNum = Integer.parseInt(input);
				piSum += inputNum;
			}
			piResult.setText("" + piSum);
			
			int deSum = 0;
			for(int i=0; i < deScores.length; i++) {
				input = deScores[i].getText();
				inputNum = Integer.parseInt(input);
				deSum += inputNum;
			}
			deResult.setText("" + deSum);
			
			if(piSum == deSum) {
				result.setText("*** The ballot is a tie! ***");
			}else if(piSum > deSum){
				result.setText("*** The P team wins by " + (piSum - deSum) + " point(s)! ***");
			}else {
				result.setText("*** The D team wins by " + (deSum - piSum) + " point(s)! ***");
			}
		}	
	}

}
