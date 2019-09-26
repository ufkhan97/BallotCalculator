// Accepts AMTA Ballot input and outputs which team won and by how many points (Point Differential)
// AMTA: American Mock Trial Association, a collegiate organization where two teams compete head-to-head and are assigned numeric scores by judges. Each judge assigns 14 numeric scores to each team. Each of those 14 scores is for a different part of the trial (for example: opening statements, direct examination, cross examination, closing statement)
// The winning team is the one with highest score, when summed across all 14 parts of trial

import java.util.Scanner;
import java.util.Arrays;

public class BallotCalculator {
	// TODO: Ask for and Store Input: 2 sets of 14 integers (1 set per team, 1 integer per trial section) 
	// TODO: For each team, find the SUM of their score. Calculate and output the winning team and point differential.
	public static void main(String[] args) {
		int[] piTeam = new int[14];
		int[] deTeam = new int[14];
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter ballot scores as prompted.");
		
		System.out.println("P Open: ");
		piTeam[0] = scan.nextInt();
		System.out.println("D Open: ");
		deTeam[0] = scan.nextInt();
		
		System.out.println("P Attorney 1 Direct: ");
		piTeam[1] = scan.nextInt();
		System.out.println("P Witness 1 Direct: ");
		piTeam[2] = scan.nextInt();
		System.out.println("P Witness 1 Cross: ");
		piTeam[3] = scan.nextInt();
		System.out.println("D Attorney 1 Cross: ");
		deTeam[1] = scan.nextInt();
		
		System.out.println("P Attorney 2 Direct: ");
		piTeam[4] = scan.nextInt();
		System.out.println("P Witness 2 Direct: ");
		piTeam[5] = scan.nextInt();
		System.out.println("P Witness 2 Cross: ");
		piTeam[6] = scan.nextInt();
		System.out.println("D Attorney 2 Cross: ");
		deTeam[2] = scan.nextInt();
		
		System.out.println("P Attorney 3 Direct: ");
		piTeam[7] = scan.nextInt();
		System.out.println("P Witness 3 Direct: ");
		piTeam[8] = scan.nextInt();
		System.out.println("P Witness 3 Cross: ");
		piTeam[9] = scan.nextInt();
		System.out.println("D Attorney 3 Cross: ");
		deTeam[3] = scan.nextInt();
		
		
		System.out.println("D Attorney 1 Direct: ");
		deTeam[4] = scan.nextInt();
		System.out.println("D Witness 1 Direct: ");
		deTeam[5] = scan.nextInt();
		System.out.println("D Witness 1 Cross: ");
		deTeam[6] = scan.nextInt();
		System.out.println("P Attorney 1 Cross: ");
		piTeam[10] = scan.nextInt();
		
		System.out.println("D Attorney 2 Direct: ");
		deTeam[7] = scan.nextInt();
		System.out.println("D Witness 2 Direct: ");
		deTeam[8] = scan.nextInt();
		System.out.println("D Witness 2 Cross: ");
		deTeam[9] = scan.nextInt();
		System.out.println("P Attorney 2 Cross: ");
		piTeam[11] = scan.nextInt();
		
		System.out.println("D Attorney 3 Direct: ");
		deTeam[10] = scan.nextInt();
		System.out.println("D Witness 3 Direct: ");
		deTeam[11] = scan.nextInt();
		System.out.println("D Witness 3 Cross: ");
		deTeam[12] = scan.nextInt();
		System.out.println("P Attorney 3 Cross: ");
		piTeam[12] = scan.nextInt();
		
		
		System.out.println("P Close: ");
		piTeam[13] = scan.nextInt();
		System.out.println("D Close: ");
		deTeam[13] = scan.nextInt();
		scan.close();
		
		int piSum = findSum(piTeam);
		int deSum = findSum(deTeam);
		
		System.out.println("P Team scored: " + Arrays.toString(piTeam));
		System.out.println("P Team total: " + piSum );
		System.out.println("D Team scored: " + Arrays.toString(deTeam));
		System.out.println("D Team total: " + deSum);
		
		if(piSum == deSum) {
			System.out.println("*** The ballot is a tie! ***");
		}else if(piSum > deSum){
			System.out.println("*** The P team wins by " + (piSum - deSum) + " points! ***");
		}else {
			System.out.println("*** The D team wins by " + (deSum - piSum) + " points! ***");
		}
		

	}

	public static int findSum(int[] a) {
		int sum = 0;
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
}
