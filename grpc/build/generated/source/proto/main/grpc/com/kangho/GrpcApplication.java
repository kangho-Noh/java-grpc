package com.kangho;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcApplication {
    public static void main(String[] args) {
        //Initialize gRPC Server
        int port = 8080;
        Server server = ServerBuilder.forPort(port).addService(new UserServiceImpl()).build();

        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        /* Add server shutdown handler */
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.err.println("Server: Shutting down gRPC server");
            server.shutdown();
            System.err.println("Server: Server shut down");
        }));
        /* shutdown handler end */

        //gRPC Client (Unary RPC, 2 times)
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",
                8080).usePlaintext().build();
        UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);
        UserIdx setUserResult = stub.setUser(User.newBuilder().setUsername("Noh Kangho")
                .setEmail("rkdgh98@gmail.com").addRoles("USER").addRoles("ADMIN").build());
        System.out.println("Client : " + setUserResult.getIdx());

        User getUserResult = stub.getUser(setUserResult);
        System.out.println(getUserResult.toString());

        //Release
        channel.shutdown();
        Runtime.getRuntime().exit(0);
    }
}
