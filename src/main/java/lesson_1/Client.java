package lesson_1;

import lesson_1.diseases.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Client {

    private final String name;

    private Disease disease;

    public String getName() {
        return name;
    }

    public Disease getDisease() {
        return disease;
    }

    @Autowired
    public Client(@Value("${client.name}") String name, @Qualifier("myopiaDisease") Disease disease) {
        this.disease = disease;
        this.name = name;
    }


}
