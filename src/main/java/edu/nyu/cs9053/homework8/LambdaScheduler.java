package edu.nyu.cs9053.homework8;

import java.util.List;

import edu.nyu.cs9053.homework8.base.BaseScheduler;

public class LambdaScheduler<J extends LambdaJob> extends BaseScheduler<J> {

    @Override
    public List<J> schedule(J[] jobs) {
        return super.schedule(jobs);
    }

}
