package example.grpc.server.grpc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import example.grpc.Userinfo;
import example.grpc.server.grpc.controller.grpccall.GrpcCall;
import example.grpc.server.restapi.controller.MyIdForm;
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

	@GetMapping("/grpc/find")
	public String restFind() {
		return "grpc/find-form-grpc";
	}

	@PostMapping("/grpc/find")
	public String restFindId(MyIdForm idForm) {
		String id = idForm.getId();
		return "redirect:/grpc/find/" + id;
	}

	@GetMapping("/grpc/find/{userId}")
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
	public String grpcUsers(Model model){

		List<Userinfo> users = grpcCall.getUsers();
		model.addAttribute("users", users);
		return "grpc/userList-grpc";
	}

	@GetMapping("/grpc/delete")
	public String deleteUser(){
		return "delete-rest";
	}

	@PostMapping("/grpc/delete")
	public String deleteUserById(MyIdForm idForm) {
		String id = idForm.getId();
		grpcCall.deleteUser(id);
		return "redirect:/grpc";
	}
}
