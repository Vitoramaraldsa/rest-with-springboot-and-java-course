package br.com.vitor.data.vo.V2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class PersonVoV2 implements Serializable {

    private static final long serialVersionUID = 1l;


    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Date birthDay;


    public PersonVoV2() {
    }

    public PersonVoV2(Long id, String firstName, String lastName, String address, String gender, Date birthDay) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
        this.birthDay = birthDay;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDay() {return birthDay;}

    public void setBirthDay(Date birthDay) {this.birthDay = birthDay;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonVoV2 personVo = (PersonVoV2) o;
        return Objects.equals(id, personVo.id) && Objects.equals(firstName, personVo.firstName) && Objects.equals(lastName, personVo.lastName) && Objects.equals(address, personVo.address) && Objects.equals(gender, personVo.gender) && Objects.equals(birthDay, personVo.birthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, gender, birthDay);
    }
}
