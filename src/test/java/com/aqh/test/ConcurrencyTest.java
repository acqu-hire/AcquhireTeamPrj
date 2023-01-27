//package com.aqh.test;
//import static org.junit.Assert.assertEquals;
//
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//import org.apache.ibatis.reflection.SystemMetaObject;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.aqh.board.domain.dto.BoardDTO;
//import com.aqh.board.service.QnAService;
//import com.aqh.reply.service.ReplyService2;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
//public class ConcurrencyTest {
//
//	@Autowired
//	ReplyService2 replyService2;
//	@Autowired
//	QnAService qnaService;
//	
//	@Test
//	public void CountingTest() {
//	        Count count = new Count();
//	        int cnt = 100;
//	        for (int i = 0; i < cnt; i++) {
//	            new Thread(){
//	                public void run(){
//	                    for (int j = 0; j < cnt; j++) {
//	                        System.out.println(count.view());
//	                    }
//	                }
//	            }.start();
//	        }
//	        assertEquals(cnt*cnt, count.getCount());
//	    }
//	
//	class Count {
//	    private int count;
//	    public int view() {return count++;}
//	    public int getCount() {return count;}
//	}
//	
//	@Test
//	public void ConcurrencyTest1() throws Exception {
//		long bNo = 618;
//		int numberOfThread = 600;
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setbNo(bNo);
//		boardDTO.setReadCount(qnaService.getReadCnt(bNo));
//		ExecutorService executorService = Executors.newFixedThreadPool(10);
//		CountDownLatch countDownLatch = new CountDownLatch(numberOfThread);
//		for(int i = 1; i <= numberOfThread; i++) {
//			executorService.execute(() -> {
//				qnaService.readCntUp(bNo);
//				System.out.println("ReadCount = " + qnaService.getReadCnt(bNo));
//				countDownLatch.countDown();
//			});
//		}
//		countDownLatch.await();
//		assertEquals(boardDTO.getReadCount(), qnaService.getReadCnt(bNo)-numberOfThread);
//		
//	}
//	
//	
//}
