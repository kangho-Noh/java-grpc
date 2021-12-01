package example.grpc.server.form;

import lombok.Data;

@Data
public class MyUserForm {
	long id;
	String name;
	String age;
	String email;
}
