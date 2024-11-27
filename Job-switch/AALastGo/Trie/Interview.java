package AALastGo.Trie;

import java.util.HashMap;

public class Interview {
You are given a list of domain names and an integer "score" for each of them.
A domain is a "leaf" if it doesn't have any child domains in the input.
A leaf domain's "total score" is the sum of the scores of itself and all its ancestor domains.

Write a program that, given a list of domains and their scores, outputs a list of leaf domains with their respective total scores.
  
Example input:

test.mydomain.com       10
mail.test.mydomain.com  15
test.com               -10
com                     20
mydomain.com             5
www.mydomain.com        10
mail.test.com           10
www.test.com            -5

Example output:

mail.test.mydomain.com      50          // (20 + 5 + 10 + 15)
www.mydomain.com            35          // (10 + 5 + 20)
mail.test.com               20          // (10 - 10 + 20)
www.test.com                 5          // (-5 - 10 + 20)
  
  com
  a.com
  b.a.com
  c.a.com
  d.a.com
  
  // test -> mydomain -> com (10)
  // mail ->
  class GoogleInterview{
    
      private  HashMap<String, Integer> solution(String[] domains, int[] score){
          int n = domains.length;
          
          HashMap<String, Integer> map = new HashMap<>();
          HashMap<String, Integer> answer = new HashMap<>();
          boolean[] isParent = new boolean[n];
          
          // O(n*n) * O(largetst split)
          for(int i = 0; i<n; i++){
            map.put(domains[i], score[i]);
            
            for(int j = 0; j<n; j++){
              if(i != j){
                  String child = domains[i];
                  String parent = domains[j];
                  if(isChild(child, parent)){
                    isParent[i] = false;
                  }
                }
              }
          }  
          
          // O(n)*O(largest split) 
          for(int i = 0; i<n; i++){
            if(isParent[i]){
                
              //  mail.test.mydomain.com  
              String parentdomain = domains[i];
              String[] parts = child.split(".");
              String ruuningDomain = ""; // com
              for(int i = parts.length - 1; i>=0; i--){
                String currPart = parts[i]; // mydomain
                ruuningDomain = currPart + "."+ currPart;
                if(map.containsKey(ruuningDomain)){
                  int currRunningScore = map.get(ruuningDomain);
                  answer.put(parentdomain, map.getOrDefault(parentdomain, 0) + currRunningScore);
                }
              }
            }
          }
          return answer;
      }
      
      public boolean isChild(String child, String parent){
        String[] childParts = child.split(".");
        String[] parentParts = parent.split(".");
        
        if(parentParts.length < childParts.length) return false;
        for(int i = childParts.length - 1; i>=0; i--){
          if(childParts[i].equals(parentParts[i]) ==false){
            return false;
           }
        }
        return true;
      }
    
  }
}
