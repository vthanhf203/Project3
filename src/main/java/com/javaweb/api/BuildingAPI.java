package com.javaweb.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.model.ErrorResponseDTO;
import com.javaweb.service.BuildingService;

import customexception.FieldRequiredException;

@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;
	@GetMapping(value = "/api/building/")
		public List<BuildingDTO> getBuilding(@RequestParam(name="name", required = false) String name,
											 @RequestParam(name="districtid", required = false) Long district,
											 @RequestParam(name="typeCode", required = false) List<String> typeCode) {
		List<BuildingDTO> result = buildingService.findAll(name,district);
		return result;
}
//	public void valiDate(BuildingDTO buildingDTO) throws FieldRequiredException {
//		if(buildingDTO.getName() == null || buildingDTO.getName().equals("") || buildingDTO.getNumberOfBasement()==null ) {
//			throw new FieldRequiredException("name or numberofbasement is null");
//		}
//	}
	
	
//	@PostMapping(value ="/api/building/")
//	public BuildingDTO getBuilding2(@RequestBody BuildingDTO building) {
//		// sau khi xu ly duoi database
//		return building;
//}
	
	@DeleteMapping(value ="/api/building/{id}/{name}")
	public void deleteBuilding(@PathVariable Integer id,
							   @PathVariable String name) {
		System.out.println("Da xoa thanh cong " +id +" roi nhe");
	}
}
