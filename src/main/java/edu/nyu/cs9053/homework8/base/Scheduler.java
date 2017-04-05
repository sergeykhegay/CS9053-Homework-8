package edu.nyu.cs9053.homework8.base;

import java.util.List;

public interface Scheduler<J extends Job> {

    List<J> schedule(J[] jobs);

}
