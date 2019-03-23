package de.java.daemon.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Logger;

@Service
@PropertySource("classpath:application.properties")
public class DaemonServiceImpl implements DaemonService{

    private static final Logger LOGGER = Logger.getLogger(DaemonServiceImpl.class.getName());

    @Value("${host}")
    private String host;

    public boolean pingServer() {
        LOGGER.info("Daemon Service started !!!");

        System.out.println("host::" +host );

        boolean flag = false;
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("localhost", 8080), 1000);
            flag = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("Server status:::" + flag);

        return flag;
    }
}
