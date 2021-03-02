package com.example.synchronization;

import com.example.synchronization.problem.Account;
import com.example.synchronization.problem.Card;
import com.example.synchronization.problem.EPay;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SynchronizationApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void test1() {
		// 开个银行帐号
		Account account = new Account();
		// 开银行帐号之后银行给张银行卡
		Card card = new Card("card",account);
		// 开银行帐号之后银行给张存折
		EPay ePay = new EPay("ePay",account);

		Thread thread1 = new Thread(card);
		Thread thread2 = new Thread(ePay);

		thread1.start();
		thread2.start();
		System.out.println("thread starting");
	}

}
