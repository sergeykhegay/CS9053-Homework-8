package edu.nyu.cs9053.homework8;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaScheduler {

    private static class LambdaJobComparator<J extends LambdaJob> 
                         implements Comparator<J>
    {
        @Override public int compare(J o1, J o2) {
            final long startTime1 = o1.getStartTime();
            final long finishTime1 = o1.getFinishTime();

            final long startTime2 = o2.getStartTime();
            final long finishTime2 = o2.getFinishTime();

            if (finishTime1 != finishTime2) {
                return Long.signum(finishTime1 - finishTime2);
            }

            return Long.signum(startTime1 - startTime2);
        }
    }

    /**
     *  Greedily schedules maximum number of non overlapping {@code <? extends 
     *  LambdaJob>} jobs.
     *  
     *  <p> For correctness and optimality refer to the literature provided.
     *  The implementation does not save the relative order of jobs.
     *  
     *  @param  jobs
     *          A list of {@code List<? extends LambdaJob>} jobs
     *  
     *  @return  The resultant sublist of {@code <? extends LambdaJob>} jobs
     *
     *  @see {@literal https://www.amazon.com/Introduction-Algorithms-3rd-MIT-Press/dp/0262033844}
     */
    public static <J extends LambdaJob> List<J> schedule(J[] jobs) {
        if (jobs == null) {
            throw new IllegalArgumentException("'jobs' cannot be null");
        }
        
        List<J> scheduledJobs = new ArrayList<>();
        if (jobs.length == 0) {
            return scheduledJobs;
        }

        long lastScheduledJobFinishTime = 0;
        Arrays.sort(jobs, new LambdaJobComparator<>());
        for (J job : jobs) {
            if (lastScheduledJobFinishTime <= job.getStartTime()) {
                scheduledJobs.add(job);
                lastScheduledJobFinishTime = job.getFinishTime();
            }
        }

        return scheduledJobs;
    }

}
