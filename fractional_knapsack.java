// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

/*
Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
Note: Unlike 0/1 knapsack, you are allowed to break the item. 

--------------------------
Example 1:

Input:
N = 3, W = 50
values[] = {60,100,120}
weight[] = {10,20,30}
Output: 240.00
Explanation: Total maximum value of item
we can have is 240.00 from the given
capacity of sack. 


--------------------------

Example 2:

Input:
N = 2, W = 50
values[] = {60,100}
weight[] = {10,20}
Output: 160.00
Explanation: Total maximum value of item
we can have is 160.00 from the given
capacity of sack.

--------------------------
 */
    class Item implements  Comparable<Item>{
        int value, weight;
        Item(int value, int weight){
            this.value = value;
            this.weight = weight;
        }
        //Default sort will be in Increasing Order of Efficiency
        @Override
        public int compareTo(Item b){
            return (int)Math.signum(((this.value/this.weight*1.0) - (b.value/b.weight*1.0)));
        }
    }

    //Comparator to sort in Decreading order of Efficiency
    class sortByEfficiency implements Comparator<Item>{
        public int compare(Item a,Item b){
            double res = ((b.value*1.0/b.weight*1.0) - (a.value*1.0/a.weight*1.0));
            return (int)Math.signum(res);
        }
    }


class fractional_knapsack {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new solve().fractionalKnapsack(w, arr, n)));
        }
    }
}// } Driver Code Ends

class solve{


    double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr,new sortByEfficiency());
        double value = 0.00;
        int i=0;
        /*for(Item item:arr){
            System.out.println(item.weight+" "+item.value);
        }*/
        while(W>0 && i<arr.length){
            if(W>=arr[i].weight){
                value += arr[i].value;
                W -= arr[i].weight;
            }
            else{
                value += (W*1.0/(arr[i].weight*1.0))*arr[i].value*1.0;
                break;
            }
            i++;
        }//---while ends here
        return value;
    }//---fractionalKnapsack(...) ends
}