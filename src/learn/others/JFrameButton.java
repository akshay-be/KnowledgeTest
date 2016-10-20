package learn.others;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class JFrameButton extends JFrame 
{

	public void initUI()
	{
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		panel.setLayout(null);
		
		JButton quitButton = new JButton("Lets Go");
		quitButton.setBounds(50, 60, 80, 30);
		quitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
