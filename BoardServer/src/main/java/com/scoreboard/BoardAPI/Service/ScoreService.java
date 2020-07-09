package com.scoreboard.BoardAPI.Service;

import java.util.List;
import java.util.Map;

import com.scoreboard.BoardAPI.entity.Score;

public interface ScoreService {

	public List<Score> getallscores();

	public List<String> getleftplayers();

	public void saveplayer(Score score);

	public Score getplayer(String name);

	public boolean isout(int id);

	public Map<String, List<Object>> chartdetails();

	public List<Score> bettingscorecard();

	

}
