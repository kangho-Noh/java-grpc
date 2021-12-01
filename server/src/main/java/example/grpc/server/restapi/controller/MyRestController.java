package example.grpc.server.restapi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import example.grpc.server.domain.User;
import example.grpc.server.form.MyIdForm;
import example.grpc.server.form.MyUserForm;
import example.grpc.server.restapi.controller.restcall.RestCall;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyRestController {

	private final RestCall restCall = new RestCall();

	@GetMapping("/rest")
	public String restHome() {
		return "restindex";
	}

	@GetMapping("/rest/find")
	public String restFind() {
		return "find-form-rest";
	}

	@PostMapping("/rest/find")
	public String restFindId(MyIdForm idForm) {
		String id = idForm.getId();
		return "redirect:/rest/find/" + id;
	}

	@GetMapping("/rest/find/{userId}")
	public String mappingPath(@PathVariable("userId") String userId, Model model) {
		log.info("mappingPath userId={}", userId);
		User user = restCall.getUserById(userId);
		model.addAttribute("user", user);
		return "userinfo-rest";
	}

	@GetMapping("/rest/user/new")
	public String createForm() {
		return "user-form";
	}

	@PostMapping("/rest/user/save")
	public String saveUserRest(MyUserForm form) {
		User user = new User();
		user.setAge(form.getAge());
		user.setEmail(form.getEmail());
		user.setId(form.getId());
		user.setName(form.getName());
		restCall.setData(user);
		restCall.saveUser(user);
		return "redirect:/rest";
	}

	@GetMapping("/rest/users")
	public String list(Model model) {
		//REST call
		List<User> users = restCall.getUsersRest();
		model.addAttribute("users", users);
		return "userList";
	}

	@GetMapping("/rest/delete")
	public String deleteUser(){
		return "delete-rest";
	}

	@PostMapping("/rest/delete")
	public String deleteUserById(MyIdForm idForm){
		String id = idForm.getId();
		restCall.deleteUser(id);
		return "redirect:/rest";
	}
}
