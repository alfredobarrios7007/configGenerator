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
public class LoggingToCvsFile { 

	static String unid;
	static String directory;
	
	public static void LoadConfigValues(){
		ReadProperties rProp = new ReadProperties("logging");
		unid = rProp.getValue("servicesLogUnit");
		directory = rProp.getValue("servicesLogDirectory");
	}
		
	public static void writeLog(String logFile, String line) {
		String logFilePath = unid + ":" + directory + "/" + logFile;
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
