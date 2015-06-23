package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Random;

import main.Main;

public class Fort extends Entity {
	private Point spawn;
	private int MAN_PRICE = 10;
	private int FORT_PRICE = 10000;
	private static int fortsToLeft = 0;
	private static int fortsToRight = 0;
	public Fort(final int x, final int y) {
		super(x, y, 1000, 0);
		spawn = new Point(x - 1, y - 1);
		
	}

	@Override
	public void update() {
		//adds men and forts depending on coinage
		if(Main.coins >= FORT_PRICE){
			if(r.nextBoolean()){
				Main.entities.add(new Fort(pos.x + fortsToRight*2, pos.y));
				fortsToRight++;
			}else{
				Main.entities.add(new Fort(pos.x - fortsToLeft*2, pos.y));
				fortsToLeft++;
			}
			Main.coins -= FORT_PRICE;
		}
		if(Main.coins >= MAN_PRICE){
			Main.entities.add(new Man(spawn.x, spawn.y));
			Main.coins -= MAN_PRICE;
		}
	}

	@Override
	public void draw(final Graphics2D g) {
		g.setColor(Color.GRAY);
		int[] x = {pos.x*Main.scale, pos.x*Main.scale + 2,  pos.x*Main.scale + 1};
		int[] y = {pos.y*Main.scale, pos.y*Main.scale, pos.y*Main.scale - 1};
		g.fillPolygon(x, y, 3);
		g.setColor(Color.BLUE);
		g.fillRect(pos.x * Main.scale, pos.y * Main.scale, 2 * Main.scale, 2 * Main.scale);
	}

	@Override
	public String getType() {
		return "Fort";
	}

}
