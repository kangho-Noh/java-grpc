package example.grpc.server.grpc.controller.grpccall;

import org.springframework.stereotype.Service;

import example.grpc.UserIdx;
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
}
