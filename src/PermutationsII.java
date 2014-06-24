import java.util.*;
public class PermutationsII {
	private int[] num = null;
	private List<List<Integer>> lists = new ArrayList<List<Integer>>();
	private List<Integer> list = new ArrayList<>();
	private boolean[] mark = null;
	private int count = 0;	
	public List<List<Integer>> permuteUnique(int[] num) {
		if(num == null) return new ArrayList<List<Integer>>();
		Arrays.sort(num);
		this.num = num;
		this.mark = new boolean[num.length];		
		this.count = num.length;
		helper();
		return lists;
	}
	private void helper(){
		
		if(count == 0 ){
			List<Integer> r = new ArrayList<Integer>(list);
			lists.add(r);
		}
		for(int i=0;i<num.length;i++){
			if(mark[i] == false){				
				mark[i] = true;;
				list.add(num[i]);
				count--;
				helper();
				count++;	
				list.remove(list.size()-1);
				mark[i] = false;
				//if next to be append element is the same as this one, we should avoid it
				while(i < num.length-1 && num[i] == num[i+1])
					
					i++;
			}
//			System.out.println("count = " + count + ", i = " + i + ", " + Arrays.toString(mark) + ", " + list);					
		}	
	}

	public static void main(String[] args){
		int[] A = new int[]{0,1,1,0};
		PermutationsII solution = new PermutationsII();
		List<List<Integer>> res = solution.permuteUnique(A);
		solution.printLists(res);		
	}
	private void printLists(List<List<Integer>> lists){
		for(List<Integer> list : lists){
			for(Integer i:list){
				System.out.print(i + ", ");
			}
			System.out.println();
		}
		
	}

}
