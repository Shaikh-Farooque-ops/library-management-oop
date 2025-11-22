package com.library.models;

public class Book extends Item {

	private int pages;
	private String genre;

	public Book(int id, String title, String author, boolean isAvailable, int pages, String genre) {
		super(id, title, author, isAvailable);
		this.pages = pages;
		this.genre = genre;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public void displayDetails() {

	}

}
