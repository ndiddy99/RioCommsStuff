package org.usfirst.frc.team2537.robot.vision;

import java.util.ArrayList;

import org.usfirst.frc.team2537.robot.Robot;

public class VisionPacketHandler {

	public static String encodeVisionPacket(Point[] visionPackets) {
		String stringToOutput="<";
		for (int i=0; i < visionPackets.length; i++) {
			stringToOutput+=visionPackets[i].outputPacket();
		}
		stringToOutput+=">";
		return stringToOutput;
	}
	public static Point[] decodeVisionPacket(String packetToDecode) {
		if (Robot.serialSys.DEBUG)
			System.out.println("original string: "+packetToDecode);
		ArrayList<Point>visionPackets = new ArrayList<>();
		
		while(packetToDecode.contains("|")) {
			String stringX = packetToDecode.substring(0, packetToDecode.indexOf(":"));
			String stringY = packetToDecode.substring(packetToDecode.indexOf(":") + 1, packetToDecode.indexOf("|"));
			int x=Integer.valueOf(stringX);
			int y = Integer.valueOf(stringY);
			Point visionPacketObject = new Point(x, y);
			visionPackets.add(visionPacketObject);
			packetToDecode=packetToDecode.substring(packetToDecode.indexOf("|")+1, packetToDecode.length());
			
		}
		return visionPackets.toArray(new Point[visionPackets.size()]);
	}
}