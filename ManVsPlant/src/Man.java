import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public class Man extends Entity {

	public Man(int x, int y) {
		super(x, y);
		super.health = 30;
	}

	@Override
	void update() {
		findJewel(Main.entities);
	}

	@Override
	void draw(Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.drawString("M", x * Main.scale, y * Main.scale);
	}

	private void findJewel(ArrayList<Entity> entities) {
		for (Entity e : entities) {
			if (e.getType().equals("Jewel")) {
				moveTowards(e.x, e.y);
			}
		}
	}

	@Override
	public String getType() {
		return "Man";
	}

	private void moveTowards(int goalx, int goaly) {
		Point[] awsd = { new Point(x, y - 1), new Point(x, y + 1), new Point(x - 1, y), new Point(x + 1, y), new Point(x, y) };
		Point goal = new Point(goalx, goaly);

		double mind = goal.distance(awsd[0]);
		int min = 0;
		for (int i = 1; i < awsd.length; i++) {
			if (goal.distance(awsd[i]) < mind) {
				mind = goal.distance(awsd[i]);
				min = i;
			}
		}
		this.x = awsd[min].x;
		this.y = awsd[min].y;
	}

}
