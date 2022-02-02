package lesson_1.diseases;

import org.springframework.stereotype.Component;

@Component
public class PneumoniaDisease implements Disease {

    @Override
    public DiseaseType getDiseaseType() {
        return DiseaseType.PNEUMONIA;
    }
}
