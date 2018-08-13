package global.sesoc.calendar.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat
public class Car {
	
	private String id;
	private String make;
	private String model;
	private String price;
	
	public Car() {}

	public Car(String id, String model) {
		super();
		this.id = id;
		this.model = model;
	}

	public Car(String id, String make, String model, String price) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.price = price;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model + ", price=" + price + "]";
	}
}
