
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameReg;
	private JTextField passwordReg;
	private JTextField confirmpassReg;


	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public Register() {
		setBackground(Color.BLACK);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(450, 450, 520, 690);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(55, 71, 133));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 41));
		lblNewLabel.setBounds(31, 38, 261, 65);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 26));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(31, 108, 133, 36);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 26));
		lblNewLabel_1_1.setBounds(31, 229, 133, 36);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Confirm Password");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 26));
		lblNewLabel_1_2.setBounds(31, 348, 235, 36);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_2 = new JLabel("Your password must contain at least 12 characters, 1 ");
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setForeground(new Color(168, 208, 230));
		lblNewLabel_2.setBounds(31, 462, 452, 65);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.setBackground(new Color(168, 208, 230));
		btnNewButton.addActionListener(new ActionListener() {


		@Override
		public void actionPerformed(ActionEvent e)  {
			String username = usernameReg.getText();
			String password = passwordReg.getText();
			String confirmpassword = confirmpassReg.getText();
			//if the password and confirm password matches
			if (!password.equals(confirmpassword)) {
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "Passwords do not match!", "Registration failed",
		                    JOptionPane.ERROR_MESSAGE);
			}
			//if the password is valid (12 characters, 1 number and 1 symbol)
			else if (!ValidPass(password)) {
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "Password must be at least 12 characters long,"
						+ " and contain at least one number and one symbol.",
						"Registration failed", JOptionPane.ERROR_MESSAGE);
			}
			else {
				try {
					PrintWriter pw = new PrintWriter(new FileWriter("login.txt"));
					pw.write(username+","+password);
					pw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "Your account has been created!",
						"Registration successful", JOptionPane.INFORMATION_MESSAGE);

				LogIn lg = new LogIn();
				lg.run();
				dispose();
			}
		}

			private boolean ValidPass(String password) {//method for checking if password is valid
				int length = password.length();
				String specialChar = "!£$%^&*()_-+={}[];:@=~#<,>.?/|\";";
				if (length < 12) {
					return false;
				}
				boolean hasNum = false;
				boolean hasSymbol = false;
				for (char c : password.toCharArray()) {//Found on GeeksforGeeks
					if (Character.isDigit(c)) {
						hasNum = true;
					}

					if (specialChar.contains(Character.toString(c))){
						hasSymbol = true;
					}

				}
				if (hasNum && hasSymbol) {
					return true;
				}
				else {
					return false;
				}
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 22));
		btnNewButton.setBounds(283, 565, 200, 50);
		contentPane.add(btnNewButton);

		usernameReg = new JTextField();
		usernameReg.setForeground(new Color(0, 0, 0));
		usernameReg.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 19));
		usernameReg.setBackground(new Color(248, 233, 161));
		usernameReg.setBounds(31, 160, 448, 58);
		contentPane.add(usernameReg);
		usernameReg.setColumns(10);

		passwordReg = new JTextField();
		passwordReg.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 19));
		passwordReg.setColumns(10);
		passwordReg.setBackground(new Color(248, 233, 161));
		passwordReg.setBounds(31, 275, 448, 58);
		contentPane.add(passwordReg);

		confirmpassReg = new JTextField();
		confirmpassReg.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 19));
		confirmpassReg.setColumns(10);
		confirmpassReg.setBackground(new Color(248, 233, 161));
		confirmpassReg.setBounds(31, 394, 448, 58);
		contentPane.add(confirmpassReg);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("src/route-forge-high-resolution-logo-white-transparent.png"));
		lblNewLabel_3.setBounds(235, 0, 271, 71);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_2_1 = new JLabel("number and 1 symbol.");
		lblNewLabel_2_1.setForeground(new Color(168, 208, 230));
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1.setBackground(Color.BLACK);
		lblNewLabel_2_1.setBounds(31, 487, 452, 65);
		contentPane.add(lblNewLabel_2_1);
	}
}
