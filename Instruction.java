package robertina.renzi.test;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


public class Instruction {
	
	@JsonProperty("Entity")
	private String entity;
	
	@JsonProperty("Buy/Sell")
	private String operation;
	
	@JsonProperty("AgreedFx")
	@JsonDeserialize(using = DoubleDeserializer.class)
	private Double agreedFx;
	
	@JsonProperty("Currency")
	private String currency;
	
	@JsonProperty("InstructionDate")
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date instructionDate;
	
	@JsonProperty("SettlementDate")
	@JsonFormat
	(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date settlementDate;
	
	@JsonProperty("Units")
	private int units;
	
	@JsonProperty("Price per unit")
	private Double pricePerUnit;
	
	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Double getAgreedFx() {
		return agreedFx;
	}

	public void setAgreedFx(Double agreedFx) {
		this.agreedFx = agreedFx;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public Double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	@Override
	public String toString() {
		return "Instruction [entity=" + entity + ", operation=" + operation + ", agreedFx=" + agreedFx + ", currency="
				+ currency + ", instructionDate=" + instructionDate + ", settlementDate=" + settlementDate + ", units="
				+ units + ", pricePerUnit=" + pricePerUnit + "]";
	}

}
