package ru.asgubin.rsr.report.chapter6.pojo;

public class Probability {
    private String probability;

    public Probability(){
    }

    public Probability(String probability) {
        this.probability = probability;
    }

    @Override
    public int hashCode() {
        return this.probability.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Probability)) {
            return false;
        }
        Probability other = (Probability) o;
        return (this.probability == null && other.probability == null)
                || (this.probability != null && this.probability.equals(other.probability));
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }
}
