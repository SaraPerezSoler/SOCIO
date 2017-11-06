package es.uam.app.message;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SendBranchOptions extends SendMessageExc {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String, File> branchs=new HashMap<String,File>();
	private Map<String, Integer> voting=new HashMap<String,Integer>();

	public SendBranchOptions(String message, File png) {
		super(message, png);
		// TODO Auto-generated constructor stub
	}
	

}
