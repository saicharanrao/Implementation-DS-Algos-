import java.util.*;

/** 
 *  Ver 1.0:  2/4/2017
 *  
 *  This Program takes two Integers and calculates the sum and difference of two integers.
 *  
 */   // Return z = x + y.  Numbers are stored using base b.
		  // The "digits" are stored in the list with the least
	   	  // significant digit first.  For example, if b = 10, then
		  // the number 709 will be stored as 9 -> 0 -> 7.
		  // Assume that b is small enough that you will not get any
		  // overflow of numbers during the operation.
 
public class AddSubtract {

	public static void main(String args[]){
		List<Integer>one=new ArrayList<Integer>();
		List<Integer>two=new ArrayList<Integer>();
		List<Integer>resultAdd = new ArrayList<Integer>();
		List<Integer>resultSub = new ArrayList<Integer>();

		one.add(3);
		
		one.add(9);
		one.add(9);
		one.add(1);
		two.add(7);
		two.add(1);
		two.add(0);
		two.add(2);
		
		
		
		
		add(one,two,resultAdd,10);
		subtract(one,two,resultSub,10);
		
		System.out.println("Addition");
		for(int i:resultAdd)
			System.out.print(i+" ");
		System.out.println();
		System.out.println("Subtraction");
		for(int i:resultSub)
			System.out.print(i+" ");
		System.out.println();
		
	}
	 public static void add(List<Integer> x, List<Integer>  y,List<Integer> z, int b) {
	   	 
		 
		 int carry=0,sum=0;
		 int size1=x.size();    //List 1 Size
		 int size2=y.size();	//List 2 Size
		 
		 //If size is different then insert zeros to make equal size.
		 if(size1>size2){
			 for(int i=0;i<size1-size2;i++){
				 y.add(0);
			 }
		 }
		 else if(size1<size2){
			 for(int i=0;i<size2-size1;i++){
				 x.add(0);
			 }
		 }
		/* 
		 for(int i:x)
				System.out.print(i+" ");
		 System.out.println();
		 for(int i:y)
				System.out.print(i+" ");*/
		 
		 //Make sure that carry is propagated to next step.
		 for(int i=0;i<size1;i++){
			 sum=x.get(i)+y.get(i)+carry;
			 
			 if(sum>10){				//If sum>10 set carry to 1
				 carry=1;
				 sum=sum%10;
			 }
			 else if(sum==10){
				 carry=1;
				 sum=0;
			 }
			 else
				 carry=0;
			 z.add(sum);
			 
		 }
		 if(carry>0)z.add(carry);		//Add the final carry
		 
	   }

	   public static void subtract(List<Integer> x, List<Integer>  y,List<Integer> z, int b) {
	   	  // Return z = x - y.  Numbers are stored using base b.
		  // Assume that x >= y.
		   List<Integer>first=null;
		   List<Integer>second=null;
		   
		   
		   	 int diff=0;
			 int size1=x.size();    //List 1 Size
			 int size2=y.size();	//List 2 Size
			 //If size is different then insert zeros to make equal size.
			 if(size1>size2){
				 for(int i=0;i<size1-size2;i++){
					 y.add(0);
				 }
				 first=x;
				 second=y;
				 
			 }
			 else if(size1<size2){
				 for(int i=0;i<size2-size1;i++){
					 x.add(0);
				 }
				 first=y;
				 second=x;
			 }
			 else if(size1==size2){
				 
				 for(int j=size1-1;j>=0;j--){
					 if(x.get(j)==y.get(j)){
						 
					 }
					 else if(x.get(j)>y.get(j))
					 {
						 first=x;second=y;
						 break;
					 }
					 else{
						 first=y; second=x;
						 break;
					 }
				 }
				 
			 }
			 /*for(int i:first)
					System.out.print(i+" ");
			 System.out.println();
			*/ 
			 int b1;
			 
			 for(int i=0;i<size1;i++){
				 
				 diff=first.get(i)-second.get(i);
				 //System.out.println(first.get(i)+" "+second.get(i)+" diff "+diff);
				 if(diff<0){
					 diff+=10;
					 
					 int temp=first.get(i+1);
					 //System.out.println("Differnece "+diff+" temp"+temp);
					 if(temp!=0){temp-=1;
					 first.set(i+1, temp);
					 }
					 else{
						 b1=i+1;
						 while(first.get(b1)==0){
						 temp=9;
					  
						 first.set(i+1, temp);
						 b1++;
						 }
						 first.set(b1,first.get(b1)-1);
					 }
					 
				 }
				 //System.out.println(diff);
				 z.add(diff);
				 
			 }
			
			 
	   }
}
