import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Popup {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();

        JDialog jd = new JDialog(jFrame);

        jd.setLayout(new FlowLayout());

        jd.setBounds(500, 300, 400, 300);

        JLabel jLabel = new JLabel("Press close button to close the dialog.");

        JButton jButton = new JButton("Close");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jd.setVisible(false);
            }
        });

        jd.add(jLabel);
        jd.add(jButton);
        jd.setVisible(true);
    }
}

