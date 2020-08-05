package sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.zmluvy;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
public class UrazovePoistenie extends ZivotnePoistenie {
    public enum terr
    {
        SLOVAKIA("Slovakia"),
        WORLD("World"),
        SLOVAKIA_AND_WORLD("Slovakia + World");
        private final String displayValue;

        private terr(String displayValue) {
            this.displayValue = displayValue;
        }

        public String getDisplayValue() {
            return displayValue;
        }
    }
    @Min(0)
    private float longTermCompensation;
    @Min(0)
    private float deathCompensation;
    @Min(0)
    private float dailyHospitalCompenstaion;
    private terr terrVal;


    @Override
    public String toString() {
        return "Injury Insurance" + super.toString() +
                ", longTermCompensation=" + longTermCompensation +
                ", deathCompensation=" + deathCompensation +
                ", dailyHospitalCompenstaion=" + dailyHospitalCompenstaion +
                ", terrVal=" + terrVal.toString();
    }
    @Override
    public void edit( Zmluva c )
    {
        super.edit(c);
        this.dailyHospitalCompenstaion = ((UrazovePoistenie) c).getDailyHospitalCompenstaion();
        this.longTermCompensation =((UrazovePoistenie) c).getLongTermCompensation();
        this.deathCompensation =((UrazovePoistenie) c).getDeathCompensation();
        this.terrVal =  ((UrazovePoistenie) c).getTerrVal();
    }
    @Override
    public String getInsName()
    {
        return "Injury insurance";
    }

    public float getLongTermCompensation() {
        return longTermCompensation;
    }

    public float getDeathCompensation() {
        return deathCompensation;
    }

    public float getDailyHospitalCompenstaion() {
        return dailyHospitalCompenstaion;
    }

    public terr getTerrVal() {
        return terrVal;
    }

    public void setLongTermCompensation(float longTermCompensation) {
        this.longTermCompensation = longTermCompensation;
    }

    public void setDeathCompensation(float deathCompensation) {
        this.deathCompensation = deathCompensation;
    }

    public void setDailyHospitalCompenstaion(float dailyHospitalCompenstaion) {
        this.dailyHospitalCompenstaion = dailyHospitalCompenstaion;
    }

    public void setTerrVal(terr terrVal) {
        this.terrVal = terrVal;
    }
}
