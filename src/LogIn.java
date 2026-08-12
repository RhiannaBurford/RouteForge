import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.CompoundBorder;

public class LogIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static LogIn frame = new LogIn();
	private JTextField Username;
	private JTextField Password;

	public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            @Override
				public void run() {
	                try {
	                    LogIn frame = new LogIn();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public LogIn() {
		setFont(new Font("Algerian", Font.PLAIN, 12));
		setBackground(Color.BLACK);
		setTitle("Login Page");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(450, 450, 520, 540); //this changes the size of the window
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		getContentPane().setBackground(new java.awt.Color(36, 48, 94));
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sign In");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 41));
		lblNewLabel.setBounds(34, 43, 441, 66);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 26));
		lblNewLabel_1.setBounds(34, 119, 131, 37);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 26));
		lblNewLabel_1_1.setBounds(34, 249, 131, 37);
		contentPane.add(lblNewLabel_1_1);

		Username = new JTextField();
		Username.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 19));
		Username.setBackground(new Color(248, 233, 161));
		Username.setBounds(34, 166, 441, 58);
		contentPane.add(Username);
		Username.setColumns(10);

		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Register reg = new Register();
				reg.run();
				dispose();
				frame.setVisible(false);}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(168, 208, 230));
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 26));
		btnNewButton.setBounds(61, 406, 138, 51);
		contentPane.add(btnNewButton);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    try {
			        FileReader fr = new FileReader("login.txt");
			        BufferedReader br = new BufferedReader(fr);
			        String line = br.readLine();
			        boolean userExists = false;  // this tracks if the username exists
			        boolean flag = false;  // this tracks if both username and password correct
			        String checkuser = Username.getText();
			        String checkpwd = Password.getText();
			        while (line != null) {
			            String[] data = line.split(",");
			            if (data[0].equals(checkuser)) {
			                userExists = true;  
			                if (data[1].equals(checkpwd)) {
			                    System.out.println("Login successful!");
			                    flag = true;  // only when both username and password are correct
			                    break;
			                }
			            }
			            line = br.readLine();
			        }
			        br.close(); 
			        if (flag) {
			        	JOptionPane.showMessageDialog(frame, "Correct login details provided. Press OK to head to the main screen",
			        			"Access to app granted",
			                    JOptionPane.INFORMATION_MESSAGE);
			            home tp = new home();
			            home.run();  // get home page 
			            dispose();
			        } else if (userExists) {
			            // if username exists and password is incorrect
			            JOptionPane.showMessageDialog(frame, "Incorrect password!", "Login failed",
			                    JOptionPane.ERROR_MESSAGE);
			        } else {
			            // if username does not exist
			            JOptionPane.showMessageDialog(frame, "User does not exist!", "Login failed",
			                    JOptionPane.ERROR_MESSAGE);
			        }
			    } catch (IOException e1) {
			        System.out.println(e1.getMessage());
			    }
			}

		});
		btnLogin.setBackground(new Color(168, 208, 230));
		btnLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 26));
		btnLogin.setBounds(311, 406, 138, 51);
		contentPane.add(btnLogin);

		Password = new JTextField();
		Password.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 19));
		Password.setColumns(10);
		Password.setBackground(new Color(248, 233, 161));
		Password.setBounds(34, 296, 441, 58);
		contentPane.add(Password);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setIcon(new ImageIcon("src/route-forge-high-resolution-logo-white-transparent.png"));
		lblNewLabel_2.setBounds(237, 0, 259, 70);
		contentPane.add(lblNewLabel_2);
		JLabel label1 = new JLabel("Sign In");
		label1.setText("Sign In");
	}


}
