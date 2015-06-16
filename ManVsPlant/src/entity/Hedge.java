package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Main;

public class Hedge extends Entity {

	public Hedge(final int x, final int y) {
		super(x, y);
		super.health = 50;
	}

	@Override
	public void update() {
		// Randomly generate new hedges

	}

	@Override
	public void draw(final Graphics2D g) {
		g.setColor(new Color(0, 140, 0));
		g.fillRect(x * Main.scale, y * Main.scale, Main.scale, Main.scale);
	}

	@Override
	public String getType() {
		return "Hedge";
	}

}
