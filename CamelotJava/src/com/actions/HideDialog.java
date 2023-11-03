package com.actions;

/**
 * Action for hiding a dialog window in the game.
 */
public class HideDialog implements IAction {

    /**
     * Constructor for HideDialog action.
     */
    public HideDialog() {
        // No arguments needed for the constructor as per the documentation.
    }

    /**
     * Returns the action name.
     * 
     * @return The name of the action.
     */
    @Override
    public String getName() {
        return "HideDialog";
    }

    /**
     * Indicates whether the action should be waited on to complete.
     * 
     * @return false because hiding the dialog is likely an immediate action.
     */
    @Override
    public boolean getShouldWait() {
        return false; // Assuming the dialog hide action does not need the game to wait.
    }

    @Override
    public String toString() {
        return getName() + "()";
    }
}
