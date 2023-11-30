package com.actions;

public class SetDialog implements IAction{
	String dialog;
	
	public SetDialog(String dialog) {
		this.dialog = dialog;	
	}
	
	@Override
	public String getName() {
		return "SetDialog";
	}
	
	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s)", getName(), dialog);
	}
}
