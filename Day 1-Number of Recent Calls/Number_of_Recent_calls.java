class RecentCounter {

    ArrayList<Integer> al=new ArrayList<>();                  //ArrayList is used for storing time frame
    
    public RecentCounter() {
        al.clear();
    }
    
    public int ping(int t) {
        al.add(t);                     //new time frame is added in the arraylist data structure
        int low=t-3000;                //low stores the lower limit of the range
        int high=t;                    //high stores the upper limit
        int count=0;                   //count will store the number of requests in the time frame
        for(int i=0;i<al.size();i++)
        {
            if(al.get(i)>=low && al.get(i)<=high)
            {
                count++;
            }
        }
        return count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
