package com.ikomalchauhan.grpc;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Starting gRPC server...");
		Server server = ServerBuilder.forPort(9090).addService(new HelloService()).build();
		server.start();
		System.out.println("Server started at " + server.getPort());
		server.awaitTermination();
	}

}
