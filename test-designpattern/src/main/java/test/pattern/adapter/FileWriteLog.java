package test.pattern.adapter;

import org.apache.log4j.Logger;

public class FileWriteLog {
	
	private static Logger logger = Logger.getLogger(FileWriteLog.class);
	
	public void writeLog(){
		logger.info("FileWriteLog.writeLog()");
	}

}
