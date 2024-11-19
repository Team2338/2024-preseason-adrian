package team.gif.robot.subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Constants;
import team.gif.robot.RobotMap;

public class DriveTrain extends SubsystemBase {
    public static CANSparkMax motor_R = new CANSparkMax(RobotMap.RSPARK_MAX_ID, CANSparkLowLevel.MotorType.kBrushless);
    public static SparkPIDController pidController_R = motor_R.getPIDController();

    public static CANSparkMax motor_L = new CANSparkMax(RobotMap.LSPARK_MAX_ID, CANSparkLowLevel.MotorType.kBrushless);
    public static SparkPIDController pidController_L = motor_L.getPIDController();
    private static DifferentialDrive drive;
    boolean isRunning = false;
    public DriveTrain(){

        motor_R.restoreFactoryDefaults();
//        motor_R.setInverted(true);
//        motor_R.setIdleMode(CANSparkBase.IdleMode.kBrake);
//        pidController_R.setP(Constants.NEOConstants.kP_IDLE);
//        pidController_R.setFF(Constants.NEOConstants.FF_IDLE);

        motor_L.restoreFactoryDefaults();
//        motor_L.setInverted(true);
//        motor_L.setIdleMode(CANSparkBase.IdleMode.kBrake);
//        pidController_L.setP(Constants.NEOConstants.kP_IDLE);
//        pidController_L.setFF(Constants.NEOConstants.FF_IDLE);


        drive = new DifferentialDrive(motor_L,motor_R);

        // turn off the drive train watchdog - otherwise it outputs unnecessary errors on the console
        drive.setSafetyEnabled(false);
    }
    public void setMotor(double percent){
        motor_R.setVoltage(percent);
    }

    public void setNEOMotorRPM(double rpm){
        pidController_R.setReference(rpm, CANSparkBase.ControlType.kVelocity);
    }

    public double getRightMotorRPM() {
        return motor_R.getEncoder().getVelocity();
    }
    public double getLeftMotorRPM() {
        return motor_L.getEncoder().getVelocity();
    }
    public void Tank(double left, double right) {
        //Motor_L.set(TalonSRXControlMode.PercentOutput, left);
        //Motor_R.set(TalonSRXControlMode.PercentOutput, right);
        drive.tankDrive(left,right);
    }
}
