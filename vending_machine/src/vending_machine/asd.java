package vending_machine;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class asd extends JFrame {
	JButton b;

	public asd() {
		Image imgSrc;
		try {
			imgSrc = ImageIO.read(new File("image/m.jpg"));
			Image re = imgSrc.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(re);
			b = new JButton(icon);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		add(b);
		setVisible(true);
		setSize(200, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new asd();
	}
}
