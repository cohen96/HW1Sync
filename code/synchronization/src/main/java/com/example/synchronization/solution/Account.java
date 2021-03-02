package com.example.synchronization.solution;

import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 *
 * @author
 * description:
 * @since 2021/2/9 下午9:25
 * version: 1.0.0
 */
public class Account {
    private int count=0;

    /**
     * depositMoney
     * @param name term of payment
     * @param money money
     */
    public synchronized void depositMoney(String name, int money) {
        // saveMoney
        count += money;
        System.out.println(name+"-deposit："+money+"..."+Thread.currentThread().getName());
        queryBalance(name);
    }

    /**
     * withdrawMoney
     * @param name term of payment
     * @param money money
     */
    public synchronized void withdrawMoney(String name, int money) {
        // judge money enough
        if(count-money < 0){
            System.out.println("Insufficient balance！");
            return;
        }
        // withdrawMoney
        count -= money;
        System.out.println(name+"-withdraw："+money+"..."+Thread.currentThread().getName());
        queryBalance(name);
    }

    /**
     * query balance
     * @param name term of payment
     */
    public void queryBalance(String name) {
        System.out.println(name+"-balance："+count);
    }


    @Test
    public void testSync() {
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
        while (true) {}
    }

}
