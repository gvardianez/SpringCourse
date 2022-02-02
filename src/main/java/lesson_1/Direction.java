package lesson_1;

public class Direction {

    private String clientName;

    private String disease;

    private String doctor;

    public Direction(String clientName, String disease, String doctor) {
        this.clientName = clientName;
        this.doctor = doctor;
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "clientName='" + clientName + '\'' +
                ", disease='" + disease + '\'' +
                ", doctor='" + doctor + '\'' +
                '}';
    }
}
