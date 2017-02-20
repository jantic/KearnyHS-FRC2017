package org.usfirst.frc.team1572.robot;

public enum JoystickButtonMap {
    A (1),  //calls constructor with value 3
    B (2),  //calls constructor with value 2
    X (3),   //calls constructor with value 1
    Y (4),
    LB (5),
    RB (6),
	Back (7);
    // semicolon needed when fields / methods follow


    private final int buttonNumber;

    private JoystickButtonMap(int buttonNumber) {
        this.buttonNumber = buttonNumber;
    }

	public int getButtonNumber() {
		return this.buttonNumber;
	}
}

