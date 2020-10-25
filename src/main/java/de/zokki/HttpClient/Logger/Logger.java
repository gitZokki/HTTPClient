package de.zokki.HttpClient.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
		
	private String prefix;
	
	public Logger(Class<?> clazz, boolean longName) {
		prefix = longName ? clazz.getName() : clazz.getSimpleName();
	}
	
	public Logger(Class<?> clazz) {
		prefix = clazz.getName();
	}
	
	public void newLineInfo(Object... print) {
		for(Object o : print) {
			System.out.println(getMessage(o));
		}
	}
	
	public void info(Object... print) {
		String out = getMessage("");
		for(Object o : print) {
			out += o.toString();
		}
		System.out.println(out);
	}
	
	public void warn(Object... print) {
		for(Object o : print) {
			System.out.println(ConsoleColors.YELLOW + getMessage(o) + ConsoleColors.RESET);
		}
	}
	
	public void error(Object... print) {
		error(null, print);
	}
	
	public void error(Exception e) {
		e.printStackTrace();
	}
	
	public void error(Exception e, Object... print) {
		for(Object o : print) {
			System.out.println(ConsoleColors.RED + getMessage(o) + ConsoleColors.RESET);
		}
		if(e != null) {
			error(e);
		}
	}
	
	
	private String getMessage(Object o) {
		long id = Thread.currentThread().getId();
		String thread = id == 1 ? "[Main]" : "[Thread-" + id + "]";
		return getTime() + " " + thread + " " + prefix + ": " + o + " ";
	}
	
	private String getTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");  
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
}
