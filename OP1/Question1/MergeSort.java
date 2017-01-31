/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.*;
import java.util.Random;
import javax.swing.Timer;
/** 
 *  Ver 1.0:  Merge Sort: 2017/01/30.
 *  
 *  This is MergeSort Implementation using Generics.
 */
public class MergeSort<T> {
	 private static <T extends Comparable<T>> void mergesort (T[] a, T[] temp,int i, int j) {
			if (j-i < 1) return;
			int mid = (i+j)/2;
			mergesort(a, temp,i, mid);
			mergesort(a, temp,mid+1, j);
			merge(a, temp,i, j);
		    }
	 
	 private static <T extends Comparable<? super T>> void merge(T[] array, T[] temp, int leftStart, int rightEnd) {
			// TODO Auto-generated method stub
			int leftEnd = (leftStart+rightEnd)/2;
			int rightStart = leftEnd+1;
			int size=rightEnd-leftStart+1;
			
			int left=leftStart;
			int right = rightStart;
			int index=leftStart;
			
			while(left<=leftEnd&&right<=rightEnd){
				if(array[left].compareTo(array[right]) <= 0){
					temp[index]=array[left];
					left++;
				}
				else{
					temp[index]=array[right];
					right++;
				}
				index++;
			}
			System.arraycopy(array, left, temp, index, leftEnd-left+1);
			System.arraycopy(array, right, temp, index, rightEnd-right+1);
			System.arraycopy(temp, leftStart, array, leftStart, size);
			
			for(int qw=0;qw<10;qw++){
				System.out.println(temp[qw]);
			}
			for(int qw=0;qw<10;qw++){
				System.out.println(array[qw]);
			}
			
			
			
		}
	 
	 public static void main(String[] args) 
	    {
	    	//timer class object creation to begin the timer
	        Timer timer = new Timer(0, null);
	        long startTime = System.nanoTime();
	      //code
	     
		 //javax.swing.Timer timer = new javax.swing.Timer(DELAY, listener);
	        (timer).start();
	        Integer[] a = new Integer[1000000];
	        Integer[] temp = new Integer[1000000];
	        
	        Random rand = new Random();
	        double d;
	        int in;
	     // Invariant: insert random 1000000 elements into array
	        for(int x = 0; x < 1000000; x++){
	            d =   Math.random()*50;
	            in = (int) d;
	            a[x] = in;
	        }
	        mergesort(a, temp,0, a.length-1);        
	        timer.stop();
	        long endTime = System.nanoTime();
		      System.out.println("Took "+(endTime - startTime) + " ns"); 
	        System.out.println(timer);
	        
	    }    
}
