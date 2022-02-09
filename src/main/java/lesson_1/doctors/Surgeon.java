package lesson_1.doctors;

import lesson_1.diseases.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Surgeon implements Doctor{

    List<Disease> specializedDiseases;

    @Autowired
    public Surgeon(@Qualifier("herniaDisease") List<Disease> diseases) {
        this.specializedDiseases = diseases;
    }

    public List<Disease> getSpecializedDiseases() {
        return specializedDiseases;
    }

    @Override
    public DoctorSpecialization getDoctorSpecialization() {
        return DoctorSpecialization.SURGEON;
    }
}
