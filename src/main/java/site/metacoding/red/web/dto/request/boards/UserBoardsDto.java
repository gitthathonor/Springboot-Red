package site.metacoding.red.web.dto.request.boards;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserBoardsDto {
	private String title;
	private String content;
	private String writeDate;
	private String username;
}
