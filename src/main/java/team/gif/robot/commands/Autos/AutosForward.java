package team.gif.robot.commands.Autos;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class AutosForward extends Command {
    public AutosForward() {
        super();
        addRequirements(Robot.drivetrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        Robot.pigeon.resetPigeonPosition();

    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        System.out.println("drivetrain running");
        double gain= .2;
        double error=0-Robot.pigeon.get360Heading();
        double rotation= gain * error;
        Robot.drivetrain.driveArcade(.5,rotation);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return (Timer.getMatchTime()) < 13.3;  //2 seconds??
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.drivetrain.driveArcade(0,0);
    }
}

