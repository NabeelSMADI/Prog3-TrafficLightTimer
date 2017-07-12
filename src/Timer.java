import java.util.Date;

public class Timer extends Thread{
    public long startTime;
    public long endTime;
    public long elapsedTime = 0L;

    public void run() {

    }

    public  void waits(Long time)  {
        startTime = System.currentTimeMillis();
        elapsedTime = 0L;
        endTime = time;
        if(!Controller.wait){
        Controller.wait = true;
        while (elapsedTime < endTime*1000 ) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            elapsedTime = (new Date()).getTime() - startTime;

        }
        Controller.wait = false;
        }

    }

    public  void blinking(Long time)  {
        long startTime = System.currentTimeMillis();
        long  elapsedTime = 0L;
        long endTime = time;
        Testing.blinking = !Testing.blinking;
        while (elapsedTime < endTime*1000) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            elapsedTime = (new Date()).getTime() - startTime;

        }


    }





}
