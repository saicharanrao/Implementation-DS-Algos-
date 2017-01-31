import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SinglyLinkedList{
	
	public static void main(String args[]){
		/*
		* Question: Given two Linked Lists return lists that represent Union, Intersection, Difference of Linked Lists.
		
		
		*/
		
		
		//Creating the Lists
		List<Integer>lst=new LinkedList<Integer>();
		List<Integer>two = new LinkedList<Integer>();
		
		List<Integer>unionList = new LinkedList<Integer>();
		List<Integer>intersectList = new LinkedList<Integer>();
		List<Integer>diffList = new LinkedList<Integer>();
		
		
		//For random value insertion
		Random rand = new Random();
		double d;
        int in;
		
		//Passing Values into them
		for(int i=1;i<6;i++){
			d =   Math.random()*20;
            in = (int) d;
			lst.add(in);
		}
		
		lst.add(2);
		lst.add(3);
		for(int i=0;i<5;i++){
			two.add(i);
		}
		
		
		//Printing both the Lists
		System.out.println("List 1: ");
		sort(lst);
		printList(lst);
		System.out.println("List 2: ");
		printList(two);
		
		System.out.println("Intersection is:");
		intersect(lst,two,intersectList);
		printList(intersectList);
		
		
		System.out.println("UnionList is:");
		union(lst,two,unionList);
		printList(unionList);
		
		
		System.out.println("DiffList is:");
		difference(lst,two,diffList);
		printList(diffList);
		
	}
	
	public static<T extends Comparable<? super T>>
    void printList(List<T> outList) {
	if(outList.size()==0){
		System.out.println("Nothing to Print in here");
	}
	else{
		for(T item:outList){
			System.out.print(item+" ");
		}
		System.out.println();
	}
}
	
	public static<T extends Comparable<? super T>>
    void sort(List<T> out) {
		List<T> outList=out;
		
		int size=outList.size();
	if(outList.size()==0||outList.size()==1){
		System.out.println("Nothing to sort in here");
	}
	else{
		//Using Insertion Sort Procedure since size is less
		
		int i,j,k;
		T key,min;
		//System.out.println(outList.size());
		for(j=1;j<size;j++){
			i=j-1;
			key = outList.get(j) ;
			while(i>=0&&(outList.get(i).compareTo(key))>0 ){
				min=outList.get(i);
				outList.remove(i+1);
				outList.add(i+1,min);
				
				i--;
			}
			outList.remove(i+1);
			outList.add(i+1,key);
			//ar[i+1]=key;
		}
	}
	
	out=outList;
}
	
	public static<T extends Comparable<? super T>>
    void intersect(List<T> l1, List<T> l2, List<T> outList) {
   // Return elements common to l1 and l2, in sorted order.
   // outList is an empty list created by the calling
       // program and passed as a parameter.
   // Function should be efficient whether the List is
   // implemented using ArrayList or LinkedList.
   // Do not use HashSet/Map or TreeSet/Map or other complex
       // data structures.
		List<T> input1=l1;
		List<T> input2=l2;
		int i=0;
		T temp;
		while (i<input1.size())
	    {
			temp=(T) input1.get(i);
	        if (isPresent(input2,temp )&&(!isPresent(outList,temp)))
	            outList.add(temp);
	        i++;
	    }
		
		
}
	public static<T extends Comparable<? super T>>
    boolean isPresent(List<T> list,T temp){
		//Check if an element is present in the given List.
		List<T> input3=list;
		int i=0;
		T data;
	    while (i<input3.size())
	    {	
	    	data=(T) input3.get(i);
	        if (temp == data)
	            return true;
	        i++;
	    }
		return false;
		
	}

public static<T extends Comparable<? super T>>
    void union(List<T> l1, List<T> l2, List<T> out) {
   // Return the union of l1 and l2, in sorted order.
   // Output is a set, so it should have no duplicates.
	
	
	List<T>outList=out;
	List<T>inp1=l1;
	List<T>inp2=l2;
	int size1=l1.size();
	int size2=l2.size();
	
	for(int i=0;i<size1;i++){
		if(!isPresent(outList,l1.get(i)))
		outList.add(inp1.get(i));
	}
	//printList(outList);
	for(int i=0;i<size2;i++){
		if(!isPresent(outList,l2.get(i)))
		outList.add(inp2.get(i));
	}
	sort(outList);
	out=outList;
}

public static<T extends Comparable<? super T>>
    void difference(List<T> l1, List<T> l2, List<T> out) {
   // Return l1 - l2 (i.e, items in l1 that are not in l2), in sorted order.
   // Output is a set, so it should have no duplicates.
	List<T>outList=out;
	List<T>inp1=l1;
	List<T>inp2=l2;
	int size1=l1.size();
	int size2=l2.size();
	
	for(int i=0;i<size1;i++){
		if(!isPresent(inp2,inp1.get(i))&&!isPresent(outList,l1.get(i)))
		outList.add(inp1.get(i));
	}
	//printList(outList);
	
	sort(outList);
	out=outList;
}
}