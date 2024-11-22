package team.gif.robot.commands.Autos;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class AutosIndex extends Command {
    double initalTime;
    public AutosIndex(){
        super();
        addRequirements(Robot.indexer);
    }
    @Override
    public void initialize() {
        initalTime =  Timer.getFPGATimestamp();
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {

        Robot.indexer.index(Constants.INDEXER_PERCENT);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {

        return (Timer.getFPGATimestamp() > initalTime + 0);
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        //Robot.indexer.index(0);
    }

}
