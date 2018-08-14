package global.sesoc.calendar.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat
public class Car {
	
	private String id;
	private String make;
	private String model;
	private String price;
	private String register_date;
	
	public Car() {}

	public Car(String id, String make, String model, String price, String register_date) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.price = price;
		this.register_date = register_date;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the register_date
	 */
	public String getRegister_date() {
		return register_date;
	}

	/**
	 * @param register_date the register_date to set
	 */
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [id=");
		builder.append(id);
		builder.append(", make=");
		builder.append(make);
		builder.append(", model=");
		builder.append(model);
		builder.append(", price=");
		builder.append(price);
		builder.append(", register_date=");
		builder.append(register_date);
		builder.append("]");
		return builder.toString();
	}

}
