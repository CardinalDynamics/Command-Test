package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
// import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;

public class ShooterSubsystem extends SubsystemBase {

    /**
     * VictorSPX on PWM, runs the front of the shooter.
     */
    private final CANSparkMax frontShooterMotor = new CANSparkMax(Constants.kFrontShooterPort, MotorType.kBrushed);
    /**
     * VictorSPX on PWM, runs the back of the shooter.
     */
    private final CANSparkMax backShooterMotor = new CANSparkMax(Constants.kBackShooterPort, MotorType.kBrushed);

    /** Creates a new ShooterSubsystem. */
    public ShooterSubsystem() {
        super();
        // addChild("ShooterMotor", frontShooterMotor);
        // addChild("ShooterMotor", backShooterMotor);
    }

    /**
     * Logs data to the SmartDashboard.
     */
    public void log() {
        SmartDashboard.putNumber("FrontShooterMotor", frontShooterMotor.get());
        SmartDashboard.putNumber("BackShooterMotor", backShooterMotor.get());
    }

    /**
     * Runs the shooter motors at a set speed.
     * 
     * @param speed The speed to run the motors at.
     */
    public void shoot(double speed) {
        frontShooterMotor.set(speed);
        backShooterMotor.set(speed);
    }

    /**
     * Runs the shooter motors in reverse.
     */
    public void reverse() {
        frontShooterMotor.set(-Constants.kShooterMotorSpeed);
        backShooterMotor.set(-Constants.kShooterMotorSpeed);
    }

    /**
     * Stops the shooter.
     */
    public void stop() {
        frontShooterMotor.set(0);
        backShooterMotor.set(0);
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
     * Runs the shooter until told to stop.
     */
    public Command runShooter() {
        return new StartEndCommand(() -> this.shoot(1.0), this::stop, this);
      }

}
