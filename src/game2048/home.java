package game2048;

import java.awt.*;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

public class home extends JFrame {

	private Readfile file = new Readfile();
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
					window.frame.setResizable(false);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public home() throws IOException {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 1500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int data[] = file.Read();
		int best = data[0];

		Image bg_home_icon = new ImageIcon(this.getClass().getResource("/game_bg.png")).getImage();
		Image logo_icon = new ImageIcon(this.getClass().getResource("/menu_logo.png")).getImage();
		Image newgame = new ImageIcon(this.getClass().getResource("/menu_newgame.png")).getImage();
		Image collection = new ImageIcon(this.getClass().getResource("/menu_collection.png")).getImage();

		frame.getContentPane().setLayout(null);

		JLabel logo = new JLabel("");
		logo.setBounds(500, 30, 548, 511);
		logo.setIcon(new ImageIcon(logo_icon));
		frame.getContentPane().add(logo);

		JLabel menu_button = new JLabel("");
		menu_button.setFont(new Font("Tw Cen MT", Font.PLAIN, 34));
		menu_button.setBounds(212, 552, 406, 205);
		frame.getContentPane().add(menu_button);
		menu_button.setIcon(new ImageIcon(newgame));
		menu_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				gameplay game = new gameplay(best);

				frame.dispose();
				frame.setVisible(false);

			}
		});

		JLabel collection_button = new JLabel("");
		collection_button.setFont(new Font("Tw Cen MT", Font.PLAIN, 34));
		collection_button.setBounds(864, 568, 398, 189);
		frame.getContentPane().add(collection_button);
		collection_button.setIcon(new ImageIcon(collection));
		collection_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				collection col = new collection(data[13], data);

				frame.dispose();
				frame.setVisible(false);

			}
		});

		JLabel bg_home = new JLabel("");
		bg_home.setBounds(0, 0, 1484, 761);
		bg_home.setIcon(new ImageIcon(bg_home_icon));
		frame.getContentPane().add(bg_home);
	}

	public void readwriteFile() throws IOException {

	}

}
