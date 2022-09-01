package site.metacoding.red.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.boards.Boards;
import site.metacoding.red.domain.boards.BoardsDao;
import site.metacoding.red.web.dto.request.boards.UpdateDto;
import site.metacoding.red.web.dto.request.boards.WriteDto;
import site.metacoding.red.web.dto.response.RespDto;

@RestController
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardsDao boardsDao;
	
//	@GetMapping("/boards")
//	public RespDto<?> getBoardList() {
//		return new RespDto<>(1, "게시글 목록 불러오기", boardsDao.findAll());
//	}
//	
//	@GetMapping("/boards/{id}")
//	public RespDto<?> getBoard(@PathVariable Integer id) {
//		return new RespDto<>(1, "게시글 가져오기", boardsDao.findById(id));
//	}
//	
//	
//	@PostMapping("/boards")
//	public RespDto<?> join(WriteDto writeDto) {
//		boardsDao.insert(writeDto);
//		return new RespDto<>(1, "글쓰기 성공", null);
//	}
//	
//	
//	@DeleteMapping("/boards/{id}")
//	public RespDto<?> delete(@PathVariable Integer id) {
//		boardsDao.delete(id);
//		return new RespDto<>(1, id + "번 글 삭제 성공", null);
//	}
//	
//	@PutMapping("/boards/{id}")
//	public RespDto<?> updateAll(@PathVariable Integer id, UpdateDto updateDto) {
//		//1. 영속화
//		Boards boardsPS = boardsDao.findById(id);
//		
//		//2. 변경
//		boardsPS.전체변경(updateDto);
//		
//		//3. 전체 업데이트
//		boardsDao.update(boardsPS);
//		
//		return new RespDto<>(1, "게시판 글 수정", null);
//	}
	
	
	// 외래키를 한 번 사용해서 컨트롤러 설정해보자
	@GetMapping("/boards/{id}")
	public RespDto<?> getBoardsListByUser(@PathVariable Integer id) {
		return new RespDto<>(1, "유저별 게시글 목록 불러오기", boardsDao.findAllByUser(id));
	}
	
	
	
	
	
	
	
}
