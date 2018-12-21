package Maman13.question2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class TimerLabel extends JLabel{
	
	public TimerLabel() {
        Timer timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(String.valueOf(counter));
                counter++;
                if (counter == 10) {
                    //timer.removeActionListener(this);
                      timer.stop();
                }
			}
        });
        timer.start();
    }
}
