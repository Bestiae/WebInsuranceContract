package sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.zmluvy;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
public class ZivotnePoistenie extends Zmluva{
    @Min(0)
    private long insuredId;

    @Override
    public String toString() {
        return super.toString() +
                ", insuredId=" + insuredId;
    }

    @Override
    public void edit( Zmluva c ){
        super.edit( c );
        this.insuredId = ((ZivotnePoistenie) c).getInsuredId();
    }

    public long getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(long insuredId) {
        this.insuredId = insuredId;
    }
}
