package es.uam.app.main.exceptions;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletContext;

public class ExceptionControl {
	private final Logger logger = Logger.getLogger("app.main.Logger");
	private static ExceptionControl exceptionControl = null;

	public static ExceptionControl geExceptionControl(ServletContext context) {
		if (exceptionControl == null) {
			String path = context.getInitParameter("project.files")+"/"+context.getInitParameter("log.file");
			exceptionControl = new ExceptionControl(path);
		}
		return exceptionControl;
	}

	private ExceptionControl(String file) {
		try {
			Handler fileHandler = new FileHandler(file, false);
			SimpleFormatter simpleFormatter = new SimpleFormatter();
			fileHandler.setFormatter(simpleFormatter);
			logger.addHandler(fileHandler);
		} catch (SecurityException | IOException e) {

			e.printStackTrace();
		}
	}

	public void printLogger(String s) {
		logger.log(Level.INFO, s);
	}

	public void printLogger(Exception e) {
		logger.log(Level.SEVERE, getStackTrace(e));
	}

	public void printLogger(String s,Exception e) {
		logger.log(Level.SEVERE, s+":"+getStackTrace(e));
	}
	
	public void printLogger(Level level ,String s) {
		logger.log(level, s);
	}

	public void printLogger(Level level ,Exception e) {
		logger.log(level, getStackTrace(e));
	}

	public void printLogger(Level level ,String s,Exception e) {
		logger.log(level, s+":"+getStackTrace(e));
	}
	

	private String getStackTrace(Exception e) {
		StringWriter sWriter = new StringWriter();
		PrintWriter pWriter = new PrintWriter(sWriter);
		e.printStackTrace(pWriter);
		return sWriter.toString();
	}
}
