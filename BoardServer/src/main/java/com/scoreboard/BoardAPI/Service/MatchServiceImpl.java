package com.scoreboard.BoardAPI.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoreboard.BoardAPI.DAO.matchsRepository;
import com.scoreboard.BoardAPI.dto.MatchesToTeams;
import com.scoreboard.BoardAPI.entity.matchs;

@Service
public class MatchServiceImpl implements MatchService {
	
	
	@Autowired
	private matchsRepository matchsrepository;

	@Override
	@Transactional
	public matchs getMatches(MatchesToTeams matchs) {
		return matchsrepository.save(matchs.getMatchs());
	}

	@Override
	public List<matchs> getall() {
		
		return matchsrepository.findAll();
	}	
}
