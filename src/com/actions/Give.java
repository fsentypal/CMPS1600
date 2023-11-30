package com.actions;

import com.entities.Character;
import com.entities.Item;

/**
 * Action for making one character give an item to another character.
 */
public class Give implements IAction {
    Character giver;
    Item item;
    Character receiver;

    /**
     * Constructor for Give action.
     * 
     * @param giver The character that will give the item.
     * @param item The item to be given.
     * @param receiver The character that will receive the item.
     */
    public Give(Character giver, Item item, Character receiver) {
        this.giver = giver;
        this.item = item;
        this.receiver = receiver;
    }

    /**
     * Returns the action name.
     * 
     * @return The name of the action.
     */
    @Override
    public String getName() {
        return "Give";
    }

    /**
     * Indicates whether the action should be waited on to complete.
     * 
     * @return true if the action should be waited on, otherwise false.
     */
    @Override
    public boolean getShouldWait() {
        // Assuming we always want to wait for a give action to complete.
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s(%s, %s, %s)", getName(), giver.getName(), item.getName(), receiver.getName());
    }
}
