package xinye;

import java.util.concurrent.Semaphore;

/**
 * @ClassName: Test01
 * @Package: xinye
 */


public class Test01 {
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);


    static class PrintThread implements Runnable{
        private String content;
        private Semaphore currentSemaphore;
        private Semaphore nextSemaphore;

        public PrintThread(String content, Semaphore currentSemaphore, Semaphore nextSemaphore) {
            this.content = content;
            this.currentSemaphore = currentSemaphore;
            this.nextSemaphore = nextSemaphore;
        }

        @Override
        public void run(){
            for (int i = 0; i < 10; i++) {
                try{
                    currentSemaphore.acquire();
                    System.out.print(content);
                    nextSemaphore.release();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintThread("A", semaphoreA, semaphoreB));
        Thread threadB = new Thread(new PrintThread("B", semaphoreB, semaphoreC));
        Thread threadC = new Thread(new PrintThread("C", semaphoreC, semaphoreA));

        threadA.start();
        threadB.start();
        threadC.start();

    }
}

