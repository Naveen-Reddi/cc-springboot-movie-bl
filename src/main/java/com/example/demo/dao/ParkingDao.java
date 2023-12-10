package com.example.demo.dao;

import java.util.List;
import com.example.demo.model.Parking;

public interface ParkingDao {

	int create(Parking parking);

	List<Parking> read();

	Parking read(Long id);

	List<Parking> findBooksByCustomer(Long customer_id);

	int update(Parking parking);

	int delete(Long id);

	Long generateParkingId();

	Parking getParkingId();
}
