# Multi-Threading
# Classes and Methods:

* Class : ``GenomeSequenceGeneratorThread`` : Main class that implements interface `runnable`
* Methods:
  * `generateRandomGenome` : The method to generate genome sequence of length 10.
  * `generateWithoutThreads`: Method that will be called to generate required numbers of sequences.
  * `run()`: The run method of interface runnable will be called when a thread is started.
  * `main()` : The main method creates and starts the threads by.


# With and without thread execution time comparison.

```
Time taken without threads: 849125 ns
Time taken with threads: 407334 ns
Difference in time: 441791 ns
```

# Inference:
The execution time with threads is a little lower than without threading. However, for the most part they are very close to each other.
Specially in the small set of work to create 100 sequences.
