package ru.asgubin.rsr.report.chapter6.pojo;

public class FailureRate {
    private String failureRate;

    public FailureRate() {
    }

    public FailureRate(String failureRate) {
        this.failureRate = failureRate;
    }

    @Override
    public int hashCode() {
        return this.failureRate.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof FailureRate)) {
            return false;
        }
        FailureRate other = (FailureRate) o;
        return (this.failureRate == null && other.failureRate == null)
                || (this.failureRate != null && this.failureRate.equals(other.failureRate));
    }

    public String getFailureRate() {
        return failureRate;
    }

    public void setFailureRate(String failureRate) {
        this.failureRate = failureRate;
    }
}
