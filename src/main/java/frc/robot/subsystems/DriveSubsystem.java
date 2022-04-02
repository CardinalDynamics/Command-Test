package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
// import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
// import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

// import com.kauailabs.navx.frc.AHRS;

public class DriveSubsystem extends SubsystemBase {

    private final MotorController m_leftMotor = new MotorControllerGroup(
            new CANSparkMax(Constants.frontLeftDriveMotorPort, MotorType.kBrushless),
            new CANSparkMax(Constants.backLeftDriveMotorPort, MotorType.kBrushless));

    private final MotorController m_rightMotor = new MotorControllerGroup(
            new CANSparkMax(Constants.frontRightDriveMotorPort, MotorType.kBrushless),
            new CANSparkMax(Constants.backRightDriveMotorPort, MotorType.kBrushless));

    private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

    // private final RelativeEncoder m_leftEncoder = new
    // CANSparkMax(Constants.frontLeftDriveMotorPort,
    // MotorType.kBrushless).getEncoder();
    // private final RelativeEncoder m_rightEncoder = new
    // CANSparkMax(Constants.frontRightDriveMotorPort,
    // MotorType.kBrushless).getEncoder();
    private final Gyro m_gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public DriveSubsystem() {
        super();

        m_rightMotor.setInverted(true);

        addChild("Drive", m_drive);
        // addChild("Left Encoder", m_leftEncoder);
        // addChild("Right Encoder", m_rightEncoder);
        // addChild("Gyro", m_gyro);
    }

    public void log() {
        // SmartDashboard.putNumber("Left Distance", m_leftEncoder.getPosition());
        // SmartDashboard.putNumber("Right Distance", m_rightEncoder.getPosition());
        SmartDashboard.putNumber("Gyro", m_gyro.getAngle());
    }

    public void drive(double left, double right) {
        m_drive.tankDrive(left, right);
    }

    public double getHeading() {
        return m_gyro.getAngle();
    }

    public void reset() {
        m_gyro.reset();
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
