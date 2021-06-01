package interfaces;

public interface Rates {
	float getRegularCustomerRate();

	void setRegularCustomerRate(float regularCustomerRate);

	float getRewardsCustomerRate();

	void setRewardsCustomerRate(float rewardsCustomerRate);
	
	float ratesOnCustomerType(String customerType,boolean isBlackOutDate);
}
