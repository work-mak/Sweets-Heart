package game2048;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.*;

public class gameplay extends JPanel {

	private JFrame frame = new JFrame();
	private int score = 0;
	private JLabel txtScore;
	private JLabel txtBestScore;
	private JLabel lblbscore, lblbhighscore;

	int b_score = 0;
	private boolean myWin = false, myLose = false;

	private int CanCreate = 2;

	private int emptyOrnot[] = new int[16];
	private int numgame[] = new int[16];
	private int x[] = { 78, 246, 414, 582 };
	private int y[] = { 83, 251, 419, 587 };

	private Value value[] = new Value[16];
	private JLabel num[] = new JLabel[16];

	/*
	 * public static void main(String[] args) throws IOException {
	 * 
	 * gameplay game = new gameplay(); game.frame.add(game);
	 * game.frame.setVisible(true); game.frame.setSize(1500, 800);
	 * game.frame.setTitle("Sweet Heart");
	 * game.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	 * game.frame.setResizable(false); game.frame.setVisible(true);
	 * 
	 * }
	 */

	public gameplay(int best) {

		frame = new JFrame();
		frame.setSize(1500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(this);
		this.b_score = best;
		for (int i = 0; i < value.length; i++) {
			value[i] = new Value(String.valueOf(numgame[i]));
		}

		for (int i = 0; i < num.length; i++) {
			num[i] = new JLabel();
			value[i] = new Value(String.valueOf(numgame[i]));
			num[i].setIcon(new ImageIcon(value[i].newGame()));
			this.frame.getContentPane().add(num[i]);
		}

		lblbscore = new JLabel(String.valueOf(score));
		lblbscore.setHorizontalAlignment(SwingConstants.CENTER);
		lblbscore.setFont(new Font("UD Digi Kyokasho NK-B", Font.PLAIN, 50));
		lblbscore.setBounds(929, 251, 180, 95);
		frame.getContentPane().add(lblbscore);

		lblbhighscore = new JLabel(String.valueOf(b_score));
		lblbhighscore.setFont(new Font("UD Digi Kyokasho NK-B", Font.PLAIN, 32));
		lblbhighscore.setToolTipText("");
		lblbhighscore.setHorizontalAlignment(SwingConstants.CENTER);
		lblbhighscore.setBounds(1169, 495, 180, 95);
		frame.getContentPane().add(lblbhighscore);

		setFocusable(true);
		requestFocusInWindow();

		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_Z) {
					try {
						GameStart();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (!canMove()) {
					myLose = true;
				}

				if (!myWin && !myLose) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						System.out.println("1");
						try {
							left();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						break;
					case KeyEvent.VK_A:
						System.out.println("1");
						try {
							left();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						CanCreate++;
						AddNewTile();
						break;
					case KeyEvent.VK_RIGHT:
						System.out.println("2");
						try {
							right();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					case KeyEvent.VK_D:
						System.out.println("2");
						try {
							right();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					case KeyEvent.VK_DOWN:
						System.out.println("3");
						try {
							down();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					case KeyEvent.VK_S:
						System.out.println("3");
						try {
							down();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					case KeyEvent.VK_UP:
						System.out.println("4");
						try {
							up();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					case KeyEvent.VK_W:
						System.out.println("4");
						try {
							up();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					}
				}

				if (!myWin && !canMove()) {
					myLose = true;
				}

			}

		});

		AddNewTile();
		gamelayout();

	}

	public boolean canMove() {
		for (int i = 0; i < 16; i++) {
			if (numgame[i] == 0) {
				return true;

			}
		}

		if (numgame[0] == numgame[1] || numgame[0] == numgame[4]) {
			return true;
		} else if (numgame[1] == numgame[0] || numgame[1] == numgame[2] || numgame[1] == numgame[5]) {
			return true;
		} else if (numgame[2] == numgame[1] || numgame[2] == numgame[3] || numgame[2] == numgame[6]) {
			return true;
		} else if (numgame[3] == numgame[2] || numgame[3] == numgame[7]) {
			return true;
		} else if (numgame[4] == numgame[0] || numgame[4] == numgame[5] || numgame[4] == numgame[8]) {
			return true;
		} else if (numgame[5] == numgame[1] || numgame[5] == numgame[4] || numgame[5] == numgame[6]
				|| numgame[5] == numgame[9]) {
			return true;
		} else if (numgame[6] == numgame[2] || numgame[6] == numgame[7] || numgame[6] == numgame[5]
				|| numgame[6] == numgame[10]) {
			return true;
		} else if (numgame[7] == numgame[3] || numgame[7] == numgame[6] || numgame[7] == numgame[11]) {
			return true;
		} else if (numgame[8] == numgame[4] || numgame[8] == numgame[9] || numgame[8] == numgame[12]) {
			return true;
		} else if (numgame[9] == numgame[5] || numgame[9] == numgame[10] || numgame[9] == numgame[8]
				|| numgame[9] == numgame[13]) {
			return true;
		} else if (numgame[10] == numgame[9] || numgame[10] == numgame[6] || numgame[10] == numgame[11]
				|| numgame[10] == numgame[14]) {
			return true;
		} else if (numgame[11] == numgame[7] || numgame[11] == numgame[10] || numgame[11] == numgame[15]) {
			return true;
		} else if (numgame[12] == numgame[8] || numgame[12] == numgame[13]) {
			return true;
		} else if (numgame[13] == numgame[12] || numgame[13] == numgame[14] || numgame[13] == numgame[9]) {
			return true;
		} else if (numgame[14] == numgame[13] || numgame[14] == numgame[10] || numgame[14] == numgame[15]) {
			return true;
		} else if (numgame[15] == numgame[14] || numgame[15] == numgame[11]) {
			return true;

		}
		return false;

	}

	public void GameStart() throws IOException {
		for (int i = 0; i < num.length; i++) {
			numgame[i] = 0;
			emptyOrnot[i] = 0;
		}
		myWin = false;
		myLose = false;
		score = 0;
		CanCreate = 2;
		AddNewTile();
		gamelayout();
		ChangeTile();

	}

	public void ChangeTile() throws IOException {

		for (int i = 0; i < num.length; i++) {

			value[i] = new Value(String.valueOf(numgame[i]));
			num[i].setIcon(new ImageIcon(value[i].newGame()));
			if (numgame[i] == 0) {
				emptyOrnot[i] = 0;
			}

			if (numgame[i] >= 2048) {
				myWin = true;
			}

			if (!canMove()) {
				myLose = true;
			}

		}
		if (score >= b_score) {
			b_score = score;
		}
		lblbscore.setText(String.valueOf(score));
		lblbscore.getText();
		lblbhighscore.setText(String.valueOf(b_score));
		lblbhighscore.getText();

		if (myWin) {
			gameWin win = new gameWin(1);

			frame.dispose();
			frame.setVisible(false);
		}

		if (myLose) {
			gameWin lose = new gameWin(2);

			frame.dispose();
			frame.setVisible(false);
		}

	}

	public void AddNewTile() {

		num[0].setBounds(x[0], y[0], 140, 140);
		num[1].setBounds(x[1], y[0], 140, 140);
		num[2].setBounds(x[2], y[0], 140, 140);
		num[3].setBounds(x[3], y[0], 140, 140);
		num[4].setBounds(x[0], y[1], 140, 140);
		num[5].setBounds(x[1], y[1], 140, 140);
		num[6].setBounds(x[2], y[1], 140, 140);
		num[7].setBounds(x[3], y[1], 140, 140);
		num[8].setBounds(x[0], y[2], 140, 140);
		num[9].setBounds(x[1], y[2], 140, 140);
		num[10].setBounds(x[2], y[2], 140, 140);
		num[11].setBounds(x[3], y[2], 140, 140);
		num[12].setBounds(x[0], y[3], 140, 140);
		num[13].setBounds(x[1], y[3], 140, 140);
		num[14].setBounds(x[2], y[3], 140, 140);
		num[15].setBounds(x[3], y[3], 140, 140);

		for (int j = 0; j < 2; j++) {

			if (CanCreate == 0) {
				break;
			}

			checkValue();

			if (j == 0) {
				for (int i = 0; i < (num.length); i++) {
					System.out.println(i + " " + numgame[i]);
					double random = Math.random();
					System.out.println(i + " " + random + " ");
					if (emptyOrnot[i] == 0 && random < 0.3 && CanCreate > 0) {

						numgame[i] = 2;
						value[i] = new Value(String.valueOf(numgame[i]));
						num[i].setIcon(new ImageIcon(value[i].newGame()));
						emptyOrnot[i] = 1;
						CanCreate--;
					}
					System.out.println(i + " " + numgame[i]);

					if (CanCreate == 0) {
						break;
					}
				}
			}
			if (j == 1) {
				for (int i = 0; i < (num.length); i++) {
					System.out.println(i + " " + numgame[i]);
					double random = Math.random();
					System.out.println(i + " " + random + " ");
					if (emptyOrnot[i] == 0 && random < 1 && CanCreate > 0) {

						numgame[i] = 2;
						value[i] = new Value(String.valueOf(numgame[i]));
						num[i].setIcon(new ImageIcon(value[i].newGame()));
						emptyOrnot[i] = 1;
						CanCreate--;
					}
					System.out.println(i + " " + numgame[i]);

					if (CanCreate == 0) {
						break;
					}
				}
			}
		}

	}

	public void left() throws IOException {

		L_MergeLine();
		L_Sumvalue();
		L_MergeLine();

		AddNewTile();
		ChangeTile();

	}

	public void right() throws IOException {

		R_MergeLine();
		R_Sumvalue();
		R_MergeLine();

		AddNewTile();
		ChangeTile();

	}

	public void up() throws IOException {
		U_MergeLine();
		U_Sumvalue();
		U_MergeLine();

		AddNewTile();
		ChangeTile();

	}

	public void down() throws IOException {
		D_MergeLine();
		D_Sumvalue();
		D_MergeLine();

		AddNewTile();
		ChangeTile();

	}

	private void gamelayout() {

		Image all = new ImageIcon(this.getClass().getResource("/game_all_bg.png")).getImage();
		Image logo = new ImageIcon(this.getClass().getResource("/game_logo.png")).getImage();
		Image menu = new ImageIcon(this.getClass().getResource("/game_menu.png")).getImage();
		Image score_im = new ImageIcon(this.getClass().getResource("/game_score.png")).getImage();
		Image bestscore = new ImageIcon(this.getClass().getResource("/game_bestscore.png")).getImage();
		Image bg = new ImageIcon(this.getClass().getResource("/game_bg.png")).getImage();

		JLabel lblAll = new JLabel("");
		lblAll.setIcon(new ImageIcon(all));
		lblAll.setHorizontalAlignment(SwingConstants.CENTER);
		lblAll.setBounds(50, 50, 700, 700);
		frame.getContentPane().add(lblAll);

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 32));
		label.setBounds(1147, 29, 327, 235);
		frame.getContentPane().add(label);
		label.setIcon(new ImageIcon(logo));

		txtScore = new JLabel();
		txtScore.setBounds(830, 137, 392, 297);
		frame.getContentPane().add(txtScore);
		txtScore.setIcon(new ImageIcon(score_im));

		txtBestScore = new JLabel();
		txtBestScore.setBounds(1134, 419, 260, 212);
		frame.getContentPane().add(txtBestScore);
		txtBestScore.setIcon(new ImageIcon(bestscore));

		JLabel btnMenu = new JLabel("");
		btnMenu.setBounds(870, 601, 307, 149);
		frame.getContentPane().add(btnMenu);
		btnMenu.setIcon(new ImageIcon(menu));
		btnMenu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Readfile read = new Readfile();
				try {
					int data[] = read.Read();
					data[0] = b_score;
					read.Save(data);
					home GoMenu = new home();
				} catch (IOException e2) {
					e2.printStackTrace();
				}

				frame.dispose();
				frame.setVisible(false);

			}
		});

		JLabel bg_collection = new JLabel("");
		bg_collection.setBounds(0, 0, 1500, 800);
		bg_collection.setIcon(new ImageIcon(bg));
		frame.getContentPane().add(bg_collection);

		if (score == 2048) {
			gameWin.main(null);
		}

	}

	public void L_MergeLine() {
		///// Start MergeLine

		if (numgame[0] == 0) {

			if (numgame[1] != 0) {
				CanCreate = 1;
				numgame[0] = numgame[1]; // 0 2 0 0
				emptyOrnot[0] = 1;
				numgame[1] = 0;
				emptyOrnot[1] = 0;

				if (numgame[2] != 0) {
					numgame[1] = numgame[2]; // 0 2 2 0, 0 2 2 2
					emptyOrnot[1] = 1;
					numgame[2] = numgame[3];
					numgame[3] = 0;
					emptyOrnot[3] = 0;
				}

				else if (numgame[2] == 0) { // 0 2 0 2
					if (numgame[3] != 0) {
						CanCreate = 1;
						numgame[1] = numgame[3];
						emptyOrnot[1] = 1;
						numgame[2] = 0;
						emptyOrnot[2] = 0;
						numgame[3] = 0;
						emptyOrnot[3] = 0;
					}

				}
			}

			else if (numgame[1] == 0) {

				if (numgame[2] != 0) { // 0 0 2 2, 0 0 2 0
					CanCreate = 1;
					numgame[0] = numgame[2];
					emptyOrnot[0] = 1;
					numgame[1] = numgame[3];
					emptyOrnot[1] = 1;
					numgame[2] = 0;
					emptyOrnot[2] = 0;
					numgame[3] = 0;
					emptyOrnot[3] = 0;
				}

				else if (numgame[2] == 0) {
					if (numgame[3] != 0) { // 0 0 0 2
						CanCreate = 1;
						numgame[0] = numgame[3];
						emptyOrnot[0] = 1;
						numgame[1] = 0;
						emptyOrnot[1] = 0;
						numgame[2] = 0;
						emptyOrnot[2] = 0;
						numgame[3] = 0;
						emptyOrnot[3] = 0;

					}

				}

			}

		}

		//
		else if (numgame[1] == 0) {

			if (numgame[2] != 0) { // 2 0 2 0
				CanCreate = 1;
				numgame[1] = numgame[2];
				emptyOrnot[1] = 1;
				numgame[2] = 0;
				emptyOrnot[2] = 0;

				if (numgame[3] != 0) { // 2 0 2 2
					numgame[2] = numgame[3];
					emptyOrnot[2] = 1;
					numgame[3] = 0;
					emptyOrnot[3] = 0;
				}

			}

			else if (numgame[2] == 0) { // 2 0 0 0

				if (numgame[3] != 0) { // 2 0 0 0
					CanCreate = 1;
					numgame[1] = numgame[3];
					emptyOrnot[1] = 1;
					numgame[2] = 0;
					emptyOrnot[2] = 0;
					numgame[3] = 0;
					emptyOrnot[3] = 0;
				}

			}

		}

		//

		else if (numgame[2] == 0) { // 2 2 0 0

			if (numgame[3] != 0) { // 2 2 0 2
				CanCreate = 1;
				numgame[2] = numgame[3];
				emptyOrnot[2] = 1;
				numgame[3] = 0;
				emptyOrnot[3] = 0;
			}

		}
		//// end line 1

		if (numgame[4] == 0) {

			if (numgame[5] != 0) {
				CanCreate = 1;
				numgame[4] = numgame[5]; // 0 2 0 0
				emptyOrnot[4] = 1;
				numgame[5] = 0;
				emptyOrnot[5] = 0;

				if (numgame[6] != 0) {
					numgame[5] = numgame[6]; // 0 2 2 0, 0 2 2 2
					emptyOrnot[5] = 1;
					numgame[6] = numgame[7];
					numgame[7] = 0;
					emptyOrnot[7] = 0;
				}

				else if (numgame[6] == 0) { // 0 2 0 2
					if (numgame[7] != 0) {
						CanCreate = 1;
						numgame[5] = numgame[7];
						emptyOrnot[5] = 1;
						numgame[6] = 0;
						emptyOrnot[6] = 0;
						numgame[7] = 0;
						emptyOrnot[7] = 0;
					}

				}
			}

			else if (numgame[5] == 0) {

				if (numgame[6] != 0) { // 0 0 2 2, 0 0 2 0
					CanCreate = 1;
					numgame[4] = numgame[6];
					emptyOrnot[4] = 1;
					numgame[5] = numgame[7];
					emptyOrnot[5] = 1;
					numgame[7] = 0;
					emptyOrnot[7] = 0;
				}

				else if (numgame[6] == 0) {
					if (numgame[7] != 0) { // 0 0 0 2
						CanCreate = 1;
						numgame[4] = numgame[7];
						emptyOrnot[4] = 1;
						numgame[5] = 0;
						emptyOrnot[5] = 0;
						numgame[6] = 0;
						emptyOrnot[6] = 0;
						numgame[7] = 0;
						emptyOrnot[7] = 0;

					}

				}
			}

		}

		//
		else if (numgame[5] == 0) {

			if (numgame[6] != 0) { // 2 0 2 0
				CanCreate = 1;
				numgame[5] = numgame[6];
				emptyOrnot[5] = 1;
				numgame[6] = 0;
				emptyOrnot[6] = 0;

				if (numgame[7] != 0) { // 2 0 2 2
					numgame[6] = numgame[7];
					emptyOrnot[6] = 1;
					numgame[7] = 0;
					emptyOrnot[7] = 0;
				}

			}

			else if (numgame[6] == 0) { // 2 0 0 0

				if (numgame[7] != 0) { // 2 0 0 0
					CanCreate = 1;
					numgame[5] = numgame[7];
					emptyOrnot[5] = 1;
					numgame[6] = 0;
					emptyOrnot[6] = 0;
					numgame[7] = 0;
					emptyOrnot[7] = 0;
				}

			}

		}

		//

		else if (numgame[6] == 0) { // 2 2 0 0

			if (numgame[7] != 0) { // 2 2 0 2
				CanCreate = 1;
				numgame[6] = numgame[7];
				emptyOrnot[6] = 1;
				numgame[7] = 0;
				emptyOrnot[7] = 0;
			}

		}
		//// end line 2

		if (numgame[8] == 0) {

			if (numgame[9] != 0) {
				CanCreate = 1;
				numgame[8] = numgame[9]; // 0 2 0 0
				emptyOrnot[8] = 1;
				numgame[9] = 0;
				emptyOrnot[9] = 0;

				if (numgame[10] != 0) {
					numgame[9] = numgame[10]; // 0 2 2 0, 0 2 2 2
					emptyOrnot[9] = 1;
					numgame[10] = numgame[11];
					numgame[11] = 0;
					emptyOrnot[11] = 0;
				}

				else if (numgame[10] == 0) { // 0 2 0 2
					if (numgame[11] != 0) {
						CanCreate = 1;
						numgame[9] = numgame[11];
						emptyOrnot[9] = 1;
						numgame[10] = 0;
						emptyOrnot[10] = 0;
						numgame[11] = 0;
						emptyOrnot[11] = 0;
					}

				}
			}

			else if (numgame[9] == 0) {

				if (numgame[10] != 0) { // 0 0 2 2, 0 0 2 0
					CanCreate = 1;
					numgame[8] = numgame[10];
					emptyOrnot[8] = 1;
					numgame[9] = numgame[11];
					emptyOrnot[9] = 1;
					numgame[11] = 0;
					emptyOrnot[11] = 0;
				}

				else if (numgame[10] == 0) {
					if (numgame[11] != 0) { // 0 0 0 2
						CanCreate = 1;
						numgame[8] = numgame[11];
						emptyOrnot[8] = 1;
						numgame[9] = 0;
						emptyOrnot[9] = 0;
						numgame[10] = 0;
						emptyOrnot[10] = 0;
						numgame[11] = 0;
						emptyOrnot[11] = 0;

					}

				}
			}

		}

		//
		else if (numgame[9] == 0) {

			if (numgame[10] != 0) { // 2 0 2 0
				CanCreate = 1;
				numgame[9] = numgame[10];
				emptyOrnot[9] = 1;
				numgame[10] = 0;
				emptyOrnot[10] = 0;

				if (numgame[11] != 0) { // 2 0 2 2
					numgame[10] = numgame[11];
					emptyOrnot[10] = 1;
					numgame[11] = 0;
					emptyOrnot[11] = 0;
				}

			}

			else if (numgame[10] == 0) { // 2 0 0 0

				if (numgame[11] != 0) { // 2 0 0 0
					CanCreate = 1;
					numgame[9] = numgame[11];
					emptyOrnot[9] = 1;
					numgame[10] = 0;
					emptyOrnot[10] = 0;
					numgame[11] = 0;
					emptyOrnot[11] = 0;
				}

			}

		}

		//

		else if (numgame[10] == 0) { // 2 2 0 0

			if (numgame[11] != 0) { // 2 2 0 2
				CanCreate = 1;
				numgame[10] = numgame[11];
				emptyOrnot[10] = 1;
				numgame[11] = 0;
				emptyOrnot[11] = 0;
			}

		}
		//// end line 3

		if (numgame[12] == 0) {

			if (numgame[13] != 0) {
				CanCreate = 1;
				numgame[12] = numgame[13]; // 0 2 0 0
				emptyOrnot[12] = 1;
				numgame[13] = 0;
				emptyOrnot[13] = 0;

				if (numgame[14] != 0) {
					numgame[13] = numgame[14]; // 0 2 2 0, 0 2 2 2
					emptyOrnot[13] = 1;
					numgame[14] = numgame[15];
					numgame[15] = 0;
					emptyOrnot[15] = 0;
				}

				else if (numgame[14] == 0) { // 0 2 0 2
					if (numgame[15] != 0) {
						CanCreate = 1;
						numgame[13] = numgame[15];
						emptyOrnot[13] = 1;
						numgame[14] = 0;
						emptyOrnot[14] = 0;
						numgame[15] = 0;
						emptyOrnot[15] = 0;
					}

				}
			}

			else if (numgame[13] == 0) {

				if (numgame[14] != 0) { // 0 0 2 2, 0 0 2 0
					CanCreate = 1;
					numgame[12] = numgame[14];
					emptyOrnot[12] = 1;
					numgame[13] = numgame[15];
					emptyOrnot[13] = 1;
					numgame[15] = 0;
					emptyOrnot[15] = 0;
				}

				else if (numgame[14] == 0) {
					if (numgame[15] != 0) { // 0 0 0 2
						CanCreate = 1;
						numgame[12] = numgame[15];
						emptyOrnot[12] = 1;
						numgame[13] = 0;
						emptyOrnot[13] = 0;
						numgame[14] = 0;
						emptyOrnot[14] = 0;
						numgame[15] = 0;
						emptyOrnot[15] = 0;

					}

				}
			}

		}

		//
		else if (numgame[13] == 0) {

			if (numgame[14] != 0) { // 2 0 2 0
				CanCreate = 1;
				numgame[13] = numgame[14];
				emptyOrnot[13] = 1;
				numgame[14] = 0;
				emptyOrnot[14] = 0;

				if (numgame[15] != 0) { // 2 0 2 2
					numgame[14] = numgame[15];
					emptyOrnot[14] = 1;
					numgame[15] = 0;
					emptyOrnot[15] = 0;
				}

			}

			else if (numgame[14] == 0) { // 2 0 0 0

				if (numgame[15] != 0) { // 2 0 0 0
					CanCreate = 1;
					numgame[13] = numgame[15];
					emptyOrnot[13] = 1;
					numgame[14] = 0;
					emptyOrnot[14] = 0;
					numgame[15] = 0;
					emptyOrnot[15] = 0;
				}

			}

		}

		//

		else if (numgame[14] == 0) { // 2 2 0 0

			if (numgame[15] != 0) { // 2 2 0 2
				CanCreate = 1;
				numgame[14] = numgame[15];
				emptyOrnot[14] = 1;
				numgame[15] = 0;
				emptyOrnot[15] = 0;
			}

		}
		//// end line 4
		///////// end mergeLine
	}

	public void L_Sumvalue() {

		//////////// Start SumValue

		if (numgame[0] == numgame[1]) {
			numgame[0] += numgame[1];
			emptyOrnot[0] = 1;
			score += numgame[1];
			numgame[1] = 0;
			emptyOrnot[1] = 0;

			if (numgame[0] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[1] == numgame[2]) {
			numgame[1] += numgame[2];
			emptyOrnot[1] = 1;
			score += numgame[2];
			numgame[2] = 0;
			emptyOrnot[2] = 0;

			if (numgame[1] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[2] == numgame[3]) {
			numgame[2] += numgame[3];
			emptyOrnot[2] = 1;
			score += numgame[3];
			numgame[3] = 0;
			emptyOrnot[3] = 0;

			if (numgame[2] > 0) {
				CanCreate = 1;
			}

		}
		//////// end line 1

		if (numgame[4] == numgame[5]) {
			numgame[4] += numgame[5];
			emptyOrnot[4] = 1;
			score += numgame[5];
			numgame[5] = 0;
			emptyOrnot[5] = 0;

			if (numgame[4] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[5] == numgame[6]) {
			numgame[5] += numgame[6];
			emptyOrnot[5] = 1;
			score += numgame[6];

			numgame[6] = 0;
			emptyOrnot[6] = 0;

			if (numgame[5] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[6] == numgame[7]) {
			numgame[6] += numgame[7];
			emptyOrnot[6] = 1;
			score += numgame[7];
			numgame[7] = 0;
			emptyOrnot[7] = 0;

			if (numgame[6] > 0) {
				CanCreate = 1;
			}

		}
		//////// end line 2

		if (numgame[8] == numgame[9]) {
			numgame[8] += numgame[9];
			emptyOrnot[8] = 1;
			score += numgame[9];

			numgame[9] = 0;
			emptyOrnot[9] = 0;

			if (numgame[8] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[9] == numgame[10]) {
			numgame[9] += numgame[10];
			score += numgame[10];
			emptyOrnot[9] = 1;
			numgame[10] = 0;
			emptyOrnot[10] = 0;

			if (numgame[9] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[10] == numgame[11]) {
			numgame[10] += numgame[11];
			score += numgame[11];
			emptyOrnot[10] = 1;
			numgame[11] = 0;
			emptyOrnot[11] = 0;

			if (numgame[10] > 0) {
				CanCreate = 1;
			}

		}
		//////// end line 3

		if (numgame[12] == numgame[13]) {
			numgame[12] += numgame[13];
			score += numgame[13];
			emptyOrnot[12] = 1;
			numgame[13] = 0;
			emptyOrnot[13] = 0;

			if (numgame[12] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[13] == numgame[14]) {
			numgame[13] += numgame[14];
			score += numgame[14];
			emptyOrnot[13] = 1;
			numgame[14] = 0;
			emptyOrnot[14] = 0;

			if (numgame[13] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[14] == numgame[15]) {
			numgame[14] += numgame[15];
			score += numgame[15];
			emptyOrnot[14] = 1;
			numgame[15] = 0;
			emptyOrnot[15] = 0;

			if (numgame[14] > 0) {
				CanCreate = 1;
			}

		}
		//////// end line 4
		///////////////// end SumValue

	}

	public void R_MergeLine() {
		///// Start MergeLine
		if (numgame[3] == 0) {

			if (numgame[2] != 0) {
				CanCreate = 1;
				numgame[3] = numgame[2]; // 0 2 0 0
				emptyOrnot[3] = 1;
				numgame[2] = 0;
				emptyOrnot[2] = 0;

				if (numgame[1] != 0) {
					numgame[2] = numgame[1]; // 0 2 2 0, 0 2 2 2
					emptyOrnot[2] = 1;
					numgame[1] = numgame[0];
					numgame[0] = 0;
					emptyOrnot[0] = 0;
				}

				else if (numgame[1] == 0) { // 0 2 0 2
					if (numgame[0] != 0) {
						CanCreate = 1;
						numgame[2] = numgame[0];
						emptyOrnot[2] = 1;
						numgame[1] = 0;
						emptyOrnot[1] = 0;
						numgame[0] = 0;
						emptyOrnot[0] = 0;
					}

				}
			}

			else if (numgame[2] == 0) {

				if (numgame[1] != 0) { // 0 0 2 2, 0 0 2 0
					CanCreate = 1;
					numgame[3] = numgame[1];
					emptyOrnot[3] = 1;
					numgame[2] = numgame[0];
					emptyOrnot[2] = 1;
					numgame[1] = 0;
					emptyOrnot[1] = 0;
					numgame[0] = 0;
					emptyOrnot[0] = 0;
				}

				else if (numgame[1] == 0) {
					if (numgame[0] != 0) { // 0 0 0 2
						CanCreate = 1;
						numgame[3] = numgame[0];
						emptyOrnot[3] = 1;
						numgame[2] = 0;
						emptyOrnot[2] = 0;
						numgame[1] = 0;
						emptyOrnot[1] = 0;
						numgame[0] = 0;
						emptyOrnot[0] = 0;

					}

				}

			}

		}

		//
		else if (numgame[2] == 0) {

			if (numgame[1] != 0) { // 2 0 2 0
				CanCreate = 1;
				numgame[2] = numgame[1];
				emptyOrnot[2] = 1;
				numgame[1] = 0;
				emptyOrnot[1] = 0;

				if (numgame[0] != 0) { // 2 0 2 2
					numgame[1] = numgame[0];
					emptyOrnot[1] = 1;
					numgame[0] = 0;
					emptyOrnot[0] = 0;
				}

			}

			else if (numgame[1] == 0) { // 2 0 0 0

				if (numgame[0] != 0) { // 2 0 0 0
					CanCreate = 1;
					numgame[2] = numgame[0];
					emptyOrnot[2] = 1;
					numgame[1] = 0;
					emptyOrnot[1] = 0;
					numgame[1] = 0;
					emptyOrnot[1] = 0;
				}

			}

		}

		//

		else if (numgame[1] == 0) { // 2 2 0 0

			if (numgame[0] != 0) { // 2 2 0 2
				CanCreate = 1;
				numgame[1] = numgame[0];
				emptyOrnot[1] = 1;
				numgame[0] = 0;
				emptyOrnot[0] = 0;
			}

		}
		
		//end line1
		
		if (numgame[7] == 0) {

			if (numgame[6] != 0) {
				CanCreate = 1;
				numgame[7] = numgame[6]; // 0 2 0 0
				emptyOrnot[7] = 1;
				numgame[6] = 0;
				emptyOrnot[6] = 0;

				if (numgame[5] != 0) {
					numgame[6] = numgame[5]; // 0 2 2 0, 0 2 2 2
					emptyOrnot[6] = 1;
					numgame[5] = numgame[4];
					numgame[4] = 0;
					emptyOrnot[4] = 0;
				}

				else if (numgame[5] == 0) { // 0 2 0 2
					if (numgame[4] != 0) {
						CanCreate = 1;
						numgame[6] = numgame[4];
						emptyOrnot[6] = 1;
						numgame[5] = 0;
						emptyOrnot[5] = 0;
						numgame[4] = 0;
						emptyOrnot[4] = 0;
					}

				}
			}

			else if (numgame[6] == 0) {

				if (numgame[5] != 0) { // 0 0 2 2, 0 0 2 0
					CanCreate = 1;
					numgame[7] = numgame[5];
					emptyOrnot[7] = 1;
					numgame[6] = numgame[4];
					emptyOrnot[6] = 1;
					numgame[5] = 0;
					emptyOrnot[5] = 0;
					numgame[4] = 0;
					emptyOrnot[4] = 0;
				}

				else if (numgame[5] == 0) {
					if (numgame[4] != 0) { // 0 0 0 2
						CanCreate = 1;
						numgame[7] = numgame[4];
						emptyOrnot[7] = 1;
						numgame[6] = 0;
						emptyOrnot[6] = 0;
						numgame[5] = 0;
						emptyOrnot[5] = 0;
						numgame[4] = 0;
						emptyOrnot[4] = 0;

					}

				}

			}

		}

		//
		else if (numgame[6] == 0) {

			if (numgame[5] != 0) { // 2 0 2 0
				CanCreate = 1;
				numgame[6] = numgame[5];
				emptyOrnot[6] = 1;
				numgame[5] = 0;
				emptyOrnot[5] = 0;

				if (numgame[4] != 0) { // 2 0 2 2
					numgame[5] = numgame[4];
					emptyOrnot[5] = 1;
					numgame[4] = 0;
					emptyOrnot[4] = 0;
				}

			}

			else if (numgame[5] == 0) { // 2 0 0 0

				if (numgame[4] != 0) { // 2 0 0 0
					CanCreate = 1;
					numgame[6] = numgame[4];
					emptyOrnot[6] = 1;
					numgame[5] = 0;
					emptyOrnot[5] = 0;
					numgame[5] = 0;
					emptyOrnot[5] = 0;
				}

			}

		}

		//

		else if (numgame[5] == 0) { // 2 2 0 0

			if (numgame[4] != 0) { // 2 2 0 2
				CanCreate = 1;
				numgame[5] = numgame[4];
				emptyOrnot[5] = 1;
				numgame[4] = 0;
				emptyOrnot[4] = 0;
			}

		}
		
		//// end line 2

		if (numgame[11] == 0) {

			if (numgame[10] != 0) {
				CanCreate = 1;
				numgame[11] = numgame[10]; // 0 2 0 0
				emptyOrnot[11] = 1;
				numgame[10] = 0;
				emptyOrnot[10] = 0;

				if (numgame[9] != 0) {
					numgame[10] = numgame[9]; // 0 2 2 0, 0 2 2 2
					emptyOrnot[10] = 1;
					numgame[9] = numgame[8];
					numgame[8] = 0;
					emptyOrnot[8] = 0;
				}

				else if (numgame[9] == 0) { // 0 2 0 2
					if (numgame[8] != 0) {
						CanCreate = 1;
						numgame[10] = numgame[8];
						emptyOrnot[10] = 1;
						numgame[9] = 0;
						emptyOrnot[9] = 0;
						numgame[8] = 0;
						emptyOrnot[8] = 0;
					}

				}
			}

			else if (numgame[10] == 0) {

				if (numgame[9] != 0) { // 0 0 2 2, 0 0 2 0
					CanCreate = 1;
					numgame[11] = numgame[9];
					emptyOrnot[11] = 1;
					numgame[10] = numgame[8];
					emptyOrnot[10] = 1;
					numgame[9] = 0;
					emptyOrnot[9] = 0;
					numgame[8] = 0;
					emptyOrnot[8] = 0;
				}

				else if (numgame[9] == 0) {
					if (numgame[8] != 0) { // 0 0 0 2
						CanCreate = 1;
						numgame[11] = numgame[8];
						emptyOrnot[11] = 1;
						numgame[10] = 0;
						emptyOrnot[10] = 0;
						numgame[9] = 0;
						emptyOrnot[9] = 0;
						numgame[8] = 0;
						emptyOrnot[8] = 0;

					}

				}

			}

		}

		//
		else if (numgame[10] == 0) {

			if (numgame[9] != 0) { // 2 0 2 0
				CanCreate = 1;
				numgame[10] = numgame[9];
				emptyOrnot[10] = 1;
				numgame[9] = 0;
				emptyOrnot[9] = 0;

				if (numgame[8] != 0) { // 2 0 2 2
					numgame[9] = numgame[8];
					emptyOrnot[9] = 1;
					numgame[8] = 0;
					emptyOrnot[8] = 0;
				}

			}

			else if (numgame[9] == 0) { // 2 0 0 0

				if (numgame[8] != 0) { // 2 0 0 0
					CanCreate = 1;
					numgame[10] = numgame[8];
					emptyOrnot[10] = 1;
					numgame[9] = 0;
					emptyOrnot[9] = 0;
					numgame[9] = 0;
					emptyOrnot[9] = 0;
				}

			}

		}

		//

		else if (numgame[9] == 0) { // 2 2 0 0

			if (numgame[8] != 0) { // 2 2 0 2
				CanCreate = 1;
				numgame[9] = numgame[8];
				emptyOrnot[9] = 1;
				numgame[8] = 0;
				emptyOrnot[8] = 0;
			}

		}
		//// end line 3

		if (numgame[15] == 0) {

			if (numgame[14] != 0) {
				CanCreate = 1;
				numgame[15] = numgame[14]; // 0 2 0 0
				emptyOrnot[15] = 1;
				numgame[14] = 0;
				emptyOrnot[14] = 0;

				if (numgame[13] != 0) {
					numgame[14] = numgame[13]; // 0 2 2 0, 0 2 2 2
					emptyOrnot[14] = 1;
					numgame[13] = numgame[12];
					numgame[12] = 0;
					emptyOrnot[12] = 0;
				}

				else if (numgame[13] == 0) { // 0 2 0 2
					if (numgame[12] != 0) {
						CanCreate = 1;
						numgame[14] = numgame[12];
						emptyOrnot[14] = 1;
						numgame[13] = 0;
						emptyOrnot[13] = 0;
						numgame[12] = 0;
						emptyOrnot[12] = 0;
					}

				}
			}

			else if (numgame[14] == 0) {

				if (numgame[13] != 0) { // 0 0 2 2, 0 0 2 0
					CanCreate = 1;
					numgame[15] = numgame[13];
					emptyOrnot[15] = 1;
					numgame[14] = numgame[12];
					emptyOrnot[14] = 1;
					numgame[13] = 0;
					emptyOrnot[13] = 0;
					numgame[12] = 0;
					emptyOrnot[12] = 0;
				}

				else if (numgame[13] == 0) {
					if (numgame[12] != 0) { // 0 0 0 2
						CanCreate = 1;
						numgame[15] = numgame[12];
						emptyOrnot[15] = 1;
						numgame[14] = 0;
						emptyOrnot[14] = 0;
						numgame[13] = 0;
						emptyOrnot[13] = 0;
						numgame[12] = 0;
						emptyOrnot[12] = 0;

					}

				}

			}

		}

		//
		else if (numgame[14] == 0) {

			if (numgame[13] != 0) { // 2 0 2 0
				CanCreate = 1;
				numgame[14] = numgame[13];
				emptyOrnot[14] = 1;
				numgame[13] = 0;
				emptyOrnot[13] = 0;

				if (numgame[12] != 0) { // 2 0 2 2
					numgame[13] = numgame[12];
					emptyOrnot[13] = 1;
					numgame[12] = 0;
					emptyOrnot[12] = 0;
				}

			}

			else if (numgame[13] == 0) { // 2 0 0 0

				if (numgame[12] != 0) { // 2 0 0 0
					CanCreate = 1;
					numgame[14] = numgame[12];
					emptyOrnot[14] = 1;
					numgame[13] = 0;
					emptyOrnot[13] = 0;
					numgame[13] = 0;
					emptyOrnot[13] = 0;
				}

			}

		}

		//

		else if (numgame[13] == 0) { // 2 2 0 0

			if (numgame[12] != 0) { // 2 2 0 2
				CanCreate = 1;
				numgame[13] = numgame[12];
				emptyOrnot[13] = 1;
				numgame[12] = 0;
				emptyOrnot[12] = 0;
			}

		}
		//// end line 4
	}

	public void R_Sumvalue() {

		//////////// Start SumValue
		if (numgame[3] == numgame[2]) {
			numgame[3] += numgame[2];
			emptyOrnot[3] = 1;
			score += numgame[2];
			numgame[2] = 0;
			emptyOrnot[2] = 0;

			if (numgame[3] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[2] == numgame[1]) {
			numgame[2] += numgame[1];
			emptyOrnot[2] = 1;
			score += numgame[1];

			numgame[1] = 0;
			emptyOrnot[1] = 0;

			if (numgame[2] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[1] == numgame[0]) {
			numgame[1] += numgame[0];
			emptyOrnot[1] = 1;
			score += numgame[0];
			numgame[0] = 0;
			emptyOrnot[0] = 0;

			if (numgame[1] > 0) {
				CanCreate = 1;
			}

		}

		//////// end line 1

		if (numgame[7] == numgame[6]) {
			numgame[7] += numgame[6];
			emptyOrnot[7] = 1;
			score += numgame[6];
			numgame[6] = 0;
			emptyOrnot[6] = 0;

			if (numgame[7] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[6] == numgame[5]) {
			numgame[6] += numgame[5];
			emptyOrnot[6] = 1;
			score += numgame[5];
			numgame[5] = 0;
			emptyOrnot[5] = 0;

			if (numgame[6] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[5] == numgame[4]) {
			numgame[5] += numgame[4];
			emptyOrnot[5] = 1;
			score += numgame[4];
			numgame[4] = 0;
			emptyOrnot[4] = 0;

			if (numgame[5] > 0) {
				CanCreate = 1;
			}

		}
		//////// end line 2

		if (numgame[11] == numgame[10]) {
			numgame[11] += numgame[10];
			emptyOrnot[11] = 1;
			score += numgame[10];
			numgame[10] = 0;
			emptyOrnot[10] = 0;

			if (numgame[11] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[10] == numgame[9]) {
			numgame[10] += numgame[9];
			emptyOrnot[10] = 1;
			score += numgame[9];

			numgame[9] = 0;
			emptyOrnot[9] = 0;

			if (numgame[10] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[9] == numgame[8]) {
			numgame[9] += numgame[8];
			emptyOrnot[9] = 1;
			score += numgame[8];
			numgame[8] = 0;
			emptyOrnot[8] = 0;

			if (numgame[9] > 0) {
				CanCreate = 1;
			}

		}
		//////// end line 3

		if (numgame[15] == numgame[14]) {
			numgame[15] += numgame[14];
			emptyOrnot[15] = 1;
			score += numgame[14];
			numgame[14] = 0;
			emptyOrnot[14] = 0;

			if (numgame[15] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[14] == numgame[13]) {
			numgame[14] += numgame[13];
			emptyOrnot[14] = 1;
			score += numgame[13];

			numgame[13] = 0;
			emptyOrnot[13] = 0;

			if (numgame[14] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[13] == numgame[12]) {
			numgame[13] += numgame[12];
			emptyOrnot[13] = 1;
			score += numgame[12];
			numgame[12] = 0;
			emptyOrnot[12] = 0;

			if (numgame[13] > 0) {
				CanCreate = 1;
			}

		}
	}
	
	public void U_MergeLine() {
		///// Start MergeLine

		if (numgame[0] == 0) {

			if (numgame[4] != 0) {
				CanCreate = 1;
				numgame[0] = numgame[4]; // 0 2 0 0
				emptyOrnot[0] = 1;
				numgame[4] = 0;
				emptyOrnot[4] = 0;

				if (numgame[8] != 0) {
					numgame[4] = numgame[8]; // 0 2 2 0, 0 2 2 2
					emptyOrnot[4] = 1;
					numgame[8] = numgame[12];
					numgame[12] = 0;
					emptyOrnot[12] = 0;
				}

				else if (numgame[8] == 0) { // 0 2 0 2
					if (numgame[12] != 0) {
						CanCreate = 1;
						numgame[4] = numgame[12];
						emptyOrnot[4] = 1;
						numgame[8] = 0;
						emptyOrnot[8] = 0;
						numgame[12] = 0;
						emptyOrnot[12] = 0;
					}

				}
			}

			else if (numgame[4] == 0) {

				if (numgame[8] != 0) { // 0 0 2 2, 0 0 2 0
					CanCreate = 1;
					numgame[0] = numgame[8];
					emptyOrnot[0] = 1;
					numgame[4] = numgame[12];
					emptyOrnot[4] = 1;
					numgame[8] = 0;
					emptyOrnot[8] = 0;
					numgame[12] = 0;
					emptyOrnot[12] = 0;
				}

				else if (numgame[8] == 0) {
					if (numgame[12] != 0) { // 0 0 0 2
						CanCreate = 1;
						numgame[0] = numgame[12];
						emptyOrnot[0] = 1;
						numgame[4] = 0;
						emptyOrnot[4] = 0;
						numgame[8] = 0;
						emptyOrnot[8] = 0;
						numgame[12] = 0;
						emptyOrnot[12] = 0;

					}

				}

			}

		}

		//
		else if (numgame[4] == 0) {

			if (numgame[8] != 0) { // 2 0 2 0
				CanCreate = 1;
				numgame[4] = numgame[8];
				emptyOrnot[4] = 1;
				numgame[8] = 0;
				emptyOrnot[8] = 0;

				if (numgame[12] != 0) { // 2 0 2 2
					numgame[8] = numgame[12];
					emptyOrnot[8] = 1;
					numgame[12] = 0;
					emptyOrnot[12] = 0;
				}

			}

			else if (numgame[8] == 0) { // 2 0 0 0

				if (numgame[12] != 0) { // 2 0 0 0
					CanCreate = 1;
					numgame[4] = numgame[12];
					emptyOrnot[4] = 1;
					numgame[8] = 0;
					emptyOrnot[8] = 0;
					numgame[12] = 0;
					emptyOrnot[12] = 0;
				}

			}

		}

		//

		else if (numgame[8] == 0) { // 2 2 0 0

			if (numgame[12] != 0) { // 2 2 0 2
				CanCreate = 1;
				numgame[8] = numgame[12];
				emptyOrnot[8] = 1;
				numgame[12] = 0;
				emptyOrnot[12] = 0;
			}

		}
		//// end line 1
		if (numgame[1] == 0) {

			if (numgame[5] != 0) {
				CanCreate = 1;
				numgame[1] = numgame[5]; // 0 2 0 0
				emptyOrnot[1] = 1;
				numgame[5] = 0;
				emptyOrnot[5] = 0;

				if (numgame[9] != 0) {
					numgame[5] = numgame[9]; // 0 2 2 0, 0 2 2 2
					emptyOrnot[5] = 1;
					numgame[9] = numgame[13];
					numgame[13] = 0;
					emptyOrnot[13] = 0;
				}

				else if (numgame[9] == 0) { // 0 2 0 2
					if (numgame[13] != 0) {
						CanCreate = 1;
						numgame[5] = numgame[13];
						emptyOrnot[5] = 1;
						numgame[9] = 0;
						emptyOrnot[9] = 0;
						numgame[13] = 0;
						emptyOrnot[13] = 0;
					}

				}
			}

			else if (numgame[5] == 0) {

				if (numgame[9] != 0) { // 0 0 2 2, 0 0 2 0
					CanCreate = 1;
					numgame[1] = numgame[9];
					emptyOrnot[1] = 1;
					numgame[5] = numgame[13];
					emptyOrnot[5] = 1;
					numgame[9] = 0;
					emptyOrnot[9] = 0;
					numgame[13] = 0;
					emptyOrnot[13] = 0;
				}

				else if (numgame[9] == 0) {
					if (numgame[13] != 0) { // 0 0 0 2
						CanCreate = 1;
						numgame[1] = numgame[13];
						emptyOrnot[1] = 1;
						numgame[5] = 0;
						emptyOrnot[5] = 0;
						numgame[9] = 0;
						emptyOrnot[9] = 0;
						numgame[13] = 0;
						emptyOrnot[13] = 0;

					}

				}

			}

		}

		//
		else if (numgame[5] == 0) {

			if (numgame[9] != 0) { // 2 0 2 0
				CanCreate = 1;
				numgame[5] = numgame[9];
				emptyOrnot[5] = 1;
				numgame[9] = 0;
				emptyOrnot[9] = 0;

				if (numgame[13] != 0) { // 2 0 2 2
					numgame[9] = numgame[13];
					emptyOrnot[9] = 1;
					numgame[13] = 0;
					emptyOrnot[13] = 0;
				}

			}

			else if (numgame[9] == 0) { // 2 0 0 0

				if (numgame[13] != 0) { // 2 0 0 0
					CanCreate = 1;
					numgame[5] = numgame[13];
					emptyOrnot[5] = 1;
					numgame[9] = 0;
					emptyOrnot[9] = 0;
					numgame[13] = 0;
					emptyOrnot[13] = 0;
				}

			}

		}

		//

		else if (numgame[9] == 0) { // 2 2 0 0

			if (numgame[13] != 0) { // 2 2 0 2
				CanCreate = 1;
				numgame[9] = numgame[13];
				emptyOrnot[9] = 1;
				numgame[13] = 0;
				emptyOrnot[13] = 0;
			}

		}
		//// end line 2

		if (numgame[2] == 0) {

			if (numgame[6] != 0) {
				CanCreate = 1;
				numgame[2] = numgame[6]; // 0 2 0 0
				emptyOrnot[2] = 1;
				numgame[6] = 0;
				emptyOrnot[6] = 0;

				if (numgame[10] != 0) {
					numgame[6] = numgame[10]; // 0 2 2 0, 0 2 2 2
					emptyOrnot[6] = 1;
					numgame[10] = numgame[14];
					numgame[14] = 0;
					emptyOrnot[14] = 0;
				}

				else if (numgame[10] == 0) { // 0 2 0 2
					if (numgame[14] != 0) {
						CanCreate = 1;
						numgame[6] = numgame[14];
						emptyOrnot[6] = 1;
						numgame[10] = 0;
						emptyOrnot[10] = 0;
						numgame[14] = 0;
						emptyOrnot[14] = 0;
					}

				}
			}

			else if (numgame[6] == 0) {

				if (numgame[10] != 0) { // 0 0 2 2, 0 0 2 0
					CanCreate = 1;
					numgame[2] = numgame[10];
					emptyOrnot[2] = 1;
					numgame[6] = numgame[14];
					emptyOrnot[6] = 1;
					numgame[10] = 0;
					emptyOrnot[10] = 0;
					numgame[14] = 0;
					emptyOrnot[14] = 0;
				}

				else if (numgame[10] == 0) {
					if (numgame[14] != 0) { // 0 0 0 2
						CanCreate = 1;
						numgame[2] = numgame[14];
						emptyOrnot[2] = 1;
						numgame[6] = 0;
						emptyOrnot[6] = 0;
						numgame[10] = 0;
						emptyOrnot[10] = 0;
						numgame[14] = 0;
						emptyOrnot[14] = 0;

					}

				}

			}

		}

		//
		else if (numgame[6] == 0) {

			if (numgame[10] != 0) { // 2 0 2 0
				CanCreate = 1;
				numgame[6] = numgame[10];
				emptyOrnot[6] = 1;
				numgame[10] = 0;
				emptyOrnot[10] = 0;

				if (numgame[14] != 0) { // 2 0 2 2
					numgame[10] = numgame[14];
					emptyOrnot[10] = 1;
					numgame[14] = 0;
					emptyOrnot[14] = 0;
				}

			}

			else if (numgame[10] == 0) { // 2 0 0 0

				if (numgame[14] != 0) { // 2 0 0 0
					CanCreate = 1;
					numgame[6] = numgame[14];
					emptyOrnot[6] = 1;
					numgame[10] = 0;
					emptyOrnot[10] = 0;
					numgame[14] = 0;
					emptyOrnot[14] = 0;
				}

			}

		}

		//

		else if (numgame[10] == 0) { // 2 2 0 0

			if (numgame[14] != 0) { // 2 2 0 2
				CanCreate = 1;
				numgame[10] = numgame[14];
				emptyOrnot[10] = 1;
				numgame[14] = 0;
				emptyOrnot[14] = 0;
			}

		}
		//// end line 3

		if (numgame[3] == 0) {

			if (numgame[7] != 0) {
				CanCreate = 1;
				numgame[3] = numgame[7]; // 0 2 0 0
				emptyOrnot[3] = 1;
				numgame[7] = 0;
				emptyOrnot[7] = 0;

				if (numgame[11] != 0) {
					numgame[7] = numgame[11]; // 0 2 2 0, 0 2 2 2
					emptyOrnot[7] = 1;
					numgame[11] = numgame[15];
					numgame[15] = 0;
					emptyOrnot[15] = 0;
				}

				else if (numgame[11] == 0) { // 0 2 0 2
					if (numgame[15] != 0) {
						CanCreate = 1;
						numgame[7] = numgame[15];
						emptyOrnot[7] = 1;
						numgame[11] = 0;
						emptyOrnot[11] = 0;
						numgame[15] = 0;
						emptyOrnot[15] = 0;
					}

				}
			}

			else if (numgame[7] == 0) {

				if (numgame[11] != 0) { // 0 0 2 2, 0 0 2 0
					CanCreate = 1;
					numgame[15] = numgame[11];
					emptyOrnot[15] = 1;
					numgame[7] = numgame[15];
					emptyOrnot[7] = 1;
					numgame[11] = 0;
					emptyOrnot[11] = 0;
					numgame[15] = 0;
					emptyOrnot[15] = 0;
				}

				else if (numgame[11] == 0) {
					if (numgame[15] != 0) { // 0 0 0 2
						CanCreate = 1;
						numgame[3] = numgame[15];
						emptyOrnot[3] = 1;
						numgame[7] = 0;
						emptyOrnot[7] = 0;
						numgame[11] = 0;
						emptyOrnot[11] = 0;
						numgame[15] = 0;
						emptyOrnot[15] = 0;

					}

				}

			}

		}

		//
		else if (numgame[7] == 0) {

			if (numgame[11] != 0) { // 2 0 2 0
				CanCreate = 1;
				numgame[7] = numgame[11];
				emptyOrnot[7] = 1;
				numgame[11] = 0;
				emptyOrnot[11] = 0;

				if (numgame[15] != 0) { // 2 0 2 2
					numgame[11] = numgame[15];
					emptyOrnot[11] = 1;
					numgame[15] = 0;
					emptyOrnot[15] = 0;
				}

			}

			else if (numgame[11] == 0) { // 2 0 0 0

				if (numgame[15] != 0) { // 2 0 0 0
					CanCreate = 1;
					numgame[7] = numgame[15];
					emptyOrnot[7] = 1;
					numgame[11] = 0;
					emptyOrnot[11] = 0;
					numgame[15] = 0;
					emptyOrnot[15] = 0;
				}

			}

		}

		//

		else if (numgame[11] == 0) { // 2 2 0 0

			if (numgame[15] != 0) { // 2 2 0 2
				CanCreate = 1;
				numgame[11] = numgame[15];
				emptyOrnot[11] = 1;
				numgame[15] = 0;
				emptyOrnot[15] = 0;
			}

		}
		//// end line 4
		///////// end mergeLine
	}

	public void U_Sumvalue() {

		//////////// Start SumValue

		if (numgame[0] == numgame[4]) {
			numgame[0] += numgame[4];
			emptyOrnot[0] = 1;
			score += numgame[4];
			numgame[4] = 0;
			emptyOrnot[4] = 0;

			if (numgame[0] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[4] == numgame[8]) {
			numgame[4] += numgame[8];
			emptyOrnot[4] = 1;
			score += numgame[8];
			numgame[8] = 0;
			emptyOrnot[8] = 0;

			if (numgame[4] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[8] == numgame[12]) {
			numgame[8] += numgame[12];
			emptyOrnot[8] = 1;
			score += numgame[12];
			numgame[12] = 0;
			emptyOrnot[12] = 0;

			if (numgame[8] > 0) {
				CanCreate = 1;
			}

		}
		//////// end line 1

		if (numgame[1] == numgame[5]) {
			numgame[1] += numgame[5];
			emptyOrnot[1] = 1;
			score += numgame[5];
			numgame[5] = 0;
			emptyOrnot[5] = 0;

			if (numgame[1] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[5] == numgame[9]) {
			numgame[5] += numgame[9];
			emptyOrnot[5] = 1;
			score += numgame[9];

			numgame[9] = 0;
			emptyOrnot[9] = 0;

			if (numgame[5] > 0) {
				CanCreate = 1;
			}
		}

		if (numgame[9] == numgame[13]) {
			numgame[9] += numgame[13];
			emptyOrnot[9] = 1;
			score += numgame[13];
			numgame[13] = 0;
			emptyOrnot[13] = 0;

			if (numgame[9] > 0) {
				CanCreate = 1;
			}

		}
		//////// end line 2

		if (numgame[2] == numgame[6]) {
			numgame[2] += numgame[6];
			emptyOrnot[2] = 1;
			score += numgame[6];

			numgame[6] = 0;
			emptyOrnot[6] = 0;

			if (numgame[2] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[6] == numgame[10]) {
			numgame[6] += numgame[10];
			score += numgame[10];
			emptyOrnot[6] = 1;
			numgame[10] = 0;
			emptyOrnot[10] = 0;

			if (numgame[6] > 0) {
				CanCreate = 1;
			}
		}

		if (numgame[10] == numgame[14]) {
			numgame[10] += numgame[14];
			score += numgame[14];
			emptyOrnot[10] = 1;
			numgame[14] = 0;
			emptyOrnot[14] = 0;

			if (numgame[10] > 0) {
				CanCreate = 1;
			}
		}
		//////// end line 3

		if (numgame[3] == numgame[7]) {
			numgame[3] += numgame[7];
			score += numgame[7];
			emptyOrnot[3] = 1;
			numgame[7] = 0;
			emptyOrnot[7] = 0;

			if (numgame[3] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[7] == numgame[11]) {
			numgame[7] += numgame[11];
			score += numgame[11];
			emptyOrnot[7] = 1;
			numgame[11] = 0;
			emptyOrnot[11] = 0;

			if (numgame[7] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[11] == numgame[15]) {
			numgame[11] += numgame[15];
			score += numgame[15];
			emptyOrnot[11] = 1;
			numgame[15] = 0;
			emptyOrnot[15] = 0;

			if (numgame[11] > 0) {
				CanCreate = 1;
			}
		}
		//////// end line 4
		///////////////// end SumValue

	}

	public void D_MergeLine() {
		///// Start MergeLine

		if (numgame[12] == 0) {

			if (numgame[8] != 0) {
				CanCreate = 1;
				numgame[12] = numgame[8]; // 0 2 0 0
				emptyOrnot[12] = 1;
				numgame[8] = 0;
				emptyOrnot[8] = 0;

				if (numgame[4] != 0) {
					numgame[8] = numgame[4]; // 0 2 2 0, 0 2 2 2
					emptyOrnot[8] = 1;
					numgame[4] = numgame[0];
					numgame[0] = 0;
					emptyOrnot[0] = 0;
				}

				else if (numgame[4] == 0) { // 0 2 0 2
					if (numgame[0] != 0) {
						CanCreate = 1;
						numgame[8] = numgame[0];
						emptyOrnot[8] = 1;
						numgame[4] = 0;
						emptyOrnot[4] = 0;
						numgame[0] = 0;
						emptyOrnot[0] = 0;
					}

				}
			}

			else if (numgame[8] == 0) {

				if (numgame[4] != 0) { // 0 0 2 2, 0 0 2 0
					CanCreate = 1;
					numgame[12] = numgame[4];
					emptyOrnot[12] = 1;
					numgame[8] = numgame[0];
					emptyOrnot[8] = 1;
					numgame[4] = 0;
					emptyOrnot[4] = 0;
					numgame[0] = 0;
					emptyOrnot[0] = 0;
				}

				else if (numgame[4] == 0) {
					if (numgame[0] != 0) { // 0 0 0 2
						CanCreate = 1;
						numgame[12] = numgame[0];
						emptyOrnot[12] = 1;
						numgame[8] = 0;
						emptyOrnot[8] = 0;
						numgame[4] = 0;
						emptyOrnot[4] = 0;
						numgame[0] = 0;
						emptyOrnot[0] = 0;

					}

				}

			}

		}

		//
		else if (numgame[8] == 0) {

			if (numgame[4] != 0) { // 2 0 2 0
				CanCreate = 1;
				numgame[8] = numgame[4];
				emptyOrnot[8] = 1;
				numgame[4] = 0;
				emptyOrnot[4] = 0;

				if (numgame[0] != 0) { // 2 0 2 2
					numgame[4] = numgame[0];
					emptyOrnot[4] = 1;
					numgame[0] = 0;
					emptyOrnot[0] = 0;
				}

			}

			else if (numgame[4] == 0) { // 2 0 0 0

				if (numgame[0] != 0) { // 2 0 0 0
					CanCreate = 1;
					numgame[8] = numgame[0];
					emptyOrnot[8] = 1;
					numgame[4] = 0;
					emptyOrnot[4] = 0;
					numgame[0] = 0;
					emptyOrnot[0] = 0;
				}

			}

		}

		//

		else if (numgame[4] == 0) { // 2 2 0 0

			if (numgame[0] != 0) { // 2 2 0 2
				CanCreate = 1;
				numgame[4] = numgame[0];
				emptyOrnot[4] = 1;
				numgame[0] = 0;
				emptyOrnot[0] = 0;
			}

		}
		//// end line 1

		if (numgame[13] == 0) {

			if (numgame[9] != 0) {
				CanCreate = 1;
				numgame[13] = numgame[9]; // 0 2 0 0
				emptyOrnot[13] = 1;
				numgame[9] = 0;
				emptyOrnot[9] = 0;

				if (numgame[5] != 0) {
					numgame[9] = numgame[5]; // 0 2 2 0, 0 2 2 2
					emptyOrnot[9] = 1;
					numgame[5] = numgame[1];
					numgame[1] = 0;
					emptyOrnot[1] = 0;
				}

				else if (numgame[5] == 0) { // 0 2 0 2
					if (numgame[1] != 0) {
						CanCreate = 1;
						numgame[9] = numgame[1];
						emptyOrnot[9] = 1;
						numgame[5] = 0;
						emptyOrnot[5] = 0;
						numgame[1] = 0;
						emptyOrnot[1] = 0;
					}

				}
			}

			else if (numgame[9] == 0) {

				if (numgame[5] != 0) { // 0 0 2 2, 0 0 2 0
					CanCreate = 1;
					numgame[13] = numgame[5];
					emptyOrnot[13] = 1;
					numgame[9] = numgame[1];
					emptyOrnot[9] = 1;
					numgame[5] = 0;
					emptyOrnot[5] = 0;
					numgame[1] = 0;
					emptyOrnot[1] = 0;
				}

				else if (numgame[5] == 0) {
					if (numgame[1] != 0) { // 0 0 0 2
						CanCreate = 1;
						numgame[13] = numgame[1];
						emptyOrnot[13] = 1;
						numgame[9] = 0;
						emptyOrnot[9] = 0;
						numgame[5] = 0;
						emptyOrnot[5] = 0;
						numgame[1] = 0;
						emptyOrnot[1] = 0;

					}

				}

			}

		}

		//
		else if (numgame[9] == 0) {

			if (numgame[5] != 0) { // 2 0 2 0
				CanCreate = 1;
				numgame[9] = numgame[5];
				emptyOrnot[9] = 1;
				numgame[5] = 0;
				emptyOrnot[5] = 0;

				if (numgame[1] != 0) { // 2 0 2 2
					numgame[5] = numgame[1];
					emptyOrnot[5] = 1;
					numgame[1] = 0;
					emptyOrnot[1] = 0;
				}

			}

			else if (numgame[5] == 0) { // 2 0 0 0

				if (numgame[1] != 0) { // 2 0 0 0
					CanCreate = 1;
					numgame[9] = numgame[1];
					emptyOrnot[9] = 1;
					numgame[5] = 0;
					emptyOrnot[5] = 0;
					numgame[1] = 0;
					emptyOrnot[1] = 0;
				}

			}

		}

		//

		else if (numgame[5] == 0) { // 2 2 0 0

			if (numgame[1] != 0) { // 2 2 0 2
				CanCreate = 1;
				numgame[5] = numgame[1];
				emptyOrnot[5] = 1;
				numgame[1] = 0;
				emptyOrnot[1] = 0;
			}

		}
		//// end line 2

		if (numgame[14] == 0) {

			if (numgame[10] != 0) {
				CanCreate = 1;
				numgame[14] = numgame[10]; // 0 2 0 0
				emptyOrnot[14] = 1;
				numgame[10] = 0;
				emptyOrnot[10] = 0;

				if (numgame[6] != 0) {
					numgame[10] = numgame[6]; // 0 2 2 0, 0 2 2 2
					emptyOrnot[10] = 1;
					numgame[6] = numgame[2];
					numgame[2] = 0;
					emptyOrnot[2] = 0;
				}

				else if (numgame[6] == 0) { // 0 2 0 2
					if (numgame[2] != 0) {
						CanCreate = 1;
						numgame[10] = numgame[2];
						emptyOrnot[10] = 1;
						numgame[6] = 0;
						emptyOrnot[6] = 0;
						numgame[2] = 0;
						emptyOrnot[2] = 0;
					}

				}
			}

			else if (numgame[10] == 0) {

				if (numgame[6] != 0) { // 0 0 2 2, 0 0 2 0
					CanCreate = 1;
					numgame[14] = numgame[6];
					emptyOrnot[14] = 1;
					numgame[10] = numgame[2];
					emptyOrnot[10] = 1;
					numgame[6] = 0;
					emptyOrnot[6] = 0;
					numgame[2] = 0;
					emptyOrnot[2] = 0;
				}

				else if (numgame[6] == 0) {
					if (numgame[2] != 0) { // 0 0 0 2
						CanCreate = 1;
						numgame[14] = numgame[2];
						emptyOrnot[14] = 1;
						numgame[10] = 0;
						emptyOrnot[10] = 0;
						numgame[6] = 0;
						emptyOrnot[6] = 0;
						numgame[2] = 0;
						emptyOrnot[2] = 0;

					}

				}

			}

		}

		//
		else if (numgame[10] == 0) {

			if (numgame[6] != 0) { // 2 0 2 0
				CanCreate = 1;
				numgame[10] = numgame[6];
				emptyOrnot[10] = 1;
				numgame[6] = 0;
				emptyOrnot[6] = 0;

				if (numgame[2] != 0) { // 2 0 2 2
					numgame[6] = numgame[2];
					emptyOrnot[6] = 1;
					numgame[2] = 0;
					emptyOrnot[2] = 0;
				}

			}

			else if (numgame[6] == 0) { // 2 0 0 0

				if (numgame[2] != 0) { // 2 0 0 0
					CanCreate = 1;
					numgame[10] = numgame[2];
					emptyOrnot[10] = 1;
					numgame[6] = 0;
					emptyOrnot[6] = 0;
					numgame[2] = 0;
					emptyOrnot[2] = 0;
				}

			}

		}

		//

		else if (numgame[6] == 0) { // 2 2 0 0

			if (numgame[2] != 0) { // 2 2 0 2
				CanCreate = 1;
				numgame[6] = numgame[2];
				emptyOrnot[6] = 1;
				numgame[2] = 0;
				emptyOrnot[2] = 0;
			}

		}
		//// end line 3

		if (numgame[15] == 0) {

			if (numgame[11] != 0) {
				CanCreate = 1;
				numgame[15] = numgame[11]; // 0 2 0 0
				emptyOrnot[15] = 1;
				numgame[11] = 0;
				emptyOrnot[11] = 0;

				if (numgame[7] != 0) {
					numgame[11] = numgame[7]; // 0 2 2 0, 0 2 2 2
					emptyOrnot[11] = 1;
					numgame[7] = numgame[3];
					numgame[3] = 0;
					emptyOrnot[3] = 0;
				}

				else if (numgame[7] == 0) { // 0 2 0 2
					if (numgame[3] != 0) {
						CanCreate = 1;
						numgame[11] = numgame[3];
						emptyOrnot[11] = 1;
						numgame[7] = 0;
						emptyOrnot[7] = 0;
						numgame[3] = 0;
						emptyOrnot[3] = 0;
					}

				}
			}

			else if (numgame[11] == 0) {

				if (numgame[7] != 0) { // 0 0 2 2, 0 0 2 0
					CanCreate = 1;
					numgame[15] = numgame[7];
					emptyOrnot[15] = 1;
					numgame[11] = numgame[3];
					emptyOrnot[11] = 1;
					numgame[7] = 0;
					emptyOrnot[7] = 0;
					numgame[3] = 0;
					emptyOrnot[3] = 0;
				}

				else if (numgame[7] == 0) {
					if (numgame[3] != 0) { // 0 0 0 2
						CanCreate = 1;
						numgame[15] = numgame[3];
						emptyOrnot[15] = 1;
						numgame[11] = 0;
						emptyOrnot[11] = 0;
						numgame[7] = 0;
						emptyOrnot[7] = 0;
						numgame[3] = 0;
						emptyOrnot[3] = 0;

					}

				}

			}

		}

		//
		else if (numgame[11] == 0) {

			if (numgame[7] != 0) { // 2 0 2 0
				CanCreate = 1;
				numgame[11] = numgame[7];
				emptyOrnot[11] = 1;
				numgame[7] = 0;
				emptyOrnot[7] = 0;

				if (numgame[3] != 0) { // 2 0 2 2
					numgame[7] = numgame[3];
					emptyOrnot[7] = 1;
					numgame[3] = 0;
					emptyOrnot[3] = 0;
				}

			}

			else if (numgame[7] == 0) { // 2 0 0 0

				if (numgame[3] != 0) { // 2 0 0 0
					CanCreate = 1;
					numgame[11] = numgame[3];
					emptyOrnot[11] = 1;
					numgame[7] = 0;
					emptyOrnot[7] = 0;
					numgame[3] = 0;
					emptyOrnot[3] = 0;
				}

			}

		}

		//

		else if (numgame[7] == 0) { // 2 2 0 0

			if (numgame[3] != 0) { // 2 2 0 2
				CanCreate = 1;
				numgame[7] = numgame[3];
				emptyOrnot[7] = 1;
				numgame[3] = 0;
				emptyOrnot[3] = 0;
			}

		}
		//// end line 4
		/////// end mergeLine
	}

	public void D_Sumvalue() {

		//////////// Start SumValue

		if (numgame[12] == numgame[8]) {
			numgame[12] += numgame[8];
			emptyOrnot[12] = 1;
			score += numgame[8];
			numgame[8] = 0;
			emptyOrnot[8] = 0;

			if (numgame[12] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[8] == numgame[4]) {
			numgame[8] += numgame[4];
			emptyOrnot[8] = 1;
			score += numgame[4];
			numgame[4] = 0;
			emptyOrnot[4] = 0;

			if (numgame[8] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[4] == numgame[0]) {
			numgame[4] += numgame[0];
			emptyOrnot[4] = 1;
			score += numgame[0];
			numgame[0] = 0;
			emptyOrnot[0] = 0;

			if (numgame[4] > 0) {
				CanCreate = 1;
			}

		}
		//////// end line 1

		if (numgame[13] == numgame[9]) {
			numgame[13] += numgame[9];
			emptyOrnot[13] = 1;
			score += numgame[9];
			numgame[9] = 0;
			emptyOrnot[9] = 0;

			if (numgame[13] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[9] == numgame[5]) {
			numgame[9] += numgame[5];
			emptyOrnot[9] = 1;
			score += numgame[5];
			numgame[5] = 0;
			emptyOrnot[5] = 0;

			if (numgame[9] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[5] == numgame[1]) {
			numgame[5] += numgame[1];
			emptyOrnot[5] = 1;
			score += numgame[1];
			numgame[1] = 0;
			emptyOrnot[1] = 0;

			if (numgame[5] > 0) {
				CanCreate = 1;
			}

		}
		//////// end line 2

		if (numgame[14] == numgame[10]) {
			numgame[14] += numgame[10];
			emptyOrnot[14] = 1;
			score += numgame[10];
			numgame[10] = 0;
			emptyOrnot[10] = 0;

			if (numgame[14] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[10] == numgame[6]) {
			numgame[10] += numgame[6];
			emptyOrnot[10] = 1;
			score += numgame[6];
			numgame[6] = 0;
			emptyOrnot[6] = 0;

			if (numgame[10] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[6] == numgame[2]) {
			numgame[6] += numgame[2];
			emptyOrnot[6] = 1;
			score += numgame[2];
			numgame[2] = 0;
			emptyOrnot[2] = 0;

			if (numgame[6] > 0) {
				CanCreate = 1;
			}

		}
		//////// end line 3

		if (numgame[15] == numgame[11]) {
			numgame[15] += numgame[11];
			emptyOrnot[15] = 1;
			score += numgame[11];
			numgame[11] = 0;
			emptyOrnot[11] = 0;

			if (numgame[15] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[11] == numgame[7]) {
			numgame[11] += numgame[7];
			emptyOrnot[11] = 1;
			score += numgame[7];
			numgame[7] = 0;
			emptyOrnot[7] = 0;

			if (numgame[11] > 0) {
				CanCreate = 1;
			}

		}

		if (numgame[7] == numgame[3]) {
			numgame[7] += numgame[3];
			emptyOrnot[7] = 1;
			score += numgame[3];
			numgame[3] = 0;
			emptyOrnot[3] = 0;

			if (numgame[7] > 0) {
				CanCreate = 1;
			}

		}
		//////// end line 4
		///////////////// end SumValue

	}

	public void checkValue() {
		for (int i = 0; i < num.length; i++) {
			if ((String.valueOf(numgame[i]) == "0")) {
				emptyOrnot[i] = 0;
			}

		}
	}
}
