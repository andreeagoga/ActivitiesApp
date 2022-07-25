package ro.ubb.hellorpc.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import ro.ubb.hellorpc.client.service.MontaniarziiServiceClient;
import ro.ubb.hellorpc.client.ui.ClientConsole;
import ro.ubb.hellorpc.common.MontaniarziiService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@Configuration
public class ClientConfig {

    @Bean
     RmiProxyFactoryBean rmiProxyFactoryBean() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1099/MontaniarziiService");
        rmiProxyFactoryBean.setServiceInterface(MontaniarziiService.class);
        return rmiProxyFactoryBean;
    }

    @Bean
    ClientConsole clientConsole(){
        return new ClientConsole(montaniarziiService());
    }

    @Bean
    MontaniarziiService montaniarziiService(){
        return new MontaniarziiServiceClient();
    }

}
