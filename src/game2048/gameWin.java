package game2048;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.SwingConstants;
import java.awt.Color;

public class gameWin {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameWin window = new gameWin(1);
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public gameWin(int text) throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 570, 432);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		Image bg_collection_icon = new ImageIcon(this.getClass().getResource("/game_bg.png")).getImage();
		Image pop_up_icon = new ImageIcon(this.getClass().getResource("/pop_up.png")).getImage();
		Image logo00_icon = new ImageIcon(this.getClass().getResource("/game_logo.png")).getImage();

		JLabel Text = new JLabel();
		Text.setHorizontalAlignment(SwingConstants.CENTER);
		Text.setBounds(0, 235, 554, 102);
		frame.getContentPane().add(Text);

		JLabel button = new JLabel("NEXT");
		button.setForeground(Color.BLACK);
		button.setBackground(Color.LIGHT_GRAY);
		button.setHorizontalAlignment(SwingConstants.CENTER);
		button.setFont(new Font("UD Digi Kyokasho NK-B", Font.BOLD, 20));
		button.setBounds(232, 348, 97, 34);
		frame.getContentPane().add(button);

		if (text == 1) {
			Text = new JLabel("YOU WIN, SELECT NEW SWEATS");
			Text.setFont(new Font("UD Digi Kyokasho NK-B", Font.BOLD, 30));
			Text.setHorizontalAlignment(SwingConstants.CENTER);
			Text.setBounds(0, 235, 554, 102);
			frame.getContentPane().add(Text);
			button.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {

					Readfile read = new Readfile();

					int data[];
					try {
						data = read.Read();
						data[13] += 1;
						read.Save(data);

						collection col = new collection(data[13], data);
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}

					
					frame.dispose();
					frame.setVisible(false);
				}
			});
			
		}
		if (text == 2) {
			Text = new JLabel("YOU LOSE, BACK TO MENU");
			Text.setFont(new Font("UD Digi Kyokasho NK-B", Font.BOLD, 30));
			Text.setHorizontalAlignment(SwingConstants.CENTER);
			Text.setBounds(0, 235, 554, 102);
			frame.getContentPane().add(Text);
			button.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {

					Readfile read = new Readfile();

					
					try {
						int data[] = read.Read();

						data[13] += 1;
						read.Save(data);
						home welose = new home();
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}

					
					frame.setVisible(false);
				}
			});
		}

		JLabel logo00 = new JLabel("");
		logo00.setBounds(135, 0, 344, 236);
		frame.getContentPane().add(logo00);
		logo00.setIcon(new ImageIcon(logo00_icon));

		JLabel bg_pop_up = new JLabel("");
		bg_pop_up.setBounds(0, 0, 554, 409);
		frame.getContentPane().add(bg_pop_up);
		bg_pop_up.setIcon(new ImageIcon(bg_collection_icon));

	}

}
