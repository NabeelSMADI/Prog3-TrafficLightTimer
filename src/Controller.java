import java.util.Date;

public class Controller extends Thread{
    Timer timerN = new Timer() ;
    public static boolean wait = false;



    public void run() {
        timerN.start();
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!wait && !Testing.testing){
                switch (TrafficLight.status){
                    case 0:
                        TrafficLight.red();
                        TrafficLight.status = 1;
                        timerN.waits((long) 2);
                        break;
                    case 1:
                        TrafficLight.redyellow();
                        TrafficLight.status = 2;
                        timerN.waits((long) 1);
                        break;
                    case 2:
                        TrafficLight.green();
                        TrafficLight.status = 3;
                        timerN.waits((long) 3);
                        break;
                    case 3:
                        TrafficLight.yellow();
                        TrafficLight.status = 0;
                        timerN.waits((long) 1);
                        break;
                }

            }

        }



    }




    public void red() {
        TrafficLight.red();
        TrafficLight.status = 1;
        timerN.waits((long) 2);
    }

    public  void green(){
        TrafficLight.green();
        TrafficLight.status = 3;
        timerN.waits((long) 3);
    }






}
