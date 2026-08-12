import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class NameGenerator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					NameGenerator frame = new NameGenerator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the frame.
	 * @throws IOException
	 */
	public NameGenerator() throws IOException {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(850, 850, 1300, 870);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 233, 161));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		Stack <String> generatedNames = new Stack<>();
		//creating the stack that will store the generated names

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Title = new JLabel("Route Name Generator");
		Title.setForeground(new Color(0, 0, 0));
		Title.setBounds(31, 48, 712, 75);
		Title.setFont(new Font("Rockwell", Font.BOLD, 63));
		contentPane.add(Title);

		JLabel lblNewLabel_1 = new JLabel("Press the 'Create new' button to generate a new route name. If you love the route name, press the star button ");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.ITALIC, 24));
		lblNewLabel_1.setBounds(31, 133, 1218, 62);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("to add it to your favourites!");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.ITALIC, 24));
		lblNewLabel.setBounds(31, 182, 329, 44);
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
		btnNewButton.setBackground(new Color(168, 208, 230));
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
		btnNewButton.setBounds(31, 754, 167, 44);
		contentPane.add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(168, 208, 230));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(244, 301, 759, 178);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblNewLabel_2.setBounds(10, 36, 739, 97);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel YellowLogo = new JLabel("");
		ImageIcon originalIcon = new ImageIcon("src/yellow route forge logo.png");
		Image scaledImage = originalIcon.getImage().getScaledInstance(190,50,Image.SCALE_SMOOTH);
		ImageIcon lblNewlabel_2 = new ImageIcon(scaledImage);
		YellowLogo.setIcon(lblNewlabel_2);
		YellowLogo.setBounds(1076, 0, 200, 68);
		contentPane.add(YellowLogo);

		JButton btnNewButton_1 = new JButton("Previous");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        if (!generatedNames.isEmpty()) { // Ensure the stack is not empty
		            String name = generatedNames.pop(); // Pop the most recent name
		            lblNewLabel_2.setText(name); // display popped name
		        } else {
		            // optionally show a message if there are no more names to display
		            JOptionPane.showMessageDialog(null, "No more names to go back to.");
		        }
		    }
		});
		
		btnNewButton_1.setBackground(new Color(247, 108, 108));
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
		btnNewButton_1.setBounds(352, 515, 187, 49);
		contentPane.add(btnNewButton_1);


		JButton btnNewButton_1_1 = new JButton("Create New");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int Omin = 1;
				int Omax = 4;
				int OptionRandom = (int)Math.floor(Math.random() * (Omax - Omin + 1) + Omin);//generate a random number between 1 and 4
				//Single words
				String [] Option1 = {"Suspense","Despair","Cheese","Square","Trapezium","Lightning","Bolster","Strengthen","Equinox","Vixen","Thunder"
						,"Meditation","Titanium","Crimpocalypse","Wobble","Tectonic","Dynosaur","Fernando","Oracle","Vertigo","Neptune","Pluto","Tupperware",
						"Silence","CrimpFest","Intersloper","Falafel","Kneebarbara","Youth","Torture","Hybrid","Radioactive","Finale","Bingo","Butterfingers"};
				//Random
				String [] Option2 = {"It's Alright Really","Smoked Salmon","Burger and Chips","High and Dry","Up in Arms","Not All It's Cracked Up to Be",
						"Fists for Freedom","Coffee Break","Catch Your Breath","In a Hurry","Tug of War","Head over Heels","No More Excuses","Uno Dos Tres",
						"Jeepers Creepers","Basil Brush","Piece of Cake","Mind the Gap","In the Zone","Cuts and Scrapes","Buy One Get One Free","Just Kidding",
						"D.I.Y","Leaps and Bounds","Chance of Rain","Thunderstorms Expected","Finger Snaps","Forearm Torture","Make or Break","Alright on the Night",
						"Between a Rock And a Hard Place","Above and Beyond","Crux of the Matter","King Kong","Beans on Toast","Have you had your Weetabix?"};
				//Single words to add route/wall/climb/slab to the end of
				String [] Option3 = {"Spinach","Pearl","Imposter","Total","Courage","Baseball","Profession","Marble","Marmalade","Murky","Dizzy","Bizarre",
						"Goofy","Secret","Stanage","Manchester","Hoy","Cenotaph","Froggatt","Anglesey","Somerset","Devon","Snowdon","Wasdale","Pembroke",
						"Yosemite","Nevada","Dolomites","Messy","October","November","April","January","December","Brutal","Dave's","Sally's","Hamlet's",
						"Shakespeare's","Rabbit's","Johnny's","Exuberant","Reverse","Broccoli","Quantum","Electron","Proton","Neutron","Beetle","Typhoon",
						"Twisty","Macbeth's","Cryptic","Potato","Tesco","Christmas","Brutal","Mercurial","Celebration","Victory","Triumph","Bunny","Dracula's",
						"Goldilocks'","Frankenstein's","Garden","Cranberry","Lavender","Umbrella","Topaz"};
				//Words to have 'the' in front of it
				String [] Option4 = {"Grandmaster","Blissful","Blurter","Beautician","Roman","Tango","Sleepwalker","Daydreamer","Abacus","Bruise","Trouble",
						"Astronaut","Moonwalker","Storm","Breadbox","Photograph","Broken","Glimpse","Teacake","Smile","Lion","Gazelle","Butterfly","Scoop","Link",
						"Wasp","King","Hawk","Joker","Grotto","Pipette","Spanners","Goat"};

				int random;
				int min = 0;
				int max;
				String name = "";
				if (OptionRandom == 1) {
					max = 34;
					random = (int)Math.floor(Math.random() * (max - min + 1) + min);
					name = Option1[random];
				}
				else if (OptionRandom == 2) {
					max = 35;
					random = (int)Math.floor(Math.random() * (max - min + 1) + min);
					name = Option2[random];
				}
				else if (OptionRandom == 3) {
					max = 69;
					random = (int)Math.floor(Math.random() * (max - min + 1) + min);
					String [] endings = {"Route","Wall","Climb","Slab"};
					int endmin = 0;
					int endmax = 3;
					int endrandom = (int)Math.floor(Math.random() * (endmax - endmin + 1) + endmin);
					name = Option3[random]+" "+endings[endrandom];

				}
				else if (OptionRandom == 4) {
					max = 33;
					random = (int)Math.floor(Math.random() * (max - min + 1) + min);
					name = "The " + Option4[random];

				}
				lblNewLabel_2.setText(name);
				generatedNames.push(name);
				}

			}
		);
		btnNewButton_1_1.setBackground(new Color(247, 108, 108));
		btnNewButton_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
		btnNewButton_1_1.setBounds(664, 515, 224, 49);
		contentPane.add(btnNewButton_1_1);
		ImageIcon originalIcon1 = new ImageIcon("src/star.png");
		Image scaledImage1 = originalIcon1.getImage().getScaledInstance(100,120,Image.SCALE_SMOOTH);
		ImageIcon lblNewlabel_3 = new ImageIcon(scaledImage1);

		JLabel Mountains = new JLabel("");
		ImageIcon originalIcon2 = new ImageIcon("src/mountainsilhouette.png");
		Image scaledImage2 = originalIcon2.getImage().getScaledInstance(1300,600,Image.SCALE_SMOOTH);
		ImageIcon lblNewlabel_4 = new ImageIcon(scaledImage2);
		Mountains.setIcon(lblNewlabel_4);
		Mountains.setBounds(0, 515, 1286, 318);
		contentPane.add(Mountains);


		JButton btnNewButton_2 = new JButton(""); //Favourite star Button
		FileWriter fw = new FileWriter("FavouriteNames.txt",true);
		btnNewButton_2.addActionListener(new ActionListener() {
			int count = 0;
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					count = count + 1;
					if (count > 9) {
						//displaying error message if the number of favourite names is too large
						Component frame = null;
						JOptionPane.showMessageDialog(frame, "You have favourited too many names. "
								+ "Navigate to the favourite names page to delete some.",
								"Favourite name not saved",
			                    JOptionPane.ERROR_MESSAGE);
					}
					//Retrieving the generated name form the top of the stack
					String name = generatedNames.pop();
					fw.write(name+"\n"); //Adding the name to the 'Favourite Names' text file
					generatedNames.push(name);
					fw.close();

				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});


		btnNewButton_2.setForeground(new Color(248, 233, 161));
		ImageIcon originalIcon11 = new ImageIcon("src/star.png");
		Image resizedImage = originalIcon11.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
		btnNewButton_2.setIcon(resizedIcon);
		btnNewButton_2.setBackground(new Color(248, 233, 161));
		btnNewButton_2.setSelectedIcon(new ImageIcon("src/star.png"));
		btnNewButton_2.setBounds(1043, 336, 122, 115);
		contentPane.add(btnNewButton_2);


	}
}
