package edu.nyu.cs9053.homework8.base;

import java.util.Comparator;

public class JobComparator<J extends Job> implements Comparator<J> {

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
