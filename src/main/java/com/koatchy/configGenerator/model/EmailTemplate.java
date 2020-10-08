package com.koatchy.configGenerator.model;

public class EmailTemplate {
	private String host;
	private Integer port;
	private String from;
	private String to;
	private String subject;
	private String message;


	public EmailTemplate() {
	
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(Integer port) {
		this.port = port;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
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
	 * @param host
	 * @param port
	 * @param from
	 * @param to
	 * @param subject
	 * @param message
	 */
	public EmailTemplate(String host, Integer port, String from, String to, String subject, String message) {
		this.host = host;
		this.port = port;
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.message = message;
	}

	@Override
	public String toString() {
		return "EmailTemplate [" + (host != null ? "host=" + host + ", " : "")
				+ (port != null ? "port=" + port + ", " : "") + (from != null ? "from=" + from + ", " : "")
				+ (to != null ? "to=" + to + ", " : "") + (subject != null ? "subject=" + subject + ", " : "")
				+ (message != null ? "message=" + message : "") + "]";
	}
	
	
	
}
