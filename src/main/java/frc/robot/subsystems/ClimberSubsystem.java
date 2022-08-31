package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase {

    /**
     * VictorSPX on PWM, runs the climber
     */
    private final CANSparkMax climberMotor = new CANSparkMax(Constants.kClimberMotorPort, MotorType.kBrushed);

    /** Creates a new ClimberSubsystem. */
    public ClimberSubsystem() {
        super();

    }

    /**
     * Log the motor speed to the SmartDashboard.
     */
    public void log() {
        SmartDashboard.putNumber("ClimberMotor", climberMotor.get());
    }

    /**
     * Run the climber motor forward.
     */
    public void climb() {
        climberMotor.set(Constants.kClimberMotorSpeed);
    }

    /**
     * Run the climber motor backwards.
     */
    public void reverse() {
        climberMotor.set(-Constants.kClimberMotorSpeed);
    }

    /**
     * Stop the climber motor.
     */
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
