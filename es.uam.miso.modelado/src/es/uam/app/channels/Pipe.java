package es.uam.app.channels;

import java.util.ArrayDeque;
import java.util.Queue;

import es.uam.app.message.ReceivedMessage;

public class Pipe {

	private Queue<ReceivedMessage> messages;
	
	public Pipe() {
		messages=new  ArrayDeque<ReceivedMessage>();
	}
	
	public synchronized void write(ReceivedMessage m) {
		messages.offer(m);
		notify();
	}
	
	public synchronized ReceivedMessage read(){
		while (messages.isEmpty()){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ReceivedMessage m=messages.poll();
		return m;
	}
}
