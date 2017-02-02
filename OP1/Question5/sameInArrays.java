package delete;

public class sameInArrays {

	public static void main(String args[]){
		
		int ar[]=new int[10];
		for(int i=0;i<10;i++){
			ar[i]=i+1;
		}
		int n=4;
		print(ar,n);
	}

	private static void print(int[] ar, int n) {
		// TODO Auto-generated method stub
		int temp=0;
		int cur=0;
		int count=0;
		
		while(temp<n){
			
		count++;
		
		while(cur<ar.length){
			System.out.print(ar[cur]);
			cur+=n;
		}
		cur=count;
		temp++;
		}
	}
}
