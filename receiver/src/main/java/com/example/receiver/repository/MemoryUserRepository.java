package com.example.receiver.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.receiver.domain.User;

import example.grpc.Userinfo;
import io.grpc.Status;
import io.grpc.StatusException;

@Repository
public class MemoryUserRepository implements MemoryRepository{

	private static long idxCounter = 1;
	private Map<Long, Userinfo> userMap = new HashMap<>();

	public MemoryUserRepository(){
		userMap.put(999L, Userinfo.newBuilder()
				.setAge("24")
				.setEmail("rkdgh98@khu.ac.kr")
				.setId(999)
				.setName("kangho")
			.build());
	}

	@Override
	public long save(Userinfo user) {
		userMap.put(idxCounter++, user);
		return idxCounter-1;
	}

	@Override
	public Userinfo findById(Long userid) {
		if (userMap.containsKey(userid)) {
			return userMap.get(userid);
		} else {
			return null;
		}
	}

	@Override
	public List<Userinfo> findAll() {
		return new ArrayList<>(userMap.values());
	}
}
