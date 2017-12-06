package org.usfirst.frc.team2537.robot.vision;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

public class SerialSubsystem extends Subsystem {
	public static SerialPort serial;
	public final boolean DEBUG=true;
	final int BAUDRATE = 38400;
	ProtocolHandler protocolHandler;

	public void initDefaultCommand() {
		serial = new SerialPort(BAUDRATE, Port.kMXP);
		protocolHandler=new ProtocolHandler();
		setDefaultCommand(new ReadSerialCommand()); //automatically adds packets to the buffer
	}
	
	public void addToBuffer() { //should run periodically
		if (serial.getBytesReceived() > 0) {
			try { //wrapped in a try/catch because if the pi inits before the rio it'll crash otherwise
				protocolHandler.addToBuffer(serial.readString());
				serial.flush();
			}
			catch (Exception e) {
				System.out.println("serial exception");
				protocolHandler=new ProtocolHandler();
			}
		}
	}
	public Target[] getVisionPacket() {
		if (!protocolHandler.getLastString().equals("")) 
			return VisionPacketHandler.decodeVisionPacket(protocolHandler.getLastString());
		else
			return new Target[0];
	}
	public void sendVisionPacket(Point[] packetsToSend) {
		serial.writeString(VisionPacketHandler.encodeVisionPacket(packetsToSend));
	}
}
