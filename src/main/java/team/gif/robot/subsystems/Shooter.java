// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class Shooter extends SubsystemBase {
    public static TalonSRX shooterMotor = new TalonSRX(RobotMap.SHOOTER);
    public static TalonSRX indexerMotor = new TalonSRX(RobotMap.INDEXER);
  /** Creates a new ExampleSubsystem. */
    public Shooter() {
        shooterMotor = new TalonSRX(RobotMap.SHOOTER);
        shooterMotor.configFactoryDefault();
        shooterMotor.setNeutralMode(NeutralMode.Brake);

        indexerMotor = new TalonSRX(RobotMap.INDEXER);
        indexerMotor.configFactoryDefault();
        indexerMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void shoot(double speed) {
        shooterMotor.set(ControlMode.PercentOutput, speed);
    }
    public void index(double speed){
        indexerMotor.set(ControlMode.PercentOutput, speed);
    }

    public void stop() {
        shooterMotor.set(ControlMode.PercentOutput, 0);
        indexerMotor.set(ControlMode.PercentOutput, 0);
    }



}
