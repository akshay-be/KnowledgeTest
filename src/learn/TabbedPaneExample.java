package learn;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class TabbedPaneExample extends JPanel 
{
	public TabbedPaneExample()
	{
		JTabbedPane example = new JTabbedPane();
		JPanel panel1 =null;
	}
	
	protected JPanel createInnerPanel(String text)
	{
		JPanel jp = new JPanel();
		JLabel jd = new JLabel(text);
		jd.setHorizontalAlignment(JLabel.CENTER);
		jp.setLayout(new GridLayout(0,2));
		jp.add(jd);
		return jp;
	}
	public static void main(String[] args)
	{
		JFrame fram = new JFrame("TabbedPane Source Deom");
		fram.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		fram.getContentPane().add(new TabbedPaneExample(), BorderLayout.CENTER);
	}
}
