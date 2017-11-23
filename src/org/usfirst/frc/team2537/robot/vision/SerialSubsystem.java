package org.usfirst.frc.team2537.robot.vision;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

public class SerialSubsystem extends Subsystem {
	public static SerialPort serial;
	final int BAUDRATE = 38400;
	ProtocolHandler protocolHandler;
	VisionPacketHandler visionPacketHandler;

	public void initDefaultCommand() {
		serial = new SerialPort(BAUDRATE, Port.kMXP);
		protocolHandler=new ProtocolHandler();
	}
	
	public void addToBuffer() { //should run periodically
		if (serial.getBytesReceived() > 0) {
			protocolHandler.addToBuffer(serial.readString());
			serial.flush();
		}
	}
	public VisionPacket[] getVisionPacket() {
		if (!protocolHandler.getLastString().equals("")) 
			return visionPacketHandler.decodeVisionPacket(protocolHandler.getLastString());
		else
			return new VisionPacket[0];
	}
	public void sendVisionPacket(VisionPacket[] packetsToSend) {
		visionPacketHandler.encodeVisionPacket(packetsToSend);
	}
}
