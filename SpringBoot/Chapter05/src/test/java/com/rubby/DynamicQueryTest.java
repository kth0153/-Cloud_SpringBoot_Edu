package com.rubby;


import com.querydsl.core.BooleanBuilder;
import com.rubby.domain.Board;
import com.rubby.domain.QBoard;
import com.rubby.persistence.DynamicBoardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DynamicQueryTest {
    @Autowired
    private DynamicBoardRepository boardRepo;

    @Test
    public void testDynamicQuery(){
        String searchCondition = "TITLE";
        String searchKeyword = "테스트 제목10";

        BooleanBuilder builder = new BooleanBuilder();

        QBoard qBoard = QBoard.board;

        if(searchCondition.equals("TITLE")){
            builder.and(qBoard.title.like("%"+searchKeyword + "%"));
        }else if(searchCondition.equals("CONTENT")){
            builder.and(qBoard.content.like("%"+searchKeyword + "%"));
        }

        Pageable paging = PageRequest.of(0,5);

        Page<Board> boardList = boardRepo.findAll(builder, paging);

        System.out.println("검색 결과");
        for(Board board : boardList){
            System.out.println("------->" + board.toString());
        }
    }
}
