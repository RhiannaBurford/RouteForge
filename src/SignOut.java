import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class SignOut extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					SignOut frame = new SignOut();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the frame.
	 */
	public SignOut() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(200, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(36, 48, 94));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(39, 30, 509, 294);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Are you sure you");
		lblNewLabel.setBounds(110, 37, 296, 48);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 36));
		panel.add(lblNewLabel);

		JLabel lblWouldLikeTo = new JLabel("would like to sign out?");
		lblWouldLikeTo.setFont(new Font("Yu Gothic UI", Font.BOLD, 36));
		lblWouldLikeTo.setBounds(71, 95, 380, 48);
		panel.add(lblWouldLikeTo);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				home Home = new home();
				home.run();
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(168, 208, 230));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnNewButton.setBounds(35, 203, 150, 59);
		panel.add(btnNewButton);

		JButton btnYes = new JButton("YES");
		btnYes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Component frame = null;
				try {
					clearFavouriteNames();//this is a method to clear all the values stored in favourite names
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(frame, "Logged out successfully!", "Logout",
			JOptionPane.INFORMATION_MESSAGE);
			dispose();

			}
		public void clearFavouriteNames() throws IOException {
			FileWriter fw = new FileWriter("FavouriteNames.txt");
			fw.write("");
		}
		});


		btnYes.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnYes.setBackground(new Color(248, 233, 161));
		btnYes.setBounds(311, 203, 157, 59);
		panel.add(btnYes);
	}
}
