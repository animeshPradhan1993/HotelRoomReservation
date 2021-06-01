package interfaces;

import java.time.LocalDate;
import java.util.List;

import implementation.Hotel;

public interface CalculateFare {

	double calculateFare(Hotel hotel, String customerType, List<LocalDate>  dates);

}
