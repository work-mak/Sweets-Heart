package game2048;

import java.awt.Image;

import javax.swing.ImageIcon;

public class character_data {

	Image num1 = new ImageIcon(this.getClass().getResource("/Pudding.png")).getImage();
	Image num2 = new ImageIcon(this.getClass().getResource("/Cupcake.png")).getImage();
	Image num3 = new ImageIcon(this.getClass().getResource("/Macaron.png")).getImage();
	Image num4 = new ImageIcon(this.getClass().getResource("/I-tim1.png")).getImage();
	Image num5 = new ImageIcon(this.getClass().getResource("/Cookie.png")).getImage();
	Image num6 = new ImageIcon(this.getClass().getResource("/Donut.png")).getImage();
	Image num7 = new ImageIcon(this.getClass().getResource("/Pie.png")).getImage();
	Image num8 = new ImageIcon(this.getClass().getResource("/Candy.png")).getImage();
	Image num9 = new ImageIcon(this.getClass().getResource("/Cake.png")).getImage();
	Image num10 = new ImageIcon(this.getClass().getResource("/I-tim2.png")).getImage();
	Image num11 = new ImageIcon(this.getClass().getResource("/Jamroll.png")).getImage();
	Image num12 = new ImageIcon(this.getClass().getResource("/Jelly.png")).getImage();

	public Image imageGame(int value) {

		if (value == 1) {
			return num2;
		}
		;
		if (value == 2) {
			return num1;
		}
		;
		if (value == 3) {
			return num3;
		}
		;
		if (value == 4) {
			return num4;
		}
		;
		if (value == 5) {
			return num5;
		}
		;
		if (value == 6) {
			return num6;
		}
		;
		if (value == 7) {
			return num7;
		}
		;
		if (value == 8) {
			return num8;
		}
		;
		if (value == 9) {
			return num9;
		}
		;
		if (value == 10) {
			return num10;
		}
		;
		if (value == 11) {
			return num11;
		}
		;
		return num12;
	}

}
