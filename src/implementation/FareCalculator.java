package implementation;
import java.time.LocalDate;
import java.util.List;

import interfaces.CalculateFare;
import interfaces.Rates;

public class FareCalculator implements CalculateFare {

	@Override
	public double calculateFare(Hotel hotel, String customerType, List<LocalDate>  dates) {
		double totalFare = 0.0d;
		for (LocalDate date : dates) {
			if (isWeekend(date)) {
				totalFare += calculateRateByCustomerType(hotel.getWeekEndRates(), customerType,
						hotel.getBlackoutDates()==null?false:hotel.getBlackoutDates().contains(date));
			} else {
				totalFare += calculateRateByCustomerType(hotel.getWeekDayRates(), customerType,
						hotel.getBlackoutDates()==null?false:hotel.getBlackoutDates().contains(date));
			}
		}
		return totalFare;
	}

	private double calculateRateByCustomerType(Rates rate, String customerType, boolean isBlackOutDate) {
		return rate.ratesOnCustomerType(customerType, isBlackOutDate);
	}

	private boolean isWeekend(LocalDate date) {
		switch (date.getDayOfWeek().getValue()) {

		case 6:
			return true;
		case 7:
			return true;
		}
		return false;
	}

	

}
