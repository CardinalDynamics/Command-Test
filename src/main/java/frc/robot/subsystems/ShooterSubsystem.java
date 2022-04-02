package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {

    private final PWMVictorSPX frontShooterMotor = new PWMVictorSPX(Constants.kFrontShooterPort);
    private final PWMVictorSPX backShooterMotor = new PWMVictorSPX(Constants.kBackShooterPort);

    /** Creates a new ShooterSubsystem. */
    public ShooterSubsystem() {
        addChild("ShooterMotor", frontShooterMotor);
        addChild("ShooterMotor", backShooterMotor);
    }

    public void log() {
        SmartDashboard.putNumber("FrontShooterMotor", frontShooterMotor.get());
        SmartDashboard.putNumber("BackShooterMotor", backShooterMotor.get());
    }

    public void shoot(double speed) {
        frontShooterMotor.set(speed);
        backShooterMotor.set(speed);
    }

    public void reverse() {
        frontShooterMotor.set(-Constants.kShooterMotorSpeed);
        backShooterMotor.set(-Constants.kShooterMotorSpeed);
    }

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

}
