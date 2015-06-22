package entity;

import java.awt.Graphics2D;
import java.awt.Point;

public abstract class Entity {
	public int health;
	public Point pos;
	public int hitpoints;

	public Entity(final int x, final int y, int health, int hitpoints) {
		this.health = health;
		this.hitpoints = hitpoints;
		pos = new Point(x, y);
	}

	public abstract void update();

	public abstract void draw(Graphics2D g);

	public abstract String getType();
	
}
