package com.actions;

import com.entities.Character;

/**
 * Represents the action of two characters dancing together in the game.
 */
public class DanceTogether implements IAction {
    Character character1;
    Character character2;

    /**
     * Constructs a DanceTogether action for the specified characters.
     * 
     * @param character1 The first character that will dance.
     * @param character2 The second character that will dance.
     */
    public DanceTogether(Character character1, Character character2) {
        this.character1 = character1;
        this.character2 = character2;
    }

    /**
     * Returns the action name.
     * 
     * @return The name of the action, "DanceTogether".
     */
    @Override
    public String getName() {
        return "DanceTogether";
    }

    /**
     * Determines if the game should wait for this action to complete before proceeding.
     * 
     * @return true, indicating that the game should wait for the characters to finish dancing.
     */
    @Override
    public boolean getShouldWait() {
        return true;
    }

    /**
     * Provides a string representation of the DanceTogether action.
     * 
     * @return A string in the format of "DanceTogether(characterName1, characterName2)".
     */
    @Override
    public String toString() {
        return String.format("%s(%s, %s)", getName(), character1.getName(), character2.getName());
    }
}
