package be.vdab.persons;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;

@Entity
@Table (name="PERSONS",
        indexes = {@Index ( name = "PERSON_INDEX",
                            columnList = "LAST_NAME, BIRTHDAY")})
@SecondaryTable(name = "URLS")
public class Person {

    @Id
    @GeneratedValue
    @Column (name="ID")
    private long id;

    @Version
    @Column (name="VERSION")
    private long version;

    @Column (   name="FIRST_NAME",
                length = 40,
                nullable = false)
    private String firstName;

    @Column (   name="LAST_NAME",
                length = 40,
                nullable = false)
    private String lastName;

    @Embedded
    private Address address = new Address();

    //@Temporal(TemporalType.DATE)
    @Column (name="BIRTHDAY")
    private LocalDate birthDay;

    @Enumerated (EnumType.STRING)
    @Column (name="GENDER",
            updatable = false,
            length = 10,
            nullable = false)
    private GenderType gender;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column (name="PICTURE")
    private byte[] picture;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column (name="COMMNT")
    private String comment;

    @Column (name="MARRIED",
            columnDefinition = "Boolean")
    private boolean married;

    @Transient
    private int age;

    @Column (name="HOMEPAGE",
            length = 255,
            table="URLS")
    private String homepage;

    public Person() {
    }

    // Getters & Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
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

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", version=" + version +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", birthDay=" + birthDay +
                ", gender=" + gender +
                ", picture=" + Arrays.toString(picture) +
                ", comment='" + comment + '\'' +
                ", married=" + married +
                ", age=" + age +
                ", homepage='" + homepage + '\'' +
                '}';
    }
}

