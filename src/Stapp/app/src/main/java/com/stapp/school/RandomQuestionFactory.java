package com.stapp.school;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rahulkumar1998 on 2017-11-25.
 */

public class RandomQuestionFactory {

  private static HashMap<Object, Object> newQuestion(String questionString, ArrayList<String> choices, int index) {

    HashMap<Object, Object> question = new HashMap<>();

    question.put("QUESTION", questionString);
    question.put("CHOICES", choices);
    question.put("ANSWER", index);

    return question;
  }

  /**
   * Template for Wen.
   */
  public static HashMap<Object, Object> createNew___Question() {
    String question = "your question string";
    ArrayList<String> choices = new ArrayList<>();
    choices.add("c1");
    choices.add("c2");
    choices.add("c3");
    choices.add("c4");
    int index = -1;
    return newQuestion(question, choices, index);
  }

  //public static HashMap<Object, Object> createNewMeanQuestion()
  //public static HashMap<Object, Object> createNewVarianceQuestion()
  //public static HashMap<Object, Object> createNewStandardDeviationQuestion()


}
