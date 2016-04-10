package mapping.one2onefk;

public class PersonOne2OneFK {
    private int personid;
    private String name;
    private int age;
    private AddressOne2OneFK addressOne2OneFK;

    public AddressOne2OneFK getAddressOne2OneFK() {
        return addressOne2OneFK;
    }

    public void setAddressOne2OneFK(AddressOne2OneFK addressOne2OneFK) {
        this.addressOne2OneFK = addressOne2OneFK;
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

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }
}
