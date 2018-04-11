package tradingCardProject;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class UserGUI extends JFrame
{
	private int testCounter = 0;
	
	private JFrame f;
	private JPanel test;
	private JLabel testLabel;
	private JButton testButton;
	
	private Font testFont = new Font("serif", Font.BOLD, 16);

	private TestButtonHandler testHandler;
	
	public void run()
	{
		f = new JFrame();
		f.setSize(800, 600);

		test = new JPanel();
		test.setLayout(new BoxLayout(test,BoxLayout.Y_AXIS));
		test.setOpaque(false);
		
		testLabel = new JLabel("test number: 0");
		testLabel.setFont(testFont);
		
		testButton = new JButton("Test");
		testButton.setFont(testFont);
		testHandler = new TestButtonHandler();
		testButton.addActionListener(testHandler);
		
		f.getRootPane().setDefaultButton(testButton);
		f.getContentPane().add(test,BorderLayout.NORTH);

		test.add(testLabel);
		test.add(testButton);

		testLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		testButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		f.setLocationRelativeTo(null); // centers frame on screen
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		f.setTitle("Steam Trading Card Project");
		f.addWindowListener(new java.awt.event.WindowAdapter() {
   		@Override
    	public void windowClosing(java.awt.event.WindowEvent windowEvent)
		{
			JOptionPane.showMessageDialog(f, "Thank you for testing");
			System.exit(0);
		}
    	});
		f.setVisible(true);
	}
	
	public class TestButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			testCounter++;
			testLabel.setText("test number: " + testCounter);
			repaint();
		}
	}
}
