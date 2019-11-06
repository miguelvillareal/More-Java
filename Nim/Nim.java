import java.util.Random;
import java.util.Scanner;
public class Nim{
	public static void main(String[] args)
	{
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		int pileSize = rand.nextInt(101) + 10;
		int firstTurn = rand.nextInt(2) + 0;
		int mode = rand.nextInt(2) + 0;

		System.out.println("Current number of marbles in pile: " + pileSize);

		if (mode == 0){
			System.out.println("Computer is in stupid mode.");


		}	else {
				System.out.println("Computer is in smart mode.");
				}

		while (pileSize > 1){
			if (firstTurn == 1){
				System.out.println("How many marbles do you want to remove?:");
				int playerTurn = scanner.nextInt();
				pileSize = pileSize - playerTurn;
				System.out.println("Current number of marbles in pile: " + pileSize);
				firstTurn = 0;

			}
			if (firstTurn == 0){
				if (mode == 0){
					int computerTurn = rand.nextInt((pileSize+1)/2) + 1;
					System.out.println("The computer removes " + computerTurn + " marble(s)");
					pileSize = pileSize- computerTurn;
					System.out.println("Current number of marbles in pile: " + pileSize);
					firstTurn = 1;
				}
				if (mode ==1) {
					int computerTurn = smartMode(pileSize);
					pileSize = pileSize - computerTurn;
					System.out.println("The computer removes " + pileSize + " marble(s)");
					System.out.println("Current number of marbles in pile: " + computerTurn);
					pileSize = computerTurn;
					firstTurn = 1;
				}
			}
		}
	}
	public static int smartMode (int marbles){
		int power = 2;
		while (power < marbles){
			power *= 2;
		}
		power /= 2;
		marbles = power - 1;
		return marbles;
	}
}
