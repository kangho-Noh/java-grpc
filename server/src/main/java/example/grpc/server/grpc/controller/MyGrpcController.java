package example.grpc.server.grpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import example.grpc.Userinfo;
import example.grpc.server.domain.User;
import example.grpc.server.grpc.controller.grpccall.GrpcCall;
import example.grpc.server.restapi.controller.MyUserForm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyGrpcController {

	private final GrpcCall grpcCall = new GrpcCall();

	@GetMapping("/grpc")
	public String grpcHome(){
		return "grpc/grpcindex";
	}

	@GetMapping("/grpc/user/{userId}")
	public String getUserinfoGrpc(@PathVariable("userId") long userId, Model model) {
		log.info("mappingPath userId={}", userId);
		Userinfo user = grpcCall.getUserInfo(userId);
		model.addAttribute("user", user);
		return "grpc/userinfo-grpc";
	}

	@GetMapping("/grpc/user/new")
	public String createForm(){
		return "grpc/user-form-grpc";
	}

	@PostMapping("/grpc/user/save")
	public String setUserinfoGrpc(MyUserForm form){
		Userinfo user = Userinfo.newBuilder()
			.setName(form.getName())
			.setId(form.getId())
			.setEmail(form.getEmail())
			.setAge(form.getAge()).build();
		grpcCall.setUserInfo(user);
		return "redirect:/grpc";
	}

	@GetMapping("/grpc/users")
	public String grpcUsers(){

		return "ok";
	}
}
