import java.util.concurrent.atomic.AtomicInteger;
class Test extends Thread
{
    private int number = new AtomicInteger();
    
    public synchronized void incrementNumber() {
        number.getAndIncrement();

    }
    
    public synchronized AtomicInteger getNumber() {
        return this.number;
    }
    
    public static void main(String[] args) throws InterruptedException {
        final Test rmw = new Test();
        
        for (int i = 0; i < 1_000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rmw.incrementNumber();
                }
            }, "T" + i).start();
        }
        
        Thread.sleep(4000);

        System.out.println("Final number (should be 1_000): " + rmw.getNumber());
    }
    
}


