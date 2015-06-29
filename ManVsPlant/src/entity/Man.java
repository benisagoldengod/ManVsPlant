package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import main.Main;

public class Man extends Entity {
	private Random r = new Random();
	private Point goal;
	public Man(final int x, final int y) {
		super(x, y, 75, 5);
		goal = getGoal();
	}

	@Override
	public void update() {
		if(Main.getEntityAt(goal) == null){
			goal = getGoal();
		}
		moveTowardsGoal();
	}

	@Override
	public void draw(final Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.fillRect(pos.x * Main.scale + Main.scale/4, pos.y * Main.scale + Main.scale/4, Main.scale/2, Main.scale/2);
	}

	private Point getGoal() {
		while(true) {
			int i = r.nextInt(Main.entities.size());
			if (Main.entities.get(i).getType().equals("Hedge") || Main.entities.get(i).getType().equals("Jewel")) {
				return Main.entities.get(i).pos;
			}
		}
	}

	@Override
	public String getType() {
		return "Man";
	}

	private void moveTowardsGoal() {
		
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
			Main.getEntityAt(awsd[min]).health -= damage;
			super.health -= Main.getEntityAt(awsd[min]).damage;
		}else if((Main.getEntityAt(awsd[min]).getType().equals("Jewel"))){
			Main.getEntityAt(awsd[min]).health -= damage;
		}else if((Main.getEntityAt(awsd[min]).getType().equals("Man"))){
			goal = getGoal();
		}
	}
}
