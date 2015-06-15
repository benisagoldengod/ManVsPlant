import java.awt.Color;
import java.awt.Graphics2D;

public class Fort extends Entity {

	public Fort(int x, int y) {
		super(x, y);
		super.health = 1000;
	}

	@Override
	void update() {
		// TODO Auto-generated method stub

	}

	@Override
	void draw(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(x * Main.scale, y * Main.scale, 2 * Main.scale, 2 * Main.scale);
	}

	@Override
	public String getType() {
		return "Fort";
	}

}
