package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase {

    private final PWMVictorSPX climberMotor = new PWMVictorSPX(Constants.kClimberMotorPort);

    /** Creates a new ClimberSubsystem. */
    public ClimberSubsystem() {
        addChild("ClimberMotor", climberMotor);
    }

    public void log() {
        SmartDashboard.putNumber("ClimberMotor", climberMotor.get());
    }

    public void climb() {
        climberMotor.set(Constants.kClimberMotorSpeed);
    }

    public void reverse() {
        climberMotor.set(-Constants.kClimberMotorSpeed);
    }

    public void stop() {
        climberMotor.set(0);
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
