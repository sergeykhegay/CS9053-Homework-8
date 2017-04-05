package edu.nyu.cs9053.homework8;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class LambdaWeightedSchedulerTest {

    @Test
    public void testSchedule() {
        LambdaWeightedJob[] jobs = new LambdaWeightedJob[] {
            new LambdaWeightedJob(0, 1, 1),
            new LambdaWeightedJob(1, 2, 1),
            new LambdaWeightedJob(2, 3, 1),
            new LambdaWeightedJob(2, 8, 4),
            new LambdaWeightedJob(0, 8, 2)
        };

        List scheduledJobs = (new LambdaWeightedScheduler<>()).schedule(jobs);

        final int expected = 3;
        assertEquals(expected, scheduledJobs.size());
    }

}
