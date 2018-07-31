package com.socio.client.command;

import java.io.File;
import java.util.List;

import com.socio.client.beans.EndConsensus;
import com.socio.client.beans.Message;
import com.socio.client.beans.Polling;
import com.socio.client.beans.Project;
import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;

public abstract class Channel {
	public static final SocioCommands SOCIO = SocioCommands.getSOCIO();
	private ReaderUpdateThread reader;

	public Channel() {
		reader = new ReaderUpdateThread();
		reader.start();
	}

	public abstract String getChannelName();

	public abstract void onUpdate(Project p, List<Message> msg, File f);
	public abstract void onPolling(Polling polling);
	public abstract void onEndConsensus(EndConsensus cons);

	private class ReaderUpdateThread extends Thread {

		@Override
		public synchronized void start() {
			try {
				SOCIO.register(getChannelName());
			} catch (ResponseError | ForbiddenResponse e) {
				e.printStackTrace();
			}
			super.start();
		}

		@Override
		public void run() {
			while (true) {
				try {
					List<Project> projects = SOCIO.getUpdates(getChannelName());
					if (!projects.isEmpty()) {
						for (Project p : projects) {
							List<Message> msgs = SOCIO.getUpdate(getChannelName(), p);
							File f = SOCIO.getLastFile(p);
							onUpdate(p, msgs, f);
						}
					}
					List<Polling> pollings = SOCIO.getPolling(getChannelName());
					if (pollings != null) {
						for (Polling polling: pollings) {
							onPolling(polling);
						}
					}
					List<EndConsensus> consensus = SOCIO.getEndConsensus(getChannelName());
					if (consensus != null) {
						for (EndConsensus cons: consensus) {
							onEndConsensus(cons);
						}
					}
					synchronized (this) {
						this.wait(500);
					}

				} catch (ResponseError | ForbiddenResponse e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		
	}


}
