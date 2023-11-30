package com.actions;

import com.entities.Character;
import com.entities.Furniture;

/**
 * Represents the action of a character sleeping in the game.
 */
public class Sleep implements IAction {
    Character character;
    Furniture bed;

    /**
     * Constructs a Sleep action for the specified character and bed.
     * 
     * @param character The character that will sleep.
     * @param bed The bed on which the character will lie down.
     */
    public Sleep(Character character, Furniture bed) {
        this.character = character;
        this.bed = bed;
    }

    /**
     * Returns the action name.
     * 
     * @return The name of the action, "Sleep".
     */
    @Override
    public String getName() {
        return "Sleep";
    }

    /**
     * Determines if the game should wait for this action to complete before proceeding.
     * 
     * @return true, indicating that the game should wait for the character to finish the sleeping action.
     */
    @Override
    public boolean getShouldWait() {
        return true;
    }

    /**
     * Provides a string representation of the Sleep action.
     * 
     * @return A string in the format of "Sleep(characterName, bedName)".
     */
    @Override
    public String toString() {
        return String.format("%s(%s, %s)", getName(), character.getName(), bed.getName());
    }

    // Additional methods, if necessary
}
