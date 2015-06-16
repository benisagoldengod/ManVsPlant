package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Main;

public class Jewel extends Entity {

	public Jewel(final int x, final int y) {
		super(x, y);
		super.health = 1;

	}

	@Override
	public void update() {

	}

	@Override
	public void draw(final Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(x * Main.scale, y * Main.scale, Main.scale, Main.scale);
	}

	@Override
	public String getType() {
		return "Jewel";
	}

}
