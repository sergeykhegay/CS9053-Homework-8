package edu.nyu.cs9053.homework8;

import edu.nyu.cs9053.homework8.base.WeightedJob;

public class LambdaWeightedJob extends LambdaJob implements WeightedJob {

    private final long weight;

    public LambdaWeightedJob(long startTime, long finishTime, long weight) {
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
