package org.usfirst.frc.team2537.robot.vision;

import org.usfirst.frc.team2537.robot.Robot;

public class ProtocolHandler {
	String buffer;
	String lastCompletedString;
	public ProtocolHandler() {
		buffer="";
		lastCompletedString="";
	}
	/*
	 * Example packet of the protocol we're using:
	 *  >x1,y1|x2,y2#x1,y1|x2,y2>
	 *  pretty much, the greater than symbols frame the packets
	 *  pipes separate points
	 *  the hashtag separates objects
	 */
	public void addToBuffer(String stringToAppend) {

		for (int i=0; i < stringToAppend.length();i++) {
			char charToAppend=stringToAppend.charAt(i);
			if (charToAppend=='>') {  //is current character opening character?
				buffer="";	//if yes, reset the buffer
				lastCompletedString=buffer;
			}
			else 				//otherwise, add current char to the buffer
				buffer+=charToAppend;
				//if (Robot.serialSys.DEBUG)
				//	System.out.println("adding char to buffer: "+charToAppend);
		}
	}
	public String getLastString() {
		return lastCompletedString;
	}
}
