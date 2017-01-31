import java.util.PriorityQueue;
import java.util.Random;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/** 
 *  Ver 1.0:  PriorityQueue Sort: 2017/01/30.
 */


public class PriorityQueueSort {

	public static void main(String args[]){
		
		
		PriorityQueue<Integer> tja = new PriorityQueue<Integer>(); 
		long startTime = System.nanoTime();
		Random rand = new Random();
        double d;
        int in;
     // Invariant: insert random 1000000 elements into array
        //adding an element into priority queue
        for(int x = 0; x < 1000000; x++){
            d =   Math.random()*50;
            in = (int) d;
            tja.add(in);
            //a[x] = in;
        }
		
		
		System.out.println("------------------------");
		while (tja.size()>0)
	        tja.remove();
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
	}
}
