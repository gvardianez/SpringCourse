package lesson_1.diseases;

import org.springframework.stereotype.Component;

@Component
public class MyopiaDisease implements Disease {

    @Override
    public DiseaseType getDiseaseType() {
        return DiseaseType.MYOPIA;
    }
}
