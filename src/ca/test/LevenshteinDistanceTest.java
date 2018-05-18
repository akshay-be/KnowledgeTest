package ca.test;

import org.apache.commons.text.similarity.LevenshteinDetailedDistance;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.apache.commons.text.similarity.LevenshteinResults;

/**
 * 
 * @author eshak01
 *
 */
public class LevenshteinDistanceTest {

   public static void main(String[] args) {
      LevenshteinDistance levenshteinDistance =LevenshteinDistance.getDefaultInstance();
      System.out.println(""+levenshteinDistance.apply("Akshay", "akshay"));
      
      LevenshteinDetailedDistance levenshteinDetailedDistance = new LevenshteinDetailedDistance();
      LevenshteinResults levenshteinResults = levenshteinDetailedDistance.apply("asdfgskdjfn", "akasdasdhshay");
      System.out.println("getDistance : "+levenshteinResults.getDistance()+", getInsertCount : "+levenshteinResults.getInsertCount()
                        +", getSubstituteCount : "+levenshteinResults.getSubstituteCount()+", getDeleteCount : "+levenshteinResults.getDeleteCount());
   }
}


