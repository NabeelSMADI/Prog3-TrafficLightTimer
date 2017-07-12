
public class Testing extends Thread{
    Timer timerT = new Timer() ;
    public static boolean blinking = true;
    public static boolean testing = false;

    public void run() {
        timerT.start();
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                if(testing){
                    System.out.println("on");
                    if(blinking){
                        TrafficLight.blinkOn();
                        timerT.blinking((long) 1);
                    }else{
                        TrafficLight.blinkOff();
                        timerT.blinking((long) 1);
                    }
                }


    }

    }}
