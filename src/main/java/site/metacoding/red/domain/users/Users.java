package site.metacoding.red.domain.users;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import site.metacoding.red.web.dto.request.users.LoginDto;
import site.metacoding.red.web.dto.request.users.UpdateDto;

@Getter
public class Users {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private Timestamp createdAt;
	
	public void 패스워드수정(String password) {
		this.password = password;
	}
	
	public void 전체수정(UpdateDto updateDto) {
		this.username = updateDto.getUsername();
		this.password = updateDto.getPassword();
		this.email = updateDto.getEmail();
	}
	
	public void validateId(LoginDto loginDto) {
		if(this.username == loginDto.getUsername() && this.password == loginDto.getPassword()) {
			System.out.println("로그인 되었습니다!");
		}
	}
	
}
