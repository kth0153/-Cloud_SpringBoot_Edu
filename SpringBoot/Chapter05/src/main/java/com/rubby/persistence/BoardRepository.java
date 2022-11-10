package com.rubby.persistence;

import com.rubby.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {

    // 쿼리 메소드 사용하기 - 글 제목으로 목록 조회
    List<Board> findByTitle(String searchKeyWord);

    // Like 연산자
    List<Board> findByContentContaining(String searchKeyWord);

    // 여러 조건 사용하기
    List<Board> findByTitleContainingOrContentContaining(String title, String content);

    // 데이터 정렬
    List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);

    // 페이징 처리
    //List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
    Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);

//    @Query("SELECT b from Board b where b.title like %?1% order by b.seq desc")
//    List<Board> queryAnnotationTest1(String searchKeyword);

   /* @Query("select b from Board b where b.title like %:searchKeyword% order by b.seq desc")
    List<Board> queryAnnotationTest1(@Param("searchKeyword") String searchKeyword);

    @Query("select b.seq, b.title, b.writer, b.createDate from Board b where b.title like %?1% order by b.seq desc")
    List<Object[]> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);

    @Query(value = "select seq,title,writer,create_date from board where title like '%'||?1||'%' order by seq desc", nativeQuery = true)
    List<Object[]> queryAnnotationTest3(@Param("searchKeyword") String searchKeyword);

    @Query("select b from Board b order by b.seq desc ")
    List<Board> queryAnnotationTest4(Pageable paging);*/


}
