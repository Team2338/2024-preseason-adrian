package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;
import team.gif.robot.RobotMap;

public class ArcadeDrive extends Command {

    public ArcadeDrive() {
        super();
        addRequirements(Robot.drivetrain);
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        double speed = -Robot.oi.driver.getLeftY();
        double rotation = -Robot.oi.driver.getRightX();
        Robot.drivetrain.driveArcade(speed, rotation);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.drivetrain.driveArcade(0, 0);
    }
}
