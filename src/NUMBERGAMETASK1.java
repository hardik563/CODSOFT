import java.util.Random;
import java.util.Scanner;
public class NUMBERGAMETASK1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        boolean playAgain;

        System.out.println(" WELCOME \n GET READY TO PLAY THE NUMBER GUESSING GAME !");

        do {
            System.out.println("\nLET SELECT THE DIFFICULTY LEVEL:");
            System.out.println("1.  LEVEL EASY (1-50,  TOTAL 10 ATTEMPTS)");
            System.out.println("2. LEVEL MEDIUM (1-100, TOTAL 7 ATTEMPTS");
            System.out.println("3. LEVEL HARD (1-200, TOTAL 5 ATTEMPTS)");
            System.out.print("ENTER OPTION (1/2/3): ");
            int difficultylevel = scanner.nextInt();

            int minrange = 1;
            int maxrange = 100;
            int maxguess = 7;

            switch (difficultylevel) {
                case 1:
                    maxrange = 50;
                    maxguess = 10;
                    break;
                case 2:
                    maxrange = 100;
                    maxguess = 7;
                    break;
                case 3:
                    maxrange = 200;
                    maxguess = 5;
                    break;
                default:
                    System.out.println("Invalid choice. Defaulting to Medium.");
            }

            int target = random.nextInt(maxrange - minrange + 1) + minrange;
            int attempts = 0;
            boolean isGuessed = false;

            System.out.println("\nI've picked a number between " + minrange + " and " + maxrange + ".");

            while (attempts < maxguess) {
                System.out.print("Guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == target) {
                    System.out.println("Correct! You got it in " + attempts + " attempts.");
                    score += (maxguess - attempts + 1) * difficultylevel;
                    isGuessed = true;
                    break;
                } else if (guess < target) {
                    System.out.println("Too low.....");
                } else {
                    System.out.println("Too high.....");
                }
            }

            if (!isGuessed) {
                System.out.println("No more attempts left. The number was " + target + ".");
            }

            System.out.println(" Your Score: " + score);
            System.out.print("DO YOU WANT TO PLAY AGAIN? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println(" ACCORDING TO THE PERFORMANCE THE FINAL SCORE: " + score);
    }
}