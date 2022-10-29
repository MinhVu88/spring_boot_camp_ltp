package com.udemy.ltp.spring_boot_camp.workbooks.sec_8.workbook_2_2;

public class Show {
	private String title;
	private String episode;
	private double rating;

	public Show() {}

	public Show(String title, String episode, double rating) {
		this.title = title;
		this.episode = episode;
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEpisode() {
		return episode;
	}

	public void setEpisode(String episode) {
		this.episode = episode;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
}
