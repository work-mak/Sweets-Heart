package game2048;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class collection {

	private JFrame frame;
	private int CanOpen;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int data[] = new int[14];
					for(int i = 0; i<data.length;i++){
						data[i] = 0;
					}
					collection window = new collection(1,data);
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public collection(int CanOp,int[] data) {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		
		this.CanOpen = CanOp;
		Readfile save = new Readfile();
		
		frame.getContentPane().setLayout(null);
		Image bg_collection_icon = new ImageIcon(this.getClass().getResource("/game_bg.png")).getImage();
		Image menu = new ImageIcon(this.getClass().getResource("/game_menu.png")).getImage();
		Image base_cha = new ImageIcon(this.getClass().getResource("/base.jpg")).getImage();
		Image bg_cha1 = new ImageIcon(this.getClass().getResource("/col_1.png")).getImage();
		Image bg_cha2 = new ImageIcon(this.getClass().getResource("/col_2.png")).getImage();
		Image bg_cha3 = new ImageIcon(this.getClass().getResource("/col_4.png")).getImage();
		Image bg_cha4 = new ImageIcon(this.getClass().getResource("/col_3.png")).getImage();
		Image bg_cha5 = new ImageIcon(this.getClass().getResource("/col_5.png")).getImage();
		Image bg_cha6 = new ImageIcon(this.getClass().getResource("/col_6.png")).getImage();
		Image bg_cha7 = new ImageIcon(this.getClass().getResource("/col_7.png")).getImage();
		Image bg_cha8 = new ImageIcon(this.getClass().getResource("/col_8.png")).getImage();
		Image bg_cha9 = new ImageIcon(this.getClass().getResource("/col_9.png")).getImage();
		Image bg_cha10 = new ImageIcon(this.getClass().getResource("/col_10.png")).getImage();
		Image bg_cha11 = new ImageIcon(this.getClass().getResource("/col_11.png")).getImage();
		
		
		JLabel cha1 = new JLabel();
		cha1.setHorizontalAlignment(SwingConstants.CENTER);
		cha1.setFont(new Font("UD Digi Kyokasho N-B", Font.PLAIN, 42));
		cha1.setBounds(25, 190, 200, 200);
		frame.getContentPane().add(cha1);
		cha1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(data[1] == 1){
				character op_data = new character(1);
				
				frame.dispose();
				frame.setVisible(false);
				}
				
				else if(data[1] == 0 && CanOpen != 0){
					data[13]-=1;
					data[1] = 1;
					try {
						save.Save(data);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					character op_data = new character(1);
					frame.dispose();
					frame.setVisible(false);
					}
			}
		});
		if(data[1] == 0){cha1.setIcon(new ImageIcon(base_cha));}
		if(data[1] == 1 ){cha1.setIcon(new ImageIcon(bg_cha1));}
		
		JLabel cha2 = new JLabel();
		cha2.setHorizontalAlignment(SwingConstants.CENTER);
		cha2.setFont(new Font("UD Digi Kyokasho N-B", Font.PLAIN, 42));
		cha2.setBounds(275, 190, 200, 200);
		frame.getContentPane().add(cha2);
		cha2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(data[2] == 1){
				character op_data = new character(2);
				
				frame.dispose();
				frame.setVisible(false);
				}
				
				else if(data[2] == 0 && CanOpen != 0){
					data[13]-=1;
					data[2] = 1;
					try {
						save.Save(data);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					character op_data = new character(2);
					frame.dispose();
					frame.setVisible(false);
					}
			}
		});
		
		
		if(data[2] == 0){cha2.setIcon(new ImageIcon(base_cha));}
		if(data[2] == 1 ){cha2.setIcon(new ImageIcon(bg_cha2));}
		
		JLabel cha3 = new JLabel();
		cha3.setHorizontalAlignment(SwingConstants.CENTER);
		cha3.setFont(new Font("UD Digi Kyokasho N-B", Font.PLAIN, 42));
		cha3.setBounds(525, 190, 200, 200);
		frame.getContentPane().add(cha3);
		cha3.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(data[3] == 1){
				character op_data = new character(3);
				
				frame.dispose();
				frame.setVisible(false);
				}
				
				else if(data[3] == 0 && CanOpen != 0){
					data[13]-=1;
					data[3] = 1;
					try {
						save.Save(data);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					character op_data = new character(3);
					frame.dispose();
					frame.setVisible(false);
					}
			}
		});

		if(data[3] == 0){cha3.setIcon(new ImageIcon(base_cha));}
		if(data[3] == 1 ){cha3.setIcon(new ImageIcon(bg_cha3));}
		
		JLabel cha4 = new JLabel();
		cha4.setHorizontalAlignment(SwingConstants.CENTER);
		cha4.setFont(new Font("UD Digi Kyokasho N-B", Font.PLAIN, 42));
		cha4.setBounds(775, 190, 200, 200);
		frame.getContentPane().add(cha4);
		cha4.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(data[4] == 1){
				character op_data = new character(4);
				
				frame.dispose();
				frame.setVisible(false);
				}
				
				else if(data[4] == 0 && CanOpen != 0){
					data[13]-=1;
					data[4] = 1;
					try {
						save.Save(data);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					character op_data = new character(4);
					frame.dispose();
					frame.setVisible(false);
					}
			}
		});
		
		if(data[4] == 0){cha4.setIcon(new ImageIcon(base_cha));}
		if(data[4] == 1 ){cha4.setIcon(new ImageIcon(bg_cha4));}
		
		JLabel cha5 = new JLabel();
		cha5.setHorizontalAlignment(SwingConstants.CENTER);
		cha5.setFont(new Font("UD Digi Kyokasho N-B", Font.PLAIN, 42));
		cha5.setBounds(1025, 190, 200, 200);
		frame.getContentPane().add(cha5);
		cha5.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(data[5] == 1){
				character op_data = new character(5);
				
				frame.dispose();
				frame.setVisible(false);
				}
				
				else if(data[5] == 0 && CanOpen != 0){
					data[13]-=1;
					data[5] = 1;
					try {
						save.Save(data);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					character op_data = new character(5);
					frame.dispose();
					frame.setVisible(false);
					}
			}
		});
		
		if(data[5] == 0){cha5.setIcon(new ImageIcon(base_cha));}
		if(data[5] == 1 ){cha5.setIcon(new ImageIcon(bg_cha5));}
		
		JLabel cha6 = new JLabel();
		cha6.setHorizontalAlignment(SwingConstants.CENTER);
		cha6.setFont(new Font("UD Digi Kyokasho N-B", Font.PLAIN, 42));
		cha6.setBounds(1275, 190, 200, 200);
		frame.getContentPane().add(cha6);
		cha6.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(data[6] == 1){
				character op_data = new character(6);
				
				frame.dispose();
				frame.setVisible(false);
				}
				
				else if(data[6] == 0 && CanOpen != 0){
					data[13]-=1;
					data[6] = 1;
					try {
						save.Save(data);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					character op_data = new character(6);
					frame.dispose();
					frame.setVisible(false);
					}
			}
		});
		if(data[6] == 0){cha6.setIcon(new ImageIcon(base_cha));}
		if(data[6] == 1 ){cha6.setIcon(new ImageIcon(bg_cha6));}
		
		JLabel cha7 = new JLabel();
		cha7.setHorizontalAlignment(SwingConstants.CENTER);
		cha7.setFont(new Font("UD Digi Kyokasho N-B", Font.PLAIN, 42));
		cha7.setBounds(25, 420, 200, 200);
		frame.getContentPane().add(cha7);
		cha7.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(data[7] == 1){
				character op_data = new character(7);
				
				frame.dispose();
				frame.setVisible(false);
				}
				
				else if(data[7] == 0 && CanOpen != 0){
					data[13]-=1;
					data[7] = 1;
					try {
						save.Save(data);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					character op_data = new character(7);
					frame.dispose();
					frame.setVisible(false);
					}
			}
		});
		
		if(data[7] == 0){cha7.setIcon(new ImageIcon(base_cha));}
		if(data[7] == 1 ){cha7.setIcon(new ImageIcon(bg_cha7));}
		
		JLabel cha8 = new JLabel();
		cha8.setHorizontalAlignment(SwingConstants.CENTER);
		cha8.setFont(new Font("UD Digi Kyokasho N-B", Font.PLAIN, 42));
		cha8.setBounds(275, 420, 200, 200);
		frame.getContentPane().add(cha8);
		cha8.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(data[8] == 1){
				character op_data = new character(8);
				
				frame.dispose();
				frame.setVisible(false);
				}
				
				else if(data[8] == 0 && CanOpen != 0){
					data[13]-=1;
					data[8] = 1;
					try {
						save.Save(data);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					character op_data = new character(8);
					frame.dispose();
					frame.setVisible(false);
					}
			}
		});
		
		
		if(data[8] == 0){cha8.setIcon(new ImageIcon(base_cha));}
		if(data[8] == 1 ){cha8.setIcon(new ImageIcon(bg_cha8));}
		
		JLabel cha9 = new JLabel();
		cha9.setHorizontalAlignment(SwingConstants.CENTER);
		cha9.setFont(new Font("UD Digi Kyokasho N-B", Font.PLAIN, 42));
		cha9.setBounds(525, 420, 200, 200);
		frame.getContentPane().add(cha9);
		cha9.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(data[9] == 1){
				character op_data = new character(9);
				
				frame.dispose();
				frame.setVisible(false);
				}
				
				else if(data[9] == 0 && CanOpen != 0){
					data[13]-=1;
					data[9] = 1;
					try {
						save.Save(data);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					character op_data = new character(9);
					frame.dispose();
					frame.setVisible(false);
					}
			}
		});

		if(data[9] == 0){cha9.setIcon(new ImageIcon(base_cha));}
		if(data[9] == 1 ){cha9.setIcon(new ImageIcon(bg_cha9));}
		
		JLabel cha10 = new JLabel();
		cha10.setHorizontalAlignment(SwingConstants.CENTER);
		cha10.setFont(new Font("UD Digi Kyokasho N-B", Font.PLAIN, 42));
		cha10.setBounds(775, 420, 200, 200);
		frame.getContentPane().add(cha10);
		cha10.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(data[10] == 1){
				character op_data = new character(10);
				
				frame.dispose();
				frame.setVisible(false);
				}
				
				else if(data[10] == 0 && CanOpen != 0){
					data[13]-=1;
					data[10] = 1;
					try {
						save.Save(data);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					character op_data = new character(10);
					frame.dispose();
					frame.setVisible(false);
					}
			}
		});

		if(data[10] == 0){cha10.setIcon(new ImageIcon(base_cha));}
		if(data[10] == 1 ){cha10.setIcon(new ImageIcon(bg_cha4));}
		
		JLabel cha11 = new JLabel();
		cha11.setHorizontalAlignment(SwingConstants.CENTER);
		cha11.setFont(new Font("UD Digi Kyokasho N-B", Font.PLAIN, 42));
		cha11.setBounds(1025, 420, 200, 200);
		frame.getContentPane().add(cha11);
		cha11.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(data[11] == 1){
				character op_data = new character(11);
				
				frame.dispose();
				frame.setVisible(false);
				}
				
				else if(data[11] == 0 && CanOpen != 0){
					data[13]-=1;
					data[11] = 1;
					try {
						save.Save(data);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					character op_data = new character(11);
					frame.dispose();
					frame.setVisible(false);
					}
			}
		});
		
		if(data[11] == 0){cha11.setIcon(new ImageIcon(base_cha));}
		if(data[11] == 1 ){cha11.setIcon(new ImageIcon(bg_cha10));}
		
		JLabel cha12 = new JLabel();
		cha12.setHorizontalAlignment(SwingConstants.CENTER);
		cha12.setFont(new Font("UD Digi Kyokasho N-B", Font.PLAIN, 42));
		cha12.setBounds(1275, 420, 200, 200);
		frame.getContentPane().add(cha12);
		cha12.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(data[12] == 1){
				character op_data = new character(12);
				
				frame.dispose();
				frame.setVisible(false);
				}
				
				else if(data[12] == 0 && CanOpen != 0){
					data[13]-=1;
					data[12] = 1;
					try {
						save.Save(data);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					character op_data = new character(12);
					
					frame.dispose();
					frame.setVisible(false);
					}
			}
		});
		
		if(data[12] == 0){cha12.setIcon(new ImageIcon(base_cha));}
		if(data[12] == 1 ){cha12.setIcon(new ImageIcon(bg_cha11));}
		
		JLabel label = new JLabel("SELECT SWEATS "+String.valueOf(CanOpen));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("UD Digi Kyokasho NK-B", Font.BOLD, 30));
		label.setBounds(25, 27, 356, 139);
		frame.getContentPane().add(label);
		
		
		JLabel lblCollection = new JLabel("COLLECTION");
		lblCollection.setFont(new Font("UD Digi Kyokasho NK-B", Font.BOLD, 70));
		lblCollection.setBounds(505, 11, 504, 139);
		
		frame.getContentPane().add(lblCollection);
		
		JLabel Menu = new JLabel("");
		Menu.setFont(new Font("Tw Cen MT", Font.PLAIN, 34));
		Menu.setBounds(620, 616, 298, 134);
		frame.getContentPane().add(Menu);
		Menu.setIcon(new ImageIcon(menu));
		Menu.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				try {
					home GoMenu = new home();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				frame.dispose();
				frame.setVisible(false);

			}
		});
		
		JLabel bg_collection = new JLabel("New label");
		bg_collection.setBounds(0, 0, 1500, 800);
		bg_collection.setIcon(new ImageIcon(bg_collection_icon));
		frame.getContentPane().add(bg_collection);
	}

}
