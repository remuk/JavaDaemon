package de.java.daemon;

import de.java.daemon.service.DaemonService;
import de.java.daemon.service.DaemonServiceImpl;
import de.java.daemon.service.InvokingDaemonTimer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String args[]) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String... args) throws Exception {

        Timer timer = new Timer();

        TimerTask task = new InvokingDaemonTimer();

        timer.schedule(task, 1000, 5000);

    }
}
