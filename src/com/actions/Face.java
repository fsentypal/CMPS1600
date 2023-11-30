package com.actions;

import com.entities.Character;
import com.entities.IEntity;

/**
 * Represents the action of a character turning to face an entity in the game.
 */
public class Face implements IAction {
    Character character;
    IEntity entity;

    /**
     * Constructs a Face action for the specified character and entity.
     * 
     * @param character The character that will turn.
     * @param entity The entity to face.
     */
    public Face(Character character, IEntity entity) {
        this.character = character;
        this.entity = entity;
    }

    /**
     * Returns the action name.
     * 
     * @return The name of the action, "Face".
     */
    @Override
    public String getName() {
        return "Face";
    }

    /**
     * Determines if the game should wait for this action to complete before proceeding.
     * 
     * @return true, indicating that the game should wait for the character to finish facing the entity.
     */
    @Override
    public boolean getShouldWait() {
        return true;
    }

    /**
     * Provides a string representation of the Face action.
     * 
     * @return A string in the format of "Face(characterName, entityName)".
     */
    @Override
    public String toString() {
        return String.format("%s(%s, %s)", getName(), character.getName(), entity.getName());
    }

    // Additional methods, if necessary
}
