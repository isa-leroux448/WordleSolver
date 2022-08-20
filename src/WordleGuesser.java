import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordleGuesser {

    private WordCollection words;
    // green, yellow or grey values for each character
    private String currentGuess;
    public Map<Integer, String> wordMap;
    private List<Character> duplicates;
    private List<String> characters;
    private WordList wordList;

    public WordleGuesser() {

        this.words = new WordCollection();
        this.wordList = new WordList();
        this.words = wordList.addAllWords();
        wordMap = new HashMap<Integer, String>();

    }
    public void feedbackChar(String val, int charIndex) {
        wordMap.put(charIndex, val);
    }

    public void nextGuess() {

        characters = new ArrayList<>();
        characters.add("0");
        characters.add("1");
        characters.add("2");
        characters.add("3");
        characters.add("4");

        // from: https://www.javatpoint.com/java-program-to-find-the-duplicate-characters-in-a-string
        duplicates = new ArrayList<>();
        int count;

        //Converts given string into character array
        char string[] = currentGuess.toCharArray();

        //Counts each character present in the string
        for(int i = 0; i <string.length; i++) {
            count = 1;
            for(int j = i+1; j <string.length; j++) {
                if(string[i] == string[j] && string[i] != ' ') {
                    count++;
                    //Set string[j] to 0 to avoid printing visited character
                    string[j] = '0';
                }
            }
            //A character is considered as duplicate if count is greater than 1
            if(count > 1 && string[i] != '0')
                duplicates.add(string[i]);
        }

        if (!this.duplicates.isEmpty()) {
//            System.out.println("duplicates!");
//            System.out.println(duplicates);

            int firstIndex = currentGuess.indexOf(duplicates.get(0));
            int secondIndex = currentGuess.lastIndexOf(duplicates.get(0));

//            System.out.println(wordMap.get(firstIndex));
//            System.out.println(wordMap.get(secondIndex));

            if ((wordMap.get(firstIndex).equals("1")) && (wordMap.get(secondIndex).equals("1"))) {
                words.doubleGreen(duplicates.get(0), firstIndex, secondIndex);
            } else if ((wordMap.get(firstIndex).equals("1")) && (wordMap.get(secondIndex).equals("3"))) {
                words.green(duplicates.get(0), firstIndex);
//                printWords();
                words.deleteDuplicates(duplicates.get(0));
//                System.out.println("after duplicates");
//                printWords();
            } else if ((wordMap.get(firstIndex).equals("3")) && (wordMap.get(secondIndex).equals("1"))) {
                words.green(duplicates.get(0), secondIndex);
                words.deleteDuplicates(duplicates.get(0));
            } else if ((wordMap.get(firstIndex).equals("1")) && (wordMap.get(secondIndex).equals("2"))) {
                words.green(duplicates.get(0), firstIndex);
                words.yellow(duplicates.get(0), secondIndex);
                words.keepOnlyDuplicates(duplicates.get(0));
            } else if ((wordMap.get(firstIndex).equals("2")) && (wordMap.get(secondIndex).equals("1"))) {
                words.yellow(duplicates.get(0), firstIndex);
                words.green(duplicates.get(0), secondIndex);
                words.keepOnlyDuplicates(duplicates.get(0));
            } else if ((wordMap.get(firstIndex).equals("2")) && (wordMap.get(secondIndex).equals("2"))) {
                words.yellow(duplicates.get(0), firstIndex);
                words.yellow(duplicates.get(0), secondIndex);
                words.keepOnlyDuplicates(duplicates.get(0));
            } else if ((wordMap.get(firstIndex).equals("3")) && (wordMap.get(secondIndex).equals("2"))) {
                words.yellow(duplicates.get(0), secondIndex);
            } else if ((wordMap.get(firstIndex).equals("3")) && (wordMap.get(secondIndex).equals("3"))) {
                words.grey(duplicates.get(0));
        }


            characters.remove(Integer.toString(firstIndex));
            characters.remove(Integer.toString(secondIndex));

            for (String i: characters) {
                String val = wordMap.get(Integer.parseInt(i));
                char letter = currentGuess.charAt(Integer.parseInt(i));
                // if input is grey
                if (val.equals("3")) {
                    words.grey(letter);
                    // if input is yellow
                } else if (val.equals("2")) {
                    words.yellow(letter, Integer.parseInt(i));
                    // if input is green
                } else {
                    words.green(letter, Integer.parseInt(i));
                }
            }

        } else {
                for (int i = 0; i<5; i++) {

                    String val = wordMap.get(i); // THIS LINE IS PROBLEM

                    char letter = currentGuess.charAt(i);
                    // if input is grey
                    if (val.equals("3")) {
                        words.grey(letter);
                    // if input is yellow
                    } else if (val.equals("2")) {
                        words.yellow(letter, i);
                    // if input is green
                    } else {
                        words.green(letter, i);
                    }
                }
            }
        printWords();
        }



    public void remove(String word) {
        words.remove(word);
    }

    public void setCurrentWord(String currentWord) {
        this.currentGuess = currentWord;
        words.removeFirst();
    }

    public String firstWord() {
        return words.firstWord();
    }

    public void printWords() {
        words.print();
    }

    public void newWord(String word) {
        this.wordList.addWord(word);
    }

}




