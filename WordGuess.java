import java.util.Scanner;
import java.io.IOException;
public class MemoryGame {
	public static void main(String[] args) {
		 int[] index = new int[7];
		 String[] words = {"Ant","Zebra","Pig","Bee","Honey","Car","Motorcycle","Nuclear","Eclipse","Money", "Minecraft", "New","Attached",
                 "Goodnight","Manipulation","Zimbabwe","Void", "Circle", "Cool", "Adidas", "Chicken","Hotspot", "Oracle", "Event","Midnight",
		          "Carpool", "Wine", "Winter", "Zealous","Pyramid", "Padini","Eyes", "Wagyu", "Ribeye", "Love", "Alcohol","Inverse","Partial",
		          "Eclipse", "Sun", "Apple","Refresher", "Search", "Find", "Long","Would","Make","Like","Him","Into","Time","Feast", "Daylight",
		          "Has","Look","Donggle","More", "Yacht", "Write","Go","See","Number","No","Way","Could","People","Witch","Fest",
		          "Beast","Split", "Premier","Toilet", "Retain", "Sticker", "Conferences", "Scanner","GitHub", "Query","Collectives",
		          "Mexican", "Druglord", "Hashmap", "Dandelions", "Map", "Developing", "Bribe", "Overflow", "Techincal","Companies",
		          "Formula", "Course", "Stuck", "Greetings", "Arabians", "Structure", "Matrix", "Session","Frequency", "Assignment"};		      
		Greetings();
		RandomNumbers(index);
		Words(words,index);
		Timer();
		Marks(Answer(words,index));		
	}
	static void Greetings() {
		System.out.println("\n*****************************************\n"
				+ "	*** Word Memory game ***\n\tYou will be given 7 words\n Try to memorize it within 10 seconds!"
				+ "\n*****************************************\n");
	}
	static void RandomNumbers(int[] index) {	 
		//initially generate random number between (0-99)
		for(int i = 0; i < 7; i++)
			index[i] = (int)(Math.random() * 99 );
		//change the repeated number 
		for(int i = 0 ; i < 7; i++)
			for(int j = 0 ; j < 7-1;j++)
				if(index[j] == index[j+1]) 
					index[j] = (int)(Math.random() * 99 );	
	}
	static void Words(String[] words, int[] index) {
		for(int i = 0; i < index.length; i++) {
			try {
			    System.out.println("#" + (i+1) + " word: " + words[index[i]]);
			    Thread.sleep(1000);
			}catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	static void Timer(){
		System.out.println("\nYou have 10 seconds to memorize the word!");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		//clear screen 
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		System.out.println("Times Up!\n");
	}
	static int Answer(String[] words, int[] index) {
		Scanner input = new Scanner(System.in);
		int marks = 0;
		String ans;
		System.out.println("Type a word with the same sequence display!");
		System.out.println("Please enter your answer");
		for(int i = 0; i < index.length; i++) {	
			System.out.print("#" + (i+1) + " word: ");
			ans = input.next();
			if(ans.equalsIgnoreCase(words[index[i]]))
				marks += 1;
		}
		input.close();
		return marks;
	}
   static void Marks(int marks) {
   	int percentage;
   	System.out.println("Total correct words: " + marks + "/7");
		percentage = (int) ((marks/7.0) * 100);
		if(percentage == 100)
			System.out.println("You got it all correct!\nGreat!\nYou've got " + percentage + "%" );
		else if (percentage >= 60 && percentage < 100)
			System.out.println("Good job!\nYou almost nailed it!\nYou've got " + percentage + "%");
		else if(percentage >= 40 && percentage < 60)
			System.out.println("Better luck next time buddy!\nYou've got " + percentage + "%");
		else if (percentage > 0 && percentage < 40)
			System.out.println("You need to improve your memory!\nYou've got " + percentage + "%");
		else if (percentage == 0)
		  System.out.println("You have memory loss problem!");
  }
}
