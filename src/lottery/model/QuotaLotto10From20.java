package lottery.model;

public enum QuotaLotto10From20 {

	ONE_NUMBER(1.95),
	TWO_NUMBERS(4.00),
	THREE_NUMBERS(9.00),
	FOUR_NUMBERS(21.00),
	FIVE_NUMBERS(55.00),
	SIX_NUMBERS(165.00),
	SEVEN_NUMBERS(550.00),
	EIGHT_NUMEBRS(2200.00),
	NINE_NUMBERS(5500.00),
	TEN_NUMEBRS(15000.00);
	
	private Double quotaLotto;

	public Double getQuotaLotto() {
		return quotaLotto;
	}

	public void setQuotaLotto(Double quotaLotto) {
		this.quotaLotto = quotaLotto;
	}
	
	private QuotaLotto10From20(Double quotaLotto) {
		this.quotaLotto=quotaLotto;
	}
}
