package sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.zmluvy;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.utilities.Adresa;

@Data
@NoArgsConstructor
public class NezivotnePoistenie extends Zmluva{
    public enum type
    {
        APARTMENT("Apartment"),
        HOUSE_STONE("Stone house"),
        HOUSE_WOOD("Wooden house"),
        UNKNOWN("Unknown");
        private final String displayValue;

        private type(String displayValue) {
            this.displayValue = displayValue;
        }

        public String getDisplayValue() {
            return displayValue;
        }
    }
    private Adresa address;
    private float propertyValue;
    private type propertyType;


    @Override
    public String toString() {
        return super.toString() +
                ", address=" + address.toString() +
                ", propertyValue=" + propertyValue +
                ", propertyType=" + propertyType.toString();
    }

    @Override
    public void edit( Zmluva c )
    {
        super.edit(c);
        this.propertyValue = ((NezivotnePoistenie) c).getPropertyValue();
        this.propertyType = ((NezivotnePoistenie) c).getPropertyType();
    }

    public Adresa getAddress() {
        return address;
    }

    public float getPropertyValue() {
        return propertyValue;
    }

    public type getPropertyType() {
        return propertyType;
    }

    public void setAddress(Adresa address) {
        this.address = address;
    }

    public void setPropertyValue(float propertyValue) {
        this.propertyValue = propertyValue;
    }

    public void setPropertyType(type propertyType) {
        this.propertyType = propertyType;
    }
}
