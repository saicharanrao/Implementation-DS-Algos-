import java.util.*;

public class ShuntingMain {
	/*This program uses Shunting Algorithm to find Postfix evaluation of 
	 * an given expression.
	*/
	public static void main(String args[]){
		
		Scanner cs=new Scanner(System.in);
		
		String order = "!^*/+-";		//Order of priority
		
		String inpExpr=cs.nextLine();		//Input expression
		inpExpr=inpExpr.replaceAll(" ", "");  //Remove all spaces
		
		performShunt(inpExpr,order);		//Shunting Algorithm
	}

	private static void performShunt(String inpExpr, String order) {
		// TODO Auto-generated method stub
		int count1=0,count2=0;
		String Stack1="", Stack2 = "" , tempStack = "";
		
		String prec = order+"()";
		
		for(int i=0;i<inpExpr.length();i++){
			
			
			if(prec.indexOf(inpExpr.charAt(i))==-1){
				
				/*
				 * If a given character is not on operator add to stack1
				 */
				Stack1+=inpExpr.charAt(i);
				
			}
			else{
				/*
				 * If a given character is an operator add to stack2
				 */
				Stack2+=inpExpr.charAt(i);
				 
				count2=Stack2.length();
				if(Stack2.indexOf('(')!=-1&&Stack2.indexOf(')')!=-1){
					/*
					 * If stack2 encounters both ( and ) pop all operators
					 * between them to stack1 and replace (,) with empty spaces.
					 */
					int one = Stack2.indexOf('(');
					int two = Stack2.indexOf(')');
					
					for(int q=one+1;q<two;q++){
						Stack1+=Stack2.charAt(q);
						Stack2=Stack2.replace(Stack2.charAt(q)+"", "");
					}
					Stack2=Stack2.replace("(", "");
					Stack2=Stack2.replace(")", "");
				}
				else if(count2>1){
					/*
					 * Check if the existing stack top has higher priority than
					 * incoming element,if so pop and add to stack1.
					 */
					if(highPrec(order,Stack2.charAt(count2-1),Stack2.charAt(count2-2))){
						Stack1+=Stack2.charAt(count2-2);
						
						Stack2=Stack2.replace(Stack2.charAt(count2-2)+"", "");
						
					}
				}
				/*
				 * tempStack contains Stack2 string free of spaces .
				 */
				
				tempStack=Stack2.replace(" ", "");
			}
			
			
			
		}
		
		System.out.println("Final Postfix Expression:");
		StringBuffer sb = new StringBuffer(tempStack);
		Stack1+=sb.reverse();
		System.out.println(Stack1);
	}
	

	private static boolean highPrec(String order, char i, char j) {
		// TODO Auto-generated method stub
		int temp1=order.indexOf(i);
		int temp2 = order.indexOf(j);
		if(temp1<0||temp2<0)return false;
		return temp1>temp2;
	}
}
