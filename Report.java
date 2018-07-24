package robertina.renzi.test;

import java.util.Comparator;

public class Report {
	private String entity;
	private String currency;
	private Double amount;

	public Report(String entity, String currency, Double amount) {
		this.entity = entity;
		this.currency = currency;
		this.amount = amount;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return '\n' + "entity=" + entity + ", currency=" + currency + ", amount=" + amount + " UDP ";
	}

	public static Comparator<Report> getCompByAmount() {
		Comparator comp = new Comparator<Report>() {

			public int compare(Report o1, Report o2) {
				return o1.amount > o2.amount ? -1 : o1.amount == o2.amount ? 0 : 1;
			}
		};
		return comp;
	}

}
