package ru.asgubin.rsr.report.chapter6.pojo;

public class TestInterval {
    private String testInterval;

    public TestInterval() {
    }

    public TestInterval(String testInterval) {
        this.testInterval = testInterval;
    }

    @Override
    public int hashCode() {
        return this.testInterval.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TestInterval)) {
            return false;
        }
        TestInterval other = (TestInterval) o;
        return (this.testInterval == null && other.testInterval == null)
                || (this.testInterval != null && this.testInterval.equals(other.testInterval));
    }

    public String getTestInterval() {
        return testInterval;
    }

    public void setTestInterval(String testInterval) {
        this.testInterval = testInterval;
    }
}
