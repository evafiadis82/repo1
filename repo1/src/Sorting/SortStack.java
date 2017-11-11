package Sorting;

import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
		
		public Stack<Integer> sort(Stack<Integer> s)
		{
			//add code here.
			if(!s.isEmpty()) {
				int top = s.pop();
				sort(s);
				insertSort(s,top);

			}
			return s;

		}

		private void insertSort(Stack<Integer> s, int top) {
			if(s.isEmpty() || top > s.peek()){
				s.push(top);
			}else{
				int temp = s.pop();
				insertSort(s,top);
				s.push(temp);
			}
		}
		
	}

