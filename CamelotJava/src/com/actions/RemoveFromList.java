package com.actions;

import com.entities.IEntity;

/**
 * Action for removing an entity from a list.
 */
public class RemoveFromList implements IAction {
    private IEntity entity;

    /**
     * Constructor for RemoveFromList action.
     * 
     * @param entity The entity to be removed from the list.
     */
    public RemoveFromList(IEntity entity) {
        this.entity = entity;
    }

    /**
     * Returns the action name.
     * 
     * @return The name of the action.
     */
    @Override
    public String getName() {
        return "RemoveFromList";
    }

    /**
     * Indicates whether the action should be waited on to complete.
     * 
     * @return true if the action should be waited on, otherwise false.
     */
    @Override
    public boolean getShouldWait() {
        // Assuming we do not need to wait for a remove from list action to complete.
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", getName(), entity.getName());
    }
}
