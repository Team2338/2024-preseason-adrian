package team.gif.robot.commands.Autos;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class AutosStopIndex extends Command {
    double Time;
    double initalTime;
    public AutosStopIndex(double time){
        super();
        addRequirements(Robot.indexer);
        Time = time;
    }
    @Override
    public void initialize() {
        initalTime =  Timer.getFPGATimestamp();
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {

        Robot.indexer.index(0);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {

        return (Timer.getFPGATimestamp() > initalTime + Time);
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.indexer.index(0);
    }
}