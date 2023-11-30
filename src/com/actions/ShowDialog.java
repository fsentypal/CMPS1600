package com.actions;

/**
 * Action for showing a dialog window in the game.
 */
public class ShowDialog implements IAction {

    /**
     * Constructor for ShowDialog action.
     */
    public ShowDialog() {
        // No arguments needed for the constructor as per the documentation.
    }

    /**
     * Returns the action name.
     * 
     * @return The name of the action.
     */
    @Override
    public String getName() {
        return "ShowDialog";
    }

    /**
     * Indicates whether the action should be waited on to complete.
     * 
     * @return true if the action should be waited on, otherwise false.
     * Assuming the dialog should be shown before proceeding.
     */
    @Override
    public boolean getShouldWait() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + "()";
    }
}
