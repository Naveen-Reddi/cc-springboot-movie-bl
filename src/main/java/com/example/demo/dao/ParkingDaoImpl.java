package com.example.demo.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.mappers.BookRowMapper;
import com.example.demo.mappers.BookingIdRowMapper;
import com.example.demo.mappers.MyBookRowMapper;
import com.example.demo.mappers.ParkingIdRowMapper;
import com.example.demo.mappers.ParkingRowMapper;
import com.example.demo.model.Book;
import com.example.demo.model.Parking;

@Component
public class ParkingDaoImpl implements ParkingDao  {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Parking parking) {
		// TODO Auto-generated method stub
		System.out.println("Insert Parking Details: "+ parking);
		return jdbcTemplate.update("INSERT INTO parking VALUES (?,?,?,?,?,?)", parking.getParkingId(), parking.getCustomerId(), parking.getBookDate(), parking.getNoOfTwoWheelers(), parking.getNoOfFourWheelers(), parking.getPrice() );
	}

	@Override
	public List<Parking> read() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM parking ", new ParkingRowMapper());
	}

	@Override
	public Parking read(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("SELECT * FROM parking WHERE parkingId=?", new ParkingRowMapper(), id);
	}

	@Override
	public List<Parking> findBooksByCustomer(Long customer_id) {
		// TODO Auto-generated method stub
		//return jdbcTemplate.query("SELECT p.parkingId, p.bookingDate, p.noOfTwoWheelers, p.noOfFourWheelers, p.price FROM parking p where p.customer_Id = ?", new ParkingRowMapper(), customer_id);
		return jdbcTemplate.query("select * from parking p where p.customer_Id = ?", new ParkingRowMapper(), customer_id);

	}

	@Override
	public int update(Parking parking) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("UPDATE parking SET customer_id=?, bookingDate=?, noOfTwoWheelers=?, noOfFourWheelers=?, price=? WHERE parkingId=?", parking.getCustomerId(),parking.getBookDate(),parking.getNoOfTwoWheelers(), parking.getNoOfFourWheelers(),parking.getPrice(), parking.getParkingId());
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("DELETE FROM parking WHERE parking=?",id);
	}

	@Override
	public Long generateParkingId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parking getParkingId() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("SELECT MAX(parkingId) FROM parking ", new ParkingIdRowMapper());
	}


	
}
