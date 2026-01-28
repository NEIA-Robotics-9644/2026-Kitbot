package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.shooter.feederWheel.FeederWheelIO;

public class ShooterSubsystem extends SubsystemBase {

    private final double[] angleSetpoints;

    private final double[] wheelSpeedSetpoints;

    private final double[] feederSpeedSetpoints;

    private int setpointIndex = 0;
    
    
    private final FeederWheelIO feeder;

    private final boolean feederReversed = true;

    private double angleSetpoint = 0.0; 
    private double wheelSpeedSetpoint = 0.1;
    private double feederSpeedSetpoint = 0.1;


    public ShooterSubsystem() {
        throw new IllegalArgumentException("You must pass in valid hardware for a subsystem to work");
    }

    /*
     * Create a new shooter subsystem
     * @param leftShooter The left shooter wheel
     * @param rightShooter The right shooter wheel
     * @param feeder The feeder wheel
     * @param angleMechanism The angle mechanism
     * @param noteSensor The note sensor
     * @param angleSetpoints in degrees
     * @param wheelSpeedSetpoints normalized
     * @param feederSpeedSetpoints normalized
     */
    public ShooterSubsystem(FeederWheelIO feeder, double[] angleSetpoints
    , double[] wheelSpeedSetpoints, double[] feederSpeedSetpoints) {

        if (feeder == null || angleSetpoints == null || wheelSpeedSetpoints == null || feederSpeedSetpoints == null) {
            throw new IllegalArgumentException("You must pass in valid hardware for a subsystem to work");
        }

        if (angleSetpoints.length != wheelSpeedSetpoints.length || angleSetpoints.length != feederSpeedSetpoints.length) {
            throw new IllegalArgumentException("The length of the angle setpoints, wheel speed setpoints, and feeder speed setpoints must be the same");
        }

        // Initialize things
        this.feeder = feeder;

        this.wheelSpeedSetpoints = wheelSpeedSetpoints;

        this.angleSetpoints = angleSetpoints;
        this.feederSpeedSetpoints = feederSpeedSetpoints;
    

        // Turn on brake mode for the feeder
        this.feeder.setBrakeMode(true);

        

        
    }

    @Override
    public void periodic() {
        feeder.periodic();
    }


    /*
     * Spin the shooter wheels
     */

    public void setManualAngleSetpoint(double angle, double wheelSpeed, double feederSpeed) {
        this.angleSetpoint = angle;
        this.wheelSpeedSetpoint = wheelSpeed;
        this.feederSpeedSetpoint = feederSpeed;
    }

    /*
     * Get the percent at which the shooter wheels are spinning
     */

    public double getFeederVelocityPercent() {
        return feeder.getVelocityPercent();
    }   


    /*
     * Spin the feeder wheel
     */
    public void spinFeederWheel(boolean reversed) {
        if (reversed) {
            feeder.spinWheel(feederReversed ? -feederSpeedSetpoint : feederSpeedSetpoint);
        } else {
            feeder.spinWheel( feederReversed ? feederSpeedSetpoint : -feederSpeedSetpoint);
        }
    }


    /*
     * Spin the feeder wheel manually
     * This is used when not moving to a specific setpoint
     */
    public void spinFeederWheelManual(double normalizedSpeed) {
        feeder.spinWheel(feederReversed ? -normalizedSpeed : normalizedSpeed);
    }




    /*
     * Get the current angle of the shooter in degrees
     */

    /*
     * Enable manual control of the angle mechanism
     * This disables all internal control loops
     * USE WITH CAUTION
     */


    /*
     * Get whether manual control of the angle mechanism is enabled
     */


    /*
     * Set the velocity of the angle mechanism
     * This is only used when manual control is enabled
     */



    /*
     * Reset the angle of the shooter to the bottom
     */


    /*
     * Move to a specific setpoint
     * This is used to change the shooter angle, wheel speed, and feeder speed
     */
    public void goToSetpoint(int setpointIndex) {
        if (setpointIndex < 0 || setpointIndex >= angleSetpoints.length) {
            throw new IllegalArgumentException("Invalid setpoint.  Setpoint must be between 0 and " + (angleSetpoints.length - 1) + " inclusive.");
        }
        this.angleSetpoint = angleSetpoints[setpointIndex];
        this.wheelSpeedSetpoint = wheelSpeedSetpoints[setpointIndex];
        this.feederSpeedSetpoint = feederSpeedSetpoints[setpointIndex];
        this.setpointIndex = setpointIndex;
    }


    /*
     * Modify the current setpoint
     */
    public void modifyAngleSetpoint(double delta) {
        angleSetpoints[setpointIndex] += delta;
        goToSetpoint(setpointIndex);
    }
    

    public void modifyFeederSetpoint(double delta) {
        feederSpeedSetpoints[setpointIndex] += delta;
        goToSetpoint(setpointIndex);
    }

    public void modifyShooterSpeedSetpoint(double delta) {
        wheelSpeedSetpoints[setpointIndex] += delta;
        goToSetpoint(setpointIndex);
    }

    public int getSetpointIndex() {
        return setpointIndex;
    }

    /*
     * Degrees
     */
    public double getAngleSetpoint() {
        return angleSetpoint;
    }

    /*
     * Normalized wheel speed setpoint
     
     */
    public double getWheelSpeedSetpoint() {
        return wheelSpeedSetpoint;
    }

    /*
     * Normalized feeder speed setpoint
     */
    public double getFeederSpeedSetpoint() {
        return feederSpeedSetpoint;
    }

}