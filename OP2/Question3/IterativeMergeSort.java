/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/** 
 *  Ver 1.0:  Merge Sort: 2017/02/16.
 *  
 *  This is MergeSort Implementation without Recursion.
 */
public class IterativeMergeSort {
	public static void main(String[] args) {
		Scanner cs=new Scanner(System.in);
		System.out.println("Enter the size:");
		int n=cs.nextInt();
		System.out.println("Enter the elements:");
		int i,j,k,l;
		int ar[]=new int[n];
		for(i=0;i<n;i++)
			ar[i]=cs.nextInt();
		
		int temp[]=new int[n];
		mergesort(ar,0,n-1,temp);
			
		for(int yj:ar)
			System.out.print(yj+" ");
	}

	private static void mergesort(int[] ar, int low, int high,int[] temp) {
		// TODO Auto-generated method stub
		int curr_size;  // For current size of subarrays to be merged
        // curr_size varies from 1 to n/2
		int left_start; // For picking starting index of left subarray
        // to be merged
		int n=high-low+1;
		// Merge subarrays in bottom up manner.  First merge subarrays of
		// size 1 to create sorted subarrays of size 2, then merge subarrays
		// of size 2 to create sorted subarrays of size 4, and so on.
		for (curr_size=1; curr_size<=n-1; curr_size = 2*curr_size)
		{
		// Pick starting point of different subarrays of current size
		for (left_start=0; left_start<n-1; left_start += 2*curr_size)
		{
		// Find ending point of left subarray. mid+1 is starting 
		// point of right
		int mid = left_start + curr_size - 1;
		
		int right_end = Math.min(left_start + 2*curr_size - 1, n-1);
		
		// Merge Subarrays arr[left_start...mid] & arr[mid+1...right_end]
		merge(ar, left_start, mid, right_end,temp);
		}
		}
		
		
	}
	
	private static void merge(int []ar,int low,int mid,int high,int[] temp){
		int leftStart=low,leftEnd=mid,rightStart=mid+1,rightEnd=high
				
				,left=leftStart,right=rightStart;
		int index=low;
		while((left<=leftEnd)&&(right<=rightEnd)){
			if(ar[left]<=ar[right])
				temp[index]=ar[left++];
			else
				temp[index]=ar[right++];
			index++;
		}
		
		System.arraycopy(ar, left,temp, index, leftEnd-left+1);
		System.arraycopy(ar, right,temp, index, rightEnd-right+1);
		System.arraycopy(temp, low,ar, low, high-low+1);
		
	}
}
