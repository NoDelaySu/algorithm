import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {

    private final static Lock connectLock = new ReentrantLock();

    public static void main(String[] args) {
        connectLock.unlock();
    }
}
