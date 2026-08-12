import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static home frame = new home(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		run(); 
	}

	/**
	 * Create the frame.
	 */
	public static void run() {
		try {
			frame.setVisible(true); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("null")
	public home() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(850, 850, 1300, 870);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(36, 48, 94));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("src/route-forge-high-resolution-logo-white-transparent.png"));
		Logo.setBounds(25, 23, 259, 44);
		contentPane.add(Logo);

		JLabel lblNewLabel_1 = new JLabel("Welcome to...");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(25, 88, 229, 44);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("RouteForge");
		lblNewLabel_2.setForeground(new Color(248, 233, 161));
		lblNewLabel_2.setFont(new Font("Rockwell", Font.BOLD, 78));
		lblNewLabel_2.setBackground(new Color(248, 233, 161));
		lblNewLabel_2.setBounds(25, 142, 485, 99);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("The world's first specialised indoor climbing route generator. Generate, explore, and inspire...");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(25, 240, 1136, 44);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Press on one of the buttons below to get started:");
		lblNewLabel_1_2.setForeground(new Color(247, 108, 108));
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(25, 294, 583, 44);
		contentPane.add(lblNewLabel_1_2);

		JLabel HoldsIcon = new JLabel("");
		HoldsIcon.setIcon(new ImageIcon("src/climbwall.jpg"));
		HoldsIcon.setBounds(25, 381, 215, 262);
		contentPane.add(HoldsIcon);

		JButton btnNewButton = new JButton("Route Design Generator");
		btnNewButton.setBackground(new Color(168, 208, 230)); // Initial colour

		//so the button changes colour when hovered over
		btnNewButton.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		        btnNewButton.setBackground(new Color(248,233,161)); // Change colour
		    }

		    @Override
		    public void mouseExited(java.awt.event.MouseEvent e) {
		        btnNewButton.setBackground(new Color(168, 208, 230)); 
		    }
		});
		btnNewButton.addActionListener(new ActionListener() {
		    @Override
			public void actionPerformed(ActionEvent e) {
		        DesignGenerator design = new DesignGenerator();
		        design.run();
		        frame.setVisible(false);
		    }
		});
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		btnNewButton.setBounds(25, 643, 215, 64);
		contentPane.add(btnNewButton);

		JButton btnRouteNameGenerator = new JButton("Route Name Generator");
		btnRouteNameGenerator.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		        btnRouteNameGenerator.setBackground(new Color(248, 233, 161));
		    }

		    @Override
		    public void mouseExited(java.awt.event.MouseEvent e) {
		        btnRouteNameGenerator.setBackground(new Color(168, 208, 230));
		    }
		});
		btnRouteNameGenerator.addActionListener(new ActionListener() {
		    @Override
			public void actionPerformed(ActionEvent e) {
		        NameGenerator name = null;
		        try {
		            name = new NameGenerator();
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
		        name.run();
		        frame.setVisible(false);
		    }
		});
		btnRouteNameGenerator.setBackground(new Color(168, 208, 230));
		btnRouteNameGenerator.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		btnRouteNameGenerator.setBounds(275, 643, 215, 64);
		contentPane.add(btnRouteNameGenerator);


		JButton btnFavouriteNames = new JButton("Favourite Names");
		btnFavouriteNames.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		        btnFavouriteNames.setBackground(new Color(248, 233, 161));
		    }

		    @Override
		    public void mouseExited(java.awt.event.MouseEvent e) {
		        btnFavouriteNames.setBackground(new Color(168, 208, 230));
		    }
		});
		btnFavouriteNames.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FavouriteNames fav = null;
				try {
					fav = new FavouriteNames();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fav.run();
				frame.setVisible(false);
			}
		});
		btnFavouriteNames.setBackground(new Color(168, 208, 230));
		btnFavouriteNames.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		btnFavouriteNames.setBounds(526, 643, 213, 64);
		contentPane.add(btnFavouriteNames);

		JButton btnHelp = new JButton("Help");
		btnHelp.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		        btnHelp.setBackground(new Color(248, 233, 161));
		    }

		    @Override
		    public void mouseExited(java.awt.event.MouseEvent e) {
		        btnHelp.setBackground(new Color(168, 208, 230));
		    }
		});
		btnHelp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Help help = new Help();
				help.run();
				frame.setVisible(false);
			}
		});
		btnHelp.setBackground(new Color(168, 208, 230));
		btnHelp.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		btnHelp.setBounds(778, 643, 213, 64);
		contentPane.add(btnHelp);

		JButton btnLogOut = new JButton("Log Out ");
		btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseEntered(java.awt.event.MouseEvent e) {
		        btnLogOut.setBackground(new Color(248, 233, 161));
		    }

		    @Override
		    public void mouseExited(java.awt.event.MouseEvent e) {
		        btnLogOut.setBackground(new Color(168, 208, 230));
		    }
		});
		btnLogOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignOut out = new SignOut();
				out.run();
				frame.setVisible(false);
			}
		});
		btnLogOut.setBackground(new Color(168, 208, 230));
		btnLogOut.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		btnLogOut.setBounds(1029, 643, 213, 64);
		contentPane.add(btnLogOut);

		JLabel NameIcon = new JLabel("");
		NameIcon.setIcon(new ImageIcon("src/RouteNameLogo.png"));
		NameIcon.setBounds(275, 381, 215, 262);
		ImageIcon nameIcon = new ImageIcon(new ImageIcon("src/RouteNameLogo.png").getImage().getScaledInstance(220, 280, Image.SCALE_DEFAULT));
		NameIcon.setIcon(nameIcon);
		contentPane.add(NameIcon);

		JLabel StarIcon = new JLabel("");
		ImageIcon originalIcon = new ImageIcon("src/staricon.jpg");
		Image scaledImage = originalIcon.getImage().getScaledInstance(220, 260, Image.SCALE_SMOOTH);
		ImageIcon starIcon = new ImageIcon(scaledImage);
		StarIcon.setIcon(starIcon);
		StarIcon.setBounds(526, 381, 213, 268);
		contentPane.add(StarIcon);

		JLabel Help = new JLabel("");
		Help.setIcon(new ImageIcon("src/help.png"));
		Help.setBounds(778, 381, 213, 262);
		contentPane.add(Help);

		Canvas canvas = new Canvas();
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(778, 384, 213, 16);
		contentPane.add(canvas);

		Canvas canvas_1 = new Canvas();
		canvas_1.setBackground(Color.WHITE);
		canvas_1.setBounds(778, 616, 213, 27);
		contentPane.add(canvas_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("src/log out.jpg"));
		lblNewLabel_3.setBounds(1029, 415, 200, 192);
		contentPane.add(lblNewLabel_3);

		Canvas canvas_2 = new Canvas();
		canvas_2.setBackground(Color.WHITE);
		canvas_2.setBounds(1029, 381, 200, 39);
		contentPane.add(canvas_2);

		Canvas canvas_2_1 = new Canvas();
		canvas_2_1.setBackground(Color.WHITE);
		canvas_2_1.setBounds(1029, 604, 200, 39);
		contentPane.add(canvas_2_1);

		Canvas canvas_3 = new Canvas();
		canvas_3.setBackground(Color.WHITE);
		canvas_3.setBounds(1223, 381, 19, 262);
		contentPane.add(canvas_3);

		JLabel MountainRange = new JLabel("");
		ImageIcon originalIcon2 = new ImageIcon("src/mountain_range-removebg-preview.png");
		Image scaledImage2 = originalIcon2.getImage().getScaledInstance(1400, 300, Image.SCALE_SMOOTH);
		ImageIcon lblNewlabel_4 = new ImageIcon(scaledImage2);
		MountainRange.setIcon(lblNewlabel_4);
		MountainRange.setBounds(-65, 616, 1387, 213);
		contentPane.add(MountainRange);

	}

}
