package de.java.daemon.service;


import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Logger;

public class InvokingDaemonTimer extends TimerTask {

    public static int i = 0;
    private static final Logger LOGGER = Logger.getLogger(DaemonServiceImpl.class.getName());
    private DaemonService daemonService = new DaemonServiceImpl();
    private List<Boolean> booleans = new ArrayList<>();
    private long currentTimeStamp = System.currentTimeMillis();

    public void run()
    {
        LOGGER.info("Service ran for ::" + ++i);
        boolean flag = daemonService.pingServer();
        booleans.add(flag);

        //Alert alert = new Alert(Alert.AlertType.INFORMATION);
        //ButtonType boutonOk = new ButtonType("Ok");

        if(System.currentTimeMillis() - currentTimeStamp > 60000) {
            if(booleans.contains(false)) {
                if(booleans.contains(true)) {
                    LOGGER.info("Server connection broke in between !!!");
                    /*alert.setContentText("Server connection broke in between !!!");
                    alert.getButtonTypes().add(boutonOk);*/
                    currentTimeStamp = System.currentTimeMillis();
                    booleans.clear();
                } else {
                    LOGGER.info("Server is not responding !!!");
                    /*alert.setContentText("Server is not responding !!!");
                    alert.getButtonTypes().add(boutonOk);*/
                    currentTimeStamp = System.currentTimeMillis();
                    booleans.clear();
                }
            }
            else {
                LOGGER.info("Server Connectivity Health is Good !!!");
                /*alert.setContentText("Server Connectivity Health is Good !!!");
                alert.getButtonTypes().add(boutonOk);*/
                currentTimeStamp = System.currentTimeMillis();
                booleans.clear();
            }
        }

    }

}
