package example.grpc.server.restapi.controller.restcall;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import example.grpc.Userinfo;
import example.grpc.server.domain.User;

public class RestCall {

	private User data=new User();

	// GET photo data
	public String getData(){
		//        System.out.println("get >>> "+ photo);
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("name",data.getName());
		jsonObject.addProperty("id",data.getId());
		jsonObject.addProperty("email",data.getEmail());
		jsonObject.addProperty("age",data.getAge());
		return jsonObject.toString();
	}

	// SET 인코딩한 photo data
	public User setData(User dataDto){
		System.out.println("set Data >>> " + dataDto);
		data.setId(dataDto.getId());
		data.setName(dataDto.getName());
		data.setEmail(dataDto.getEmail());
		data.setAge(dataDto.getAge());

		return data;
	}

	public User getUserById(String userId){

		// URL 설정
		String workerIP = "localhost";
		String workerPort = "8081";
		String path = "/rest/users/"+userId;
		String url = "http://"+workerIP+":"+workerPort+path;

		// Body 설정 (JSON 형태)
		JsonObject params=new JsonObject();
		//params.addProperty("name",data.getName());

		// Header 설정 ,TYPE=json
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// 요청하기 위해 header와 body 합치기
		HttpEntity<String> entity=new HttpEntity<String>(params.toString(),headers);

		// POST 요청
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response = template.exchange(
			url,
			HttpMethod.GET,
			entity,
			String.class
		);
		//System.out.println("response.getBody() = " + response.getBody());

		JsonParser jsonParser=new JsonParser();
		JsonObject jsonObject = jsonParser.parse(response.getBody()).getAsJsonObject();

		User user = new User();
		user.setId(jsonObject.get("id").getAsLong());
		user.setName(jsonObject.get("name").getAsString());
		user.setEmail(jsonObject.get("email").getAsString());
		user.setAge(jsonObject.get("age").getAsString());

		return user;
	}

	public List<User> getUsersRest()  {
		// result
		List<User> result;

		// URL 설정
		String workerIP = "localhost";
		String workerPort = "8081";
		String path = "/rest/users";
		String url = "http://"+workerIP+":"+workerPort+path;

		// Body 설정 (JSON 형태)
		JsonObject params=new JsonObject();
		//params.addProperty("name",data.getName());

		// Header 설정 ,TYPE=json
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// 요청하기 위해 header와 body 합치기
		HttpEntity<String> entity=new HttpEntity<String>(params.toString(),headers);

		// POST 요청
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response = template.exchange(
			url,
			HttpMethod.GET,
			entity,
			String.class
		);
		//System.out.println("response.getBody() = " + response.getBody());

		JsonParser jsonParser=new JsonParser();
		JsonArray jsonArray = jsonParser.parse(response.getBody()).getAsJsonArray();

		List<User> users = new Gson().fromJson(jsonArray, new TypeToken<List<User>>() {}.getType());

		// print list of users
		//users.forEach(System.out::println);

		return users;
	}

	public Long saveUser(User user) {

		// URL 설정
		String workerIP = "localhost";
		String workerPort = "8081";
		String path = "/rest/save";
		String url = "http://"+workerIP+":"+workerPort+path;

		// Body 설정 (JSON 형태)
		JsonObject params=new JsonObject();
		params.addProperty("name",data.getName());
		params.addProperty("id",data.getId());
		params.addProperty("age",data.getAge());
		params.addProperty("email",data.getEmail());

		// Header 설정 ,TYPE=json
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// 요청하기 위해 header와 body 합치기
		HttpEntity<String> entity=new HttpEntity<String>(params.toString(),headers);

		// POST 요청
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response = template.exchange(
			url,
			HttpMethod.POST,
			entity,
			String.class
		);
		//System.out.println("response.getBody() = " + response.getBody());

		JsonParser jsonParser=new JsonParser();
		long result = jsonParser.parse(response.getBody()).getAsLong();

		return result;
	}

	public String deleteUser(String id) {
		// URL 설정
		String workerIP = "localhost";
		String workerPort = "8081";
		String path = "/rest/delete";
		String url = "http://"+workerIP+":"+workerPort+path;

		// Body 설정 (JSON 형태)
		JsonObject params=new JsonObject();
		params.addProperty("id",Long.parseLong(id));

		// Header 설정 ,TYPE=json
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// 요청하기 위해 header와 body 합치기
		HttpEntity<String> entity=new HttpEntity<String>(params.toString(),headers);

		// POST 요청
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response = template.exchange(
			url,
			HttpMethod.POST,
			entity,
			String.class
		);
		//System.out.println("response.getBody() = " + response.getBody());

		JsonParser jsonParser=new JsonParser();
		String result = jsonParser.parse(response.getBody()).getAsString();
		return result;
	}

	public void updateUser(User user) {
		// URL 설정
		String workerIP = "localhost";
		String workerPort = "8081";
		String path = "/rest/update";
		String url = "http://"+workerIP+":"+workerPort+path;

		// Body 설정 (JSON 형태)
		JsonObject params=new JsonObject();
		params.addProperty("name",data.getName());
		params.addProperty("id",data.getId());
		params.addProperty("age",data.getAge());
		params.addProperty("email",data.getEmail());

		// Header 설정 ,TYPE=json
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// 요청하기 위해 header와 body 합치기
		HttpEntity<String> entity=new HttpEntity<String>(params.toString(),headers);

		// POST 요청
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response = template.exchange(
			url,
			HttpMethod.POST,
			entity,
			String.class
		);
		//System.out.println("response.getBody() = " + response.getBody());
	}
}
