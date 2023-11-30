package concurreny;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SemaphoreExampleTest {

    @Test
    public void checkMaxLimit() throws InterruptedException {
        int limit = 10;
        SemaphoreExample totalSlots = new SemaphoreExample(limit);

        ExecutorService executorService = Executors.newFixedThreadPool(limit);
        IntStream.range(0,limit).forEach(user -> executorService.execute(totalSlots::tryLogin));
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        assertEquals(0, totalSlots.availableSlots());
        assertFalse(totalSlots.tryLogin());
        totalSlots.tryLogout();
        assertEquals(1, totalSlots.availableSlots());
    }
}