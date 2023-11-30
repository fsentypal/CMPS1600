package com.actions;

import com.entities.Character;

/**
 * Represents the action of a character dancing in the game.
 */
public class Dance implements IAction {
    Character character;

    /**
     * Constructs a Dance action for the specified character.
     * 
     * @param character The character that will dance.
     */
    public Dance(Character character) {
        this.character = character;
    }

    /**
     * Returns the action name.
     * 
     * @return The name of the action, "Dance".
     */
    @Override
    public String getName() {
        return "Dance";
    }

    /**
     * Determines if the game should wait for this action to complete before proceeding.
     * 
     * @return true, indicating that the game should wait for the character to finish dancing.
     */
    @Override
    public boolean getShouldWait() {
        return true;
    }

    /**
     * Provides a string representation of the Dance action.
     * 
     * @return A string in the format of "Dance(characterName)".
     */
    @Override
    public String toString() {
        return String.format("%s(%s)", getName(), character.getName());
    }
}
