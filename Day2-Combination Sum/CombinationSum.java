class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     List<List<Integer>> result=new ArrayList<>();                //Storing Result
        combine(result,new ArrayList<>(),target,candidates,0);
        return result;
    }
    public void combine(List<List<Integer>> result,List<Integer> temp,int target,int arr[],int index)     //Performing Recursion
    {
        if(target<=0)
        {
        if(target==0)
        {
            result.add(new ArrayList<>(temp));        //if target becomes zero then result is updated
        }
            return;
        }
        for(int i=index;i<arr.length;i++)       //when i is 0 then duplicates in list will also be shown
        {
            temp.add(arr[i]);
            combine(result,temp,target-arr[i],arr,i);
            temp.remove(temp.size()-1);
        }
    }
}
