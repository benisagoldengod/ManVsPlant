import java.awt.Color;
import java.awt.Graphics2D;

public class Jewel extends Entity {

	public Jewel(int x, int y) {
		super(x, y);
		super.health = 1;

	}

	@Override
	void update() {

	}

	@Override
	void draw(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(x * Main.scale, y * Main.scale, Main.scale, Main.scale);
	}

	@Override
	public String getType() {
		return "Jewel";
	}

}
