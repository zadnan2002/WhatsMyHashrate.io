import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.Color;

public class ExtraFrame {

	private static JPanel contentPane;
	private static JFrame frame;
	private static JProgressBar progressBar;

	public static void main (String[] args) {

		frame = new JFrame();
		frame.setTitle("M    I    N    I    N    G");
		frame.setBackground(Color.BLACK);
		frame.setForeground(Color.BLACK);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 113);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);

		progressBar = new JProgressBar();
		progressBar.setForeground(Color.MAGENTA);
		progressBar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		progressBar.setStringPainted(true);
		contentPane.add(progressBar, BorderLayout.CENTER);
		
		run();
	}
	
	public static void run() {
		for (int i = 0; i <= 100; i++) {
			progressBar.setValue(i);
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}