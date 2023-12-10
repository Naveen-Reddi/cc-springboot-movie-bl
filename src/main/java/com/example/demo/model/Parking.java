package com.example.demo.model;
import java.util.Date;

public class Parking {
	private Long parkingId;
	private Long customerId;
	private Date bookDate;
	private Long noOfTwoWheelers;
	private Long noOfFourWheelers;
	private Long price;

	public Parking()
	{
		
	}

	public Parking(Long parkingId, Long customerId, Date bookDate, Long noOfTwoWheelers, Long noOfFourWheelers,
			Long price) {
		super();
		this.parkingId = parkingId;
		this.customerId = customerId;
		this.bookDate = bookDate;
		this.noOfTwoWheelers = noOfTwoWheelers;
		this.noOfFourWheelers = noOfFourWheelers;
		this.price = price;
	}

	public Parking(long parkingId) {
		super();
		this.parkingId= parkingId;
	}

	public Long getParkingId() {
		return parkingId;
	}

	public void setParkingId(Long parkingId) {
		this.parkingId = parkingId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public Long getNoOfTwoWheelers() {
		return noOfTwoWheelers;
	}

	public void setNoOfTwoWheelers(Long noOfTwoWheelers) {
		this.noOfTwoWheelers = noOfTwoWheelers;
	}

	public Long getNoOfFourWheelers() {
		return noOfFourWheelers;
	}

	public void setNoOfFourWheelers(Long noOfFourWheelers) {
		this.noOfFourWheelers = noOfFourWheelers;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Parking [parkingId=" + parkingId + ", customerId=" + customerId + ", bookDate=" + bookDate
				+ ", noOfTwoWheelers=" + noOfTwoWheelers + ", noOfFourWheelers=" + noOfFourWheelers + ", price=" + price
				+ "]";
	}
	
}
