package com.scoreboard.BoardAPI.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoreboard.BoardAPI.DAO.usersRepository;
import com.scoreboard.BoardAPI.entity.users;

@Service
public class UserServiceImpl implements UserService {
		
		private usersRepository userrepository;
		
		@Autowired
		public UserServiceImpl(usersRepository userrepository) {
			super();
			this.userrepository = userrepository;
		}

//	
//		public UserDAO userdao;
//		@Autowired
//		public UserServiceImpl(UserDAO userdao) {
//			this.userdao = userdao;
//		}

		@Override
		@Transactional
		public List<users> getUsers() {
			return userrepository.findAll();
		}

		@Override
		@Transactional
		public users getUsersById(int id) {
			Optional<users> result = userrepository.findById(id);
			users user=null;
			if(result.isPresent()) {
				user=result.get();
			}else {
				throw new RuntimeException("Employee id not foundd "+id);
			}	
			return user;
		}

		@Override
		@Transactional
		public users makeadmin(int id) {
			userrepository.makeadmin(id);
			return getUsersById(id);
		}

		@Override
		@Transactional
		public users removeadmin(int id) {
			userrepository.removeadmin(id);
			return getUsersById(id);
		}
		
		
}
