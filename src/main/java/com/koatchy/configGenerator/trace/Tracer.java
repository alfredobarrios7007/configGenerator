package com.koatchy.configGenerator.trace;

import java.io.Serializable;

/**
 * @author alfredo.barrios
 *
 */
public class Tracer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String classNameMethod;
	private String successfulError;
	private String message;
	private Tracer son;
	/**
	 * @return the classNameMethod
	 */
	public String getClassNameMethod() {
		return classNameMethod;
	}
	/**
	 * @param classNameMethod the classNameMethod to set
	 */
	public void setClassNameMethod(String classNameMethod) {
		this.classNameMethod = classNameMethod;
	}
	/**
	 * @return the successfulError
	 */
	public String getSuccessfulError() {
		return successfulError;
	}
	/**
	 * @param successfulError the successfulError to set
	 */
	public void setSuccessfulError(String successfulError) {
		this.successfulError = successfulError;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the son
	 */
	public Tracer getSon() {
		return son;
	}
	/**
	 * @param son the son to set
	 */
	public void setSon(Tracer son) {
		this.son = son;
	}
	@Override
	public String toString() {
		return "Tracer [" + (classNameMethod != null ? "classNameMethod=" + classNameMethod + ", " : "")
				+ (successfulError != null ? "successfulError=" + successfulError + ", " : "")
				+ (message != null ? "message=" + message + ", " : "") + (son != null ? "son=" + son.toString() : "") + "]\n";
	}
	/**
	 * 
	 */
	public Tracer() {}
	/**
	 * @param classNameMethod
	 * @param successfulError
	 * @param message
	 * @param son
	 */
	public Tracer(String classNameMethod, String successfulError, String message, Tracer son) {
		this.classNameMethod = classNameMethod;
		this.successfulError = successfulError;
		this.message = message;
		this.son = son;
	}
	
	
}
