package org.javatx.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 胡俊杰
 * @Date: 08点52分
 */
@Configuration
public class ServiceInfoConfig implements ApplicationListener<WebServerInitializedEvent> {
    private static WebServerInitializedEvent event;
    protected final static Logger logger = LoggerFactory.getLogger(ServiceInfoConfig.class);

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        ServiceInfoConfig.event = event;
        try {
            logger.info("入口: http://"+ InetAddress.getLocalHost().getHostAddress()+":"+event.getWebServer().getPort());
            logger.info("后台: http://"+ InetAddress.getLocalHost().getHostAddress()+":"+event.getWebServer().getPort()+"/houtai");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}