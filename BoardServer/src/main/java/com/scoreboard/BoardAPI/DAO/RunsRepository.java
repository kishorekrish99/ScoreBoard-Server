package com.scoreboard.BoardAPI.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scoreboard.BoardAPI.entity.runs;

public interface RunsRepository extends JpaRepository<runs, Integer> {

}
