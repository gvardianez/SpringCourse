package lesson_1;

import lesson_1.diseases.Disease;
import lesson_1.diseases.FluDisease;
import lesson_1.diseases.HerniaDisease;
import lesson_1.diseases.PneumoniaDisease;
import lesson_1.doctors.Therapist;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ComponentScan
@Configuration
@PropertySource("classpath:/app.properties")
public class AppConfig {

    @Bean
    public FluDisease fluDisease() {
        return new FluDisease();
    }

    @Bean
    public PneumoniaDisease pneumoniaDisease() {
        return new PneumoniaDisease();
    }

    @Bean
    public HerniaDisease herniaDisease() {
        return new HerniaDisease();
    }

    @Bean
    public List<Disease> diseaseListTherapist() {
        return new ArrayList<>(Arrays.asList(fluDisease(), pneumoniaDisease()));
    }

    @Bean
    public Therapist therapist() {
        return new Therapist(diseaseListTherapist());
    }

    @Bean
    public Client clientOne() {
        return new Client("Petya", fluDisease());
    }

    @Bean
    public Client clientTwo() {
        return new Client("Vova", herniaDisease());
    }

    @Bean
    public Client clientThree() {
        return new Client("Masha", pneumoniaDisease());
    }


}
