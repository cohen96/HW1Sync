package com.example.synchronization.problem;

/**
 * Created by IntelliJ IDEA.
 *
 * @author
 * description:
 * @since 2021/2/10 下午10:06
 * version: 1.0.0
 */
public class Card implements Runnable {

    private String name;
    private Account account;

    public Card(String name,Account account) {
        this.account = account;
        this.name = name;
    }

    @Override
    public void run() {

        for(;;) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.depositMoney(name,100);
        }
    }
}
