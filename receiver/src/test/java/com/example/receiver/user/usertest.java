package com.example.receiver.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.receiver.repository.MemoryRepository;
import com.example.receiver.repository.MemoryUserRepository;

import example.grpc.Userinfo;

public class usertest {
	MemoryRepository memoryUserRepository = new MemoryUserRepository();

	@Test
	void 초기화됐는지(){
		Userinfo byId = memoryUserRepository.findById(999L);
		Assertions.assertThat(byId.getName()).isEqualTo("kangho");
		//Assertions.assertThat(byId).isNull();
	}
}
