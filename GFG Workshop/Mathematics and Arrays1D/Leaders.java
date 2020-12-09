class Leaders{
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> res=new ArrayList<Integer>();
        int max=arr[n-1];
        res.add(arr[n-1]);
        for(int i=n-2;i>=0;i--){
            max=Math.max(arr[i+1],max);
            if(arr[i]>=max){
                res.add(arr[i]);
            }
        }
        
        Collections.reverse(res);
        return res;
    }
}
