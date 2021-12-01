package com.example.receiver.repository;

import java.util.List;
import java.util.Optional;

import com.example.receiver.domain.User;

import example.grpc.Userinfo;

public interface MemoryRepository {
	long save(Userinfo member);

	Userinfo findById(Long memberId);

	List<Userinfo> findAll();
}
