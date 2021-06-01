package Validator;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import constants.CustomerType;
import constants.ErrorConstants;

public class Validator {

	public void validateInput(String input) {
		String datePattern = "[\\s]*[\\d]{2}[\\-][a-zA-Z]{3}[\\-][\\d]{4}[\\s]*";
		String customerTypePattern = "[\\s]*[a-zA-Z]+[\\:]";
		if (!input.matches(customerTypePattern + datePattern + "([\\,]" + datePattern + ")*")) {
			throw new RuntimeException(ErrorConstants.INVALID_INPUT);
		}

	}

	public void validateDateSequence(List<LocalDate> dates) {

		Collections.sort(dates, (date1, date2) -> {
			return date1.compareTo(date2);
		});

		for (int i = 1; i < dates.size(); i++) {
			if (!dates.get(i).equals(dates.get(i - 1).plusDays(1))) {
				throw new RuntimeException(ErrorConstants.NON_SEQUENTIAL_DATES);
			}
		}
	}

	public void validateCustomerType(String customerType) {

		for (CustomerType s : CustomerType.values()) {
			if (s.toString().equalsIgnoreCase(customerType)) {

				return;
			}
		}
		throw new RuntimeException(ErrorConstants.INVALID_CUSTOMER_TYPE);
	}
}
