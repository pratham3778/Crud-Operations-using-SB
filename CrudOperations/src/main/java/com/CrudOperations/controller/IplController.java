package com.CrudOperations.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CrudOperations.entity.IplTeam;
import com.CrudOperations.service.IplService;

@RestController
public class IplController {
	
	IplService iplService;
	
	public IplController(IplService iplService) {
		super();
		this.iplService = iplService;
	}
	
	@PostMapping("/insert")
	public ResponseEntity<IplTeam> insertdata(@RequestBody IplTeam iplTeam) {
	IplTeam savedIplTeam = iplService.insertdata(iplTeam);
	return new ResponseEntity<IplTeam>(savedIplTeam, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<IplTeam>> getAll() {
		List<IplTeam> iplteams = iplService.getAllTeams();
		
		return ResponseEntity.ok(iplteams);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<IplTeam> update(@PathVariable int id,@RequestBody IplTeam IplTeam) {
		IplTeam updatedTeam = iplService.updateTeam(id, IplTeam);
		
		return new ResponseEntity<IplTeam>(updatedTeam, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>>delete(@PathVariable int id) {
		iplService.delete(id);
		
		Map<String, Boolean> response= new HashMap<String, Boolean>();
		response.put("Deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}

}
