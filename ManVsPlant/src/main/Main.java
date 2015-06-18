package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.Entity;
import entity.Fort;
import entity.Hedge;
import entity.Jewel;
import entity.Man;

public class Main {
	public static final int height = 50;
	public static final int width = 50;
	public static final int scale = 10;
	public static ArrayList<Entity> entities = new ArrayList<>();
	private static JPanel panel;
	private static BufferedImage screen = new BufferedImage(width * scale + 4 * scale, height * scale + 4 * scale, BufferedImage.TYPE_INT_RGB);
	private static Color BACKGROUND_COLOR = Color.BLACK;

	public static void main(final String[] args) {
		final JFrame frame = new JFrame();
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));
		panel.setBackground(Color.GREEN);
		frame.add(panel);
		frame.pack();
		frame.setBounds(0, 0, width * scale + 4 * scale, height * scale + 4 * scale);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		initialize();
		run();
	}

	public static void initialize() {
		entities.add(new Fort(width / 2, height - 1));
		entities.add(new Jewel(width / 2, 0));
		entities.add(new Man(width / 2 - 1, height - 1));
		entities.add(new Hedge(width / 2 - 1, 0));
		entities.add(new Hedge(width / 2 + 1, 0));
		entities.add(new Hedge(width / 2, 1));
	}

	public static void run() {
		while (true) {
			updateAll();
			drawMap();
			try {
				Thread.sleep(100);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void updateAll() {
		boolean jewelPresent = false;
		for (int i = 0; i < entities.size(); i++) {
			if(entities.get(i).health<=0){
				entities.remove(i);
				i--;
			}else{
				entities.get(i).update();
				if(entities.get(i).getType().equals("Jewel")){
					jewelPresent = true;
				}
			}
		}
		if(!jewelPresent){
			for (int i = 0; i < entities.size(); i++) {
				if(entities.get(i).health<=0){
					entities.remove(i);
					i--;
				}else{
					entities.get(i).update();
					if(entities.get(i).getType().equals("Jewel")){
						jewelPresent = true;
					}
				}
			}
			System.out.println("Victory!");
			pauseAll();
		}
	}

	public static void drawMap() {
		final Graphics g = screen.getGraphics();
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, width * scale, height * scale);
		for (final Entity e : entities) {
			e.draw((Graphics2D) g);
		}
		panel.getGraphics().drawImage(screen, 0, 0, null);
		g.dispose();
	}
	
	public static Entity getEntityAt(Point p){
		for(Entity e : entities){
			if(e.pos.equals(p)){
				return e;
			}
		}
		return null;
	}
	
	private static void pauseAll(){
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
}
