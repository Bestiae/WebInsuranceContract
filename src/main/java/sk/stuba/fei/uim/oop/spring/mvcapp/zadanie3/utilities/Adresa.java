package sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.utilities;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

@Data
public class Adresa {
    @NotNull
    private int PSC;
    @NotNull
    private String city;
    @NotNull
    private String township;
    @NotNull
    private String street;
    @Min(0)
    private int houseNumber;

    public Adresa(){
        PSC = 0;
        city = "";
        township = "";
        street = "";
        houseNumber = 0;
    }

    public Adresa(BufferedReader reader)
    {
        try {
            System.out.println("PSC: ");
            this.setPSC(Integer.parseInt(reader.readLine()));
            System.out.println("City: ");
            this.setCity(reader.readLine());
            System.out.println("Township: ");
            this.setTownship(reader.readLine());
            System.out.println("Street: ");
            this.setStreet(reader.readLine());
            System.out.println("Building number: ");
            this.setHouseNumber(Integer.parseInt(reader.readLine()));
        } catch (IOException e) {
            System.out.println("Invalid value entered");
        }
    }

    public Adresa(int PSC, String city, String township, String street, int houseNumber )
    {
        this.PSC = PSC;
        this.city = city;
        this.township = township;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adresa address = (Adresa) o;
        return PSC == address.PSC &&
                houseNumber == address.houseNumber &&
                Objects.equals(city, address.city) &&
                Objects.equals(township, address.township) &&
                Objects.equals(street, address.street);

    }

    @Override
    public String toString() {
        return  " " + PSC +
                " " + city +
                " " + township +
                " " + street +
                " " + houseNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(PSC, city, township, street, houseNumber);
    }

    public boolean isEmpty()
    {
        if(PSC == 0 && city.equals("") && township.equals("") && street.equals("") && houseNumber == 0)
            return true;
        return false;
    }
//
//    public int getPSC() {
//        return PSC;
//    }
//
    public String getCity() {
        return city;
    }
//
    public String getTownship() {
        return township;
    }
//
    public String getStreet() {
        return street;
    }
//
    public int getHouseNumber() {
        return houseNumber;
    }
//
    public void setPSC(int PSC) {
        this.PSC = PSC;
    }
//
    public void setCity(String city) {
        this.city = city;
    }
//
    public void setTownship(String township) {
        this.township = township;
    }
//
    public void setStreet(String street) {
        this.street = street;
    }
//
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
}
