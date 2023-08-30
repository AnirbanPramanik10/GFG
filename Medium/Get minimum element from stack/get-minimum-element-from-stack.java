//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends



class GfG
{
    int minEle;
    Stack<Integer> s;
    Stack<Integer> helper;
    // Constructor    
    GfG()
	{
        s=new Stack<>();
        helper=new Stack<>(); //helper is used to store the min elements 
	}
	
    /*returns min element from stack*/
    int getMin()
    {
	// Your code here
	    if(s.isEmpty())
	        return -1; //if the stack is empty, -1 is returned 
	    return helper.peek(); 
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	// Your code here
	    if(s.isEmpty())
	        return -1;
	    helper.pop();
	    return s.pop();
	    
    }

    /*push element x into the stack*/
    void push(int x)
    {
	// Your code here	
	    s.push(x); //element is pushed to stack s
	    if(helper.isEmpty())
	        helper.push(x);
	    else
	        helper.push(Math.min(x,helper.peek())); //x in stack s is compared with the element in stack helper
    }	
}