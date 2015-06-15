import java.awt.Graphics2D;

public abstract class Entity {
	public static int health;
	public int x;
	public int y;

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}

	abstract void update();

	abstract void draw(Graphics2D g);

	abstract String getType();
}
