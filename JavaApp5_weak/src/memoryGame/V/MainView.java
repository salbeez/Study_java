package memoryGame.V;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView extends JFrame {
	JPanel topP, centerP, bottomP;
	public JButton bt_start;
	public JLabel la_time;
	ImageIcon icon[] = new ImageIcon[4];
	public MainView() {
		init();
		setting();

	}

	private void init() {
		topP = new JPanel();
		centerP = new JPanel();
		bottomP = new JPanel();

		bt_start = new JButton("시작");
		la_time = new JLabel("제한 시간 :");		
	}

	private void setting() {
		
		icon[0] = new ImageIcon("gostop/card-0-0.jpeg");
		icon[1] = new ImageIcon("gostop/card-0-1.jpeg");
		icon[2] = new ImageIcon("gostop/card-0-2.jpeg");
		icon[3] = new ImageIcon("gostop/card-0-3.jpeg");
		
		topP.setBackground(Color.lightGray);
		centerP.setBackground(Color.RED);
		bottomP.setBackground(Color.YELLOW);

		topP.setLayout(new FlowLayout());
		topP.add(la_time);
		
		bottomP.setLayout(new FlowLayout());
		bottomP.add(bt_start);

		setLayout(new BorderLayout());
		add("North", topP);
		add("Center", centerP);
		add("South", bottomP);

		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private ImageIcon resizeImage(ImageIcon icon,int w,int h){
		Image image = icon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(w, h,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		icon = new ImageIcon(newimg);  // transform it back

		return icon;
	}
	public void drawCards(int[][] cards){
		
		Random rd = new Random();
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards[i].length; j++) {
				centerP.add(resizeImage(icon[rd.nextInt(cards[i].length)],50,80));
			}
		}
	}
}
