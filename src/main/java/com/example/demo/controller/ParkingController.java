package com.example.demo.controller;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Parking;
import com.example.demo.service.ParkingService;

@RestController
@CrossOrigin({"http://localhost:4200","*"})
public class ParkingController {
	
	@Autowired
	private ParkingService ps;
	
	@PostMapping("/park")
	public int addParking(@RequestBody Parking parking)
	{ 
	   System.out.println("add parking "+ parking);	
	   parking.setParkingId(generateBookId());
		return ps.create(parking);
	}
	
	@GetMapping("/park")
	public List<Parking> getAllParkings()
	{
		return ps.read();
	}
	
	@GetMapping("/park/parking/pid")
	public Parking getparkingId() {
		return ps.getParkingId();
	}
	
	@GetMapping("/park/{id}")
	public Parking findParkingById(@PathVariable Long id)
	{
		return ps.read(id);
	}
	
	@GetMapping("/park/customer/{id}")
	public List<Parking> findParkingsByCustomer(@PathVariable Long id)
	{
		return ps.findParkingByCustomer(id);
	}
	
	private Long generateBookId()
	{
		List<Parking> parking = getAllParkings();
		if(parking.size()==0)
		{
			return 1L;
		}
		Long lastIndex=parking.get(parking.size()-1).getParkingId();
		return lastIndex+1;
    }
	
	@PutMapping("/park")
	public int modifyParking(@RequestBody Parking parking)
	{
		return ps.update(parking);
	}
	
	@DeleteMapping("/park/{id}")
	public int removeParking(@PathVariable Long id)
	{
		return ps.delete(id);
	}
}
