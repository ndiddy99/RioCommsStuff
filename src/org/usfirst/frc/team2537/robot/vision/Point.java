package org.usfirst.frc.team2537.robot.vision;


public class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}

	public String outputPacket() {
		return x + ":" + y + "|";
	}

	@Override
	public String toString() {
		return "val1: " + x + " val2: " + y;
	}
}
