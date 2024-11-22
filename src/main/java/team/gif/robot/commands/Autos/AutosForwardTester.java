package team.gif.robot.commands.Autos;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class AutosForwardTester extends Command {
    double initialTime;

    double Time;
    double Speed;
    public AutosForwardTester(double time,double speed){
        super();
        addRequirements(Robot.drivetrain);
        Time = time;
        Speed = speed;
    }

    @Override
    public void initialize() {
        initialTime = Timer.getFPGATimestamp();
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        //Robot.drivetrain.Tank(0.2,0.2);
        //Robot.indexer.index(Constants.INDEXER_PERCENT);
        Robot.drivetrain.driveArcade(Speed,0); //keep speed negative so it's easier to go straight to a ball

    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {

        return (Timer.getFPGATimestamp() > initialTime + Time);
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.drivetrain.driveArcade(0,0);

    }
}
