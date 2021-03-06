package com.socio.client.twitter;

import java.util.ArrayList;
import java.util.List;


import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;

public class TwitterMain {

	public static void main(String[] args) {
		
		String debug=TwitterControl.SOCIO;
		for (String s: args) {
			if (s.equalsIgnoreCase("debug")) {
				debug=TwitterControl.TEST;
			}
		}
		
		try {
			init();
			TwitterControl.getTwitterControl(debug);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static void init() throws Exception{
		List<Class<? extends HashTag>> commands=new ArrayList<Class<? extends HashTag>>();
		new FastClasspathScanner(HashTag.class.getPackage().getName())
		.matchClassesImplementing(HashTag.class, commands::add).scan();
		
		for (Class<? extends HashTag> tc: commands){
			TwitterControl.regiterCommandHashtag(tc);
		}
	}
}
