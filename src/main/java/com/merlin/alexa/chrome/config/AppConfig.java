package com.merlin.alexa.chrome.config;

import com.merlin.alexa.chrome.websockets.AlexaReceiver;
import com.merlin.alexa.chrome.websockets.ChromeExtension;
import org.eclipse.jetty.websocket.jsr356.server.AnnotatedServerEndpointConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.websocket.DeploymentException;
import javax.websocket.server.ServerContainer;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;

@Configuration
public class AppConfig  {
    @Autowired private WebApplicationContext context;

    private ServerContainer container;

    public class SpringServerEndpointConfigurator extends ServerEndpointConfig.Configurator {
        @Override
        public < T > T getEndpointInstance( Class< T > endpointClass )
                throws InstantiationException {
            return context.getAutowireCapableBeanFactory().createBean( endpointClass );
        }
    }

    @Bean
    public ServerEndpointConfig.Configurator configurator() {
        return new SpringServerEndpointConfigurator();
    }

    @PostConstruct
    public void init() throws DeploymentException {
        container = ( ServerContainer )context.getServletContext().
                getAttribute( javax.websocket.server.ServerContainer.class.getName() );

        container.addEndpoint(
                new AnnotatedServerEndpointConfig(
                        ChromeExtension.class,
                        ChromeExtension.class.getAnnotation( ServerEndpoint.class )
                ) {
                    @Override
                    public Configurator getConfigurator() {
                        return configurator();
                    }
                }
        );

        container.addEndpoint(
                new AnnotatedServerEndpointConfig(
                        AlexaReceiver.class,
                        AlexaReceiver.class.getAnnotation( ServerEndpoint.class )
                ) {
                    @Override
                    public Configurator getConfigurator() {
                        return configurator();
                    }
                }
        );
    }
}