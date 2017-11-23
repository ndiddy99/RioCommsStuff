package org.usfirst.frc.team2537.robot.vision;


public class VisionPacket {
	String name;
	int value;

	public VisionPacket(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String outputPacket() {
		return name + ":" + value + "!";
	}

	@Override
	public String toString() {
		return "Name: " + name + " Value: " + value;
	}
}
