package Maman13.question2;

import javax.swing.JLabel;
import javax.swing.Timer;

public class TimerLabel extends JLabel{
	
	public TimerLabel() {
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }
}
