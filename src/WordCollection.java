import java.util.ArrayList;
import java.util.Iterator;

public class WordCollection implements Iterable<String>{

    private ArrayList<String> words = new ArrayList<>();

    public void add(String word) {
        words.add(word);
    }

    public void grey (char letter) {
        for (Iterator<String> iterator = words.iterator(); iterator.hasNext(); ) {
            String word = iterator.next();
            if (word.indexOf(letter) != -1) {
                iterator.remove();
            }
        }
    }

    public void yellow (char letter, int charIndex) {
        for (Iterator<String> iterator = words.iterator(); iterator.hasNext();) {
            String word = iterator.next();
            if ((word.indexOf(letter) == -1) || (word.indexOf(letter) == charIndex)) {
                iterator.remove();
            }
        }
    }

    public void green (char letter, int charIndex) {
        for (Iterator<String> iterator = words.iterator(); iterator.hasNext();) {
            String word = iterator.next();
            if (word.indexOf(letter) != charIndex) {
                if (!detectDuplicate(word, letter)) {
                    iterator.remove();
                }
            }
        }
    }

    public void deleteDuplicates(char letter) {
        for (Iterator<String> iterator = words.iterator(); iterator.hasNext();) {
            String word = iterator.next();
            if (detectDuplicate(word, letter)){
                iterator.remove();
            }
        }
    }

    public void keepOnlyDuplicates(char letter) {
        for (Iterator<String> iterator = words.iterator(); iterator.hasNext();) {
            String word = iterator.next();
            if (!detectDuplicate(word, letter)){
                iterator.remove();
            }
        }
    }

    public void doubleGreen(char letter, int indexOne, int indexTwo) {
        for (Iterator<String> iterator = words.iterator(); iterator.hasNext();) {
            String word = iterator.next();
            // using DM
            if ((word.charAt(indexOne) != letter) || (word.charAt(indexTwo) != letter)) {
                iterator.remove();
            }
        }
    }

    public String firstWord() {
        Iterator<String> iterator = words.iterator();
        String word = iterator.next();
        return word;
    }


    public void print() {
        for (Iterator<String> iterator = words.iterator(); iterator.hasNext();) {
            String word = iterator.next();
            System.out.println(word);
        }
    }

    public void remove(String word) {
//        int index = -1;
        for (Iterator<String> iterator = words.iterator(); iterator.hasNext();) {
            String cur = iterator.next();
            if (cur.equals(word)) {
                words.remove(cur);
//                index = words.indexOf(cur);
            }
        }
//        if (index > -1) {
//            words.remove(words.get(index));
//        }
    }

    public void removeFirst() {
        Iterator<String> iterator = words.iterator();
        String cur = iterator.next();
        words.remove(cur);
    }

    public boolean detectDuplicate(String word, char letter) {
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                if ((word.charAt(i) == word.charAt(j)) && (word.charAt(i) == letter)) {
                    return true;
                    }
                }
            }
        return false;
    }

    public boolean contains(String word) {
        for (String w: words) {
            if (word.equals(w)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Iterator<String> iterator() {
        return words.iterator();
    }
}
