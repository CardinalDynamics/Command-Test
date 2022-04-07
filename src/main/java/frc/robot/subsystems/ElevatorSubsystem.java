package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;

public class ElevatorSubsystem extends SubsystemBase {

    /**
     * VictorSPX on PWM, runs the elevator.
     */
    private final PWMVictorSPX elevatorMotor = new PWMVictorSPX(Constants.kElevatorMotorPort);

    /** Creates a new ElevatorSubsystem. */
    public ElevatorSubsystem() {
        super();
        addChild("ElevatorMotor", elevatorMotor);
    }

    /**
     * Logs data to the SmartDashboard.
     */
    public void log() {
        SmartDashboard.putNumber("ElevatorMotor", elevatorMotor.get());
    }

    /**
     * Moves the elevator up.
     */
    public void up() {
        elevatorMotor.set(Constants.kElevatorMotorSpeed);
    }

    /**
     * Moves the elevator down.
     */
    public void down() {
        elevatorMotor.set(-Constants.kElevatorMotorSpeed);
    }

    /**
     * Stops the elevator.
     */
    public void stop() {
        elevatorMotor.set(0);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        log();
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }

    /**
     * Runs the elevator up until told to stop.
     */
    public Command commandUp() {
        return new StartEndCommand(this::up, this::stop, this);
    }

}
