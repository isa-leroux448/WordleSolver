import java.awt.*;

public class ColouredButton extends Button {

    private Color color;

    public ColouredButton(String string) {
        super(string);
        color = Color.LIGHT_GRAY;
        setBackground(color);

        addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (color.equals(Color.lightGray)) {
                    color = Color.green;
                }
                else if (color.equals(Color.GREEN)) {
                    color = Color.yellow;
                }
                else if (color.equals(Color.yellow)) {
                    color = Color.lightGray;
                }

                setBackground(color);
                revalidate();
                repaint();
                setVisible(true);
            }
        });
    }
}