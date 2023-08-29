package ru.asgubin.rsr.report.chapter6.pojo;

public class EqKks {
    private String eqKKS;

    public EqKks() {
    }

    public EqKks(String eqKKS) {
        this.eqKKS = eqKKS;
    }

    @Override
    public int hashCode() {
        return this.eqKKS.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof EqKks)) {
            return false;
        }
        EqKks other = (EqKks)o;
        return (this.eqKKS == null && other.eqKKS == null)
                || (this.eqKKS != null && this.eqKKS.equals(other.eqKKS));
    }

    public String getEqKKS() {
        return eqKKS;
    }

    public void setEqKKS(String eqKKS) {
        this.eqKKS = eqKKS;
    }
}
