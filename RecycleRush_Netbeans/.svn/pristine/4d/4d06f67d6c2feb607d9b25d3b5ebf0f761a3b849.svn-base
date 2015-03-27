package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.RobotMap;

public class Attack3Joystick extends Joystick{

	public Attack3Joystick(int port) {
		super(RobotMap.USE_OLD_DRIVER_STATION ? (port+1) : port);
	}
	
	public double getDeadX(){
		if (Math.abs(getX()) < 0.15){ //if X difference more than 15% off 0, it = 0 
			return 0;
		}
		return getX();
	}
	
	public double getDeadY(){ //if Y difference more than 15% off 0, it = 0 
		if (Math.abs(getY()) < 0.15){
			return 0;
		}
		return getY();
	}
}
