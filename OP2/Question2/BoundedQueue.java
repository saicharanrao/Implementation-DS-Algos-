import java.io.*;
import java.util.*;
/*
 * Array-based, bounded-sized queues operations:
   1) offer, poll, peek, isEmpty 
   2) resize(), which doubles the queue size if the queue is mostly full (over 90%, say), or halves it if the queue
   is mostly empty (less then 25% occupied, say).  
 */
public class BoundedQueue {
	
	static int gIndex=0;	//Global Index		
public static void main(String[] args) {
	Scanner cs=new Scanner(System.in);
	int opt=0,item;		
	int arr[]=new int[16];			//Declaring array Initially
	Arrays.fill(arr, 0);
	while(opt!=5){
	System.out.println("\nEnter your option:");
	System.out.println("1)Offer \n2)Poll\n3)Peek\n4)isEmpty\n5)Exit");	//Options
	opt=cs.nextInt();
	if(opt==1){
		System.out.println("\nOFFER:\nEnter the item to be inserted:");
		item=cs.nextInt();
		arr=offer(arr,item);
		print(arr);
		
		
	}else if(opt==2){
		arr=poll(arr);
		print(arr);
		
	}else if(opt==3){
		peek(arr);
	}
	else if(opt==4){
		if(gIndex==0)System.out.println("The Queue is empty.");
		else System.out.println("The Queue isn't empty.");
	}
	else if(opt==5){
	arr=checkHalf(arr);		//Checking if atleast half is filled.
	print(arr);				//Printing the array finally.
	break;
	}
	}
}

private static void peek(int[] arr) {
	// TODO Auto-generated method stub
	if(gIndex>0)
		System.out.println(arr[0]);				//Printing the head element in array.
	else
		System.out.println("There aren't any elements in the Queue");
}

private static int[] poll(int[] arr) {
	// TODO Auto-generated method stub
	if(gIndex>0){
	System.out.println("The item polled is :"+arr[0]);		//Removing the head element.
	for(int i=1;i<gIndex;i++){
		arr[i-1]=arr[i];
	}
	arr[gIndex-1]=0;
	gIndex--;
	}
	else
		System.out.println("There aren't any elements in the Queue");
	return arr;
}

private static int[] offer(int[] arr, int item) {
	// TODO Auto-generated method stub
	int n=arr.length,i;
	int ar1[]=null;
	if(gIndex>=(0.9*n)){
		ar1=Arrays.copyOf(arr, 2*n);							//Doubling the size if capacity has reached 90% .
		arr=ar1;
	}
	arr[gIndex++]=item;											//Storing the item.
	return arr;
}

private static void print(int[] arr) {
	// TODO Auto-generated method stub							//Printing the array.
	for(int i:arr){
		System.out.print(i+" ");
	}
}

private static int[] checkHalf(int[] arr) {
	// TODO Auto-generated method stub							//Cheking if the array is filled atleast half.
	int ar2[]=null;												//If not reducing the array into half.
	if(gIndex<(arr.length/2)){
		ar2 = Arrays.copyOf(arr, arr.length/2);
	}
	return ar2;
}
}
