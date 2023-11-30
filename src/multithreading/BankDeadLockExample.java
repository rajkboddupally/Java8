package multithreading;

public class BankDeadLockExample {
    public static void main(String [] args){
        final Account a = new Account(1,1000);
        final Account b = new Account(2,300);
        Thread thread1 = new Thread(() -> transfer(a,b,200));
        Thread thread2 = new Thread(() -> transfer(b,a,300));
        thread1.start();
        thread2.start();
    }
    public static void transfer(Account from, Account to, double amount){
        Account first = from;
        Account second = to;

        if(first.compareTo(second) < 0){
            from = second;
            to = first;
        }


        synchronized(from){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized(to){
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }
}


class Account implements Comparable{
    double balance;
    int id;
    public Account(int id, double balance){
        this.balance = balance;
        this.id = id;
    }
    void withdraw(double amount){
        System.out.println("withdraw "+ Thread.currentThread().getName());
        balance -= amount;
    }
    void deposit(double amount){
        System.out.println("deposit "+ Thread.currentThread().getName());
        balance += amount;
    }

    @Override
    public int compareTo(Object o) {
        Account acc = (Account) o;
        return this.id - acc.id;
    }
}
