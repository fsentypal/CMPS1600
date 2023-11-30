package com.actions;

/**
 * Action for fading out the screen to black.
 */
public class FadeOut implements IAction {

    /**
     * Constructor for FadeOut action.
     */
    public FadeOut() {
        // No arguments needed for FadeOut
    }

    /**
     * Returns the action name.
     *
     * @return The name of the action.
     */
    @Override
    public String getName() {
        return "FadeOut";
    }

    /**
     * Indicates whether the action should be waited on to complete.
     *
     * @return true if the action should be waited on, otherwise false.
     */
    @Override
    public boolean getShouldWait() {
        // Assuming we need to wait for the fade out action to complete.
        return true;
    }

    @Override
    public String toString() {
        return getName() + "()";
    }
}
