package entity;

import java.awt.Graphics2D;

public abstract class Entity {
	public int health;
	public int x;
	public int y;

	public Entity(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public abstract void update();

	public abstract void draw(Graphics2D g);

	public abstract String getType();
}
