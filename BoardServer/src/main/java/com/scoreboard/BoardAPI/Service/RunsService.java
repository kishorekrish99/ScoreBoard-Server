package com.scoreboard.BoardAPI.Service;

import java.util.List;

import com.scoreboard.BoardAPI.entity.runs;

public interface RunsService {

	public List<runs> getRuns();

	public runs postruns(runs runs);

	

}
