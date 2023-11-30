package com.actions;

import com.entities.Character;

/**
 * Represents the action of a character laughing in the game.
 */
public class Laugh implements IAction {
    Character character;

    /**
     * Constructs a Laugh action for the specified character.
     * 
     * @param character The character that will laugh.
     */
    public Laugh(Character character) {
        this.character = character;
    }

    /**
     * Returns the action name.
     * 
     * @return The name of the action, "Laugh".
     */
    @Override
    public String getName() {
        return "Laugh";
    }

    /**
     * Determines if the game should wait for this action to complete before proceeding.
     * 
     * @return false, indicating that the game can continue while the character is laughing.
     */
    @Override
    public boolean getShouldWait() {
        return false;
    }

    /**
     * Provides a string representation of the Laugh action.
     * 
     * @return A string in the format of "Laugh(characterName)".
     */
    @Override
    public String toString() {
        return String.format("%s(%s)", getName(), character.getName());
    }

    // Additional methods, if necessary
}
