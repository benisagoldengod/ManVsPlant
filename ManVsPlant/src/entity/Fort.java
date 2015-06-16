package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Main;

public class Fort extends Entity {

	public Fort(final int x, final int y) {
		super(x, y);
		super.health = 1000;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(final Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(x * Main.scale, y * Main.scale, 2 * Main.scale, 2 * Main.scale);
	}

	@Override
	public String getType() {
		return "Fort";
	}

}
