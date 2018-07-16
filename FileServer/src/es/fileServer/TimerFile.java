package es.fileServer;


import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import SaveFile.SavedFiles;

public class TimerFile extends TimerTask{

	private String key;
	private SavedFiles savedFiles;
	
	
	private static Timer timer = new Timer();
	
	public TimerFile(String key, SavedFiles savedFiles, TimeUnit unit, long duration) {
		super();
		this.key = key;
		this.savedFiles = savedFiles;
		timer.schedule(this, unit.toMillis(duration));
	}
	public TimerFile(String key, SavedFiles savedFiles) {
		super();
		this.key = key;
		this.savedFiles = savedFiles;
		timer.schedule(this, TimeUnit.DAYS.toMillis(1));
	}
	
	@Override
	public void run() {
		savedFiles.deleteFile(key);
	}
}
