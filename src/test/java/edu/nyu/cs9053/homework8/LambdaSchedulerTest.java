package edu.nyu.cs9053.homework8;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class LambdaSchedulerTest {

    @Test
    public void testSchedule() {
        LambdaJob[] jobs = new LambdaJob[] {
            new LambdaJob(0, 1),
            new LambdaJob(0, 5),
            new LambdaJob(1, 4),
            new LambdaJob(2, 10),
            new LambdaWeightedJob(2, 8, 100)
        };

        List scheduledJobs = (new LambdaScheduler<>()).schedule(jobs);

        final int expected = 2;
        assertEquals(expected, scheduledJobs.size());
    }

    @Test
    public void testScheduleEmpty() {
        LambdaJob[] jobs = new LambdaJob[] {};

        List scheduledJobs = (new LambdaScheduler<>()).schedule(jobs);

        final int expected = 0;
        assertEquals(expected, scheduledJobs.size());
    }

    @Test
    public void testScheduleOne() {
        LambdaJob[] jobs = new LambdaJob[] {
            new LambdaWeightedJob(2, 8, 100)
        };

        List scheduledJobs = (new LambdaScheduler<>()).schedule(jobs);

        final int expected = 1;
        assertEquals(expected, scheduledJobs.size());
    }

}
