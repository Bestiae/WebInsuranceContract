package sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.zmluvy;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CestovnePoistenie extends ZivotnePoistenie {
    public enum territory
    {
        EU("EU"),
        NON_EU("Not EU");
        private final String displayValue;

        private territory(String displayValue) {
            this.displayValue = displayValue;
        }

        public String getDisplayValue() {
            return displayValue;
        }
    }
    public enum purpose
    {
        BUSINESS("Business"),
        MEDICAL("Medical"),
        TOURIST("Tourist"),
        SPORT("Sport");
        private final String displayValue;

        private purpose(String displayValue) {
            this.displayValue = displayValue;
        }

        public String getDisplayValue() {
            return displayValue;
        }
    }

    private territory coverage;
    private purpose insurancePurpose;


    @Override
    public String toString() {
        return "Travel insurance" + super.toString() + ", " +
                "territory=" + coverage +
                ", purpose=" + insurancePurpose;
    }

    @Override
    public void edit( Zmluva c){
        super.edit( c );
        this.coverage = ((CestovnePoistenie) c).getCoverage();
        this.insurancePurpose = ((CestovnePoistenie) c).getInsurancePurpose();
    }

    @Override
    public String getInsName()
    {
        return "Travel insurance";
    }
    public territory getCoverage() {
        return coverage;
    }

    public purpose getInsurancePurpose() {
        return insurancePurpose;
    }

    public void setCoverage(territory coverage) {
        this.coverage = coverage;
    }

    public void setInsurancePurpose(purpose insurancePurpose) {
        this.insurancePurpose = insurancePurpose;
    }
}
