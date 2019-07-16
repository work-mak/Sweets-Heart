package game2048;

import java.io.*;

import java.util.*;

public class Readfile {

	private int data[] = new int[14];
	private int loadgame[] = new int[17];
	
	private int Best_Score,collection_1,collection_2,collection_3,collection_4,collection_5, ///best score and opened character
	collection_6,collection_7,collection_8,collection_9,collection_10,collection_11,collection_12,CanOpenCharacter;


	int b_score = 0;

	public Readfile() {
		
		
	}
	
	public int[] Read() throws IOException{

		try {
			File file = new File("Data.txt");
			Scanner read = new Scanner(file);
			int i = 0;
			while (read.hasNext()) {
				String dataa = read.nextLine();
				String cut[] = dataa.split("=");

				
				data[i] += Integer.parseInt(cut[1]);
				i++;
			}
			
			/*Best_Score = Integer.parseInt(data[0]);
			collection_1 = Integer.parseInt(data[1]);
			collection_2 = Integer.parseInt(data[2]);
			collection_3 = Integer.parseInt(data[3]);
			collection_4 = Integer.parseInt(data[4]);
			collection_5 = Integer.parseInt(data[5]);
			collection_6 = Integer.parseInt(data[6]);
			collection_7 = Integer.parseInt(data[7]);
			collection_8 = Integer.parseInt(data[8]);
			collection_9 = Integer.parseInt(data[9]);
			collection_10 = Integer.parseInt(data[10]);
			collection_11 = Integer.parseInt(data[11]);
			collection_12 = Integer.parseInt(data[12]);
			CanOpenCharacter = Integer.parseInt(data[13]);*/
			

			read.close();
		} catch (FileNotFoundException e) {
			FileWriter file = new FileWriter("Data.txt");
			PrintWriter write = new PrintWriter(file);
			
			for(int i = 0; i< data.length; i++){
				data[i] = 0;
			}
			
				
			//new variable for remember
			Best_Score = 0;
			collection_1 = 0;
			collection_2 = 0;
			collection_3 = 0;
			collection_4 = 0;
			collection_5 = 0;
			collection_6 = 0;
			collection_7 = 0;
			collection_8 = 0;
			collection_9 = 0;
			collection_10 = 0;
			collection_11 = 0;
			collection_12 = 0;
			CanOpenCharacter = 0;
			
			
			write.println("Best_Score="+Best_Score);
			write.println("collection_1="+collection_1);
			write.println("collection_2="+collection_2);
			write.println("collection_3="+collection_3);
			write.println("collection_4="+collection_4);
			write.println("collection_5="+collection_5);
			write.println("collection_6="+collection_6);
			write.println("collection_7="+collection_7);
			write.println("collection_8="+collection_8);
			write.println("collection_9="+collection_9);
			write.println("collection_10="+collection_10);
			write.println("collection_11="+collection_11);
			write.println("collection_12="+collection_12);
			write.println("CanOpenCharacter="+CanOpenCharacter);
			
			write.close();
		}
		
		return data;
	}

	
	public int[] LoadGame() throws IOException{
		try {
			File file = new File("LoadGame.txt");
			Scanner read = new Scanner(file);
			int i = 0;
			while (read.hasNext()) {
				String dataa = read.nextLine();
				String cut[] = dataa.split(" ");

				
				loadgame[i] += Integer.parseInt(cut[i]);
				i++;
			}
			read.close();
		} catch (FileNotFoundException e) {
			FileWriter file = new FileWriter("LoadGame.txt");
			PrintWriter write = new PrintWriter(file);
			
			for(int i = 0; i< loadgame.length; i++){
				loadgame[i] = 0;
				write.print(loadgame[i] +" ");
			}
			
			write.close();
		}
		
		return loadgame;
	}
	
	public void Save(int[] newdata) throws IOException{


		
			FileWriter file1 = new FileWriter("Data.txt");
			PrintWriter write = new PrintWriter(file1);
			
				
			//new variable for remember
			
			
			
			write.println("Best_Score="+newdata[0]);
			write.println("collection_1="+newdata[1]);
			write.println("collection_2="+newdata[2]);
			write.println("collection_3="+newdata[3]);
			write.println("collection_4="+newdata[4]);
			write.println("collection_5="+newdata[5]);
			write.println("collection_6="+newdata[6]);
			write.println("collection_7="+newdata[7]);
			write.println("collection_8="+newdata[8]);
			write.println("collection_9="+newdata[9]);
			write.println("collection_10="+newdata[10]);
			write.println("collection_11="+newdata[11]);
			write.println("collection_12="+newdata[12]);
			write.println("CanOpenCharacter="+newdata[13]);
			
			write.close();
		
		
		
	}
}
