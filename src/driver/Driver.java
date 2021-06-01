package driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Validator.Validator;
import constants.ErrorConstants;
import implementation.Hotel;
import implementation.RatesImpl;
import interfaces.Rates;

public class Driver {

	private static List<Hotel> hotels = new ArrayList<>();
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");

	static {
		Rates lakeWoodWeekDayRate = new RatesImpl(110, 80);
		Rates lakeWoodWeekEndRate = new RatesImpl(90, 80);
		Hotel lakeWood = new Hotel("LakeWood", 3, null, lakeWoodWeekDayRate, lakeWoodWeekEndRate);

		Rates bridgewoodWeekDayRate = new RatesImpl(160, 110);
		Rates bridgewoodWeekEndRate = new RatesImpl(60, 50);
		Hotel bridgewood = new Hotel("Bridgewood", 4, null, bridgewoodWeekDayRate, bridgewoodWeekEndRate);

		Rates ridgewoodWeekDayRate = new RatesImpl(220, 100);
		Rates ridgewoodWeekEndRate = new RatesImpl(150, 40);
		Hotel ridgewood = new Hotel("Ridgewood ", 5, null, ridgewoodWeekDayRate, ridgewoodWeekEndRate);

		hotels.add(lakeWood);
		hotels.add(bridgewood);
		hotels.add(ridgewood);

	}

	public static Hotel findCheapestHotel(String customerType, List<LocalDate> dates) {
		FindCheapestHotel fCH = new FindCheapestHotel();
		return fCH.retrieveHighestRatedCheapestHotel(hotels, customerType, dates);
	}

	public static void main(String[] args) {

		Validator validator = new Validator();

		String input = readInput();
		String customerType = input.split(":")[0];
		try {
			validator.validateInput(input);
			validator.validateCustomerType(customerType);
			List<LocalDate> dateList = null;
			dateList=retrieveDatesFromInput(input);
			validator.validateDateSequence(dateList);
			Hotel cheapestHotel = findCheapestHotel(customerType, dateList);
			System.out.println("Cheapest Hotel is: " + cheapestHotel.getName());
		} catch (RuntimeException e) {
			if (e.getMessage().equals(ErrorConstants.INVALID_INPUT)) {
				System.out.println(ErrorConstants.INPUT_FORMAT_MESSAGE + ErrorConstants.INPUT_FORMAT);
			} else if (e.getMessage().equals(ErrorConstants.NON_SEQUENTIAL_DATES)) {
				System.out.println(ErrorConstants.SEQUENTIAL_DATES_MESSAGE);
			} else {
				System.out.println(e.getMessage());
			}
		}

	}

	private static String readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the customer type and the dates for which you intend to book in the format :");
		System.out.println(ErrorConstants.INPUT_FORMAT_MESSAGE);
		String input = null;
		try {
			input = br.readLine().trim();
		} catch (IOException ioe) {
			System.out.println(ioe.getCause());
		}
		return input;
	}

	private static List<LocalDate> retrieveDatesFromInput(String inputString) {
		List<LocalDate> dateList = new ArrayList<>();

		for (String date : inputString.split(":")[1].trim().split("\\,")) {
			dateList.add(LocalDate.parse(date.trim(), formatter));
		}
		return dateList;
	}
}
