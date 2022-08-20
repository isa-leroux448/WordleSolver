import java.util.Scanner;

public class main {

    // can refactor to a loop
    static void guessEveryCharacter(WordleGuesser wg, Scanner input) {
        System.out.println("Was the first character green(1), yellow (2) or grey(3)? Type 1, 2 or 3.");
        String value = input.next();
        wg.feedbackChar(value, 0);

        System.out.println("Was the second character green(1), yellow (2) or grey(3)? Type 1, 2 or 3.");
        value = input.next();
        wg.feedbackChar(value, 1);

        System.out.println("Was the third character green(1), yellow (2) or grey(3)? Type 1, 2 or 3.");
        value = input.next();
        wg.feedbackChar(value, 2);

        System.out.println("Was the fourth character green(1), yellow (2) or grey(3)? Type 1, 2 or 3.");
        value = input.next();
        wg.feedbackChar(value, 3);

        System.out.println("Was the fifth character green(1), yellow (2) or grey(3)? Type 1, 2 or 3.");
        value = input.next();
        wg.feedbackChar(value, 4);
    }

    public static void main(String[] args) {
        WordleGuesser wg = new WordleGuesser();
        Scanner input = new Scanner(System.in);
        String guess;
        int guessesLeft = 5;

        //first guess
        System.out.println("Welcome to Wordle Guesser");
        System.out.println("Our first guess is 'SOARE'");
        wg.remove("soare");
        wg.setCurrentWord("soare");
        guessesLeft -= 1;
        guessEveryCharacter(wg, input);
        wg.nextGuess();


        while (guessesLeft >= 0) {
            guessesLeft -= 1;
            if (guessesLeft < 0) {
                System.out.println("Sorry, out of guesses");
                System.out.println("What was the correct word?");
                String answer = input.next().toLowerCase();
                wg.newWord(answer);
                break;
            }
            guess = wg.firstWord();
            System.out.println("Our next guess is " + guess.toUpperCase());

            wg.setCurrentWord(guess);
            System.out.println("Was this guess correct?");
            String answer = input.next().toLowerCase();
            if (answer.equals("yes")) {
                break;
            }
            guessEveryCharacter(wg, input);
            wg.nextGuess();
        }

    }
}
