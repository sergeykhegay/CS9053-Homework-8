package edu.nyu.cs9053.homework8;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class LambdaWeightedScheduler {

    private static class LambdaWeightedJobComparator<J extends LambdaWeightedJob>
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
     *  TODO
     *  
     *  <p> For correctness and optimality refer to the literature provided.
     *  
     *  @param  jobs
     *          A list of {@code List<? extends LambdaJob>} jobs
     *  
     *  @return  The resultant sublist of {@code <? extends LambdaJob>} jobs
     *
     *  @see {@literal https://www.amazon.com/Introduction-Algorithms-3rd-MIT-Press/dp/0262033844}
     */
    public static <J extends LambdaWeightedJob> List<J> schedule(J[] jobs) {
        assert jobs != null;
        List<J> scheduledJobs = new ArrayList<>();
        
        if (jobs.length == 0) {
            return scheduledJobs;
        }

        Arrays.sort(jobs, new LambdaWeightedJobComparator<J>());

        int numberOfJobs = jobs.length;
        long[] bestWeightFor = new long[numberOfJobs];
        int[] previousIncludedJob = new int[numberOfJobs];
        final int noJob = -1;

        bestWeightFor[0] = jobs[0].getWeight();
        previousIncludedJob[0] = noJob;

        long bestWeight = bestWeightFor[0];
        int lastJobForBestWeight = 0;

        for (int i = 1; i < numberOfJobs; ++i) {
            bestWeightFor[i] = jobs[i].getWeight();
            previousIncludedJob[i] = noJob;

            for (int j = 0; j < numberOfJobs; ++j) {
                if (bestWeightFor[j] + jobs[i].getWeight() < bestWeightFor[i] 
                    && jobs[j].getFinishTime() <= jobs[i].getStartTime()) {
                    bestWeightFor[i] = bestWeightFor[j] + jobs[i].getWeight();
                    previousIncludedJob[i] = j;
                }
            }

            if (bestWeightFor[i] > bestWeight) {
                bestWeight = bestWeightFor[i];
                lastJobForBestWeight = i;
            }
        }

        int jobToInclude = lastJobForBestWeight;
        while (jobToInclude != noJob) {
            scheduledJobs.add(jobs[jobToInclude]);
            jobToInclude = previousIncludedJob[jobToInclude];
        }

        return scheduledJobs;
    }

}
