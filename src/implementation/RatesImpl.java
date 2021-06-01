package implementation;
import constants.CustomerType;
import interfaces.Rates;

public class RatesImpl implements Rates {
	private float RegularCustomerRate;
	private float RewardsCustomerRate;
	
	
	public float getRegularCustomerRate() {
		return RegularCustomerRate;
	}

	public void setRegularCustomerRate(float regularCustomerRate) {
		RegularCustomerRate = regularCustomerRate;
	}

	public float getRewardsCustomerRate() {
		return RewardsCustomerRate;
	}

	public void setRewardsCustomerRate(float rewardsCustomerRate) {
		RewardsCustomerRate = rewardsCustomerRate;
	}

	@Override
	public float ratesOnCustomerType(String customerType, boolean isBlackOutDate) {
		if(customerType.equalsIgnoreCase(CustomerType.Rewards.toString()) && !isBlackOutDate) {
			
			return getRewardsCustomerRate();
		}
		return getRegularCustomerRate();
	}

	public RatesImpl(float regularCustomerRate, float rewardsCustomerRate) {
		super();
		RegularCustomerRate = regularCustomerRate;
		RewardsCustomerRate = rewardsCustomerRate;
	}
	
	

}
