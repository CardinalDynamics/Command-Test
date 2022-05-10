// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int frontLeftDriveMotorPort = 1;
    public static final int frontRightDriveMotorPort = 4;
    public static final int backLeftDriveMotorPort = 2;
    public static final int backRightDriveMotorPort = 3;

    public static final int kFrontShooterPort = 7;
    public static final int kBackShooterPort = 8;
    public static final double kShooterMotorSpeed = 1.0;

    public static final int kIntakeMotorPort = 6;
    public static final double kIntakeMotorSpeed = 1.0;

    public static final int kClimberMotorPort = 0;
    public static final double kClimberMotorSpeed = 1.0;

    public static final int kElevatorMotorPort = 5;
    public static final double kElevatorMotorSpeed = 1.0;

    public static final int kDriveControllerPort = 0;
    public static final int kOperatorControllerPort = 1;
}
