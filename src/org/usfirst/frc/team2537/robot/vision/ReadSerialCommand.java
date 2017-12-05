package org.usfirst.frc.team2537.robot.vision;

import java.util.Arrays;

import org.usfirst.frc.team2537.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Should be in TeleopPeriodic, adds most recent serial input to buffer
 */
public class ReadSerialCommand extends Command {

    public ReadSerialCommand() {
        requires(Robot.serialSys);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.serialSys.addToBuffer();
    	if (Robot.serialSys.DEBUG) {
    		System.out.println("number of points: "+Robot.serialSys.getVisionPacket().length);
    		System.out.println(Arrays.toString(Robot.serialSys.getVisionPacket()));
    		
    	}
    //	Robot.serialSys.sendVisionPacket(Robot.serialSys.getVisionPacket());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
