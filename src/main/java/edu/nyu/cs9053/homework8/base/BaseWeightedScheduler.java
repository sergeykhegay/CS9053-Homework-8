package edu.nyu.cs9053.homework8.base;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class BaseWeightedScheduler<J extends WeightedJob> implements Scheduler<J> {

    /**
     *  Uses Dynamic Programming technique to schedule jobs for maximal weight
     *  
     *  @param  jobs
     *          A list of {@code List<? extends WeightedJob>} jobs
     *  
     *  @return  The resultant sublist of {@code <? extends WeightedJob>} jobs
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

        J lastJobForBestWeight = null;
        long bestWeight = 0;
        Map<J, Long> bestWeightWith = new HashMap<>(jobs.length);
        Map<J, J> scheduledBefore = new HashMap<>(jobs.length);
        final J nullJob = null;

        Arrays.sort(jobs, new JobComparator<J>());
        for (J current: jobs) {
            bestWeightWith.put(current, current.getWeight());
            scheduledBefore.put(current, nullJob);

            for (J previous: jobs) {
                if (current == previous) {
                    break;
                }
                long newWeight = bestWeightWith.get(previous) + current.getWeight();
                if (newWeight > bestWeightWith.get(current)
                    && previous.getFinishTime() <= current.getStartTime()) {
                    bestWeightWith.put(current, newWeight);
                    scheduledBefore.put(current, previous);
                }
            }

            if (bestWeightWith.get(current) > bestWeight) {
                bestWeight = bestWeightWith.get(current);
                lastJobForBestWeight = current;
            }
        }

        J jobToInclude = lastJobForBestWeight;
        while (jobToInclude != nullJob) {
            scheduledJobs.add(jobToInclude);
            jobToInclude = scheduledBefore.get(jobToInclude);
        }

        return scheduledJobs;
    }

}
