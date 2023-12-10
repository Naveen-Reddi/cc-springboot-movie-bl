package com.example.demo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Book;
import com.example.demo.model.Parking;

public class ParkingRowMapper implements RowMapper<Parking> {

	@Override
	public Parking mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Parking parking=null;
			try {
				parking=new Parking(rs.getLong(1),rs.getLong(2), sdf.parse(rs.getString(3)), rs.getLong(4), rs.getLong(5), rs.getLong(6));
			} catch (ParseException e) {
				parking=null;
			}
		return parking;
	}

}
