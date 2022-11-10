package com.rubby;

import com.rubby.domain.Board;
import com.rubby.persistence.BoardRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class QueryMethodTest {
    @Autowired
    private BoardRepository boardRepo;

    //@BeforeEach
    public void dataPrepare(){
        for(int i = 1; i<=200; i++){
            Board board = new Board();
            board.setTitle("테스트 제목" + i);
            board.setWriter("테스터");
            board.setContent("테스트 내용" + i);
            board.setCreateDate(new Date());
            board.setCnt(0L);
            boardRepo.save(board);
        }
    }

    @Test
    public void testFindByTitle(){
        List<Board> boardList = boardRepo.findByTitle("테스트 제목10");

        System.out.println("검색 결과");
        for(Board board : boardList){
            System.out.println("------->" + board.toString());
        }
    }

    @Test
    public void testByContentContaining(){
        List<Board> boardList = boardRepo.findByContentContaining("17");
        for(Board board : boardList){
            System.out.println("--->" + board.toString());
        }
    }

    @Test
    public void testFindByTitleContainingOrContentContaining(){
        List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("17","17");

        System.out.println("검색 결과");
        for(Board board : boardList){
            System.out.println("--->" + board.toString());
        }
    }

    @Test
    public void testFindByTitleContainingOrderBySeqDesc() {
        List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");

        System.out.println("검색 결과");
        for(Board board : boardList){
            System.out.println("--->" + board.toString());
        }
    }

//    @Test
//    public void testFindByTitleContaining() {
//        Pageable paging = PageRequest.of(0,5, Sort.Direction.DESC, "seq");
//        List<Board> boardList = boardRepo.findByTitleContaining("제목", paging);
//
//        System.out.println("검색 결과");
//        for(Board board : boardList){
//            System.out.println("--->" + board.toString());
//        }
//    }

    @Test
    public void testFindByTitleContaining() {
        Pageable paging = PageRequest.of(0,5, Sort.Direction.DESC, "seq");
        Page<Board> pageInfo = boardRepo.findByTitleContaining("제목", paging);

        System.out.println("PAGE SIZE" + pageInfo.getSize());
        System.out.println("TOTAL PAGES" + pageInfo.getTotalPages());
        System.out.println("TOTAL COUNT" + pageInfo.getTotalElements());
        System.out.println("NEXT" + pageInfo.nextPageable());

        List<Board> boardList = pageInfo.getContent();

        System.out.println("검색 결과");
        for(Board board : pageInfo){
            System.out.println("--->" + board.toString());
        }
    }

}
