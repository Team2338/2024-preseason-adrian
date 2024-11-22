package team.gif.robot.commands.Autos;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class AutosShoot extends Command {
    double initalTime;
    public AutosShoot(){
        super();
        addRequirements(Robot.shooter);
    }
    @Override
    public void initialize() {
        initalTime = Timer.getFPGATimestamp();
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        Robot.indexer.index(Constants.INDEXER_PERCENT);
        Robot.shooter.shoot(Constants.SHOOTER_PERCENT);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {

        return (Timer.getFPGATimestamp() > initalTime + 3);
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.shooter.shoot(0);
        Robot.indexer.index(0);
    }
}
