import java.util.*;
import java.lang.*;

class Pair{

 	 public static class bestMatch
     {
     private String student_set;
     private int score;
     public bestMatch(String student_set, int score)
  	 	  {
  	 	     this.student_set = student_set;
  	 	     this.score = score;
  	 	  }
     }

	public static void main(String[] args){
		//set table
		Hashtable<String, Integer> pair_table = new Hashtable<String, Integer>();
		pair_table.put("AB",1);
		pair_table.put("AC",1);
		pair_table.put("AD",17);
		pair_table.put("AE",1);
		pair_table.put("AF",1);

		pair_table.put("BC",1);
		pair_table.put("BD",1);
		pair_table.put("BE",1);
		pair_table.put("BF",5);

		pair_table.put("CD",2);
		pair_table.put("CE",1);
		pair_table.put("CF",1);

		pair_table.put("DE",1);
		pair_table.put("DF",1);

		pair_table.put("EF",2);

		bestMatch best = Score("ABCDEF", pair_table);

		System.out.println("Max score is: " + best.score + "\n");
		System.out.println("Student set is: "+best.student_set);
	}

	public static bestMatch Score(String remainder, Hashtable<String, Integer> table){
		bestMatch best = new bestMatch("",0);
		if(remainder.length() == 0){
			return best;
		}
		int max = 0;
		String best_pair = "";
		int current_pair_score = 0;
		for(int index=1; index < remainder.length(); index++){

			if(table.get(remainder.charAt(0)+remainder.charAt(index)) == null){
				//insert into the hashtable
			}
			//get pair score
			String lookup_pair = remainder.charAt(0)+""+remainder.charAt(index)+"";
			current_pair_score = table.get(remainder.charAt(0)+""+remainder.charAt(index)+"");

			//create the substring to pass in to look for smaller substrings
			StringBuilder remainder_copy = new StringBuilder(remainder);
			remainder_copy.deleteCharAt(0); 
			remainder_copy.deleteCharAt(index-1);
			best = Score(remainder_copy.toString(), table);

			//gets max at this level of the recursion
			if(max < (current_pair_score + best.score)){
			   max = current_pair_score + best.score;
			   best_pair = lookup_pair + best.student_set;
			}
		}
		best.score = max;
		best.student_set = best_pair;
		return best;
	}
}














