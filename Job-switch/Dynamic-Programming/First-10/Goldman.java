import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/* Problem Name is &&& Best Average Grade &&& PLEASE DO NOT REMOVE THIS LINE. */


/*
 **  Instructions:
 **
 **  Given a list of student test scores, find the best average grade.
 **  Each student may have more than one test score in the list.
 **
 **  Complete the bestAverageGrade function in the editor below.
 **  It has one parameter, scores, which is an array of student test scores.
 **  Each element in the array is a two-element array of the form [student name, test score]
 **  e.g. [ "Bobby", "87" ].
 **  Test scores may be positive or negative integers.
 **
 **  If you end up with an average grade that is not an integer, you should
 **  use a floor function to return the largest integer less than or equal to the average.
 **  Return 0 for an empty input.
 **
 **  Example:
 **
 **  Input:
 **  [["Bobby", "87"],
      ["Bobby", "47"],
 **   ["Charles", "100"],
 **   ["Eric", "64"],
 **   ["Charles", "22"]].
 **
 **  Expected output: 87
 **  Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
 **  respectively. 87 is the highest.
 */

class Solution {
  /*
   **  Find the best average grade.
   */
  public static int getMax(Map<String, ArrayList<Integer>> map){
    int maxValue = Integer.MIN_VALUE;
    
    for(ArrayList<Integer> scores : map.values()){
      System.out.println(scores.toString());
      int count = scores.size();
      int totScore = 0;
      int AvgScore = 0;
      for(int i = 0 ; i < scores.size() ; i++){
        totScore += scores.get(i);
      }
      AvgScore = totScore / count;
      if(AvgScore > maxValue){
        maxValue = AvgScore;
      }
    }
    return maxValue;
  }

  static class ScoreAndOccurance {
    int occurance;
    int score;
    String name;
    ScoreAndOccurance(int occurance, int score, String name){
        this.occurance = occurance;
        this.score = score;
        this.name = name;
    }
  }


  public static int bestAverageGrade(String[][] scores) {
    int ans = Integer.MIN_VALUE;
    // HM or name, value
    HashMap<String, ScoreAndOccurance> map = new HashMap<>();

    for(String[] score : scores){
        String name = score[0];
        int currScore = Integer.parseInt(score[1]);

        if(map.containsKey(name)){
            ScoreAndOccurance obj = map.get(name);
            int newScore = obj.score + currScore;
            int newOccuranc = obj.occurance + 1;
            map.put(name, new ScoreAndOccurance(newOccuranc, newScore, name));
        }else{
            // ScoreAndOccurance obj = map.getOrDefault(name, new ScoreAndOccurance(1, currScore));
            map.put(name, new ScoreAndOccurance(1, currScore, name));
        }
    }

    for(ScoreAndOccurance obj : map.values()){
        System.out.println(obj.name +" "+ obj.score +" "+obj.occurance);
        int avg = (int)(obj.score / obj.occurance);
        ans = Math.max(avg, ans);
    }
    
    return ans;
  }

  /*
   **  Returns true if the tests pass. Otherwise, returns false;
   */
  public static boolean doTestsPass() {
    // TODO: implement more test cases

    String[][] tc1 = {
        {"Bobby", "87"},
        {"Charles", "100"},
        {"Eric", "64"},
        {"Charles", "98"}, 
        {"Charles", "96"}};

    return bestAverageGrade(tc1) == 98;
  }

  /*
   **  Execution entry point.
   */
  public static void main(String[] args) {
    // Run the tests
    if (doTestsPass()) {
      System.out.println("All tests pass");
    }
    else {
      System.out.println("Tests fail.");
    }
  }
}
