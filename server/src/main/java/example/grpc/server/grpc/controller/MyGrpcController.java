package example.grpc.server.grpc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MyGrpcController {
	@GetMapping("/grpc/user/{userId}")
	public String mappingPath(@PathVariable("userId") String data) {
		log.info("mappingPath userId={}", data);
		return "ok";
	}
}
