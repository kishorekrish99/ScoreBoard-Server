package com.scoreboard.BoardAPI.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scoreboard.BoardAPI.DAO.ScoreRepository;
import com.scoreboard.BoardAPI.Service.ScoreService;
import com.scoreboard.BoardAPI.entity.Score;

@RestController
@RequestMapping("/jpa/users")
public class ScoreController {
	@Autowired
	private ScoreService scoreservice;
	
	@Autowired
	private ScoreRepository scorerepository;
	
	@GetMapping("/scores")
	   public List<Score> getallscores(){
			return scoreservice.getallscores();
		
	}
	
	@GetMapping("/leftplayers")
	public List<String> getleftplayers(){
		return scoreservice.getleftplayers();
	}
	
	
	@PutMapping("/saveauser")
	public void saveplayer(@RequestBody Score score) {
		scoreservice.saveplayer(score);
	}

	@GetMapping("/getplayer/{name}")
	public Score getplayer(@PathVariable String name) {
		return scoreservice.getplayer(name);
	}

	@GetMapping("/check/{id}")
	public boolean isout(@PathVariable int id) {
		return scoreservice.isout(id);
	}
	
	@GetMapping("/all")
	public Map<String,List<Object>> chartdetails(){
		return scoreservice.chartdetails();
	}
	
	
	@GetMapping("/battingdetails")
	public List<Score> battingscorecard(){
		return scoreservice.bettingscorecard();
	}
	
	 @MessageMapping("/scorecard")
	   @SendTo("/topic/scoreupdate")
	   public ResponseEntity<Object> updatescore(Score score) throws InterruptedException {
		   Map<String, List<Object>> map = new HashMap<>();
		   Score updatedscore = scorerepository.save(score);
		   List<Object> m,n,o,p,q,r = new ArrayList();
			m = scorerepository.findnames();
			n=scorerepository.findruns();
			o=scorerepository.findfours();
			p=scorerepository.findsix();
			q=scorerepository.findtotal();
			map.put("names",m);
			map.put("runs", n);
			map.put("fours",o);
			map.put("six",p);
			map.put("total",q); 
		   Thread.sleep(2000);
		   r.add(updatedscore);
		   r.add(map);
			return new ResponseEntity<Object>(r,HttpStatus.OK);
	   }
}
