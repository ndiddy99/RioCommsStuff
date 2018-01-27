package org.usfirst.frc.team2537.robot.vision;

import java.util.ArrayList;

import org.usfirst.frc.team2537.robot.Robot;

public class VisionPacketHandler {

	public static String encodeVisionPacket(Point[] visionPackets) {
		String stringToOutput = ">";
		for (int i = 0; i < visionPackets.length; i++) {
			stringToOutput += visionPackets[i].outputPacket();
		}
		stringToOutput += ">";
		return stringToOutput;
	}

	public static Target[] decodeVisionPacket(String packetToDecode) {
		if (Robot.serialSys.DEBUG)
			System.out.println("original string, " + packetToDecode);
//		ArrayList<Target> targets = new ArrayList<>();
//		while (packetToDecode.contains("#")) {
//			String singleTarget = packetToDecode.substring(0, packetToDecode.indexOf("#"));
//			ArrayList<Point> visionPackets = new ArrayList<>();
//			while (singleTarget.contains("|")) {
//				String stringX = singleTarget.substring(0, singleTarget.indexOf(","));
//				String stringY = singleTarget.substring(singleTarget.indexOf(",") + 1, singleTarget.indexOf("|"));
//				int x = Integer.valueOf(stringX);
//				int y = Integer.valueOf(stringY);
//				Point visionPacketObject = new Point(x, y);
//				visionPackets.add(visionPacketObject);
//				singleTarget = singleTarget.substring(singleTarget.indexOf("|") + 1, singleTarget.length());
//			}
//			targets.add(new Target(visionPackets.toArray(new Point[visionPackets.size()])));
//			packetToDecode = packetToDecode.substring(packetToDecode.indexOf("#") + 1, packetToDecode.length());
//		}
//		return targets.toArray(new Target[targets.size()]);
		String[] stringTargets=packetToDecode.split("#");
		Target[] targets=new Target[stringTargets.length];
		for (int i=0; i < stringTargets.length; i++) {
			String[] pointArr=stringTargets[i].split("\\|");
			Point[] points=new Point[pointArr.length];
			for (int j=0; j < pointArr.length;j++) {
				String[] coordinates=pointArr[i].split(",");
				points[j] = new Point(Integer.parseInt(coordinates[0]),Integer.parseInt(coordinates[1]));
			}
			targets[i]=new Target(points);
		}
		return targets;
	}
}