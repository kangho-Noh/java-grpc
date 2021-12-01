package com.example.receiver.gprc.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.receiver.domain.User;

import example.grpc.Userinfo;

@Repository
public class MemoryUserRepository implements MemoryRepository {

	private static long idxCounter = 1;
	private Map<Long, Userinfo> userMap = new HashMap<>();

	public MemoryUserRepository(){
		userMap.put(999L, Userinfo.newBuilder()
				.setAge("24")
				.setEmail("rkdgh98@khu.ac.kr")
				.setId(999)
				.setName("admin")
			.build());
	}

	@Override
	public long save(Userinfo user) {
		user = user.toBuilder().setId(idxCounter).build();

		System.out.println("idxCounter = " + idxCounter);
		System.out.println("user.getName() = " + user.getName());
		System.out.println("user.getId() = " + user.getId());
		userMap.put(idxCounter++, user);
		return idxCounter-1;
	}

	@Override
	public Userinfo findById(Long userid) {
		return userMap.getOrDefault(userid, null);
	}

	@Override
	public List<Userinfo> findAll() {
		return new ArrayList<>(userMap.values());
	}

	public String delete(Long id) {
		if(userMap.containsKey(id)){
			userMap.remove(id);
		}
		return "ok";
	}

	public Long update(Userinfo user) {

		if(userMap.containsKey(user.getId())){
			System.out.println("update user = " + user);

			delete(user.getId());
			userMap.put(user.getId(), user);
			return user.getId();
		}else{
			return 0L;
		}
	}
}
