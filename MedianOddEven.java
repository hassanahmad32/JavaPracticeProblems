
import java.util.*;
import java.util.stream.Collectors;

public class MedianOddEven {

	private int medianSumOddEven(int arr[])
	{
		List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		Collections.sort(arrList);
		int evenCount = 0, oddCount = 0;
		for(Integer a: arrList)
		{
		  if(a%2 == 0)
		    evenCount++;
		  else
		    oddCount++;
		}
		int evenMedianIndex1 = -1, evenMedianIndex2 = -1;
		int oddMedianIndex1 = -1, oddMedianIndex2 = -1;
		if(evenCount%2 == 0)
		{
		  evenMedianIndex1 = evenCount/2;
		  evenMedianIndex2 = ((evenCount/2)+1);
		}
		else
			evenMedianIndex1 = (evenCount)/2;
		
		if(oddCount%2 == 0)
		{
		  oddMedianIndex1 = oddCount/2;
		  oddMedianIndex2 = ((oddCount/2)+1);
		}
		else
			oddMedianIndex1 = (oddCount)/2;
		
		int oddIndex = -1, evenIndex = -1;
		int evenMedian = 0, oddMedian = 0;
	    for(int i = 0; i < arrList.size();i++)
	    {
	    	if(arrList.get(i)%2 == 0)
	    	{
	    		evenIndex++;
	    	}
	    	else
	    	{
	    		oddIndex++;
	    	}
	    	if((oddMedianIndex1 == oddIndex && oddIndex != -1) || (oddMedianIndex2 == oddIndex && oddIndex != -1))
	    	{
	    		oddMedian += arrList.get(i);
	    		oddMedianIndex1 = -1;
	    	}
	    	if((evenMedianIndex1 == evenIndex && evenIndex != -1) || (evenMedianIndex2 == evenIndex && evenIndex != -1))
	    	{
	    		evenMedian += arrList.get(i);
	    		evenMedianIndex1 = -1;
	    	}
	    	
	    }
	    return evenMedian+oddMedian;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianOddEven md = new MedianOddEven();
		System.out.println(md.medianSumOddEven(new int[] {2,1,7,6, 8, 3}));//1,3,7 //2, 6 8
	}

}
