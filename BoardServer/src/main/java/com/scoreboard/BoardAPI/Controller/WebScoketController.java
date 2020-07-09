package com.scoreboard.BoardAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.scoreboard.BoardAPI.DAO.RunsRepository;
import com.scoreboard.BoardAPI.entity.runs;

@Controller
public class WebScoketController {
		@Autowired
		private RunsRepository runsrepository;
	
		@MessageMapping("/hello")
		@SendTo("/topic/greetings")
		public List<runs> returnruns(runs runs) throws Exception {
			runsrepository.save(runs);
			Thread.sleep(1000);
			return runsrepository.findAll(); 
		}
}
