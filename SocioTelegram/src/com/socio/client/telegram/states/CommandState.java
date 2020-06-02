package com.socio.client.telegram.states;

public interface CommandState extends State {

	
	public String getCommand();
	public String getDescription();
}
