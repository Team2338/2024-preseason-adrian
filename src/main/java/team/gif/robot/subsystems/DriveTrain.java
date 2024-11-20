package team.gif.robot.subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class DriveTrain extends SubsystemBase {
    public static CANSparkMax rightMotor;

    public static CANSparkMax leftMotor;

    private static DifferentialDrive drive;
    public DriveTrain(){
        rightMotor = new CANSparkMax(RobotMap.DRIVETRAIN_RIGHT, CANSparkLowLevel.MotorType.kBrushless);
        leftMotor = new CANSparkMax(RobotMap.DRIVETRAIN_LEFT, CANSparkLowLevel.MotorType.kBrushless);

        rightMotor.restoreFactoryDefaults();
        rightMotor.setInverted(true);
        rightMotor.setIdleMode(CANSparkBase.IdleMode.kBrake);

        leftMotor.restoreFactoryDefaults();
        leftMotor.setInverted(false);
        leftMotor.setIdleMode(CANSparkBase.IdleMode.kBrake);

        drive = new DifferentialDrive(leftMotor, rightMotor);

    }

    public void driveArcade(double speed, double rotation) {
        drive.arcadeDrive(speed, rotation);
    }

    public void driveTank(double left, double right) {
        drive.tankDrive(left,right);
    }
}
