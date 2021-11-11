// Java program for reversing the linked list
import java.util.*;
public class Main {
    public static int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        int[][] counters = new int[3][S.length()+1];

        int countA = 0, countC = 0, countG = 0;
        for(int i = 0; i < S.length(); i++)
        {
            String s = S.substring(i, i+1);
            if(s == "A")
                countA++;
            else if(s == "C")
                countC++;
            else if(s == "G")
                countG++;
            
            counters[0][i+1] = countA;
            counters[1][i+1] = countC;
            counters[2][i+1] = countG;
        }
        for(int i = 0; i < S.length(); i++)
        {
          System.out.print(counters[0][i]);
          System.out.print(counters[1][i]);
          System.out.print(counters[2][i]);
          System.out.println();
        }
        System.out.print(counters);
        int[] result = new int[P.length];
        for(int i = 0; i < P.length; i++)
        {
            int startIndex = P[i];
            int endIndex = Q[i] + 1;

            int r = 4;
            for(int j = 0; j < 3; j++)
            {
                if(counters[j][startIndex] != counters[j][endIndex])
                {
                    r = j + 1;
                    break;
                }
            }
            result[i] = r;
        }
        return result;
    }

	// Driver Code
	public static void main(String[] args)
	{
   // Creating an empty Set
   int[] arr = {10,10,10};
    System.out.println(Main.solution("CAGCCTA", new int[]{2,5,0}, new int[]{4,5,6}));
    }
}

// This code has been contributed by Mayank Jaiswal
