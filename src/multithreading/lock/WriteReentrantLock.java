package multithreading.lock;

/* Raj Kumar Boddupally created on 11/10/2023 inside the package - multithreading */

import java.util.HashMap;
import java.util.Map;

/*
    Write reentrance is granted only if the thread has already write access
 */
public class WriteReentrantLock {
  private final Map<Thread, Integer> readingThreads = new HashMap<>();
  private int writingThreads = 0;
  private int writeRequests = 0;

  private Thread currentThread = null;

  public synchronized void writeLock() throws InterruptedException {
     writeRequests++;
     Thread callingThread = Thread.currentThread();
     while(!canGrantWriteAccess(callingThread)){
        wait();
     }
     writingThreads++;
     writeRequests--;
     currentThread = callingThread;
  }

  public synchronized void writeUnlock(){
      writingThreads --;
      if(writingThreads == 0){
          currentThread = null;
      }
      notifyAll();
  }

    private boolean canGrantWriteAccess(Thread callingThread) {
      if(hasReaders()) return false;
      if(callingThread == null) return true;
      if(!isWriter(callingThread)) return false;
      return true;
    }

    private boolean isWriter(Thread callingThread) {
      return currentThread == callingThread;
    }

    private boolean hasReaders() {
     return !readingThreads.isEmpty();
    }
}
