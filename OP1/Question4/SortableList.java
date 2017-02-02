public class SortableList<T extends Comparable<? super T>> extends SinglyLinkedList<T> {
    public void merge(SortableList<T> list) {
    	//this.printList();
       // list.printList();
        SortableList<T>.Entry<T> head;
        //comparing elements of both lists
        if (this.header.next.element.compareTo(list.header.next.element) < 0){
            head = this.header.next;
        }
        else
        {
            head = list.header.next;
            list.header.next = this.header.next;
            this.header.next = head;
        }
        
        SortableList<T>.Entry<T> leftCurr = this.header.next;
        SortableList<T>.Entry<T> rightCurr = list.header.next;
        head = leftCurr;
        
        //Invariant : comparing left and right lists elements 
        //merging the elements into left list accordingly
        //loop continues until the list ends
        if (head.next != null)
        while(leftCurr != null){
            if (leftCurr.element.compareTo(rightCurr.element) > 0){
                SortableList<T>.Entry<T> temp = leftCurr;
                leftCurr = rightCurr;
                rightCurr = temp;        
            }
            leftCurr = leftCurr.next;
        }
        if (head.next != null)
        if (leftCurr == null){
        leftCurr = rightCurr;
        }        
        this.header = head;     
    		
    	}
    	
		
    
    void mergeSort() {
    	mergeSort(this);
    }
    public static<T extends Comparable<? super T>> void mergeSort(SortableList<T> lst) {
    	
    	SortableList<T>.Entry<T> oldHead = lst.header;
		// find the length of the linkedlist
		int length = getLength(lst);
		//System.out.println("length  "+length);
		int mid=length/ 2;
		if (length<=1)
			return;
		
		SortableList<T> leftLst = new SortableList<>();
        SortableList<T> rightLst = new SortableList<>();
        
        int itr=0;
		// set one pointer to the beginning of the list and another at the next
		// element after mid
		while (itr<mid) {
			
			leftLst.add(oldHead.next.element);
			oldHead = oldHead.next;
			itr++;
		}
		
		SortableList<T>.Entry<T> newHead = oldHead.next;// make newHead points to the beginning of
									// the second half of the list
		
		while(newHead!=null){
			rightLst.add(newHead.element);
			newHead=newHead.next;
		}
		oldHead.next = null;// break the list
		oldHead = lst.header;// make one pointer points at the beginning of the first
					// half of the list
		leftLst.printList();
		rightLst.printList();
		mergeSort(leftLst);//make recursive calls 
		 mergeSort(rightLst);
		 leftLst.merge(rightLst);
		 //leftLst.printList();
		 // merge the sorted lists
    }
    public static<T extends Comparable<? super T>> int getLength(SortableList<T> lst) {
    	int count = 0;
    	SortableList<T>.Entry<T> h = lst.header;
		while (h != null) {
			count++;
			h = h.next;
		}
		return count-1;
    }
    
    public static void main(String[] args) {
    	//creating lst list and adding elements to the list
        SortableList<Integer> lst = new SortableList<>();
        lst.add(2);
        lst.add(1);
        lst.add(4);
        lst.add(3);
        lst.add(8);
        lst.printList();
        lst.mergeSort();
    }
}