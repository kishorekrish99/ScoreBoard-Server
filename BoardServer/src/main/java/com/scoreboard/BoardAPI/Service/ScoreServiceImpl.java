package com.scoreboard.BoardAPI.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoreboard.BoardAPI.DAO.ScoreRepository;
import com.scoreboard.BoardAPI.entity.Score;

@Service
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	private ScoreRepository scorerepository;
	
	@Override
	public List<Score> getallscores() {
		
		List<Score> players = new ArrayList();
		
		String s= "playing";
		
		List<Score> allplayers=scorerepository.findAll();
		
	    for(Score score: allplayers){
	    	

	    	
	    	
	       if(score.getStatus().equals("playing")) {
	    	   players.add(score);
	    	   System.out.println(score.getStatus());
	       }
	    	
	    }
	    
	    return players;
	    
	}

	@Override
	public List<String> getleftplayers() {

	    List<String> allnames = new ArrayList<String>();
	    
	    List<Score> allplayers = scorerepository.findAll();
	    
	    System.out.println(allplayers);
	    
	    for(Score score: allplayers) {
	    	if(score.getStatus().equals("not out")) {
	    		allnames.add(score.getName());
	    	}
	    }
		
		return allnames;
	}

	@Override
	public void saveplayer(Score score) {
		scorerepository.save(score);
		
	}

	@Override
	public Score getplayer(String name) {

List<Score> x = scorerepository.findAll();
		
		
		
		for(Score score: x) {
			if(score.getName().equals(name)){
				score.setStatus("playing");
				scorerepository.save(score);
				return score;
			}
		}
		
		return null;
		
	}

	@Override
	public boolean isout(int id) {
		Score score = scorerepository.findById(id).get();
		if(score.getStatus().equals("out"))
			return true;
		else return false;
		
	}

	@Override
	public Map<String, List<Object>> chartdetails() {
		Map<String, List<Object>> map = new HashMap<>();
		
		List<Object> m,n,o,p,q = new ArrayList();
		
		m=scorerepository.findnames();
		n=scorerepository.findruns();
		o=scorerepository.findfours();
		p=scorerepository.findsix();
		q=scorerepository.findtotal();
		
		map.put("names",m);
		map.put("runs", n);
		map.put("fours",o);
		map.put("six",p);
		map.put("total",q);
		
		return map;
	}

	@Override
	public List<Score> bettingscorecard() {
		return scorerepository.findAll();
				
	}
	
	
	
	
}
