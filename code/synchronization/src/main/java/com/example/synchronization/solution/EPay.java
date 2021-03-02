package com.example.synchronization.solution;

/**
 * Created by IntelliJ IDEA.
 *
 * @author
 * description:
 * @since 2021/2/10 下午10:07
 * version: 1.0.0
 */
public class EPay implements Runnable {
    private String name;
    private Account account = new Account();

    public EPay(String name, Account account) {
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
            account.withdrawMoney(name,50);
        }

    }
}
