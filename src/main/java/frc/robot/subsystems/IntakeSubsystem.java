package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class IntakeSubsystem extends SubsystemBase {

    /**
     * Spark MAX on CAN, runs the intake.
     */
    private final CANSparkMax intakeMotor = new CANSparkMax(Constants.kIntakeMotorPort, MotorType.kBrushless);

    /** Creates a new IntakeSubsystem. */
    public IntakeSubsystem() {
        super();
        // addChild("IntakeMotor", intakeMotor);
    }

    /**
     * Logs data to the SmartDashboard.
     */
    public void log() {
        SmartDashboard.putNumber("IntakeMotor", intakeMotor.get());
    }

    /**
     * Runs the intake motor.
     */
    public void intake() {
        intakeMotor.set(Constants.kIntakeMotorSpeed);
    }

    /**
     * Runs the intake motor in reverse.
     */
    public void reverse() {
        intakeMotor.set(-Constants.kIntakeMotorSpeed);
    }

    /**
     * Stops the intake motor.
     */
    public void stop() {
        intakeMotor.set(0);
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
