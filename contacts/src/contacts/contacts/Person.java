package contacts.contacts;

import contacts.exceptions.BadBirthDateException;
import contacts.exceptions.BadGenderException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Person extends Contact {

    private String surname;
    private boolean gender;
    private LocalDate birthDate;

    public Person() {
        super();
    }

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

    public char getGenderLetter() {
        return gender ? 'M' : 'F';
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setGender(String gender) {
        if (gender.equals("M")) {
            this.gender = true;
        } else if (gender.equals("F")) {
            this.gender = false;
        } else {
            throw new BadGenderException();
        }
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthDate(String birthDate) {
        try {
            this.birthDate = LocalDate.parse(birthDate);
        } catch (DateTimeParseException exc) {
            throw new BadBirthDateException();
        }
    }

    @Override
    public String toString() {
        return "Name: " + super.getName() + '\n' +
                "Surname: " + getSurname() + '\n' +
                "Gender: " + getGenderLetter() + '\n' +
                "Birth date: " + getBirthDate().toString() + '\n' +
                "Number: " + super.getPhoneNumber() + '\n' +
                "Time created: " + super.getCreatedAt() + '\n' +
                "Time last edit: " + super.getLastEditedAt() + '\n';
    }
}
