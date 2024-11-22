package team.gif.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutosGroup extends SequentialCommandGroup {
    public AutosGroup(){
        addCommands(

                // This for left side
                new AutosIndex(),
                new AutosForwardTester(2,-.5),
                new AutosTurn(.75,.57),
                new AutosIndex(),
                new AutosForwardTester(2.05,-.5),
                new AutosStopIndex(0),
                new AutosTurn(.75,.85),
                new AutosForwardTester(2.7,.5),
                //new AutosTurn(.75,.15),
                new AutosShoot()

                // This is for right side

        );
    }
}
