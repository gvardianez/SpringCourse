package lesson_1.doctors;

import lesson_1.diseases.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Oculist implements Doctor {

    List<Disease> specializedDiseases;

    @Autowired
    public Oculist(@Qualifier("myopiaDisease") List<Disease> diseases) {
        this.specializedDiseases = diseases;
    }

    @Override
    public DoctorSpecialization getDoctorSpecialization() {
        return DoctorSpecialization.OCULIST;
    }

    @Override
    public List<Disease> getSpecializedDiseases() {
        return specializedDiseases;
    }
}
