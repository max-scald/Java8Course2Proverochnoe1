package Task2;



import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService  executor = Executors.newScheduledThreadPool(1);
        try {
            executor.scheduleAtFixedRate(new CountDirectory("C:\\JAVA\\Git"),5,60, TimeUnit.SECONDS);//dir 603 files  5303
        }catch (Exception ex){
            ex.printStackTrace();
        }
        //executor.shutdown();
    }

}
