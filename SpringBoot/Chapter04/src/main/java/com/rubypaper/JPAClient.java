package com.rubypaper;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class JPAClient {
	public static void main(String[] args) {
		// EntityManager 생성
		EntityManagerFactory emf = 
Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		
		try {
			// Transaction 시작
			tx.begin();

		
			//########## 게시글 등록 ##########
			Board board = new Board();
			board.setTitle("JAP 제목");
			board.setWriter("관리자");
			board.setContent("JPA 글 등록 잘 되네요.");
			board.setCreateDate(new Date());//java.util.Date()
			board.setCnt(0L);
		
			em.persist(board);
			
			//########## 게시글 조회 ##########
//			Board searchBoard = em.find(Board.class, 1L);
//			System.out.println("--->" + searchBoard.toString());
			
			//########## 게시글 수정 ##########
//			Board board = em.find(Board.class, 1L);
//			board.setTitle("검색한 게시글의 제목 수정");
//			
			//########## 게시글 삭제 ##########
//			Board board = em.find(Board.class, 1L);
//			em.remove(board);
			
			//########## 게시글 목록 조회 ##########
//			String jpql = "select * from board b order by b.seq desc";
//			
//			List<Board> boardList =
//					em.createQuery(jpql, Board.class).getResultList();
//			for (Board brd : boardList) {
//				System.out.println("---> " + brd.toString());
//			}
			
			// Transaction commit
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();			
			// Transaction rollback
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}		
	}
}
