package com.scoreboard.BoardAPI.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import com.scoreboard.BoardAPI.dto.TeamToPlayers;



@Entity
public class matchs {
	
	@Id
	@GeneratedValue
	private int match_id;
	private int admin_id;
	private int toss;
	private Boolean isActive;
	private int overs;
	 @OneToMany(targetEntity = team.class,cascade = CascadeType.ALL)
	 @JoinColumn(name ="mt_fk",referencedColumnName = "match_id")
	private List<team> team;
	public matchs() {
		
	}
	public int getMatch_id() {
		return match_id;
	}
	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public int getToss() {
		return toss;
	}
	public void setToss(int toss) {
		this.toss = toss;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public int getOvers() {
		return overs;
	}
	public void setOvers(int overs) {
		this.overs = overs;
	}
	public List<team> getTeam() {
		return team;
	}
	public void setTeam(List<team> team) {
		this.team = team;
	}
	@Override
	public String toString() {
		return "matchs [match_id=" + match_id + ", admin_id=" + admin_id + ", toss=" + toss + ", isActive=" + isActive
				+ ", overs=" + overs + ", team=" + team + "]";
	}
	public matchs(int admin_id, int toss, Boolean isActive, int overs, List<com.scoreboard.BoardAPI.entity.team> team) {
		super();
		this.admin_id = admin_id;
		this.toss = toss;
		this.isActive = isActive;
		this.overs = overs;
		this.team = team;
	}
	
	
}
