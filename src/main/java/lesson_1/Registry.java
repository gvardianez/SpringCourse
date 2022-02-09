package lesson_1;

import lesson_1.doctors.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class Registry {

    private final List<Doctor> doctors;

    @Autowired
    public Registry(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public Direction getDirection(Client client) {
        Optional<Doctor> doctor = doctors.stream().filter(s -> s.getSpecializedDiseases().contains(client.getDisease())).findAny();
        if (doctor.isPresent()) {
            Doctor doc = doctor.get();
            return new Direction(client.getName(), client.getDisease().getDiseaseType().toString(), doc.getDoctorSpecialization().toString());
        } else
            return new Direction(client.getName(), client.getDisease().getDiseaseType().toString(), "Ваше заболевание неизлечимо нашими врачами");
    }

}
