package com.actions;
import com.entities.Character;
public class SetLeft implements IAction{
	private Character name;
	public SetLeft(Character name) {
		this.name = name;
	}
	public String getName() {
		return "SetLeft";
	}
	public boolean getShouldWait() {
		return true;
	}
	public String toString() {
		return String.format("%s(%s)", getName(), name.getName());
	}
}
