package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;
import com.rubypaper.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	public BoardController() {
		System.out.println("===> BoardController 생성");
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		return boardService.hello(name);
		//return "Hello : " + name;
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		
//		BoardVO board = new BoardVO();
//		board.setSeq(1);
//		board.setTitle("테스트 제목...");
//		board.setWriter("테스터");
//		board.setContent("테스트 내용입니다...............");
//		board.setCreateDate(new Date());
//		board.setCnt(0);
//		return board;
		
		return boardService.getBoard();
	}
	
	@GetMapping("/getBoardList")
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
//		for (int i = 1; i <= 10; i++) {
//			BoardVO board = new BoardVO();
//			board.setSeq(i);
//			board.setTitle("제목" + i);
//			board.setWriter("테스터");
//			board.setContent(i + "번 내용입니다.");
//			board.setCreateDate(new Date());
//			board.setCnt(0);
//			boardList.add(board);
//		}
//		return boardList;
		return boardService.getBoardList();
	}


}
