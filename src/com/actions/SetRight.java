package com.actions;
import com.entities.Character;
public class SetRight implements IAction{
	private Character name;
	
	public SetRight(Character name) {
		this.name = name;
	}
	
	public String getName() {
		return "SetRight";
	}
	
	public boolean getShouldWait() {
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName(), name.getName());
	}
}
