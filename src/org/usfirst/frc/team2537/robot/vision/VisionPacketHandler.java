package org.usfirst.frc.team2537.robot.vision;

import java.util.ArrayList;

public class VisionPacketHandler {

	public String encodeVisionPacket(VisionPacket[] visionPackets) {
		String stringToOutput="<";
		for (int i=0; i < visionPackets.length; i++) {
			stringToOutput+=visionPackets[i].outputPacket();
		}
		stringToOutput+=">";
		return stringToOutput;
	}
	public VisionPacket[] decodeVisionPacket(String packetToDecode) {
		ArrayList<VisionPacket>visionPackets = new ArrayList<>();
		
		while(packetToDecode.contains("!")) {
			String name = packetToDecode.substring(0, packetToDecode.indexOf(":"));
			String stringValue = packetToDecode.substring(packetToDecode.indexOf(":") + 1, packetToDecode.indexOf("!"));
			int value = Integer.valueOf(stringValue);
			VisionPacket visionPacketObject = new VisionPacket(name, value);
			visionPackets.add(visionPacketObject);
			packetToDecode=packetToDecode.substring(packetToDecode.indexOf("!")+1, packetToDecode.length());
			
		}
		return visionPackets.toArray(new VisionPacket[visionPackets.size()]);
	}
}