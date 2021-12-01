package example.grpc.server.grpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import example.grpc.Userinfo;
import example.grpc.server.grpc.controller.grpccall.GrpcCall;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyGrpcController {

	@GetMapping("/grpc")
	public String grpcHome(){
		return "grpc/grpcindex";
	}

	@GetMapping("/grpc/user/{userId}")
	public String getUserinfoGrpc(@PathVariable("userId") long userId, Model model) {
		log.info("mappingPath userId={}", userId);
		Userinfo user = GrpcCall.getUserInfo(userId);
		// System.out.println("user = " + user);
		model.addAttribute("user", user);
		return "grpc/userinfo-grpc";
	}

	@GetMapping("/grpc/user/new")
	public String createForm(){
		return "user-form";
	}

	@PostMapping("/grpc/user/save")
	public String setUserinfoGrpc(){

		return "ok";
	}

	@GetMapping("/grpc/users")
	public String grpcUsers(){

		return "ok";
	}
}
