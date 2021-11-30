package com.kangho.fieldmask.service;

import java.util.HashMap;
import java.util.Map;

import com.kangho.Customer;
import com.kangho.CustomerId;
import com.kangho.CustomerServiceGrpc;

import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;

public class FieldMaskTestImpl extends CustomerServiceGrpc.CustomerServiceImplBase {

	Map<Long, Customer> customerMap = new HashMap<>();

	@Override
	public void getCustomer(CustomerId request, StreamObserver<Customer> responseObserver) {

		long customerId = request.getId();

		if (customerMap.containsKey(customerId)) {
			responseObserver.onNext(customerMap.get(customerId));
			responseObserver.onCompleted();
		} else {
			responseObserver.onError(new StatusException(Status.NOT_FOUND));
		}
	}
}
