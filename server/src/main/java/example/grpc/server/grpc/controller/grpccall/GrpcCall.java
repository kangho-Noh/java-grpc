package example.grpc.server.grpc.controller.grpccall;

import java.util.List;

import org.springframework.stereotype.Service;

import example.grpc.UserIdx;
import example.grpc.UserList;
import example.grpc.Userinfo;
import example.grpc.UserinfoServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcCall {

	public GrpcCall(){
	}

	public Userinfo getUserInfo(long userId){
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();;
		UserinfoServiceGrpc.UserinfoServiceBlockingStub stub = UserinfoServiceGrpc.newBlockingStub(channel);

		UserIdx request = UserIdx.newBuilder().setUserId(userId).build();
		Userinfo userinfo = stub.getUserinfo(request);
		channel.shutdown();
		return userinfo;
	}

	public UserIdx setUserInfo(Userinfo userinfo){
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();;
		UserinfoServiceGrpc.UserinfoServiceBlockingStub stub = UserinfoServiceGrpc.newBlockingStub(channel);

		UserIdx useridx = stub.putUserinfo(userinfo);
		channel.shutdown();
		return useridx;
	}

	public List<Userinfo> getUsers(){
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();;
		UserinfoServiceGrpc.UserinfoServiceBlockingStub stub = UserinfoServiceGrpc.newBlockingStub(channel);

		UserList userList = stub.getAllUsers(UserIdx.newBuilder().build());
		return userList.getUsersList();
	}

	public UserIdx deleteUser(String id) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();;
		UserinfoServiceGrpc.UserinfoServiceBlockingStub stub = UserinfoServiceGrpc.newBlockingStub(channel);

		UserIdx userIdx = stub.deleteUser(
			UserIdx.newBuilder().setUserId(Long.parseLong(id)).build());
		return userIdx;
	}
}
