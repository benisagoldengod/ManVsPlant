package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import main.Main;

public class Mine extends Entity {
	private int i = 0;
	public Mine(int x, int y){
		super(x, y, 100, 1000);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		int hedgeCount = 0;
		for(Entity e : Main.entities){
			if(e.getType().equals("Hedge")){
				hedgeCount++;
			}
		}
		Main.coins += hedgeCount/50;
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
		g.setColor(Color.gray);
		g.fillRect(pos.x * Main.scale, pos.y * Main.scale, 2 * Main.scale, 2 * Main.scale);
		g.setColor(Color.YELLOW);
		g.fillRect(pos.x*Main.scale + r.nextInt(7), pos.y * Main.scale + 2* Main.scale - i, Main.scale/3, Main.scale/3);
		i++;
		if(i >= 3*Main.scale){
			i = 0;
		}
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Mine";
	}

}
