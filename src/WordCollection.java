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

    public void yellow (char letter) {
        for (Iterator<String> iterator = words.iterator(); iterator.hasNext();) {
            String word = iterator.next();
            if (word.indexOf(letter) == -1) {
                iterator.remove();
            }
        }
    }

    public void green (char letter) {
        for (Iterator<String> iterator = words.iterator(); iterator.hasNext();) {
            String word = iterator.next();
            if (word.indexOf(letter) != 0) {
                iterator.remove();
            }
        }
    }

    public void print() {
        for (Iterator<String> iterator = words.iterator(); iterator.hasNext();) {
            String word = iterator.next();
            System.out.println(word);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return words.iterator();
    }
}
