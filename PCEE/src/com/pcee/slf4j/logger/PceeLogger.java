package com.pcee.slf4j.logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.Marker;

public class PceeLogger implements Logger{

	private List<LogModule> logModules;
	
	private String name;
	
	private String shortName;
	
	public PceeLogger(String name) {
		this.name = name;
		this.logModules = new ArrayList<LogModule>();
		logModules.add(new ConsoleLogModule());
		this.shortName = name.substring(name.lastIndexOf(".") + 1);
	}

	public PceeLogger(String name, List<LogModule> logModules) {
		this.name = name;
		this.logModules = logModules;
		this.shortName = name.substring(name.lastIndexOf(".") + 1);
	}

	

	
	private String getMarker (LogLevelEnum level) {
		return "[" + level + "-" + shortName + "]";
	}
	
	private void log (LogLevelEnum level, String msg) {
		Iterator<LogModule> iter = logModules.iterator();
		String out = getMarker(level) + msg; 
		while(iter.hasNext()) {
			iter.next().log(level, out);
		}
	}
	
	private void log (LogLevelEnum level, String arg0, Object arg1) {
		String out = arg0 + "[" + arg1.toString() + "]";
		log (level, out);
	}
	
	private void log(LogLevelEnum level, String arg0, Object... arg1) {
		String arrString = "[";
		for (int i=0;i<arg1.length; i++) {
			arrString += arg1[i].toString() + ",";
		}
		arrString = arrString.substring(0, arrString.length()-1) + "]";
		String out = arg0 + arrString;
		log (level, out);
	}
	
	private void log(LogLevelEnum level, String arg0, Throwable arg1) {
		String out = arg0 + ":" + arg1.getStackTrace().toString();
		log (level, out);
	}
	
	private void log(LogLevelEnum level, Marker arg0, String arg1) {
		String out = arg0 + ":" + arg1;
		log(level, out);		
	}

	private void log(LogLevelEnum level, String arg0, Object arg1, Object arg2) {
		String out =  arg0 + "[" + arg1 + "," + arg2 + "]";
		log(level, out);
	}
	
	private void log(LogLevelEnum level, Marker arg0, String arg1, Object arg2) {
		String out = arg0 + "[" + arg1 + "," + arg2 + "]";
		log (level, out);
	}

	private void log(LogLevelEnum level, Marker arg0, String arg1, Object... arg2) {
		String arrString = "[";
		for (int i=0;i<arg2.length; i++) {
			arrString += arg2[i].toString() + ",";
		}
		arrString = arrString.substring(0, arrString.length()-1) + "]";
		String out = arg0 + "[" + arg1 + "," + arrString + "]";
		log(level, out);		
	}
	
	private void log(LogLevelEnum level, Marker arg0, String arg1, Throwable arg2) {
		String out = arg0 + "-" + arg1 +":" + arg2.getStackTrace().toString();
		log(level, out);
	}

	private void log(LogLevelEnum level, Marker arg0, String arg1, Object arg2, Object arg3) {
		String out = arg0 + "-" + arg1 +"[" + arg2 + "," + arg3 + "]";
		log(LogLevelEnum.DEBUG, out);
	}

	
	@Override
	public void debug(String arg0) {
		log (LogLevelEnum.DEBUG, arg0);
	}

	@Override
	public void debug(String arg0, Object arg1) {
		log (LogLevelEnum.DEBUG, arg0, arg1);
	}

	@Override
	public void debug(String arg0, Object... arg1) {
		log (LogLevelEnum.DEBUG, arg0, arg1);
	}

	@Override
	public void debug(String arg0, Throwable arg1) {
		log(LogLevelEnum.DEBUG, arg0 , arg1);
	}

	@Override
	public void debug(Marker arg0, String arg1) {
		log(LogLevelEnum.DEBUG, arg0, arg1);		
	}

	@Override
	public void debug(String arg0, Object arg1, Object arg2) {
		log(LogLevelEnum.DEBUG, arg0, arg1 , arg2);		
	}

	@Override
	public void debug(Marker arg0, String arg1, Object arg2) {
		log(LogLevelEnum.DEBUG, arg0, arg1, arg2);		
	}

	@Override
	public void debug(Marker arg0, String arg1, Object... arg2) {
		log(LogLevelEnum.DEBUG, arg0, arg1, arg2);		
	}

	@Override
	public void debug(Marker arg0, String arg1, Throwable arg2) {
		log(LogLevelEnum.DEBUG, arg0, arg1, arg2);		
	}

	@Override
	public void debug(Marker arg0, String arg1, Object arg2, Object arg3) {
		log(LogLevelEnum.DEBUG, arg0, arg1, arg2, arg3);
	}

	
	
	@Override
	public void error(String arg0) {
		log (LogLevelEnum.ERROR, arg0);
	}

	@Override
	public void error(String arg0, Object arg1) {
		log (LogLevelEnum.ERROR, arg0, arg1);
	}

	@Override
	public void error(String arg0, Object... arg1) {
		log (LogLevelEnum.ERROR, arg0, arg1);
	}

	@Override
	public void error(String arg0, Throwable arg1) {
		log (LogLevelEnum.ERROR, arg0, arg1);
	}

	@Override
	public void error(Marker arg0, String arg1) {
		log (LogLevelEnum.ERROR, arg0, arg1);
	}

	@Override
	public void error(String arg0, Object arg1, Object arg2) {
		log (LogLevelEnum.ERROR, arg0, arg1, arg2);
	}

	@Override
	public void error(Marker arg0, String arg1, Object arg2) {
		log (LogLevelEnum.ERROR, arg0, arg1, arg2);
	}

	@Override
	public void error(Marker arg0, String arg1, Object... arg2) {
		log (LogLevelEnum.ERROR, arg0, arg1, arg2);
	}

	@Override
	public void error(Marker arg0, String arg1, Throwable arg2) {
		log (LogLevelEnum.ERROR, arg0, arg1, arg2);
	}

	@Override
	public void error(Marker arg0, String arg1, Object arg2, Object arg3) {
		log (LogLevelEnum.ERROR, arg0, arg1, arg2, arg3);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void info(String arg0) {
		log(LogLevelEnum.INFO, arg0);
	}

	@Override
	public void info(String arg0, Object arg1) {
		log(LogLevelEnum.INFO, arg0, arg1);
	}

	@Override
	public void info(String arg0, Object... arg1) {
		log(LogLevelEnum.INFO, arg0, arg1);
	}

	@Override
	public void info(String arg0, Throwable arg1) {
		log(LogLevelEnum.INFO, arg0, arg1);
	}

	@Override
	public void info(Marker arg0, String arg1) {
		log(LogLevelEnum.INFO, arg0, arg1);
	}

	@Override
	public void info(String arg0, Object arg1, Object arg2) {
		log(LogLevelEnum.INFO, arg0, arg1, arg2);
	}

	@Override
	public void info(Marker arg0, String arg1, Object arg2) {
		log(LogLevelEnum.INFO, arg0, arg1, arg2);
	}

	@Override
	public void info(Marker arg0, String arg1, Object... arg2) {
		log(LogLevelEnum.INFO, arg0, arg1, arg2);
	}

	@Override
	public void info(Marker arg0, String arg1, Throwable arg2) {
		log(LogLevelEnum.INFO, arg0, arg1, arg2);
	}

	@Override
	public void info(Marker arg0, String arg1, Object arg2, Object arg3) {
		log(LogLevelEnum.INFO, arg0, arg1, arg2, arg3);
	}

	@Override
	public boolean isDebugEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDebugEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isErrorEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isErrorEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInfoEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInfoEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTraceEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTraceEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWarnEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWarnEnabled(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void trace(String arg0) {
		log(LogLevelEnum.TRACE, arg0);
	}

	@Override
	public void trace(String arg0, Object arg1) {
		log(LogLevelEnum.TRACE, arg0, arg1);
	}

	@Override
	public void trace(String arg0, Object... arg1) {
		log(LogLevelEnum.TRACE, arg0, arg1);
	}

	@Override
	public void trace(String arg0, Throwable arg1) {
		log(LogLevelEnum.TRACE, arg0, arg1);
	}

	@Override
	public void trace(Marker arg0, String arg1) {
		log(LogLevelEnum.TRACE, arg0, arg1);
	}

	@Override
	public void trace(String arg0, Object arg1, Object arg2) {
		log(LogLevelEnum.TRACE, arg0, arg1, arg2);
	}

	@Override
	public void trace(Marker arg0, String arg1, Object arg2) {
		log(LogLevelEnum.TRACE, arg0, arg1, arg2);
	}

	@Override
	public void trace(Marker arg0, String arg1, Object... arg2) {
		log(LogLevelEnum.TRACE, arg0, arg1, arg2);
	}

	@Override
	public void trace(Marker arg0, String arg1, Throwable arg2) {
		log(LogLevelEnum.TRACE, arg0, arg1, arg2);
	}

	@Override
	public void trace(Marker arg0, String arg1, Object arg2, Object arg3) {
		log(LogLevelEnum.TRACE, arg0, arg1, arg2, arg3);
	}

	@Override
	public void warn(String arg0) {
		log(LogLevelEnum.WARN, arg0);
	}

	@Override
	public void warn(String arg0, Object arg1) {
		log(LogLevelEnum.WARN, arg0, arg1);
	}

	@Override
	public void warn(String arg0, Object... arg1) {
		log(LogLevelEnum.WARN, arg0, arg1);
	}

	@Override
	public void warn(String arg0, Throwable arg1) {
		log(LogLevelEnum.WARN, arg0, arg1);
	}

	@Override
	public void warn(Marker arg0, String arg1) {
		log(LogLevelEnum.WARN, arg0, arg1);
	}

	@Override
	public void warn(String arg0, Object arg1, Object arg2) {
		log(LogLevelEnum.WARN, arg0, arg1, arg2);
	}

	@Override
	public void warn(Marker arg0, String arg1, Object arg2) {
		log(LogLevelEnum.WARN, arg0, arg1, arg2);
	}

	@Override
	public void warn(Marker arg0, String arg1, Object... arg2) {
		log(LogLevelEnum.WARN, arg0, arg1, arg2);
	}

	@Override
	public void warn(Marker arg0, String arg1, Throwable arg2) {
		log(LogLevelEnum.WARN, arg0, arg1, arg2);
	}

	@Override
	public void warn(Marker arg0, String arg1, Object arg2, Object arg3) {
		log(LogLevelEnum.WARN, arg0, arg1, arg2, arg3);
	}

}
