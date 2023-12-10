package com.example.demo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.example.demo.model.Parking;

public class ParkingIdRowMapper implements RowMapper<Parking> {


	@Override
	public Parking mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new Parking(rs.getLong(1));
	}
}
