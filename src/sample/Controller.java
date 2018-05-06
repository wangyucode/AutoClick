package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    Button start;

    @FXML
    TextArea log;

    ClickThread clickThread;

    @FXML
    public void onStartClicked() {
        if(start.getText().equals("start")){
            start.setText("stop");
            clickThread = new ClickThread(this);
            clickThread.start();
        }else{
            start.setText("start");
            clickThread.isStopped = true;
        }

    }

    public void addLog(String s){
        log.appendText(s+"\n");
    }


    public void initialize() {
        clickThread = new ClickThread(this);
    }
}
