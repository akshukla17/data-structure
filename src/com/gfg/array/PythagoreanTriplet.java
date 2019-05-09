package com.gfg.array;

import java.util.Arrays;

public class PythagoreanTriplet {

	public static void main(String[] args) {
		int a [] = {13,0,9,6,14,12,5};
		System.out.println("original array");
		ArrayUtils.print(a);
		System.out.println("given array is pythagorean triplet: "+ check(a));
	}

	/** 
	 *   complexity **** O(nlog n )
	 * @param a
	 * @return
	 */
	private static boolean check(int[] a) {
		int b[]=new int[a.length];
		for(int i=0;i<b.length;i++){
			b[i]= (int) Math.pow(a[i], 2);
		}
		Arrays.sort(b);  // O(n log n)
		
		ArrayUtils.print(b);
		return findTriplet(b);
	}

	// complexity ***** O(n)
	private static boolean findTriplet(int[] arr) {
		int i =arr.length-1;
		int j=i-1;
		int k = i-2;
//		if(i < 0 || j< 0 || k < 0) return false;
		while(i>=2){
				
				if(arr[j]+arr[k] == arr[i]){
					return true;
				}else if( arr[j]+arr[k] >arr[i]){
					k--;
				}else{
					//TODO need to reduce a value and similarly b & c value;
					i--;
					j = i-1;
					k = j-1;
					if(j < 0 || k < 0) break;
//					b= arr[j--];
//					k = j-1;
//					c = arr[k];
				}
		}
		return false;
	}
	
}
