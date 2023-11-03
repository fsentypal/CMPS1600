package com.actions;

/**
 * Action for waiting a specified amount of time in the game.
 */
public class Wait implements IAction {
    double duration; // Duration for which to wait.

    /**
     * Constructor for Wait action.
     * 
     * @param duration The duration to wait in the game.
     */
    public Wait(double duration) {
        this.duration = duration;
    }

    /**
     * Returns the action name.
     * 
     * @return The name of the action.
     */
    @Override
    public String getName() {
        return "Wait";
    }

    /**
     * Indicates whether the action should be waited on to complete.
     * 
     * @return true if the action should be waited on, otherwise false.
     */
    @Override
    public boolean getShouldWait() {
        return true; // We should wait for the duration to pass before continuing.
    }

    @Override
    public String toString() {
        return String.format("%s(%.1f)", getName(), duration);
    }
}
