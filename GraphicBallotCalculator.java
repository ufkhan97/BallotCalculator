// Accepts AMTA Ballot input and outputs which team won and by how many points (Point Differential)
// AMTA: American Mock Trial Association, a collegiate organization where two teams compete head-to-head and are assigned numeric scores by judges. Each judge assigns 14 numeric scores to each team. Each of those 14 scores is for a different part of the trial (for example: opening statements, direct examination, cross examination, closing statement)
// The winning team is the one with highest score, when summed across all 14 parts of trial

// Graphic should show Instructions centered at top then two columns below it. Left column is piTeam, right column is DeTeam. Each column should have 14 labeled input spots for the scores for each trial.
// Centered at the bottom will be a "Calculate!" button. Upon clicking, it should open results pane below it displaying the winning team and point differential. 
// GUI should be able to accept input changes and recalculate if button clicked again. 

//TODO: Add other 12 ballot sections on each side. Surely, there is a more efficient way to code this than copy/paste?

//TODO: Input filtering. Only accept int inputs between 1 and 10. If other value typed in, reject and ask for another input

//TODO: If 'calculate' button clicked when all inputs not an int between 1 and 10: reject and ask for complete, valid input. 

//TODO: Make the GUI pretty in general. Cleaner layout and more readable (i.e bigger) text are priorities.


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicBallotCalculator {
	
	public static JTextField piOpen;
	public static JTextField piDirect1;
	public static JTextField piResult;
	
	public static JTextField deOpen;
	public static JTextField deDirect1;
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
		piOpen = new JTextField(10);
		piDirect1 = new JTextField(10);
		piResult = new JTextField(20);
		piResult.setEditable(false);
		
		JPanel piScorePanel = new JPanel();
		piScorePanel.setLayout(new GridLayout(2,2));
		piScorePanel.add(new JLabel("P Open Score:"));
		piScorePanel.add(piOpen);
		piScorePanel.add(new JLabel("P Attorney 1 Direct Score:"));
		piScorePanel.add(piDirect1);
		
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
		deOpen = new JTextField(10);
		deDirect1 = new JTextField(10);
		deResult = new JTextField(20);
		deResult.setEditable(false);
		
		JPanel deScorePanel = new JPanel();
		deScorePanel.setLayout(new GridLayout(2,2));
		deScorePanel.add(new JLabel("D Open Score:"));
		deScorePanel.add(deOpen);
		deScorePanel.add(new JLabel("D Attorney 1 Direct Score:"));
		deScorePanel.add(deDirect1);
		
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
		f.setSize(800,800);
		f.setVisible(true);
	}
	
	public static class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			int piSum = 0;
			String input;
			int inputNum;
			input = piOpen.getText();
			inputNum = Integer.parseInt(input);
			piSum += inputNum;
			input = piDirect1.getText();
			inputNum = Integer.parseInt(input);
			piSum += inputNum;
			piResult.setText("" + piSum);
			
			int deSum = 0;
			input = deOpen.getText();
			inputNum = Integer.parseInt(input);
			deSum += inputNum;
			input = deDirect1.getText();
			inputNum = Integer.parseInt(input);
			deSum += inputNum;
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
