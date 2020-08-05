package sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.zmluvy;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class PoistenieDomuBytu extends NezivotnePoistenie {
    @NotNull
    private boolean garageInsurance;


    @Override
    public String toString() {
        return "Residence insurance" + super.toString() +
                ", garageInsurance=" + garageInsurance;
    }

    @Override
    public void edit(Zmluva c)
    {
        super.edit(c);
        this.garageInsurance = ((PoistenieDomuBytu) c).isGarageInsurance();
    }

    @Override
    public String getInsName()
    {
        return "Residence insurance";
    }

    public boolean isGarageInsurance() {
        return garageInsurance;
    }

    public void setGarageInsurance(boolean garageInsurance) {
        this.garageInsurance = garageInsurance;
    }
}
