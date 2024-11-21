package team.gif.robot.commands.Autos;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class AutosForwardTester extends Command {
    double initialTime;

    double Time;

    public AutosForwardTester(double time){
        super();
        addRequirements(Robot.drivetrain);
        Time = time;
    }

    @Override
    public void initialize() {
        initialTime = Timer.getFPGATimestamp();
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        //Robot.drivetrain.Tank(0.2,0.2);
        Robot.drivetrain.driveArcade(.5,0);
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
