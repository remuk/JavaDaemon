package de.java.daemon.test;

import de.java.daemon.service.DaemonService;
import de.java.daemon.service.DaemonServiceImpl;
import org.junit.Assert;
import org.junit.Test;

public class TestdaemonService {

    @Test
    public void testService() {

        DaemonService service = new DaemonServiceImpl();
        boolean flag = service.pingServer();

        Assert.assertEquals(flag, true);

    }
}
