package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDao;
import com.example.demo.dao.ParkingDao;
import com.example.demo.model.Parking;

@Service
public class ParkingService {
	
	@Autowired
	private ParkingDao pdao;

	public int create(Parking parking) {
		// TODO Auto-generated method stub
		return pdao.create(parking);
	}

	public List<Parking> read() {
		// TODO Auto-generated method stub
		return pdao.read();
	}

	public Parking getParkingId() {
		// TODO Auto-generated method stub
		return  pdao.getParkingId();
	}

	public Parking read(Long id) {
		// TODO Auto-generated method stub
		return pdao.read(id);
	}

	public List<Parking> findParkingByCustomer(Long customer_id) {
		// TODO Auto-generated method stub
		return pdao.findBooksByCustomer(customer_id);
	}

	public int update(Parking parking) {
		// TODO Auto-generated method stub
		return pdao.update(parking);
	}

	public int delete(Long id) {
		// TODO Auto-generated method stub
		return pdao.delete(id);
	}

	public Long generateBookId() {
		// TODO Auto-generated method stub
		return pdao.generateParkingId();
	}
}
