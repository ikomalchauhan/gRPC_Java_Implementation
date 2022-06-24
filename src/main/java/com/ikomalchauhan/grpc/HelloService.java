package com.ikomalchauhan.grpc;

import com.ikomalchauhan.proto.HelloRequest;
import com.ikomalchauhan.proto.HelloResponse;
import com.ikomalchauhan.proto.HelloServiceGrpc.HelloServiceImplBase;

import io.grpc.stub.StreamObserver;

public class HelloService extends HelloServiceImplBase {

	@Override
	public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
		System.out.println("Inside Hello");

		String greeting = new StringBuilder().append("Hello, ").append(request.getFirstName()).append(" ")
				.append(request.getLastName()).toString();

		HelloResponse response = HelloResponse.newBuilder().setGreeting(greeting).build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}
