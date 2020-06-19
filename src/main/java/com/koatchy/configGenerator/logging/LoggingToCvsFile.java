/**
 * 
 */
package com.koatchy.configGenerator.logging;

import java.io.*;
import com.koatchy.configGenerator.tools.ReadProperties;

/**
 * @author alfredo.barrios
 *
 * Write CDR file
 *
 */
public class LoggingToCvsFile implements ILogging{

	String unid;
	String directory;
	String logFile;
	
	public LoggingToCvsFile(String logFile){
		ReadProperties rProp = new ReadProperties("logging");
		this.unid = rProp.getValue("servicesLogUnit");
		this.directory = rProp.getValue("servicesLogDirectory");
		this.logFile = logFile;
	}
		
	public void writeLog(String line) {
		String logFilePath = this.unid + ":" + this.directory + "/" + this.logFile;
		//System.out.print("LoggingToCvsFile.writeLog: " + logFilePath + "\n");
		try(FileWriter fw = new FileWriter(logFilePath, true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter out = new PrintWriter(bw))
		{
			out.println(line);
		} catch (IOException err) {
			System.err.println("Exception LoggingToCvsFile.writeLog thrown: " + err.getMessage() + "\n");
			//exception handling left as an exercise for the reader
		}
	}
}
