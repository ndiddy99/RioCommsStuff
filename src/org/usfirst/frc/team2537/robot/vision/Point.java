package org.usfirst.frc.team2537.robot.vision;

public class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String outputPacket() {
		return x + ":" + y + "|";
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "X val: " + x + " Y val: " + y + "\n";
	}
}
