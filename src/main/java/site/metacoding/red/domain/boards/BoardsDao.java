package site.metacoding.red.domain.boards;

import java.util.List;

import site.metacoding.red.domain.users.Users;
import site.metacoding.red.web.dto.request.boards.UserBoardsDto;
import site.metacoding.red.web.dto.request.boards.WriteDto;

public interface BoardsDao {
	public void insert(WriteDto writeDto);
	public Boards findById(Integer id);
	public List<Users> findAll();
	public void delete(Integer id);
	public void update(Boards boards);
	public List<UserBoardsDto> findAllByUser(Integer id);
}
