package concurreny;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    private final Semaphore allowedMembers;

    public SemaphoreExample(int maxCount){
        allowedMembers = new Semaphore(maxCount);
    }

    public boolean tryLogin(){
        return allowedMembers.tryAcquire();
    }

    public void tryLogout(){
        allowedMembers.release();
    }

    public int availableSlots(){
        return allowedMembers.availablePermits();
    }
}
