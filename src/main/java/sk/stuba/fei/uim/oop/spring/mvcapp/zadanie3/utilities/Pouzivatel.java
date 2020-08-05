package sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.utilities;


import lombok.*;
import sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.zmluvy.Zmluva;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Pouzivatel {
    private long            id;
    private String          firstName;
    private String          lastName;
    private int             idNumber;
    private String          email;
    private Adresa permAddress;
    private Adresa corrAddress;
    private List<Zmluva> zmluvy;


    public Pouzivatel(long id, String firstName, String lastName, int idNumber, String email, Adresa permAddress, Adresa corrAddress ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.email = email;
        this.permAddress = permAddress;
        if( corrAddress == null )
        {
            this.corrAddress = permAddress;
        }
        else
        {
            this.corrAddress = corrAddress;
        }
        this.zmluvy = new ArrayList<>();
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idNumber=" + idNumber +
                ", email='" + email + '\'' +
                ", permAddress=" + permAddress.toString() +
                ( permAddress.equals( corrAddress ) ? "" : ", corrAddress=" + corrAddress.toString() );
    }

    public void edit( Pouzivatel u )
    {
        this.id = u.getId();
        this.firstName = u.getFirstName();
        this.lastName = u.getLastName();
        this.idNumber = u.getIdNumber();
        this.email = u.getEmail();
        this.permAddress = u.getPermAddress();
        this.corrAddress = u.getCorrAddress();
    }


    public long getId() {
        return id;
    }

    public void printZmluvy() {
        for (Zmluva c: zmluvy) {
            System.out.println(c.toString());
        }
    }

    public String getFullName()
    {
        return this.firstName + ' ' + this.lastName;
    }

    public String getEmail()
    {
        return this.email;
    }

    public Zmluva getZmluva(long id)
    {
        for(Zmluva c : zmluvy)
        {
            if (c.getId() == id)
                return c;
        }
        return null;
    }

    public void addZmluva(Zmluva c )
    {
        c.setInsurerId(this.id);
        this.zmluvy.add( c );
    }

    public void initZmluva()
    {
        this.zmluvy = new ArrayList<>();
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setCorrAddress(Adresa corrAddress) {
        this.corrAddress = corrAddress;
    }

//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public Adresa getPermAddress() {
//        return permAddress;
//    }
//
//    public void setPermAddress(Adresa permAddress) {
//        this.permAddress = permAddress;
//    }
}
