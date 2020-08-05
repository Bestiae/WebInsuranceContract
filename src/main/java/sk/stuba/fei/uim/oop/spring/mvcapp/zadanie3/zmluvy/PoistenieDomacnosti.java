package sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.zmluvy;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class PoistenieDomacnosti extends NezivotnePoistenie {
    @NotNull
    private float equipmentValue;


    @Override
    public String toString() {
        return "Household Insurance" + super.toString() +
                ", equipmentValue=" + equipmentValue;
    }

    @Override
    public void edit( Zmluva c)
    {
        super.edit(c);
        this.equipmentValue = ((PoistenieDomacnosti) c).getEquipmentValue();
    }
    @Override
    public String getInsName()
    {
        return "Household insurance";
    }

    public float getEquipmentValue() {
        return equipmentValue;
    }

    public void setEquipmentValue(float equipmentValue) {
        this.equipmentValue = equipmentValue;
    }
}
