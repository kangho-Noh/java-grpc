package example.grpc.server.domain;

import lombok.Data;

@Data
public class User {
	long id;
	String name;
	String age;
	String email;
}
