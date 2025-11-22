package com.library.models;

public class EBook extends Item {

	private int fileSize;
	private String format;

	public EBook(int id, String title, String author, boolean isAvailable, int fileSize, String format) {
		super(id, title, author, isAvailable);
		this.fileSize = fileSize;
		this.format = format;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public void displayDetails() {

	}

}
