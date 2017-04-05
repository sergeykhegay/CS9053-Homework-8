## CS9053 Introduction to Java, Spring 2017

This repository showcases the implementation of Homework 8 task for the "Introduction to Java". 

The class taught by Prof. Brian Langel at NYU Tandon. 

The source code effectively serves two goals: 
1. As a homework submission
2. To showcase my work as in a portfolio

### Motivation
* Improve `git`, GitHub mastery
* Demontrate ability to design algorithms using Java Collections
* Hone code organization and design skills
* Improve testing skills with JUnit

### Description
> * Using Java Collections, create a solution to the following problem.
>     - You have just graduated NYU!  Congratulations (w00t w00t)!  Even better, you have taken a great job at Amazon working on the AWS platform, specifically the AWS Lambda team.  The first task at your new job is to optimize the cluster of EC2 machines which are running the Lambda jobs in containers.  Specifically you need to create a scheduler of Lambda jobs which maximizes the number of jobs a single container can accept.  For context, each Lambda job consists of the following: a starting time _s_ until a final time _t_.  You can assume the job can be run by at most one container at a time.  Given a list of jobs you must accept a subset of the jobs, rejecting all others, so that the accepted jobs do not overlap in time.
> 
>     - Place this within directory/file `src/main/java/edu/nyu/cs9053/homework8/LambdaScheduler.java`
> 
>     - More formally, there will be _n_ jobs labeled _1...n_ with each job, _j_, specifying a start time _Sj_ and a finish time _Tj_.  Naturally we have _Sj_ < _Tj_ for all _j_.  Two jobs _j_ and _k_ are compatible if the requested intervals do not overlap; that is, either job _j_ is for an earlier time interval than job _k_ (_Tj_ <= _Sk_), or job _j_ is for a later time than job _k_ (_Tk_ <= _Sj_).  More generally, that a subset _A_ of jobs is compatible if all pairs of jobs _j_,_k_ within _A_, _j_ != _k_ are compatible.  The goal is to select a compatible subset of jobs of maximum possible size.  To illustrate, for the following jobs the single compatible set of size 4 is the largest compatible set.
> ```
>                  |-----------|                    |--------------|
>                |--------|                       |-----------|
>               |--------------|    |----------| |--------------|
>    |--------------|   |--------------|   |--------------|   |--------------|
> ===============================================================================>
> ```
> 
> * Again, using Java Collections, solve the above problem but change the problem to be slightly more complicated.
>     - After successfully implementing the above problem in less than two days, your boss at AWS is impressed.  The team is thinking about introducing prioritized jobs within Lambda.  In this case someone would pay more money to have their job run first.  Make an extension to your work that instead of optimizing for the number of jobs, you now maximize for the total value (i.e. each job now as an associated cost or weight and you're optimizing for the largest cost).
> 
>     - Place this within directory/file `src/main/java/edu/nyu/cs9053/homework8/LambdaWeightedScheduler.java`


### Implementation
* A greedy algorithm was used for the implementation of [`LambdaScheduler`](src/main/java/edu/nyu/cs9053/homework8/LambdaScheduler.java) which can be found [here](src/main/java/edu/nyu/cs9053/homework8/base/BaseScheduler.java).
    - correctness and optimality prove can be found at ["Introduction to Algorithms", 3rd ed.](https://www.amazon.com/Introduction-Algorithms-3rd-MIT-Press/dp/0262033844).
    - the runtime complexity is `O(Nlog(N))` (because of sorting), `N` - number of jobs provided.

* A dynamic programming approach was used for the implementation of [`LambdaWeightedScheduler`](src/main/java/edu/nyu/cs9053/homework8/LambdaWeightedScheduler.java) which can be found [here](src/main/java/edu/nyu/cs9053/homework8/base/BaseWeightedScheduler.java).
    - assume all the jobs sorted by their finish time and denoted `J0`, `J1`, ..., `Jn`. Denote `D[i]` as the maximum weight we can get from the subset of jobs `J0`, `J1`, ..., `Ji` if we take job `Ji`.
    - the Bellman-Ford equation for `D[i]` then is 
      
      ``` D[0] = weight(J0) ```
      
      ``` D[i] = MAX_{j < i && end(Rj) <= start(Ri)}_ ({D[j] + weight(Ji), weight(Ji)}), 1 <= i <= n ```
    
    - the runtime complexity is `O(N^2)`, `N` - number of jobs provided.

### Testing

1. To run the test you will have to download `junit.jar` and `hamcrest-core.jar` files from [JUnit](http://junit.org) and place them in the folder `lib/`. The `lib/` has to be placed in the root of the repository.

2. Run `build.sh` to compile the code and run JUnit tests.