package com.test.mqtt;

import com.star.tcs.init.InitServer;
import org.junit.Test;

public class TestMq {

    @Test
    public void tests(){
        InitServer initServer = new InitServer();
        initServer.init();
    }
}
