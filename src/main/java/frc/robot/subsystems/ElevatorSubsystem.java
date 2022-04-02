package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase {

    private final PWMVictorSPX elevatorMotor = new PWMVictorSPX(Constants.kElevatorMotorPort);

    /** Creates a new ElevatorSubsystem. */
    public ElevatorSubsystem() {
        addChild("ElevatorMotor", elevatorMotor);
    }

    public void log() {
        SmartDashboard.putNumber("ElevatorMotor", elevatorMotor.get());
    }

    public void up() {
        elevatorMotor.set(Constants.kElevatorMotorSpeed);
    }

    public void down() {
        elevatorMotor.set(-Constants.kElevatorMotorSpeed);
    }

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

}
