import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class WordleUI extends JFrame {

    private static final int PADDING = 50;
    private static final int ROW_HEIGHT = 50;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;

    private Border border;
    private GridLayout rowLayout;
    private JPanel row0;
    private JPanel row1;
    private JPanel row2;
    private JPanel row3;
    private JPanel row4;
    private JPanel row5;
    private JPanel row6;
    private JButton check;
    private int wordCount;
    private JPanel pbuttons;
    private ArrayList<ColouredButton> cbuttons;
//    private ColouredButton pbutton1;
//    private ColouredButton pbutton2;
//    private ColouredButton pbutton3;
//    private ColouredButton pbutton4;
//    private ColouredButton pbutton5;
    private ArrayList<Tile> tiles;
    private ArrayList<JLabel> words;
    private String currentWord;
    private WordleGuesser wg;




    public static void main(String[] args) {
        new WordleUI();
    }

    public WordleUI() {
        super("Wordle Guesser");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tiles = new ArrayList<>();
        cbuttons = new ArrayList<>();
        words = new ArrayList<>();
        currentWord = "SOARE";

        wg = new WordleGuesser();
        wg.setCurrentWord("soare");
        wg.remove("soare");
        wordCount = 0;

        border = BorderFactory.createEmptyBorder(0, 0, 0, 0);
        rowLayout = new GridLayout(8, 6);
        setSize(new Dimension(WIDTH, HEIGHT));
        setLayout(rowLayout);

        setup();

        setVisible(true);

    }

    private void setup() {
        placeRow0();
        placeRow1();
        placeRow2();
        placeRow3();
        placeRow4();
        placeRow5();
        placeRow6();
        checkButton();
    }

    public void placeRow0() {
        row0 = new JPanel();
        row0.setPreferredSize(new Dimension(WIDTH, ROW_HEIGHT));
        row0.setBorder(border);
        JLabel title = new JLabel("Wordle Guesser", SwingConstants.CENTER);
        row0.add(title);
        add(row0);

    }

    public void placeRow1() {
        row1 = new JPanel();
        row1.setPreferredSize(new Dimension(WIDTH, ROW_HEIGHT));
        row1.setBorder(border);

        JLabel word1 = new JLabel("SOARE");

        words.add(word1);
        row1.add(word1);
        for (int i = 0; i<5; i++) {
            Tile tile = new Tile();
            tiles.add(tile);
            row1.add(tile);
        }
        add(row1);
    }

    public void placeRow2() {
        row2 = new JPanel();
        row2.setPreferredSize(new Dimension(WIDTH, ROW_HEIGHT));
        row2.setBorder(border);

        JLabel word2 = new JLabel();
        words.add(word2);
        row2.add(word2);
        for (int i = 0; i<5; i++) {
            Tile tile = new Tile();
            tiles.add(tile);
            row2.add(tile);
        }
        add(row2);
    }

    public void placeRow3() {
        row3 = new JPanel();
        row3.setPreferredSize(new Dimension(WIDTH, ROW_HEIGHT));
        row3.setBorder(border);

        JLabel word3 = new JLabel();
        words.add(word3);
        row3.add(word3);
        for (int i = 0; i<5; i++) {
            Tile tile = new Tile();
            tiles.add(tile);
            row3.add(tile);
        }
        add(row3);
    }

    public void placeRow4() {
        row4 = new JPanel();
        row4.setPreferredSize(new Dimension(WIDTH, ROW_HEIGHT));
        row4.setBorder(border);

        JLabel word4 = new JLabel();
        words.add(word4);
        row4.add(word4);
        for (int i = 0; i<5; i++) {
            Tile tile = new Tile();
            tiles.add(tile);
            row4.add(tile);
        }
        add(row4);
    }

    public void placeRow5() {
        row5 = new JPanel();
        row5.setPreferredSize(new Dimension(WIDTH, ROW_HEIGHT));
        row5.setBorder(border);

        JLabel word5 = new JLabel();
        words.add(word5);
        row5.add(word5);
        for (int i = 0; i<5; i++) {
            Tile tile = new Tile();
            tiles.add(tile);
            row5.add(tile);
        }
        add(row5);

    }

    public void placeRow6() {
        row6 = new JPanel();
        row6.setPreferredSize(new Dimension(WIDTH, ROW_HEIGHT));
        row6.setBorder(border);

        JLabel word6 = new JLabel();
        words.add(word6);
        row6.add(word6);
        for (int i = 0; i<5; i++) {
            Tile tile = new Tile();
            tiles.add(tile);
            row6.add(tile);
        }
        add(row6);
    }

    public void checkButton() {
        JPanel row = new JPanel();
        row.setPreferredSize(new Dimension(WIDTH, ROW_HEIGHT));
        row.setBorder(border);
        JButton check = new JButton("Check");
        row.add(check);
        add(row);

        check.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (wordCount < 6) {
                JFrame popup = new JFrame("MyPanel");
                popup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //popup.getContentPane().add(new JPanel());
                //popup.pack();
                popup.setVisible(true);

                popup.setLayout(new GridLayout(3, 1));
                popup.setSize(new Dimension(WIDTH, HEIGHT/2));

                JPanel plabel = new JPanel();
                plabel.add(new JLabel("word"));
                popup.add(plabel);

                pbuttons = new JPanel();
                pbuttons.setPreferredSize(new Dimension(WIDTH, ROW_HEIGHT/2));
                pbuttons.setBorder(border);

                for (int i=0; i<5; i++) {
                    ColouredButton pbutton;
                    if (wordCount == 0) {
                        pbutton = new ColouredButton(Character.toString(currentWord.charAt(i)).toUpperCase());
                    } else {
                        pbutton = new ColouredButton(Character.toString(wg.firstWord().charAt(i)).toUpperCase());
                    }
                    cbuttons.add(pbutton);
                    pbuttons.add(pbutton);
                }
                popup.add(pbuttons);

//                pbutton1 = new ColouredButton("a");
//                pbutton2 = new ColouredButton("b");
//                pbutton3 = new ColouredButton("c");
//                pbutton4 = new ColouredButton("d");
//                pbutton5 = new ColouredButton("e");
//                pbuttons.add(pbutton1);
//                pbuttons.add(pbutton2);
//                pbuttons.add(pbutton3);
//                pbuttons.add(pbutton4);
//                pbuttons.add(pbutton5);

                JPanel pcheck = new JPanel();
                JButton pcheckb = new JButton(("Check"));
                pcheck.add(pcheckb);
                popup.add(pcheckb);

                pcheckb.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        updateSquares();
                        popup.dispose();
                    }
                });
            }}
        });
    }

    public void updateSquares() {
            wordCount += 1;

            int firstSquare = (wordCount-1) * 5;
            int counter = 0;
            for (int i = firstSquare; i < firstSquare+5; i++) {
                Color color = cbuttons.get(i).getBackground();
                tiles.get(i).setColor(color);

                if (color.equals(Color.GREEN)) {
                    wg.feedbackChar("1", counter);
                } else if (color.equals(Color.YELLOW)) {
                    wg.feedbackChar("2", counter);
                } else if (color.equals(Color.LIGHT_GRAY)) {
                    wg.feedbackChar("3", counter);
                }
                counter ++;
            }

                if (wordCount > 1) {
                    currentWord = wg.firstWord();
                    wg.setCurrentWord(currentWord);
                }

                wg.nextGuess();

        if (wordCount < 6) {
            words.get(wordCount).setText(wg.firstWord().toUpperCase());
        }

        repaint();
    }

    }
