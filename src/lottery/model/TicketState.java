package lottery.model;

public enum TicketState {

	WINNER,
	NOT_WINNER;
	
	private String ticketState;

	public String getTicketState() {
		return ticketState;
	}

	public void setTicketState(String ticketState) {
		this.ticketState = ticketState;
	}
	
}
