package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Random;

import main.Main;

public class Fort extends Entity {
	private static Random r = new Random();
	private Point spawn;
	private int SPAWN_PRICE = 10;
	public Fort(final int x, final int y) {
		super(x, y, 1000, 0);
		spawn = new Point(x - 1, y - 1);
	}

	@Override
	public void update() {
		// Randomly adds men
		if(r.nextInt(10) == 0 && Main.coins >= SPAWN_PRICE){
			Main.entities.add(new Man(spawn.x, spawn.y));
			Main.coins -= SPAWN_PRICE;
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
