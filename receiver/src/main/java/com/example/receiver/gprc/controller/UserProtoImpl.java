package com.example.receiver.gprc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.devh.boot.grpc.server.service.GrpcService;

import com.example.receiver.gprc.repository.MemoryUserRepository;

import example.grpc.UserIdx;
import example.grpc.UserList;
import example.grpc.Userinfo;
import example.grpc.UserinfoServiceGrpc;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;

@GrpcService
public class UserProtoImpl extends UserinfoServiceGrpc.UserinfoServiceImplBase {

	@Autowired
	MemoryUserRepository memoryRepository;

	@Override
	public void getUserinfo(UserIdx request, StreamObserver<Userinfo> responseObserver) {

		long userIdx = request.getUserId();
		Userinfo user = memoryRepository.findById(userIdx);

		if(user==null){
			responseObserver.onError(new StatusException(Status.NOT_FOUND));
		}else{
			responseObserver.onNext(user);
			responseObserver.onCompleted();
		}
	}

	@Override
	public void putUserinfo(Userinfo request, StreamObserver<UserIdx> responseObserver) {

		UserIdx response = UserIdx.newBuilder().setUserId(memoryRepository.save(request)).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	@Override
	public void getAllUsers(UserIdx request, StreamObserver<UserList> responseObserver) {

		List<Userinfo> users = memoryRepository.findAll();
		UserList resp = UserList.newBuilder().addAllUsers(users).build();
		responseObserver.onNext(resp);
		responseObserver.onCompleted();
	}

	@Override
	public void deleteUser(UserIdx request, StreamObserver<UserIdx> responseObserver) {

		memoryRepository.delete(request.getUserId());
		responseObserver.onNext(request);
		responseObserver.onCompleted();
	}

	@Override
	public void updateUser(Userinfo request, StreamObserver<UserIdx> responseObserver) {

		Long result = memoryRepository.update(request);
		if(result == 0L){
			responseObserver.onError(new StatusException(Status.NOT_FOUND));

		}else{
			responseObserver.onNext(
				UserIdx.newBuilder().setUserId(result).build());
			responseObserver.onCompleted();
		}
	}
}
