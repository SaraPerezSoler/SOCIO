package es.uam.app.channels;

import java.util.ArrayDeque;
import java.util.Queue;

import projectHistory.Msg;

public class Pipe {

	private Queue<Msg> messages;
	
	public Pipe() {
		messages=new  ArrayDeque<Msg>();
	}
	
	public synchronized void write(Msg m) {
		messages.offer(m);
		notify();
	}
	
	public synchronized Msg read(){
		while (messages.isEmpty()){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Msg m=messages.poll();
		return m;
	}
}
