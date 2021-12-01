package example.grpc.server.restapi.controller;

import lombok.Data;

@Data
public class MyUserForm {
	long id;
	String name;
	String age;
	String email;
}
