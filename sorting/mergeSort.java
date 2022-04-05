class Solution
{
	 void mergeSort(int arr[], int l, int r)
    {
        //Function to sort an Array using merrge sort.
        if(l >= r){
            return ;
        }
        int m = l + ((r-l)/2);
        
        mergeSort(arr, l, m);
        
        mergeSort(arr, m+1, r);
        
        merge(arr, l, m, r);
    }

    void merge(int arr[], int l, int m, int r)
    {
        // This function will Merge two Sorted Arrays :
        // Array1 : l to m.
        // Array2: m+1 to r.
        
         int[] temp = new int[r-l+1];// Temp Array to store sorted result
         
         int p1 = l, p2 = m+1, k = 0;
         
         while(k < temp.length){
             if(p1 <= m && (p2 > r || arr[p1] < arr[p2])){
                 temp[k++] = arr[p1++];
             } else {
                 temp[k++] = arr[p2++];
             }
         }
         
         for(int i = 0; i< temp.length; i++){
             arr[l+i] = temp[i];
         }
    }
    
}