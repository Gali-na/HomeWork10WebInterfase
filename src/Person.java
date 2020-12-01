import java.util.Objects;

public class Person {
    private int age;
    private String name;
    private String surname;
    private String gender;

    public Person(int age, String name, String surname, String gender) {
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    public Person() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name) &&
                surname.equals(person.surname) &&
                gender.equals(person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, surname, gender);
    }

    @Override
    public String toString() {
        return "surname - " + surname + ";" + " name -" + name + ";" + " age -" + age + " gender- " + gender;
    }
}
