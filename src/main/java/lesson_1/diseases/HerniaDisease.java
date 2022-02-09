package lesson_1.diseases;

import org.springframework.stereotype.Component;

@Component
public class HerniaDisease implements Disease {

    @Override
    public DiseaseType getDiseaseType() {
        return DiseaseType.HERNIA;
    }
}
