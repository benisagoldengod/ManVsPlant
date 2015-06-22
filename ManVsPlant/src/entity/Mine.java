package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Main;

public class Mine extends Entity {
	public Mine(int x, int y){
		super(x, y, 100, 1000);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		Main.coins += 0.5;
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.gray);
		g.fillRect(pos.x * Main.scale, pos.y * Main.scale, 2 * Main.scale, 2 * Main.scale);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Mine";
	}

}
