import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainFrame1 extends JFrame {

	private static Chain chain = new Chain();
	private static JTextField name;
	private static JTextField age;
	private static JPanel contentPane;
	private static Choice choice;
	private static ImageIcon soora;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame1 frame = new MainFrame1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame1() {
		DecimalFormat fmt = new DecimalFormat("0.00000");

		setResizable(false);
		setVisible(true);
		setTitle("WhatsMyHashRate.io");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 200);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon frameIcon = new ImageIcon("minerLogo.png");
		setIconImage(frameIcon.getImage());

		JLabel labelName = new JLabel("Name");
		labelName.setBounds(10, 10, 33, 13);
		contentPane.add(labelName);
		labelName.setForeground(Color.white);
		name = new JTextField();
		name.setBounds(48, 7, 162, 19);
		contentPane.add(name);
		name.setColumns(10);

		JLabel labelAge = new JLabel("Age");
		labelAge.setBounds(10, 50, 33, 13);
		contentPane.add(labelAge);
		labelAge.setForeground(Color.white);
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(48, 47, 162, 19);
		contentPane.add(age);

		JLabel labelCoin = new JLabel("Coin");
		labelCoin.setBounds(10, 92, 33, 13);
		contentPane.add(labelCoin);
		labelCoin.setForeground(Color.white);
		JButton btnNewButton = new JButton("Calculate Hash Rate");
		Cursor loading = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);

		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setCursor(loading);
				chain.run();
				String namePrint = name.getText();
				String nameString = "Hello " + namePrint + "!";
				String coinString = "Your PC can mine " + choice.getSelectedItem()
						+ " at the following specifications:";
				String loadString = "System Load Allocation: " + fmt.format(chain.load) + " %";
				String countString = "Hash Count: " + chain.n;
				String timeString = "Time Taken: " + chain.time + " seconds";
				String rateString = "";
				double Hash = chain.Hash;

				if (Hash > 1000000) {
					String HashS = fmt.format(Hash / 1000000);
					rateString = "Hash Rate: " + HashS + " MHash/Second";
				} else if (Hash > 1000) {
					String HashS = fmt.format(Hash / 1000);
					rateString = rateString = "Hash Rate: " + HashS + " KHash/Second";
				} else {
					String HashS = fmt.format(Hash);
					rateString = "Hash Rate: " + HashS + " Hash/Second";
				}
				setVisible(false);
				MainFrame2 frame2 = new MainFrame2(nameString, coinString, loadString, countString, timeString,
						rateString);
				frame2.setVisible(true);
				frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

			}
		});
		choice = new Choice();
		choice.setBounds(48, 87, 162, 15);
		contentPane.add(choice);
		choice.add("None");
		choice.add("TestCoin");
		Color gold = new Color(187, 161, 79);
		btnNewButton.setToolTipText("");
		btnNewButton.setBackground(gold);
		btnNewButton.setBounds(choice.getX() + 180, choice.getY() + 30, 160, 30);
		contentPane.add(btnNewButton);

		JLabel imageHold = new JLabel();
		soora = new ImageIcon("bitcoin-stock-photo-500x200.jpg");
		imageHold.setIcon(soora);
		imageHold.setBounds(0, 0, 500, 200);
		contentPane.add(imageHold);

	}

}
