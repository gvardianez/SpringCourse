package lesson_1.doctors;

import lesson_1.diseases.Disease;

import java.util.List;

public interface Doctor {
DoctorSpecialization getDoctorSpecialization();
List<Disease> getSpecializedDiseases();
}
