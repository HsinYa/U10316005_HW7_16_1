import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardsIcon extends JFrame{
	//Data field
	private ImageIcon[] cards = new ImageIcon[52];
	JPanel p1;
	JLabel[] lab = new JLabel[4];
	JPanel p2;
	JButton refresh = new JButton("Refresh");
	
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
		//Create a panel1 to put four cards
		p1 = new JPanel();
		p1.setLayout(new GridLayout(1,4));
		for(int n = 0; n < 4; n++){
			lab[n] = new JLabel(cards[n]);
			p1.add(lab[n]);
		}
		//Create a panel2 to put a button
		p2 = new JPanel();
		p2.add(refresh,new FlowLayout(FlowLayout.CENTER));
		//Register listener
		refresh.addActionListener(new ButtonListener());
	}
	//Handle the refresh button
	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == refresh){
				for(int i = 0; i<cards.length; i++){
					//Generate an index randomly
					int index = (int)(Math.random()*cards.length);
					ImageIcon temp = cards[i];
					cards[i] = cards[index];
					cards[index] = temp;
				}
				//Display the new four cards 
				for(int n = 0; n < 4; n++){
					lab[n].setIcon(cards[n]);
				}
				
			}
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
