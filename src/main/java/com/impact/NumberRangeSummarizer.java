package com.impact;

public interface NumberRangeSummarizer {
    //collect the input
    int[] collect(String input);

    //get the summarized string
    String summarizeCollection(int[] input);
}
