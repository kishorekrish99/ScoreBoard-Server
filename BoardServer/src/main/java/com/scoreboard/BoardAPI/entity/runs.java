package com.scoreboard.BoardAPI.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class runs {
	@Id
	@GeneratedValue
	private int id;
	private int score;
	private int wickets;
	public runs() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	@Override
	public String toString() {
		return "runs [id=" + id + ", score=" + score + ", wickets=" + wickets + "]";
	}
	public runs(int score, int wickets) {
		super();
		this.score = score;
		this.wickets = wickets;
	}	
	
	
}
