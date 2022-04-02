package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
// import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SPI;

import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// import com.kauailabs.navx.frc.AHRS;

public class DriveSubsystem extends SubsystemBase {

    private final MotorController m_leftMotor = new MotorControllerGroup(new CANSparkMax(2, MotorType.kBrushless),
            new CANSparkMax(4, MotorType.kBrushless));

    private final MotorController m_rightMotor = new MotorControllerGroup(new CANSparkMax(3, MotorType.kBrushless),
            new CANSparkMax(5, MotorType.kBrushless));

    private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

    private final Gyro m_gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public DriveSubsystem() {
        super();

        m_rightMotor.setInverted(true);
    }

    public void log() {
    }

    public void drive(double left, double right) {
        m_drive.tankDrive(left, right);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}
