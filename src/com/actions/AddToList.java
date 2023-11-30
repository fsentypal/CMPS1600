package com.actions;

import com.entities.IEntity;

/**
 * Action for adding an entity to a list with an optional description.
 */
public class AddToList implements IAction {
    IEntity entity;
    String description;

    /**
     * Constructor for AddToList action with description.
     * 
     * @param entity The entity to be added to the list.
     * @param description The description of the entity.
     */
    public AddToList(IEntity entity, String description) {
        this.entity = entity;
        this.description = description;
    }

    /**
     * Constructor for AddToList action without description.
     * 
     * @param entity The entity to be added to the list.
     */
    public AddToList(IEntity entity) {
        this(entity, ""); // Call the main constructor with an empty description.
    }

    /**
     * Returns the action name.
     * 
     * @return The name of the action.
     */
    @Override
    public String getName() {
        return "AddToList";
    }

    /**
     * Indicates whether the action should be waited on to complete.
     * 
     * @return true if the action should be waited on, otherwise false.
     */
    @Override
    public boolean getShouldWait() {
        // Assuming we do not need to wait for an add to list action to complete.
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s(%s, \"%s\")", getName(), entity.getName(), description);
    }
}
