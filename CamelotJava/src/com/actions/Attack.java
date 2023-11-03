package com.actions;

import com.entities.Character;

/**
 * Action for a character to attack another character.
 */
public class Attack implements IAction {
    private Character attacker;
    private Character victim;
    private boolean attackHits;

    /**
     * Constructor for Attack action where the attack hits is not specified and defaults to false.
     *
     * @param attacker The character performing the attack.
     * @param victim   The character who is being attacked.
     */
    public Attack(Character attacker, Character victim) {
        this(attacker, victim, false); // Default attackHits to false
    }

    /**
     * Constructor for Attack action where the attack hits is specified.
     *
     * @param attacker    The character performing the attack.
     * @param victim      The character who is being attacked.
     * @param attackHits  Whether the attack hits the victim or not.
     */
    public Attack(Character attacker, Character victim, boolean attackHits) {
        this.attacker = attacker;
        this.victim = victim;
        this.attackHits = attackHits;
    }

    /**
     * Returns the action name.
     *
     * @return The name of the action.
     */
    @Override
    public String getName() {
        return "Attack";
    }

    /**
     * Indicates whether the action should be waited on to complete.
     *
     * @return true if the action should be waited on, otherwise false.
     */
    @Override
    public boolean getShouldWait() {
        // Assuming we need to wait for an attack action to complete.
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s(%s, %s, %s)", getName(), attacker.getName(), victim.getName(), attackHits);
    }
}
