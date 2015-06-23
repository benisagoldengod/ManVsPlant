package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import main.Main;

public class Hedge extends Entity {
	private static final int SPAWN_PROBABILITY = 28; //higher number = less likely to spawn new hedges
	public static final int THICKEN_PROBABILITY = 95; //change hedge will get harder, stop producing new hedges, not hit back;
	private boolean thickened = false;
	private Color c = new Color(0, 140, 0);
	public Hedge(final int x, final int y) {
		super(x, y, 50, 5);
	}

	@Override
	public void update() {
		// Randomly generate new hedges
		if(!thickened){
			if(r.nextInt(SPAWN_PROBABILITY) == 0){
				Point[] awsd = { new Point(pos.x, pos.y - 1), new Point(pos.x, pos.y + 1), new Point(pos.x - 1, pos.y), new Point(pos.x + 1, pos.y), new Point(pos.x, pos.y)};
				ArrayList<Point> legalSpots = new ArrayList<>();
				for(int i = 0; i < awsd.length; i++){
					if(Main.spaceIsFree(awsd[i])){
						legalSpots.add(0, awsd[i]);
					}
				}
				if(legalSpots.size() > 0){
					Main.entities.add(new Hedge(legalSpots.get(r.nextInt(legalSpots.size())).x, legalSpots.get(r.nextInt(legalSpots.size())).y));
				}
			}
		}
		if(r.nextInt(THICKEN_PROBABILITY) == 0 && !thickened){
			thickened = true;
			c = new Color(0, 80, 0);
			super.health += 50;
			super.hitpoints = 2;
		}
		
	}

	@Override
	public void draw(final Graphics2D g) {
		g.setColor(c);
		g.fillRect(pos.x * Main.scale, pos.y * Main.scale, Main.scale, Main.scale);
	}

	@Override
	public String getType() {
		return "Hedge";
	}

}
