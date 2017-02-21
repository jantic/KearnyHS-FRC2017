package org.usfirst.frc.team1572.robot;

public enum Attack3ButtonMap {
    one (1),  //calls constructor with value 3
    two (2),  //calls constructor with value 2
    three (3),   //calls constructor with value 1
    four (4),
    five (5),
    six (6),
	seven (7),
	eight (8),
	nine (9),
	ten (10),
	eleven (11);
    // semicolon needed when fields / methods follow


    private final int buttonNumber;

    private Attack3ButtonMap(int buttonNumber) {
        this.buttonNumber = buttonNumber;
    }

	public int getButtonNumber() {
		return this.buttonNumber;
	}
}

