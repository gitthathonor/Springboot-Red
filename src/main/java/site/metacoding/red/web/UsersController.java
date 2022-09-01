package site.metacoding.red.web;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.users.Users;
import site.metacoding.red.domain.users.UsersDao;
import site.metacoding.red.web.dto.request.users.JoinDto;
import site.metacoding.red.web.dto.request.users.UpdateDto;
import site.metacoding.red.web.dto.response.RespDto;

@RequiredArgsConstructor
@RestController
public class UsersController {

	private final UsersDao usersDao;
	
	@GetMapping("/users/{id}")
	public RespDto<?> getUsers(@PathVariable Integer id) {
		return new RespDto<>(1, "성공", usersDao.findById(id));
	}
	
	@GetMapping("/users")
	public RespDto<?> getUsersList() {
		return new RespDto<>(1, "성공", usersDao.findAll());
	}
	
	@PostMapping("/users")
	public RespDto<?> insert(JoinDto joinDto) {
		usersDao.insert(joinDto);
		return new RespDto<>(1, "회원가입완료" , null); // 201번 - insert됨
	}
	
	@DeleteMapping("/users/{id}")
	public RespDto<?> delete(@PathVariable Integer id) {
		usersDao.deleteById(id);
		return new RespDto<>(1, "회원삭제완료", null);
	}
	
	@PutMapping("/users/{id}")
	public RespDto<?> update(@PathVariable Integer id, UpdateDto updateDto) {
		//1번 : id로 select 하자. (영속화) -> DB에 있는 행을 자바 object로 옮기는 행위를 뜻한다.
		Users usersPS = usersDao.findById(id);
		
		//2번 : 변경
		usersPS.전체수정(updateDto);
		
//		Users users = new Users();
//		users.setId(id);
//		users.setUsername(updateDto.getUsername());
//		users.setPassword(updateDto.getPassword());
//		users.setEmail(updateDto.getEmail());
		
		//3번 : 전체 업데이트
		usersDao.update(usersPS);
		return new RespDto<>(1, "회원수정완료", null);
	}
	
	
	@PutMapping("/users/{id}/password")
	public RespDto<?> updatePassword(@PathVariable Integer id, String password) {
		Users usersPS = usersDao.findById(id);
		usersPS.패스워드수정(password);
		usersDao.update(usersPS);
		return new RespDto<>(1, "비밀번호수정완료", null);
	}
	
}
