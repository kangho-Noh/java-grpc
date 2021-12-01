package com.example.receiver.rest.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.receiver.domain.User;


@Repository
public class UserRestRepository{

	private static long idxCounter = 1;
	private Map<Long, User> userMap = new HashMap<>();

	public UserRestRepository(){
		User user = new User();
		user.setAge("24");
		user.setEmail("rkdgh98@khu.ac.kr");
		user.setId(999L);
		user.setName("admin");
		userMap.put(999L, user);
	}

	public long save(User user) {
		user.setId(idxCounter);
		userMap.put(idxCounter++, user);
		return idxCounter-1;
	}

	public User findById(Long userId) {
		return userMap.get(userId);
	}

	public List<User> findAll() {
		return new ArrayList<>(userMap.values());
	}

	public String delete(Long id) {
		if(userMap.containsKey(id)){
			userMap.remove(id);
		}
		return "ok";
	}
}
