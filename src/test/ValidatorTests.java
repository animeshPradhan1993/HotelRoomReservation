package test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Validator.Validator;
import constants.ErrorConstants;

public class ValidatorTests {
	static Validator validator = new Validator();
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");

	public static String validateInputTest() {
		try {
			String input = "Regular: 20/Mar-2009, 21-Mar-2009, 22-Mar-2009";
			validator.validateInput(input);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "";

	}

	public static String validateInputTest1() {
		try {
			String input = "Regular: 20-03-2009, 21-Mar-2009, 22-Mar-2009";
			validator.validateInput(input);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "";
	}

	public static String validateInputTest2() {
		try {
			String input = "Regular: 20-Mar-2009, 21-Mar-2009, 22-Mar-2009";
			validator.validateInput(input);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "";
	}

	public static String validateDateSequenceTest() {
		try {
			List<LocalDate> dateList = new ArrayList<>();
			dateList.add(LocalDate.parse("31-May-2021", formatter));
			dateList.add(LocalDate.parse("28-May-2021", formatter));
			validator.validateDateSequence(dateList);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "";
	}

	public static String validateDateSequenceTest1() {
		try {
			List<LocalDate> dateList = new ArrayList<>();
			dateList.add(LocalDate.parse("31-May-2021", formatter));
			dateList.add(LocalDate.parse("30-May-2021", formatter));
			validator.validateDateSequence(dateList);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "";
	}

	public static String validateCustomerTest() {
		try {

			validator.validateCustomerType("animesh");
			;
		} catch (Exception e) {
			return e.getMessage();
		}
		return "";
	}

	public static String validateCustomerTest1() {
		try {

			validator.validateCustomerType("Regular");
			;
		} catch (Exception e) {
			return e.getMessage();
		}
		return "";
	}

	public static String validateCustomerTest2() {
		try {

			validator.validateCustomerType("ReWARDs");
			;
		} catch (Exception e) {
			return e.getMessage();
		}
		return "";
	}

	public static void main(String[] args) {
		if (!validateInputTest().equals(ErrorConstants.INVALID_INPUT)) {
			System.out.println("validateInputTest failed");
		} else {
			System.out.println("validateInputTest passed");
		}
		if (!validateInputTest1().equals(ErrorConstants.INVALID_INPUT)) {
			System.out.println("validateInputTest1 failed");
		} else {
			System.out.println("validateInputTest1 passed");
		}
		if (!validateInputTest2().equals("")) {
			System.out.println("validateInputTest2 failed");
		} else {
			System.out.println("validateInputTest2 passed");
		}
		if (!validateDateSequenceTest().equals(ErrorConstants.NON_SEQUENTIAL_DATES)) {
			System.out.println("validateDateSequenceTest failed");
		} else {
			System.out.println("validateDateSequenceTest passed");
		}
		if (!validateDateSequenceTest1().equals("")) {
			System.out.println("validateDateSequenceTest1 failed");
		} else {
			System.out.println("validateDateSequenceTest1 passed");
		}
		if (!validateCustomerTest().equals(ErrorConstants.INVALID_CUSTOMER_TYPE)) {
			System.out.println("validateCustomerTest failed");
		} else {
			System.out.println("validateCustomerTest passed");
		}
		if (!validateCustomerTest1().equals("")) {
			System.out.println("validateCustomerTest1 failed");
		} else {
			System.out.println("validateDateSequenceTest1 passed");
		}
		if (!validateCustomerTest2().equals("")) {
			System.out.println("validateCustomerTest2 failed");
		} else {
			System.out.println("validateCustomerTest2 passed");
		}

	}
}
