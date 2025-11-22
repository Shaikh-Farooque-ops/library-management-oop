package com.library.models;

public abstract class Item {

	private int id;
	private String title;
	private String author;
	private boolean isAvailable;

	public Item(int id, String title, String author, boolean isAvailable) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isAvailable = isAvailable;
	}

	public Item() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void markAsAvailable()
	{
		isAvailable = true;
	};
	
	public void markAsUnavailable()
	{
		isAvailable = false;
	};
	
	public abstract void displayDetails();
	
}
