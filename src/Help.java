import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Help extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					Help frame = new Help();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the frame.
	 */
	public Help() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(850, 850, 1300, 870);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(55, 71, 133));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Help");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 63));
		lblNewLabel.setBounds(38, 39, 184, 117);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				home Home = new home();
				home.run();
				Window frame = null;
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
		btnNewButton.setBackground(new Color(168, 208, 230));
		btnNewButton.setBounds(44, 745, 178, 49);
		contentPane.add(btnNewButton);

		JTextPane txtpnRouteforgeIsAn = new JTextPane();
		txtpnRouteforgeIsAn.setBackground(Color.WHITE);
		txtpnRouteforgeIsAn.setFont(new Font("Yu Gothic UI", Font.BOLD, 21));
		txtpnRouteforgeIsAn.setText("RouteForge is an app designed for route setters and climbers!\r\n\r\nYou can use this app to generate random indoor climbing route designs - just enter your desired height, incline and difficulty, and press the 'create' button. Keep on pressing the 'regenerate' button until you have found your favourite route design, or press the 'new' button to clear all the fields if you want to try something new. If you want to store the design permanently on your computer, press the 'download' button. Or, if you want to share it with your friends, press the 'share' button to attach the design to an email!\r\n\r\nQ = Why is it saying 'The height is too short'?\r\nA = If you have entered a height lower than 2m, it wouldn't really be climbing...\r\n\r\nIf you want a cool name to match your design, use the route name generator! Press the 'create new' button to keep on displaying new names until you find your favourite. Then click the star button to add it to your favourite names collection, which you can view by following the home page. If you change your mind, you can always delete the name. ");
		txtpnRouteforgeIsAn.setBounds(38, 190, 1200, 477);
		contentPane.add(txtpnRouteforgeIsAn);
		txtpnRouteforgeIsAn.setEditable(false);
	}
}
