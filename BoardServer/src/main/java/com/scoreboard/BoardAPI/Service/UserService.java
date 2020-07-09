package com.scoreboard.BoardAPI.Service;

import java.util.List;

import com.scoreboard.BoardAPI.entity.users;



public interface UserService {

	public List<users> getUsers();

	public users getUsersById(int id);

	public users makeadmin(int id);

	public users removeadmin(int id);

}
