package edu.nyu.cs9053.homework8.base;

public abstract class AbstractWeightedJob extends AbstractJob implements WeightedJob {

    private final long weight;

    protected AbstractWeightedJob(long startTime, long finishTime, long weight) {
        super(startTime, finishTime);

        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative.");   
        }
        this.weight = weight;
    }

    @Override
    public long getWeight() {
        return weight;
    }

}
