import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardsIcon extends JFrame{
	//Data field
	private ImageIcon[] cards = new ImageIcon[52];
	
	
	
	//Constructor
	public CardsIcon(){
		//Get the images from the resource
		for(int k = 0; k < 52; k++){
			cards[k] = new ImageIcon("card/"+(k+1)+".png");
		}
		//Shuffle the cards
		for(int i = 0; i<cards.length; i++){
			//Generate an index randomly
			int index = (int)(Math.random()*cards.length);
			ImageIcon temp = cards[i];
			cards[i] = cards[index];
			cards[index] = temp;
		}
	
	}

	//Main method
	public static void main(String args[]){
		CardsIcon frame = new CardsIcon();
		frame.setTitle("Pick Four Cards");
		frame.setSize(320, 180);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
