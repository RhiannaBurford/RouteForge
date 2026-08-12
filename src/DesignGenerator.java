import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DesignGenerator extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	static DesignGenerator frame = new DesignGenerator();
	 // initial values because if i didn't add then it would be a null pointer exception
	private Grid currentGrid;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	public DesignGenerator() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(850, 850, 1300, 870);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(36, 48, 94));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(1023, 10, 253, 67);
		lblNewLabel.setIcon(new ImageIcon("Logo-darkpurple.png"));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Route Design Generator");
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 63));
		lblNewLabel_1.setForeground(new Color(248, 233, 161));
		lblNewLabel_1.setBounds(32, 34, 769, 86);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Enter your climb preferences in the fields below:");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.ITALIC, 24));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(32, 133, 533, 48);
		contentPane.add(lblNewLabel_2);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.setForeground(Color.BLACK);
		panel.setBounds(32, 204, 512, 429);
		contentPane.add(panel);
		panel.setLayout(null);

		JRadioButton SlabButton = new JRadioButton("Slab");
		SlabButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 24));
		SlabButton.setBounds(40, 168, 86, 40);
		panel.add(SlabButton);

		JRadioButton VerticalButton = new JRadioButton("Vertical");
		VerticalButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 24));
		VerticalButton.setBounds(169, 168, 144, 40);
		panel.add(VerticalButton);

		JRadioButton OverhangButton = new JRadioButton("Overhang");
		OverhangButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 24));
		OverhangButton.setBounds(328, 168, 144, 40);
		panel.add(OverhangButton);
		ButtonGroup group = new ButtonGroup(); //This makes sure that the user can only press one of the incline options
		group.add(SlabButton);
		group.add(VerticalButton);
		group.add(OverhangButton);

		JSlider DifficultySlider = new JSlider();
		DifficultySlider.setBorder(null);
		DifficultySlider.setBackground(UIManager.getColor("Button.background"));
		DifficultySlider.setValue(10);
		DifficultySlider.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		DifficultySlider.setMinimum(1);
		DifficultySlider.setMaximum(10);
		DifficultySlider.setBounds(69, 297, 362, 22);
		panel.add(DifficultySlider);

		textField = new JTextField();
		textField.setFont(new Font("Yu Gothic UI", Font.PLAIN, 22));
		textField.setBounds(22, 67, 110, 35);
		panel.add(textField);
		textField.setColumns(10);


		JButton btnNewButton_1 = new JButton("Create");
		btnNewButton_1.addActionListener(new ActionListener() {
		            
					public void actionPerformed(ActionEvent e) {
		                String StrHeight = textField.getText();
		                String incline = null;
		                int difficulty = DifficultySlider.getValue();

		                // Determining Incline
		                if (SlabButton.isSelected()) {
		                    incline = "slab";
		                } else if (VerticalButton.isSelected()) {
		                    incline = "vertical";
		                } else if (OverhangButton.isSelected()) {
		                    incline = "overhang";
		                }

		                // Input Validation
		                if (incline == null) {
		                    JOptionPane.showMessageDialog(frame, "You have not chosen an incline option!", "Invalid entry",
		                            JOptionPane.ERROR_MESSAGE);
		                } else if (StrHeight == null || StrHeight.isEmpty()) {
		                    JOptionPane.showMessageDialog(frame, "You have not chosen a height option!", "Invalid entry",
		                            JOptionPane.ERROR_MESSAGE);
		                } else if (StrHeight.equals("1") || StrHeight.equals("2")) {
		                    JOptionPane.showMessageDialog(frame, "The height is too short! Please enter a larger number.",
		                            "Invalid entry", JOptionPane.ERROR_MESSAGE);
		                } else {
		                    createGrid(StrHeight, incline, difficulty); // creating route design
		                    btnNewButton_1.setText("Regenerate"); // renaming button
		                }
		            }

		            private void createGrid(String StrHeight, String incline, int difficulty) {
		                int height = Integer.parseInt(StrHeight);
		                currentGrid = new Grid(height, incline, difficulty);
		                ((Window) currentGrid).setVisible(true); // displaying grid in new window
		            }
		        });

		        JButton btnNewButton_1_1 = new JButton("Download");
		        btnNewButton_1_1.addActionListener(new ActionListener() {//When the download button is pressed
		        
					public void actionPerformed(ActionEvent e) {

		                if (currentGrid == null) {
		                    JOptionPane.showMessageDialog(frame, "No grid has been created yet! Please create a grid first.", "Error",
		                            JOptionPane.ERROR_MESSAGE);
		                    return;
		                }

		                JFileChooser fileChooser = new JFileChooser();
		                fileChooser.setDialogTitle("Save Route as Image");
		                fileChooser.setFileFilter(new FileNameExtensionFilter("PNG Image", "png"));
		                int userSelection = fileChooser.showSaveDialog(DesignGenerator.this);

		                if (userSelection == JFileChooser.APPROVE_OPTION) {
		                    File fileToSave = fileChooser.getSelectedFile();
		                    String filePath = fileToSave.getAbsolutePath();

		                    if (!filePath.toLowerCase().endsWith(".png")) {//Error checking
		                        filePath += ".png";
		                    }

		                    try {
		                        // saving current grid as image
		                        currentGrid.saveGridAsImageFile(filePath);
		                        JOptionPane.showMessageDialog(DesignGenerator.this, "Route saved as image at: " + filePath);
		                    } catch (Exception ex) {
		                        JOptionPane.showMessageDialog(DesignGenerator.this, "Error saving the image: " 
		                    + ex.getMessage(),
		                                "Error", JOptionPane.ERROR_MESSAGE);
		                    }
		                }
		                JFileChooser textFileChooser = new JFileChooser();
		                textFileChooser.setDialogTitle("Save Volume Hold Information as Text");
		                textFileChooser.setFileFilter(new FileNameExtensionFilter("Text File", "txt"));
		                int userTextSelection = textFileChooser.showSaveDialog(DesignGenerator.this);

		                if (userTextSelection == JFileChooser.APPROVE_OPTION) {
		                    File textFileToSave = textFileChooser.getSelectedFile();
		                    String textPath = textFileToSave.getAbsolutePath();
		                    if (!textPath.toLowerCase().endsWith(".txt")) {
		                        textPath += ".txt"; // if the user ends it with something else
		                    }

		                    try {
		                        // Save volume hold information to text file
		                        currentGrid.saveVolumeHoldsInfoToFile(textPath);
		                        JOptionPane.showMessageDialog(DesignGenerator.this, "Volume hold information saved at: " 
		                        + textPath);
		                    } catch (Exception ex) {
		                        JOptionPane.showMessageDialog(DesignGenerator.this, "Error saving volume hold information: "
		                    + ex.getMessage(),
		                                "Error", JOptionPane.ERROR_MESSAGE);
		                    }}
		            }
		        });

		btnNewButton_1.setBackground(new Color(248, 233, 161));
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
		btnNewButton_1.setBounds(320, 656, 222, 55);
		contentPane.add(btnNewButton_1);
		btnNewButton_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
		btnNewButton_1_1.setBackground(new Color(247, 108, 108));
		btnNewButton_1_1.setBounds(666, 751, 222, 55);
		contentPane.add(btnNewButton_1_1);


		JButton btnNewButton_1_1_1 = new JButton("Share");                                      // SHARE BUTTON
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				String pngFilePath = System.getProperty("java.io.tmpdir") + File.separator + "route.png";
				String txtFilePath = System.getProperty("java.io.tmpdir") + File.separator + "volume_info.txt";

				// Save the grid image and volume information
				currentGrid.saveGridAsImageFile(pngFilePath);
				currentGrid.saveVolumeHoldsInfoToFile(txtFilePath);

				// Create File objects for the saved files
				File routePng = new File(pngFilePath);
				File volumeInfoTxt = new File(txtFilePath);

				String recipientEmail = JOptionPane.showInputDialog("Enter recipient's email:");
				String subject = "Climbing Route Design";
				String body = "Attached is a cool route design! I think you might like it. "; //this can be changed 
				try {
					EmailSender.sendEmail(recipientEmail, subject, body, routePng, volumeInfoTxt);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		btnNewButton_1_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
		btnNewButton_1_1_1.setBackground(new Color(247, 108, 108));
		btnNewButton_1_1_1.setBounds(990, 751, 206, 55);
		contentPane.add(btnNewButton_1_1_1);

		JLabel lblNewLabel_3_1 = new JLabel("Incline");
		lblNewLabel_3_1.setBounds(22, 112, 102, 36);
		panel.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 27));

		JLabel lblNewLabel_3 = new JLabel("Height");
		lblNewLabel_3.setBounds(22, 10, 102, 47);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 27));

		JLabel lblNewLabel_3_2 = new JLabel("Difficulty");
		lblNewLabel_3_2.setBounds(22, 234, 134, 36);
		panel.add(lblNewLabel_3_2);
		lblNewLabel_3_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 27));

		JLabel lblNewLabel_4 = new JLabel("metres");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 21));
		lblNewLabel_4.setBounds(169, 67, 72, 24);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("1");
		lblNewLabel_5.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		lblNewLabel_5.setBounds(71, 315, 16, 36);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("2");
		lblNewLabel_5_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		lblNewLabel_5_1.setBounds(110, 315, 16, 36);
		panel.add(lblNewLabel_5_1);

		JLabel lblNewLabel_5_2 = new JLabel("3");
		lblNewLabel_5_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		lblNewLabel_5_2.setBounds(151, 315, 16, 36);
		panel.add(lblNewLabel_5_2);

		JLabel lblNewLabel_5_3 = new JLabel("4");
		lblNewLabel_5_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		lblNewLabel_5_3.setBounds(190, 315, 16, 36);
		panel.add(lblNewLabel_5_3);

		JLabel lblNewLabel_5_4 = new JLabel("5");
		lblNewLabel_5_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		lblNewLabel_5_4.setBounds(225, 315, 16, 36);
		panel.add(lblNewLabel_5_4);

		JLabel lblNewLabel_5_5 = new JLabel("6");
		lblNewLabel_5_5.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		lblNewLabel_5_5.setBounds(259, 315, 16, 36);
		panel.add(lblNewLabel_5_5);

		JLabel lblNewLabel_5_6 = new JLabel("7");
		lblNewLabel_5_6.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		lblNewLabel_5_6.setBounds(297, 315, 16, 36);
		panel.add(lblNewLabel_5_6);

		JLabel lblNewLabel_5_7 = new JLabel("8");
		lblNewLabel_5_7.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		lblNewLabel_5_7.setBounds(339, 315, 16, 36);
		panel.add(lblNewLabel_5_7);

		JLabel lblNewLabel_5_8 = new JLabel("9");
		lblNewLabel_5_8.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		lblNewLabel_5_8.setBounds(377, 315, 16, 36);
		panel.add(lblNewLabel_5_8);

		JLabel lblNewLabel_5_9 = new JLabel("10");
		lblNewLabel_5_9.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		lblNewLabel_5_9.setBounds(418, 315, 26, 36);
		panel.add(lblNewLabel_5_9);

		JLabel lblNewLabel_5_10 = new JLabel("(Easy)");
		lblNewLabel_5_10.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		lblNewLabel_5_10.setBounds(50, 350, 50, 36);
		panel.add(lblNewLabel_5_10);

		JLabel lblNewLabel_5_10_1 = new JLabel("(Hard)");
		lblNewLabel_5_10_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		lblNewLabel_5_10_1.setBounds(402, 350, 56, 36);
		panel.add(lblNewLabel_5_10_1);
		ImageIcon Back = new ImageIcon("back.png");
		Image scaledImage = Back.getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				home Home = new home();
				home.run();
				dispose();
			}
		});
		btnNewButton.setBounds(32, 754, 151, 49);
		contentPane.add(btnNewButton);
		btnNewButton.setBackground(new Color(168, 208, 230));
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));

		JButton btnNewButton_1_2 = new JButton("Clear");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				group.clearSelection();
				DifficultySlider.setValue(10);
				btnNewButton_1.setText("Create");
			}
		});
		btnNewButton_1_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
		btnNewButton_1_2.setBackground(new Color(248, 233, 161));
		btnNewButton_1_2.setBounds(32, 656, 151, 55);
		contentPane.add(btnNewButton_1_2);

	}

}

