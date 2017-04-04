package edu.nyu.cs9053.homework8;

public abstract class AbstractScheduler<J extends Job> implements Scheduler<J> {

    private final J[] jobs;

    protected AbstractScheduler(J[] jobs) {
        if (jobs == null) {
            throw new IllegalArgumentException("'jobs' cannot be null.");
        }
        this.jobs = jobs;
    }

    public J[] getJobs() {
        return jobs;
    }

}
