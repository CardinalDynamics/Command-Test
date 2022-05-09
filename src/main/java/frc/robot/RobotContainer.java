// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.ComplexAuto;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_drive = new DriveSubsystem();
  private final ClimberSubsystem m_climb = new ClimberSubsystem();
  private final ShooterSubsystem m_shoot = new ShooterSubsystem();
  private final IntakeSubsystem m_intake = new IntakeSubsystem();
  private final ElevatorSubsystem m_elevator = new ElevatorSubsystem();

  private final XboxController driveController = new XboxController(Constants.kDriveControllerPort);
  private final XboxController operatorController = new XboxController(Constants.kOperatorControllerPort);

  private final SendableChooser<Command> m_chooser = new SendableChooser<>();
  
  private final ComplexAuto m_complexAuto = new ComplexAuto(m_drive, m_elevator, m_intake, m_climb, m_shoot);
  
  private final Command m_autonomousCommand = 
    new RunCommand(() -> m_drive.drive(0.25, 0.25), m_drive).withTimeout(2.5);



  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    m_drive.setDefaultCommand(
        new RunCommand(
            () -> m_drive.drive(
                driveController.getLeftY(),
                driveController.getRightY()),
            m_drive));

    m_shoot.setDefaultCommand(
        new RunCommand(
            () -> m_shoot.shoot(
                operatorController.getRightTriggerAxis()),
            m_shoot));
    // Configure the button bindings
    configureButtonBindings();

    // Configure chooser
    m_chooser.setDefaultOption("Simple Auto", m_autonomousCommand);
    m_chooser.addOption("Complex Auto", m_complexAuto);

    // Add chooser to Shuffleboard
    Shuffleboard.getTab("Autonomous").add(m_chooser);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    // Configure your button bindings here
    new JoystickButton(operatorController, XboxController.Button.kA.value)
        .whenHeld(new RunCommand(m_intake::intake, m_intake));
    new JoystickButton(operatorController, XboxController.Button.kB.value)
        .whenHeld(new RunCommand(m_intake::reverse, m_intake));
    new JoystickButton(operatorController, XboxController.Button.kX.value)
        .whenHeld(new RunCommand(m_elevator::up, m_elevator));
    new JoystickButton(operatorController, XboxController.Button.kY.value)
        .whenHeld(new RunCommand(m_elevator::down, m_elevator));
    new JoystickButton(operatorController, XboxController.Button.kRightBumper.value)
        .whenHeld(new RunCommand(m_climb::climb, m_climb));
    new JoystickButton(operatorController, XboxController.Button.kLeftBumper.value)
        .whenHeld(new RunCommand(m_climb::reverse, m_climb));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_chooser.getSelected();
  }
}
