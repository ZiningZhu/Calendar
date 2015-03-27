package org.usfirst.frc.team4814.robot.autocommands;

import com.sun.squawk.io.BufferedReader;
import com.sun.squawk.microedition.io.FileConnection;
import com.sun.squawk.util.StringTokenizer;
import edu.wpi.first.wpilibj.Timer;
import java.util.Vector;

import edu.wpi.first.wpilibj.templates.Robot;

import edu.wpi.first.wpilibj.command.Command;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.microedition.io.Connector;


public class InputReader2014 extends Command {

	private String[] dataStack; //used to store data read from the text file

	public InputReader2014() {
		requires(Robot.chassis);

	}

	public void reader() {

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		//initializes scanner and sets to the text file
		readIndex = 0;
		FileConnection file_connection_ = null;
		BufferedReader reader_ = null;
		try {
			// Open the new file
			file_connection_ = (FileConnection) Connector.open("file:///output.txt");
			if (!file_connection_.exists()) {
				System.err.println("Could not find specified file!");
				return;
			}

			// Make an I/O adapter sandwich to actually get some text out
			reader_ = new BufferedReader(
			new InputStreamReader(file_connection_.openInputStream()));

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Could not open file connection!");

		}



		//loops and sets the Vector data lsit

		StringBuffer buffer = new StringBuffer();
		String line;
		try {
			while ((line = reader_.readLine()) != null) {
				buffer.append(line);
				buffer.append("\n");

			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		StringTokenizer st = new StringTokenizer(buffer.toString(), "\n");
		int count = st.countTokens();
		dataStack = new String[count];
		for (int i = 0; i < count; i++) {
			dataStack[i] = st.nextToken();
		}
        System.out.println(count);
	}


	// Called repeatedly when this Command is scheduled to run
	private int readIndex = 0;
    private boolean skip = false;
    private double lastTime = 0;
	protected void execute() {
        if (lastTime == 0){
            lastTime = Timer.getFPGATimestamp();
        }
        skip = !skip;
        if(skip) {
            //return;
        }
		if (readIndex < dataStack.length) {
            double forwardPower = -Robot.oi.driverLeftStick.getDeadY();
            double turnMod = Robot.oi.driverRightStick.getDeadX();
			StringTokenizer st = new StringTokenizer(dataStack[readIndex], ",");
			int count = st.countTokens();
			double leftPower = 0;
			double rightPower = 0;
			double armPower = 0;
			double elevatorPower = 0;
            double timeStamp = 0;
			for (int i = 0; i < count; i++) {
				String buffer = st.nextToken();
				switch (i) {
					case 0:
						leftPower = Double.parseDouble(buffer);
						break;
					case 1:
						rightPower = Double.parseDouble(buffer);
						break;
					case 2:
						armPower = Double.parseDouble(buffer);
						break;
					case 3:
						elevatorPower = Double.parseDouble(buffer);
						break;
                    case 4:
                        timeStamp = Double.parseDouble(buffer);
                        break;
				}
			}
            if (timeStamp > (Timer.getFPGATimestamp()-lastTime)){
                return;
            }
            
            System.out.println(leftPower+ ","+rightPower+" " + (Timer.getFPGATimestamp()-lastTime));
			Robot.chassis.drive(leftPower, rightPower);


			//Robot.elevator.

			//Why?? VV
			//Robot.arm.setArmPower(Double.parseDouble(temp.substring(0, temp.indexOf(','))));
			//temp = temp.substring(temp.indexOf(','));
			//Robot.elevator.setElevatorPower(Double.parseDouble(temp.substring(0, temp.indexOf(','))));
			//temp = temp.substring(temp.indexOf(','));

			//Robot.arm.setArmPower(armPower);
			//Robot.elevator.setElevatorPower(elevatorPower);
			readIndex++;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (readIndex >= dataStack.length);
	}

	// Called once after isFinished returns true
	protected void end() {
    System.out.println("done");
    }

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
        protected void interrupted() {
         System.out.println("interupted");
        }
}