package lesson_1.doctors;

import lesson_1.diseases.Disease;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Therapist implements Doctor {

    List<Disease> specializedDiseases;

    public Therapist(List<Disease> diseases) {
        this.specializedDiseases = diseases;
    }

    @Override
    public DoctorSpecialization getDoctorSpecialization() {
        return DoctorSpecialization.THERAPIST;
    }

    @Override
    public List<Disease> getSpecializedDiseases() {
        return specializedDiseases;
    }


}
