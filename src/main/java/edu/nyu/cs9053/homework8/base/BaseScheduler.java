package edu.nyu.cs9053.homework8.base;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BaseScheduler<J extends Job> implements Scheduler<J> {

    /**
     *  Greedily schedules maximum number of non overlapping {@code <? extends 
     *  Job>} jobs.
     *  
     *  <p> For correctness and optimality refer to the literature provided.
     *  The implementation does not save the relative order of jobs.
     *  
     *  @param  jobs
     *          A list of {@code List<? extends Job>} jobs
     *  
     *  @return  The resultant sublist of {@code <? extends Job>} jobs
     *
     *  @see {@literal https://www.amazon.com/Introduction-Algorithms-3rd-MIT-Press/dp/0262033844}
     */
    @Override
    public List<J> schedule(J[] jobs) {
        if (jobs == null) {
            throw new IllegalArgumentException("'jobs' cannot be null");
        }

        List<J> scheduledJobs = new ArrayList<>();
        if (jobs.length == 0) {
            return scheduledJobs;
        }

        long lastScheduledJobFinishTime = 0;
        Arrays.sort(jobs, new JobComparator<>());
        for (J job : jobs) {
            if (lastScheduledJobFinishTime <= job.getStartTime()) {
                scheduledJobs.add(job);
                lastScheduledJobFinishTime = job.getFinishTime();
            }
        }

        return scheduledJobs;
    }

}
