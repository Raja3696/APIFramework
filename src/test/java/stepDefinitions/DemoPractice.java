package stepDefinitions;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;import java.util.stream.Collector;
import java.util.stream.Collectors;


public class DemoPractice {
	public static void main(String[] args) {
		methodTwo();

	}
	public static void methodOne() {
//		Expected input = Raja is a man who is living in Hyderabad with a man
//		{Raja=1,is=2....}
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string");
		String sentence = sc.nextLine();
		String[] arr = sentence.split(" ");
		HashMap<String, Integer> hash = new HashMap<>();
		
	     for(int i=0;i<arr.length;i++) {
	    	 
	    	 if(hash.containsKey(arr[i].toLowerCase())) {
	    		 hash.put(arr[i].toLowerCase(), hash.get(arr[i])+1);
	    	 }else {
	    		 hash.put(arr[i].toLowerCase(), 1);
	    	 }
	    	 
	    	 
	     }
//	    for(Entry<String, Integer> my : hash.entrySet()) {
//	    	System.out.println("The key is "+my.getKey()+" and the value is "+my.getValue());
//	    }
	     System.out.println(hash);
	     Iterator<Entry<String, Integer>> itr = hash.entrySet().iterator();
	     while(itr.hasNext()) {
	    	 Entry<String, Integer> entry = itr.next();
	    	 System.out.println("Key is "+entry.getKey()+" And the value is "+entry.getValue());
	     }
	}
	public static void methodTwo() {
		//given int array --> reverse it 
		int[] array = {3,6,8,5,1,9};
		List<Integer> lis = Arrays.stream(array).boxed().collect(Collectors.toList());
		
		System.out.println(lis);
		Integer min = Collections.min(lis);
		System.out.println(min);
//		for(int i=0;i<array.length;i++) {
//			System.out.print(array[i]);
//		}
	}
	
}
