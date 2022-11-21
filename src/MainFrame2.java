import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainFrame2 extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame2 frame = new MainFrame2(null, null, null, null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame2(String name, String coin, String loadAll, String hashCount, String timeTaken, String rate) {
		setVisible(false);
		setResizable(false);
		setVisible(true);

		setTitle("WhatsMyHashRate.io");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon frameIcon = new ImageIcon("minerLogo.png");
		setIconImage(frameIcon.getImage());
		JButton btnNewButton = new JButton("Calculate Again");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MainFrame1 frame1 = new MainFrame1();
				frame1.setVisible(true);
			}
		});
		btnNewButton.setBounds(0, 205, 427, 22);
		contentPane.add(btnNewButton);

		JLabel nameLabel = new JLabel("");
		nameLabel.setVerticalAlignment(SwingConstants.TOP);
		nameLabel.setBounds(10, 10, 397, 22);
		contentPane.add(nameLabel);

		JLabel coinLabel = new JLabel("");
		coinLabel.setVerticalAlignment(SwingConstants.TOP);
		coinLabel.setBounds(10, 42, 397, 22);
		contentPane.add(coinLabel);

		JLabel loadLabel = new JLabel("");
		loadLabel.setVerticalAlignment(SwingConstants.TOP);
		loadLabel.setBounds(10, 74, 397, 22);
		contentPane.add(loadLabel);

		JLabel countLabel = new JLabel("");
		countLabel.setVerticalAlignment(SwingConstants.TOP);
		countLabel.setBounds(10, 106, 397, 22);
		contentPane.add(countLabel);

		JLabel timeLabel = new JLabel("");
		timeLabel.setVerticalAlignment(SwingConstants.TOP);
		timeLabel.setBounds(10, 138, 397, 22);
		contentPane.add(timeLabel);

		JLabel rateLabel = new JLabel("");
		rateLabel.setVerticalAlignment(SwingConstants.TOP);
		rateLabel.setBounds(10, 173, 397, 22);
		contentPane.add(rateLabel);

		nameLabel.setText(name);
		coinLabel.setText(coin);
		loadLabel.setText(loadAll);
		countLabel.setText(hashCount);
		timeLabel.setText(timeTaken);
		rateLabel.setText(rate);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 62, 427, 2);
		contentPane.add(separator);

	}
}
