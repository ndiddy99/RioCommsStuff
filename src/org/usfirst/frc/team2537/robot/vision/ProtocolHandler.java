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
	 *  <Val1:Val2|Val3:Val4|Val5:Val6|>
	 *  pretty much, the greater than/less than symbols frame the packets
	 *  the val1, etc text is values (must be ints)
	 *  the pipes separate values
	 */
	public void addToBuffer(String stringToAppend) {

		for (int i=0; i < stringToAppend.length();i++) {
			char charToAppend=stringToAppend.charAt(i);
			if (charToAppend=='<') {  //is current character opening character?
				buffer="";			//if yes, reset the buffer
			}
			else if (charToAppend=='>') { //is current char closing character?
				//buffer+='>';		//if yes, buffer is ready for program to read
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
