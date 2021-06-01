package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import implementation.FareCalculator;
import implementation.Hotel;
import implementation.RatesImpl;
import interfaces.Rates;

public class FareCalculatorTester {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");

	public static double testFareCalculation() {
		Rates lakeWoodWeekDayRate = new RatesImpl(110, 80);
		Rates lakeWoodWeekEndRate = new RatesImpl(90, 80);
		Hotel lakeWood = new Hotel("LakeWood", 3, null, lakeWoodWeekDayRate, lakeWoodWeekEndRate);
		FareCalculator fC = new FareCalculator();
		List<LocalDate> dateList = new ArrayList<>();
		dateList.add(LocalDate.parse("31-May-2021", formatter));
		dateList.add(LocalDate.parse("30-May-2021", formatter));
		return fC.calculateFare(lakeWood, "Regular", dateList);

	}
	public static double testFareCalculation2() {
		Rates lakeWoodWeekDayRate = new RatesImpl(110, 80);
		Rates lakeWoodWeekEndRate = new RatesImpl(90, 80);
		Hotel lakeWood = new Hotel("LakeWood", 3, null, lakeWoodWeekDayRate, lakeWoodWeekEndRate);
		FareCalculator fC = new FareCalculator();
		List<LocalDate> dateList = new ArrayList<>();
		dateList.add(LocalDate.parse("31-May-2021", formatter));
		dateList.add(LocalDate.parse("30-May-2021", formatter));
		return fC.calculateFare(lakeWood, "Rewards", dateList);

	}

	public static void main(String[] args) {
		if (testFareCalculation() != 200.0d) {
			System.out.println("testFareCalculation failed");
		}
		if (testFareCalculation2() != 160.0d) {
			System.out.println("testFareCalculation2 failed");
		}
	}
}
