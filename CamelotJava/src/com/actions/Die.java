package com.actions;

import com.entities.Character;

/**
 * Represents the action of a character dying in the game.
 */
public class Die implements IAction {
    Character character;

    /**
     * Constructs a Die action for the specified character.
     * 
     * @param character The character that will die.
     */
    public Die(Character character) {
        this.character = character;
    }

    /**
     * Returns the action name.
     * 
     * @return The name of the action, "Die".
     */
    @Override
    public String getName() {
        return "Die";
    }

    /**
     * Determines if the game should wait for this action to complete before proceeding.
     * 
     * @return true, indicating that the game should wait for the character to finish dying.
     */
    @Override
    public boolean getShouldWait() {
        return true;
    }

    /**
     * Provides a string representation of the Die action.
     * 
     * @return A string in the format of "Die(characterName)".
     */
    @Override
    public String toString() {
        return String.format("%s(%s)", getName(), character.getName());
    }
}
