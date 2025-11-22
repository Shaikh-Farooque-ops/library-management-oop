package com.library.models;

public class AudioBook extends Item {

	private int duration;
	private String narrator;

	public AudioBook(int id, String title, String author, boolean isAvailable, int duration, String narrator) {
		super(id, title, author, isAvailable);
		this.duration = duration;
		this.narrator = narrator;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getNarrator() {
		return narrator;
	}

	public void setNarrator(String narrator) {
		this.narrator = narrator;
	}

	@Override
	public void displayDetails() {
		
		System.out.println("ID: " + getId());
	    System.out.println("Title: " + getTitle());
	    System.out.println("Author: " + getAuthor());
	    System.out.println("Available: " + isAvailable());
		
		System.out.println("AudioBook Duration :" + getDuration());
		System.out.println("AudioBook Narrtor :" + getNarrator());
	}

}
