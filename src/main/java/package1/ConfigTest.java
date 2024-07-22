package package1;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@DevelopmentConfig
public class ConfigTest {

    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> System.out.println("Hello World, development profile activity in run");
    }
}
