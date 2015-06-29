package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import main.Main;

public class Hedge extends Entity {
	private static final Color THICKENED_COLOR = new Color(0, 80, 0);

	private static final int SPAWN_PROBABILITY = 28; // higher number = less likely to spawn new hedges
	private static final int THICKEN_PROBABILITY = 95; // change hedge will get harder, stop producing new hedges, not
	// hit back;
	private boolean thickened = false;
	private Color color = new Color(0, 140, 0);

	public Hedge(final int x, final int y) {
		super(x, y, 50, 5);
	}

	public Hedge(final Point point) {
		this(point.x, point.y);
	}

	@Override
	public void update() {
		if (thickened) {
			return;
		}

		// Randomly generate new hedges
		if (r.nextInt(SPAWN_PROBABILITY) == 0) {
			final List<Point> adjacentPoints = Arrays.asList(new Point[] { new Point(pos.x, pos.y - 1), new Point(pos.x, pos.y + 1),
					new Point(pos.x - 1, pos.y), new Point(pos.x + 1, pos.y) });

			final List<Point> legalSpots = adjacentPoints.stream().filter((p) -> Main.spaceIsFree(p)).collect(Collectors.toList());
			if (!legalSpots.isEmpty()) {
				Main.entities.add(new Hedge(legalSpots.get(r.nextInt(legalSpots.size()))));
			}
		}
		if (r.nextInt(THICKEN_PROBABILITY) == 0) {
			thickened = true;
			color = THICKENED_COLOR;
			super.health += 50;
			super.hitpoints = 2;
		}
	}

	@Override
	public void draw(final Graphics2D g) {
		g.setColor(color);
		g.fillRect(pos.x * Main.scale, pos.y * Main.scale, Main.scale, Main.scale);
	}

	@Override
	public String getType() {
		return "Hedge";
	}

}
