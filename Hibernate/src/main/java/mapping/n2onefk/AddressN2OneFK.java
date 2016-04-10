package mapping.n2onefk;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "address_n1kf")
public class AddressN2OneFK {
    private int addressid;
    private String addressdetail;

    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public String getAddressdetail() {
        return addressdetail;
    }

    public void setAddressdetail(String addressdetail) {
        this.addressdetail = addressdetail;
    }

    public static void main(String [] args){
        AddressN2OneFK anf = new AddressN2OneFK();

        String path = anf.getClass().getClassLoader().getResource("ehcache.xml").getPath();
        System.out.println(path);
    }
}