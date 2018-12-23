package Maman13.question2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Controller {
	private Model model;
	private View view;
	private Timer timer;
	private int counter = 14;
	private JLabel timer_lbl;

	public Controller(Model m, View v) {
		this.model = m;
		this.view = v;
		timer_lbl = new JLabel(Integer.toString(counter+1));
		timer_lbl.setPreferredSize(new Dimension(100, 100));
		timer_lbl.setFont(new Font("Serif", Font.PLAIN, 40));
		
		view.main_panel.add(timer_lbl, BorderLayout.LINE_END);
		timer = new Timer(1000, new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                timer_lbl.setText(String.valueOf(counter));
                counter--;
                if (counter == -1) {
                      timer.stop();
                }
            }
		});
		timer.restart();
	}

}
