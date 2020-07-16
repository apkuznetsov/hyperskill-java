package contacts.contacts;

import java.time.LocalDate;

public class Person extends Contact {

    private String surname;
    private boolean gender;
    private LocalDate birthDate;

    public Person(String name, String surname, String phoneNumber, boolean gender, LocalDate birthDate) {
        super(name, phoneNumber);
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isMale() {
        return gender;
    }

    public boolean isFemale() {
        return !gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "" + super.getName() + " " + surname + ", " + super.getPhoneNumber();
    }
}
