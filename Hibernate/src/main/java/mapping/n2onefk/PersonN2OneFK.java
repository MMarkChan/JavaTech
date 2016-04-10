package mapping.n2onefk;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "person_n1kf")
public class PersonN2OneFK {
    private int personid;
    private String name;
    private int age;

    private AddressN2OneFK addressN2OneFK;

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public AddressN2OneFK getAddressN2OneFK() {
        return addressN2OneFK;
    }

    public void setAddressN2OneFK(AddressN2OneFK addressN2OneFK) {
        this.addressN2OneFK = addressN2OneFK;
    }
}