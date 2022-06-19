package com.restapi.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.restapi.ApiService.ApiService;
import com.restapi.restapi.entities.Api;

@RestController
public class MyController {

	@Autowired
	public ApiService apiService;
	
	@GetMapping("/home")
	public String get() {
		return "hello";
	}
	
	@GetMapping("/api")
	public List<Api> getApis(){
		return apiService.getApis();
	}
	
	@GetMapping("/api/{apiId}")
	public Api getApi(@PathVariable String apiId) {
		return apiService.getApi(Long.parseLong(apiId));
	}
	
	@PostMapping("/api")
	public Api addCourse(@RequestBody Api api) {
		return this.apiService.addApi(api);
	}
	
	@PutMapping("/api")
	public Api upDateCourse(@RequestBody Api api) {
		return this.apiService.updateApi(api);
	}
	
	@DeleteMapping("/api/{apiId}")
	public ResponseEntity<HttpStatus> deleteApi(@PathVariable String apiId){
		try {
			this.apiService.deleteApi(Long.parseLong(apiId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
