import java.awt.Color;
import java.awt.Graphics2D;

public class Hedge extends Entity {

	public Hedge(int x, int y) {
		super(x, y);
		super.health = 50;
	}

	@Override
	void update() {
		// Randomly generate new hedges

	}

	@Override
	void draw(Graphics2D g) {
		g.setColor(new Color(0, 140, 0));
		g.fillRect(x * Main.scale, y * Main.scale, Main.scale, Main.scale);
	}

	@Override
	public String getType() {
		return "Hedge";
	}

}
