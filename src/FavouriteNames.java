import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class FavouriteNames extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public void run() {
        try {
            FavouriteNames frame = new FavouriteNames();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the frame.
     * @throws IOException
     */
    public FavouriteNames() throws IOException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(850, 850, 1300, 870);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(168, 208, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Favourite Names");
        lblNewLabel.setForeground(new Color(36, 48, 94));
        lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 63));
        lblNewLabel.setBounds(48, 10, 571, 109);
        contentPane.add(lblNewLabel);

        JLabel BlueLogo = new JLabel("");
        ImageIcon originalIcon = new ImageIcon("blue route forge logo.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(240, 60, Image.SCALE_SMOOTH);
        ImageIcon blueLogo = new ImageIcon(scaledImage);
        BlueLogo.setIcon(blueLogo);
        BlueLogo.setBounds(1036, 10, 240, 87);
        contentPane.add(BlueLogo);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
        panel.setBounds(48, 129, 1167, 548);
        contentPane.add(panel);
        panel.setLayout(null);

        JTextArea textArea1 = new JTextArea();
        textArea1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 37));
        textArea1.setBounds(35, 10, 764, 64);
        panel.add(textArea1);
        textArea1.setEditable(false);

        JTextArea textArea2 = new JTextArea();
        textArea2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 37));
        textArea2.setEditable(false);
        textArea2.setBounds(35, 70, 764, 64);
        panel.add(textArea2);

        JTextArea textArea3 = new JTextArea();
        textArea3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 37));
        textArea3.setEditable(false);
        textArea3.setBounds(35, 130, 764, 64);
        panel.add(textArea3);

        JTextArea textArea4 = new JTextArea();
        textArea4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 37));
        textArea4.setEditable(false);
        textArea4.setBounds(35, 189, 764, 64);
        panel.add(textArea4);

        JTextArea textArea5 = new JTextArea();
        textArea5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 37));
        textArea5.setEditable(false);
        textArea5.setBounds(35, 241, 764, 64);
        panel.add(textArea5);

        JTextArea textArea6 = new JTextArea();
        textArea6.setFont(new Font("Yu Gothic UI", Font.PLAIN, 37));
        textArea6.setEditable(false);
        textArea6.setBounds(35, 300, 764, 64);
        panel.add(textArea6);

        JTextArea textArea7 = new JTextArea();
        textArea7.setFont(new Font("Yu Gothic UI", Font.PLAIN, 37));
        textArea7.setEditable(false);
        textArea7.setBounds(35, 356, 764, 64);
        panel.add(textArea7);

        JTextArea textArea8 = new JTextArea();
        textArea8.setFont(new Font("Yu Gothic UI", Font.PLAIN, 37));
        textArea8.setEditable(false);
        textArea8.setBounds(35, 419, 764, 64);
        panel.add(textArea8);

        JTextArea textArea9 = new JTextArea();
        textArea9.setFont(new Font("Yu Gothic UI", Font.PLAIN, 37));
        textArea9.setEditable(false);
        textArea9.setBounds(35, 474, 764, 64);
        panel.add(textArea9);
        JTextArea[] textAreas = new JTextArea[]{textArea1, textArea2, textArea3, textArea4, textArea5, textArea6, textArea7, textArea8, textArea9};

        JButton btnNewButton_1 = new JButton("Delete");
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                try {
                	 FileWriter fw = new FileWriter("TempFavNames.txt",true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     FileReader reader = new FileReader("FavouriteNames.txt");
                     BufferedReader br = new BufferedReader(reader);
                    String nameToRemove = textArea2.getText(); // change to textArea1 if not working
                    String line = br.readLine();
                    while (line!=null) {
                        if (!line.trim().equals(nameToRemove)) {
                            fw.write(line);
                            bw.newLine();
                        }
                        line = br.readLine();
                    }
                    br.close();
                    reader.close();
                    bw.close();
                    fw.close();
                    File original = new File("FavouriteNames.txt");
                    File temp = new File("TempFavNames.txt");
                    if (original.delete()) {
                        temp.renameTo(original);
                    }
                    textArea1.setText("");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 23));
        btnNewButton_1.setBackground(new Color(247, 108, 108));
        btnNewButton_1.setBounds(979, 10, 164, 41);
        panel.add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("Delete");
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		try {
        			FileWriter fw = new FileWriter("TempFavNames.txt",true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    FileReader reader = new FileReader("FavouriteNames.txt");
                    BufferedReader br = new BufferedReader(reader);String nameToRemove = textArea1.getText();
                    String line = br.readLine();
                    while (line!=null) {
                        if (!line.trim().equals(nameToRemove)) {
                            fw.write(line);
                            bw.newLine();
                        }
                        line = br.readLine();
                    }
                    br.close();
                    reader.close();
                    bw.close();
                    fw.close();
                    File original = new File("FavouriteNames.txt");
                    File temp = new File("TempFavNames.txt");
                    if (original.delete()) {
                        temp.renameTo(original);
                    }
                    textArea2.setText("");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        	}
        });
        btnNewButton_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 23));
        btnNewButton_1_1.setBackground(new Color(247, 108, 108));
        btnNewButton_1_1.setBounds(979, 70, 164, 41);
        panel.add(btnNewButton_1_1);

        JButton btnNewButton_1_2 = new JButton("Delete");
        btnNewButton_1_2.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		try {
        			FileWriter fw = new FileWriter("TempFavNames.txt",true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    FileReader reader = new FileReader("FavouriteNames.txt");
                    BufferedReader br = new BufferedReader(reader);String nameToRemove = textArea2.getText();
                    String line = br.readLine();
                    while (line!=null) {
                        if (!line.trim().equals(nameToRemove)) {
                            fw.write(line);
                            bw.newLine();
                        }
                        line = br.readLine();
                    }
                    br.close();
                    reader.close();
                    bw.close();
                    fw.close();
                    File original = new File("FavouriteNames.txt");
                    File temp = new File("TempFavNames.txt");
                    if (original.delete()) {
                        temp.renameTo(original);
                    }
                    textArea3.setText("");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        	}
        });
        btnNewButton_1_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 23));
        btnNewButton_1_2.setBackground(new Color(247, 108, 108));
        btnNewButton_1_2.setBounds(979, 131, 164, 41);
        panel.add(btnNewButton_1_2);

        JButton btnNewButton_1_3 = new JButton("Delete");
        btnNewButton_1_3.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		try {
        			FileWriter fw = new FileWriter("TempFavNames.txt",true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    FileReader reader = new FileReader("FavouriteNames.txt");
                    BufferedReader br = new BufferedReader(reader);String nameToRemove = textArea3.getText();
                    String line = br.readLine();
                    while (line!=null) {
                        if (!line.trim().equals(nameToRemove)) {
                            fw.write(line);
                            bw.newLine();
                        }
                        line = br.readLine();
                    }
                    br.close();
                    reader.close();
                    bw.close();
                    fw.close();
                    File original = new File("FavouriteNames.txt");
                    File temp = new File("TempFavNames.txt");
                    if (original.delete()) {
                        temp.renameTo(original);
                    }
                    textArea4.setText("");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        	}
        });
        btnNewButton_1_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 23));
        btnNewButton_1_3.setBackground(new Color(247, 108, 108));
        btnNewButton_1_3.setBounds(979, 189, 164, 41);
        panel.add(btnNewButton_1_3);

        JButton btnNewButton_1_4 = new JButton("Delete");
        btnNewButton_1_4.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		try {
        			FileWriter fw = new FileWriter("TempFavNames.txt",true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    FileReader reader = new FileReader("FavouriteNames.txt");
                    BufferedReader br = new BufferedReader(reader);
                    String nameToRemove = textArea4.getText();
                    String line = br.readLine();
                    while (line!=null) {
                        if (!line.trim().equals(nameToRemove)) {
                            fw.write(line);
                            bw.newLine();
                        }
                        line = br.readLine();
                    }
                    br.close();
                    reader.close();
                    bw.close();
                    fw.close();
                    File original = new File("FavouriteNames.txt");
                    File temp = new File("TempFavNames.txt");
                    if (original.delete()) {
                        temp.renameTo(original);
                    }
                    textArea5.setText("");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        	}
        });
        btnNewButton_1_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 23));
        btnNewButton_1_4.setBackground(new Color(247, 108, 108));
        btnNewButton_1_4.setBounds(979, 253, 164, 41);
        panel.add(btnNewButton_1_4);

        JButton btnNewButton_1_5 = new JButton("Delete");
        btnNewButton_1_5.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		try {
        			FileWriter fw = new FileWriter("TempFavNames.txt",true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    FileReader reader = new FileReader("FavouriteNames.txt");
                    BufferedReader br = new BufferedReader(reader);
                    String nameToRemove = textArea5.getText();
                    String line = br.readLine();
                    while (line!=null) {
                        if (!line.trim().equals(nameToRemove)) {
                            fw.write(line);
                            bw.newLine();
                        }
                        line = br.readLine();
                    }
                    br.close();
                    reader.close();
                    bw.close();
                    fw.close();
                    File original = new File("FavouriteNames.txt");
                    File temp = new File("TempFavNames.txt");
                    if (original.delete()) {
                        temp.renameTo(original);
                    }
                    textArea6.setText("");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        	}
        });
        btnNewButton_1_5.setFont(new Font("Yu Gothic UI", Font.BOLD, 23));
        btnNewButton_1_5.setBackground(new Color(247, 108, 108));
        btnNewButton_1_5.setBounds(979, 312, 164, 41);
        panel.add(btnNewButton_1_5);

        JButton btnNewButton_1_6 = new JButton("Delete");
        btnNewButton_1_6.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		try {FileWriter fw = new FileWriter("TempFavNames.txt",true);
                BufferedWriter bw = new BufferedWriter(fw);
                FileReader reader = new FileReader("FavouriteNames.txt");
                BufferedReader br = new BufferedReader(reader);
                String nameToRemove = textArea6.getText();
                    String line = br.readLine();
                    while (line!=null) {
                        if (!line.trim().equals(nameToRemove)) {
                            fw.write(line);
                            bw.newLine();
                        }
                        line = br.readLine();
                    }
                    br.close();
                    reader.close();
                    bw.close();
                    fw.close();
                    File original = new File("FavouriteNames.txt");
                    File temp = new File("TempFavNames.txt");
                    if (original.delete()) {
                        temp.renameTo(original);
                    }
                    textArea7.setText("");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        	}
        });
        btnNewButton_1_6.setFont(new Font("Yu Gothic UI", Font.BOLD, 23));
        btnNewButton_1_6.setBackground(new Color(247, 108, 108));
        btnNewButton_1_6.setBounds(979, 368, 164, 41);
        panel.add(btnNewButton_1_6);

        JButton btnNewButton_1_7 = new JButton("Delete");
        btnNewButton_1_7.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		try {FileWriter fw = new FileWriter("TempFavNames.txt",true);
                BufferedWriter bw = new BufferedWriter(fw);
                FileReader reader = new FileReader("FavouriteNames.txt");
                BufferedReader br = new BufferedReader(reader);String nameToRemove = textArea7.getText();
                    String line = br.readLine();
                    while (line!=null) {
                        if (!line.trim().equals(nameToRemove)) {
                            fw.write(line);
                            bw.newLine();
                        }
                        line = br.readLine();
                    }
                    br.close();
                    reader.close();
                    bw.close();
                    fw.close();
                    File original = new File("FavouriteNames.txt");
                    File temp = new File("TempFavNames.txt");
                    if (original.delete()) {
                        temp.renameTo(original);
                    }
                    textArea8.setText("");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        	}
        });
        btnNewButton_1_7.setFont(new Font("Yu Gothic UI", Font.BOLD, 23));
        btnNewButton_1_7.setBackground(new Color(247, 108, 108));
        btnNewButton_1_7.setBounds(979, 431, 164, 41);
        panel.add(btnNewButton_1_7);

        JButton btnNewButton_1_8 = new JButton("Delete");
        btnNewButton_1_8.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		try {FileWriter fw = new FileWriter("TempFavNames.txt",true);
                BufferedWriter bw = new BufferedWriter(fw);
                FileReader reader = new FileReader("FavouriteNames.txt");
                BufferedReader br = new BufferedReader(reader);String nameToRemove = textArea8.getText();
                    String line = br.readLine();
                    while (line!=null) {
                        if (!line.trim().equals(nameToRemove)) {
                            fw.write(line);
                            bw.newLine();
                        }
                        line = br.readLine();
                    }
                    br.close();
                    reader.close();
                    bw.close();
                    fw.close();
                    File original = new File("FavouriteNames.txt");
                    File temp = new File("TempFavNames.txt");
                    if (original.delete()) {
                        temp.renameTo(original);
                    }
                    textArea9.setText("");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        	}
        });
        btnNewButton_1_8.setFont(new Font("Yu Gothic UI", Font.BOLD, 23));
        btnNewButton_1_8.setBackground(new Color(247, 108, 108));
        btnNewButton_1_8.setBounds(979, 486, 164, 41);
        panel.add(btnNewButton_1_8);

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                home Home = new home();
                home.run();
                dispose();
            }
        });
        btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
        btnNewButton.setBackground(new Color(248, 233, 161));
        btnNewButton.setBounds(48, 734, 153, 49);
        contentPane.add(btnNewButton);

        JLabel ClimbIcon = new JLabel("");
        ClimbIcon.setBounds(1095, 664, 191, 191);
        ImageIcon originalIcon2 = new ImageIcon("climb icon.png");
        Image scaledImage2 = originalIcon2.getImage().getScaledInstance(160, 140, Image.SCALE_SMOOTH);
        ImageIcon climbIcon = new ImageIcon(scaledImage2);
        ClimbIcon.setIcon(climbIcon);
        contentPane.add(ClimbIcon);

        // display favourite names
        try (FileReader fr = new FileReader("FavouriteNames.txt");
             BufferedReader br1 = new BufferedReader(fr)) {

            String line = br1.readLine();
            int count = 0;

            if (line == null) { //if there are no favourite names in the file
                textArea1.setText("No route names have been favourited");
            } else {
                while (line != null ) {
                    textAreas[count].setText(line);
                    line = br1.readLine();
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

