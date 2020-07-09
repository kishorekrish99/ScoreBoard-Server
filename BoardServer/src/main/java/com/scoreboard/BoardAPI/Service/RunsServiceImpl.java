package com.scoreboard.BoardAPI.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoreboard.BoardAPI.DAO.RunsRepository;
import com.scoreboard.BoardAPI.entity.runs;
@Service
public class RunsServiceImpl implements RunsService {
	@Autowired
	private RunsRepository runsrepository;
	
	
	@Override
	@Transactional
	public List<runs> getRuns() {
		return runsrepository.findAll();
	}


	@Override
	@Transactional
	public runs postruns(runs runs) {
		return runsrepository.save(runs);
	}


	

}
