package giorni.Supermercato;
//https://stackoverflow.com/questions/26416258/priorityqueue-student-cannot-be-cast-to-java-lang-comparable
public class Student implements Comparable<Student> {

    private Long id;
    private String firstName;
    private String lastName;

    public Student(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


//getter,setter and constructor

    @Override
    public int compareTo(Student student) {
        if (this.id.equals(student.getId())) {
            return 0;
        } else if (this.id > student.getId()) {
            return -1;
        } else {
            return 1;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}