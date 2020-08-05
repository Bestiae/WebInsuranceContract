package sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.zmluvy;

import lombok.Data;
import sk.stuba.fei.uim.oop.spring.mvcapp.zadanie3.utilities.Datanum;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class Zmluva {
    @Min(0)
    private long id;
    @Min(0)
    private long insurerId;
    @NotNull
    private Datanum signDate;
    @NotNull
    private Datanum startDate;
    @NotNull
    private Datanum endDate;
    @Min(0)
    private float monthPayment;
    @Min(0)
    private float compensation;

    public Zmluva()
    {
        this.signDate = new Datanum();
        this.startDate = new Datanum();
        this.endDate = new Datanum();
    }
    public Zmluva(long id, long insurerId, Datanum signDate, Datanum startDate, Datanum endDate, float monthPayment, float compensation)
    {
        this.id = id;
        this.insurerId = insurerId;
        this.signDate = signDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.monthPayment = monthPayment;
        this.compensation = compensation;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", insurerId=" + insurerId +
                ", signDate=" + signDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", monthPayment=" + monthPayment +
                ", compensation=" + compensation;
    }

    public void edit( Zmluva c )
    {
        this.signDate = c.getSignDate();
        this.startDate = c.getStartDate();
        this.endDate = c.getEndDate();
        this.monthPayment = c.getMonthPayment();
        this.compensation = c.getCompensation();

    }

    public long getId() {
        return id;
    }

    public long getInsurerId() {
        return insurerId;
    }

    public Datanum getSignDate() {
        return signDate;
    }

    public Datanum getStartDate() {
        return startDate;
    }

    public Datanum getEndDate() {
        return endDate;
    }

    public float getMonthPayment() {
        return monthPayment;
    }

    public float getCompensation() {
        return compensation;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setInsurerId(long insurerId) {
        this.insurerId = insurerId;
    }

    public void setSignDate( Datanum signDate) {
        this.signDate = signDate;
    }

    public void setStartDate(Datanum startDate) {
        this.startDate = startDate;
    }

    public void setEndDate( Datanum endDate) {
        this.endDate = endDate;
    }

    public void setMonthPayment(float monthPayment) {
        this.monthPayment = monthPayment;
    }

    public void setCompensation(float compensation) {
        this.compensation = compensation;
    }

    public String getInsName()
    {
        return "";
    }
}
