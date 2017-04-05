package edu.nyu.cs9053.homework8;

import java.util.List;

import edu.nyu.cs9053.homework8.base.BaseWeightedScheduler;

public class LambdaWeightedScheduler<J extends LambdaWeightedJob>
    extends BaseWeightedScheduler<J> {

    @Override
    public List<J> schedule(J[] jobs) {
        return super.schedule(jobs);
    }

}
