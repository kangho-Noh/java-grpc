package example.grpc.server.grpc.controller.grpccall;

import org.springframework.stereotype.Component;

import example.grpc.UserinfoServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.Data;

@Data
@Component
public class GrpcConfig {

	private static final ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
	private static final UserinfoServiceGrpc.UserinfoServiceBlockingStub stub = UserinfoServiceGrpc.newBlockingStub(channel);

}
