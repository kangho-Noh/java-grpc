package com.example.receiver.gprc.controller;

import org.springframework.beans.factory.annotation.Autowired;

import net.devh.boot.grpc.server.service.GrpcService;

import com.example.receiver.repository.MemoryRepository;
import com.example.receiver.repository.MemoryUserRepository;

import example.grpc.UserIdx;
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
}
