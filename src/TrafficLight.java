import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;




public class TrafficLight extends Application{
    public static Circle cRot;
    public static Circle cGelb;
    public static Circle cGrun;
    public static int status = 0;


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller controller = new Controller() ;
        Testing testing = new Testing();
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root,300,300);

        Group g = new Group();
        root.setCenter(g);
        Rectangle rectangle = new Rectangle(0,0,75,225);
        cRot = new Circle(75/2, 75/2, 70/2);
        cGelb = new Circle(75/2, (75/2)+75, 70/2);
        cGrun = new Circle(75/2, (75/2)+150, 70/2);
        cRot.setFill(Color.RED);
        cGelb.setFill(Color.BLACK);
        cGrun.setFill(Color.BLACK);
        g.getChildren().add(rectangle);
        g.getChildren().add(cRot);
        g.getChildren().add(cGelb);
        g.getChildren().add(cGrun);

        HBox row = new HBox();
        root.setBottom(row);
        Button bRot = new Button("Red");
        row.getChildren().add(bRot);
        bRot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                controller.red();
            }
        });
        Button bGrun = new Button("Green");
        row.getChildren().add(bGrun);
        bGrun.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                controller.green();
            }
        });
        Button bBlink = new Button("Blink");
        row.getChildren().add(bBlink);
        bBlink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(Testing.testing){
                    Testing.testing = false;
                    status = 0;
                }else{
                    Testing.testing = true;
                    blinkOff();
                }
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();


        controller.start();
        testing.start();

    }




    public static void green(){
        cRot.setFill(Color.BLACK);
        cGelb.setFill(Color.BLACK);
        cGrun.setFill(Color.GREEN);
    }

    public static void yellow(){
        cRot.setFill(Color.BLACK);
        cGelb.setFill(Color.YELLOW);
        cGrun.setFill(Color.BLACK);
    }

    public static void red(){
        cRot.setFill(Color.RED);
        cGelb.setFill(Color.BLACK);
        cGrun.setFill(Color.BLACK);
    }

    public static void redyellow(){
        cRot.setFill(Color.RED);
        cGelb.setFill(Color.YELLOW);
        cGrun.setFill(Color.BLACK);
    }

    public static void blinkOn(){
        cRot.setFill(Color.BLACK);
        cGelb.setFill(Color.YELLOW);
        cGrun.setFill(Color.BLACK);
    }

    public static void blinkOff(){
        cRot.setFill(Color.BLACK);
        cGelb.setFill(Color.BLACK);
        cGrun.setFill(Color.BLACK);
    }



}
