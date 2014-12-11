package test.pattern.adapter;

public class FileWriteLogAdapter implements IFileWriteLogger {
	
	private FileWriteLog fileWriteLog;
	
	public FileWriteLogAdapter(FileWriteLog fileWriteLog) {
		this.fileWriteLog = fileWriteLog;
	}

	public void writeLogToFile() {
		this.fileWriteLog.writeLog();
	}

}
