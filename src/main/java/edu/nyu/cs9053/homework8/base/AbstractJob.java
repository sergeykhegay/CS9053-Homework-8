package edu.nyu.cs9053.homework8.base;

public abstract class AbstractJob implements Job {

    private final long startTime;

    private final long finishTime;

    public AbstractJob(long startTime, long finishTime) {
        if (startTime < 0 || finishTime < 0) {
            throw new IllegalArgumentException("Start and finish time have to be positve.");
        }
        if (startTime > finishTime) {
            throw new IllegalArgumentException("Start cannot be grater than finish time.");   
        }
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    @Override
    public long getStartTime() {
        return startTime;
    }

    @Override
    public long getFinishTime() {
        return finishTime;
    }

}
