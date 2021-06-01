package driver;

import java.time.LocalDate;
import java.util.List;

import implementation.FareCalculator;
import implementation.Hotel;
import interfaces.CalculateFare;

public class FindCheapestHotel {
	private double lowestFare = Double.MAX_VALUE;

	public Hotel retrieveHighestRatedCheapestHotel(List<Hotel> hotels, String customerType, List<LocalDate>  dates) {
		CalculateFare fareCalculator = new FareCalculator();
		Hotel highestRatedCheapestHotel = null;

		for (Hotel hotel : hotels) {
			highestRatedCheapestHotel = compareHotelsForMinimumFare(highestRatedCheapestHotel, hotel,
					fareCalculator.calculateFare(hotel, customerType, dates));

		}
		return highestRatedCheapestHotel;
	}

	private Hotel compareHotelsForMinimumFare(Hotel hotel1, Hotel hotel2, double calculatedFare) {
		if (null == hotel1) {
			lowestFare = calculatedFare;
			return hotel2;
		}
		if (calculatedFare > lowestFare) {
			return hotel1;
		} else if (calculatedFare < lowestFare) {
			lowestFare = calculatedFare;
			return hotel2;
		}
		return hotel1.getRating() > hotel2.getRating() ? hotel1 : hotel2;
	}
}
