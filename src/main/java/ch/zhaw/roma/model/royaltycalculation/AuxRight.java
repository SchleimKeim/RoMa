package ch.zhaw.roma.model.royaltycalculation;

public class AuxRight {


    private String title;
    private double amountExMwSt;
    private double honoraryRate;
    private double netRevEur; //net revenue from auxiliary right --> Not used in PDF!
    private double sumEur; //proceeds for author

    public AuxRight() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmountExMwSt() {
        return amountExMwSt;
    }

    public void setAmountExMwSt(double amountExMwSt) {
        this.amountExMwSt = amountExMwSt;
    }

    public double getHonoraryRate() {
        return honoraryRate;
    }

    public void setHonoraryRate(double honoraryRate) {
        this.honoraryRate = honoraryRate;
    }

    public double getNetRevEur() {
        return netRevEur;
    }

    public void setNetRevEur(double netRevEur) {
        this.netRevEur = netRevEur;
    }

    public double getSumEur() {
        return sumEur;
    }

    public void setSumEur(double sumEur) {
        this.sumEur = sumEur;
    }

}
