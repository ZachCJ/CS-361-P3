# CS-361-P3

* Authors: Zach Johnston and Antonio Hernandez
* Class: CS 361 Section 1
* Semester: Spring 2025

## Overview

This project is a simulation of a turing machine that is detailed by an input file. This simulator takes in a number of symbols,
a number of states, transitions, and an input string. This is all used to build a turing machine that is then run until it reaches
a halting state (the last state numbered). Then the simulator returns the tape, length of the tape, and the sum of all the symbols
of the tape.

## Reflection

Zach - This project was rather smooth for me in implementation and what mainly helped with that was having a meeting discussing strategy.
I built the tape data structure that is based on a double-linked list but differs in methods and how the data is access and manipulated.
After that I mostly worked debugging, documentation, and making sure the project output the way specified in the assignment instructions. 
I was going to toy with the idea of multithreading to improve performance, but my busy schedule didn't give the time to do that, unfortunately.
The most difficult part of this project was really understanding how the input file works and how that affects the turing machine as a result.

## Compiling and Using

Compiling:

    javac TMSimulator.java

Running from the command line:

    java TMSimulator <filename>

File Formatting:

    First line: Number of States
    Second line: Number of symbols
    Transitions of each state format (except halting state):
    To State, On Symbol, Move Tape Direction
    Last line: Input String (Can be an empty line) 
    EOF

## Sources

[ArrayList Java API Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)

[StringTokenizer Java API Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/StringTokenizer.html)

[HashMap Java API Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)

[Map Java API Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)

[StringBuilder Java API Documentation](https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html)