/**
 * @author Prabu
 * @date Mar 18, 2012
 * 
 * This class is a data type for measuring
 *  the running time (wall clock) of a program.
 */
package com.wintech.adt;

import com.wintech.io.StdOut;

public class StopWatch {
    private long start;
    
    /**
     * Create a stopwatch object.  Start watch automatically
     */
    public StopWatch() {
        this(true);
    }
    
    /**
     * Create a stopwatch object.  Start watch automatically
     */
    public StopWatch(boolean autoStart) {
        if(autoStart) {
            start = System.currentTimeMillis();
        }
    }
    
    /**
     * Return elapsed time (in seconds) since this object was created.
     * 
     * @throws IllegalStateException - if StopWatch is not yet started
     * @return 
     */
    public double elapsedTime() {
        return elapsedTimeMillis() / 1000.0;
    }
    
    /**
     * Return elapsed time (in milli-seconds) since this object was created.
     * 
     * @throws IllegalStateException - if StopWatch is not yet started
     * @return 
     */
    public long elapsedTimeMillis() {
        if(start == 0) {
            throw new IllegalStateException("StopWatch not yet started.");
        }
        long now = System.currentTimeMillis();
        return (now - start);
    }
    
    /**
     * Start the StopWatch
     * @throws IllegalStateException - if StopWatch is already in start status
     */
    public void start() {
        if(start != 0) {
            throw new IllegalStateException("StopWatch is already started.");
        }
        start = System.currentTimeMillis();
    }
    
    /**
     * Reset the StopWatch, start if not
     * 
     * @throws IllegalStateException - if StopWatch is not yet started
     */
    public void reset() {
        if(start == 0) {
            throw new IllegalStateException("StopWatch not yet started.");
        }
        start = System.currentTimeMillis();
    }
    
    /**
     * Test client for StopWatch
     * 
     * @param args 
     */
    public static void main(String[] args) throws InterruptedException {
       StopWatch stopWatch = new StopWatch(true);
       Thread.sleep(1000);
       StdOut.println("Elapsed time in secs - 1: " + stopWatch.elapsedTime());
       StdOut.println("Elapsed time in millis - 1: " + stopWatch.elapsedTimeMillis());
       Thread.sleep(760);
       StdOut.println("Elapsed time in secs - 2: " + stopWatch.elapsedTime());
       StdOut.println("Elapsed time in millis - 2: " + stopWatch.elapsedTimeMillis());
       stopWatch.reset();
       Thread.sleep(760);
       StdOut.println("Elapsed time in secs - 3: " + stopWatch.elapsedTime());
       StdOut.println("Elapsed time in millis - 3: " + stopWatch.elapsedTimeMillis());
    }
}
