import java.util.Scanner;

public class WordleGuesser {

    private WordCollection words;
    private Scanner input;
    // green, yellow or grey values for each character
    private int val1;
    private int val2;
    private int val3;
    private int val4;
    private int val5;
    private int guessesLeft;
    private String currentGuess;

    public WordleGuesser() {

        // initializes sample list
        this.words = new WordCollection();
        this.words.add("frame");
        this.words.add("graze");
        this.words.add("windy");
        this.words.add("gourd");
        this.words.add("swing");

        // some randoms:
        this.words.add("badge");
        this.words.add("slime");
        this.words.add("famed");
        this.words.add("honey");

        this.val1 = 0;
        this.val2 = 0;
        this.val3 = 0;
        this.val4 = 0;
        this.val5 = 0;
        this.guessesLeft = 6;

        // for test purposes:
        // word is graze
        this.currentGuess = "gourd";
        // 3 tests
        // Grey: swing; remaining is all
        // Yellow: rakes; remaining should be gourd
        // Green: gourd; no remaining
    }

    public void feedbackChar(int val) {
        // need to use iterator
        char letter = currentGuess.charAt(0);
        // if input is grey
        if (val == 3) {
            words.grey(letter);
            // if input is yellow
        } else if (val == 2) {
            words.yellow(letter);
            // if input is green
        } else {
            words.green(letter);
        }
        words.print();
    }
}

// System.out.println("Was the first character green(1), yellow (2) or grey(3)? Insert 1, 2 or 3.");



