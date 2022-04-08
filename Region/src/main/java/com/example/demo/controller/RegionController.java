package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Region;
import com.example.demo.repository.RegionRepository;

@RestController
public class RegionController {
@Autowired
private RegionRepository repo;
@GetMapping("/region")
public List<Response> getAllTemplates(){
	 List<Region> responseList =repo.findAll();
	 List<Response> templist = new ArrayList<Response>();
	 for(Region temp: responseList) {
		 Response res = new Response();
		 res.id= temp.getId();
		 res.regionName= temp.getRegionName();
		 templist.add(res);	 
	 }
	return templist;	
}
}