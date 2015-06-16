package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import main.Main;

public class Man extends Entity {

	public Man(final int x, final int y) {
		super(x, y);
		super.health = 30;
	}

	@Override
	public void update() {
		findJewel(Main.entities);
	}

	@Override
	public void draw(final Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.drawString("M", x * Main.scale, y * Main.scale);
	}

	private void findJewel(final ArrayList<Entity> entities) {
		for (final Entity e : entities) {
			if (e.getType().equals("Jewel")) {
				moveTowards(e.x, e.y);
			}
		}
	}

	@Override
	public String getType() {
		return "Man";
	}

	private void moveTowards(final int goalx, final int goaly) {
		final Point[] awsd = { new Point(x, y - 1), new Point(x, y + 1), new Point(x - 1, y), new Point(x + 1, y), new Point(x, y) };
		final Point goal = new Point(goalx, goaly);

		double mind = goal.distance(awsd[0]);
		int min = 0;
		for (int i = 1; i < awsd.length; i++) {
			if (goal.distance(awsd[i]) < mind) {
				mind = goal.distance(awsd[i]);
				min = i;
			}
		}
		x = awsd[min].x;
		y = awsd[min].y;
	}

}
