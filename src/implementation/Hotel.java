package implementation;
import java.time.LocalDate;
import java.util.List;

import interfaces.Rates;

public  class Hotel {
	private String name;
	private float rating;
	private List<LocalDate> blackoutDates;
	private Rates weekDayRates;
	private Rates WeekEndRates;

	public Rates getWeekDayRates() {
		return weekDayRates;
	}

	public void setWeekDayRates(Rates weekDayRates) {
		this.weekDayRates = weekDayRates;
	}

	public Rates getWeekEndRates() {
		return WeekEndRates;
	}

	public void setWeekEndRates(Rates weekEndRates) {
		WeekEndRates = weekEndRates;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public List<LocalDate> getBlackoutDates() {
		return blackoutDates;
	}

	public void setBlackoutDates(List<LocalDate> blackoutDates) {
		this.blackoutDates = blackoutDates;
	}

	public Hotel(String name, float rating, List<LocalDate> blackoutDates, Rates weekDayRates, Rates weekEndRates) {
		super();
		this.name = name;
		this.rating = rating;
		this.blackoutDates = blackoutDates;
		this.weekDayRates = weekDayRates;
		WeekEndRates = weekEndRates;
	}

}
