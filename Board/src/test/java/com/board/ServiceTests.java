package com.board;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.domain.BoardDTO;
import com.board.service.BoardService;

@SpringBootTest
class ServiceTests {
	
	@Autowired
	private BoardService boardService;
	
	@Test
	public void testOfRegisterBoard() {
		BoardDTO params = new BoardDTO();
		params.setTitle("registerBoard 테스트 제목");
		params.setContent("registerBoard 테스트 내용");
		params.setWriter("테스터");
		
		boolean flag = boardService.registerBoard(params);

		System.out.println(flag);
	}
	
	@Test
	public void testOfGetBoardDetail() {
		BoardDTO board = boardService.getBoardDetail((long)2);
		
		System.out.println(board.getTitle());
	}
	
	@Test
	public void testOfDeleteBoard() {
		System.out.println(boardService.deleteBoard((long)2));
	}
	
	@Test
	public void testOfGetBoardList() {
		List<BoardDTO> boardList = Collections.emptyList();
		boardList = boardService.getBoardList();
		
		if(boardList != null) {
			for(BoardDTO boardDTO : boardList) {
				System.out.println(boardDTO.getTitle());
			}
		}
	}
	
}
