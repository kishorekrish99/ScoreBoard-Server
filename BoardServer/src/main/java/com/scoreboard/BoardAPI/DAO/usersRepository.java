package com.scoreboard.BoardAPI.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.scoreboard.BoardAPI.entity.users;

public interface usersRepository extends JpaRepository<users,Integer>{
	@Modifying
	@Query("update users u set u.role='admin' where u.id=:id")
	 public void makeadmin(int id);
	
	@Modifying
	@Query("update users u set u.role='manager' where u.id=:id")
	public void removeadmin(int id);
	
}
