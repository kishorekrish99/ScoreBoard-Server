package com.scoreboard.BoardAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scoreboard.BoardAPI.Service.RunsService;
import com.scoreboard.BoardAPI.entity.runs;

@RestController
public class RunsController {
	@Autowired
	private RunsService runsservice;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/runs")
	public List<runs> getRuns(){
		return runsservice.getRuns(); 
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/runs")
	public runs postRuns(@RequestBody runs runs) {
		return runsservice.postruns(runs);
	}
	
	
	
}
