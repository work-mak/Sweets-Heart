package game2048;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Value {

	Image base = new ImageIcon(this.getClass().getResource("/base.jpg")).getImage();
	Image num1 = new ImageIcon(this.getClass().getResource("/01.png")).getImage();
	Image num2 = new ImageIcon(this.getClass().getResource("/02.png")).getImage();
	Image num3 = new ImageIcon(this.getClass().getResource("/03.png")).getImage();
	Image num4 = new ImageIcon(this.getClass().getResource("/04.png")).getImage();
	Image num5 = new ImageIcon(this.getClass().getResource("/05.png")).getImage();
	Image num6 = new ImageIcon(this.getClass().getResource("/06.png")).getImage();
	Image num7 = new ImageIcon(this.getClass().getResource("/07.png")).getImage();
	Image num8 = new ImageIcon(this.getClass().getResource("/08.png")).getImage();
	Image num9 = new ImageIcon(this.getClass().getResource("/09.png")).getImage();
	Image num10 = new ImageIcon(this.getClass().getResource("/10.png")).getImage();
	Image num11 = new ImageIcon(this.getClass().getResource("/11.png")).getImage();
	
	private String value;
	
	public Value(String value) {
		this.value = value;
	}
	
	public void setValue(String value){
		this.value = value;
	}
	public Image imageGame(){
		if(value.equals("0")){return base;};
		if(value.equals("2")){return num1;};
		if(value.equals("4")){return num2;};
		if(value.equals("8")){return num3;};
		if(value.equals("16")){return num4;};
		if(value.equals("32")){return num5;};
		if(value.equals("64")){return num6;};
		if(value.equals("128")){return num7;};
		if(value.equals("256")){return num8;};
		if(value.equals("512")){return num9;};
		if(value.equals("1024")){return num10;};
		return num11;
	}
	
	public String newGame(){
		if(value.equals("0")){return "img/base.jpg";};
		if(value.equals("2")){return "img/01.png";};
		if(value.equals("4")){return "img/02.png";};
		if(value.equals("8")){return "img/03.png";};
		if(value.equals("16")){return "img/04.png";};
		if(value.equals("32")){return "img/05.png";};
		if(value.equals("64")){return "img/06.png";};
		if(value.equals("128")){return "img/07.png";};
		if(value.equals("256")){return "img/08.png";};
		if(value.equals("512")){return "img/09.png";};
		if(value.equals("1024")){return "img/10.png";};
		return "img/11.png";
	}

	
}
