package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import main.Main;

public class Man extends Entity {
	
	public Man(final int x, final int y) {
		super(x, y, 30, 5);
	}

	@Override
	public void update() {
		findJewel(Main.entities);
	}

	@Override
	public void draw(final Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.fillRect(pos.x * Main.scale + Main.scale/4, pos.y * Main.scale + Main.scale/4, Main.scale/2, Main.scale/2);
	}

	private void findJewel(final ArrayList<Entity> entities) {
		for (final Entity e : entities) {
			if (e.getType().equals("Jewel")) {
				moveTowards(e.pos);
			}
		}
	}

	@Override
	public String getType() {
		return "Man";
	}

	private void moveTowards(final Point goal) {
		final Point[] awsd = { new Point(pos.x, pos.y - 1), new Point(pos.x, pos.y + 1), new Point(pos.x - 1, pos.y), new Point(pos.x + 1, pos.y), new Point(pos.x, pos.y) };

		double mind = goal.distance(awsd[0]);
		int min = 0;
		for (int i = 1; i < awsd.length; i++) {
			if (goal.distance(awsd[i]) < mind) {
				mind = goal.distance(awsd[i]);
				min = i;
			}
		}
		if(Main.spaceIsFree(awsd[min])){
			pos = awsd[min];
		}else if(Main.getEntityAt(awsd[min]).getType().equals("Hedge")){
			Main.getEntityAt(awsd[min]).health -= hitpoints;
			super.health -= Main.getEntityAt(awsd[min]).hitpoints;
		}else if((Main.getEntityAt(awsd[min]).getType().equals("Jewel"))){
			Main.getEntityAt(awsd[min]).health -= hitpoints;
		}
	}
}
