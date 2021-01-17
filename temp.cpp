#include <bits/stdc++.h>
using namespace std;
typedef long long      ll;



struct Item  
{ 
    ll value, weight; 
  
    // Constructor 
    Item(ll value, ll weight) 
        : value(value) 
        , weight(weight) 
    { 
    } 
}; 
  
// Comparison function to sort Item according to val/weight 
// ratio 
bool cmp(struct Item a, struct Item b) 
{ 
    double r1 = ( double)a.value / ( double)a.weight; 
    double r2 = ( double)b.value / ( double)b.weight; 
    return r1 < r2; 
} 
  
// Main greedy function to solve problem 
double fractionalKnapsack(ll W, vector<Item> arr, ll n) 
{ 
    //    sorting Item on basis of ratio 
    sort(arr.begin(), arr.end(), cmp); 
  
  
    ll curWeight = 0; // Current weight in knapsack 
     double finalvalue = 0.0; // Result (value in Knapsack) 
  
    // Looping through all Items 
    for (ll i = 0; i < n; i++)  
    { 
        // If adding Item won't overflow, add it completely 
        if (curWeight + arr[i].weight <= W)  
        { 
            curWeight += arr[i].weight; 
            finalvalue += arr[i].value; 
        } 
  
        // If we can't add current Item, add fractional part 
        // of it 
        else 
        { 
            ll remain = W - curWeight; 
            finalvalue += arr[i].value * (( double)remain / ( double)arr[i].weight); 
            break; 
        } 
    } 
  
    // Returning final value 
    //cout<<finalvalue
    return finalvalue; 
} 
  

int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    ll t;
    cin>>t;
    while (t--)
    {
        ll n;
        cin>>n;
        vector<ll> fuel(n,0);
        //ARRAY
        for(ll i=0;i<n;i++)
            cin>>fuel[i];

        vector<ll> cost(n,0);
        //COST ARRAY
        for(ll i=0;i<n;i++)
            cin>>cost[i];


        for(ll i=0;i<n;i++)
            cost[i]*=fuel[i];

        vector<Item>arr;
        for(ll i=0;i<n;i++)
        {
            arr.push_back(Item(cost[i],fuel[i]));
        }
        
        // cout<<"TEST="<<arr[0].value<<endl;
        // cout<<"TEST="<<arr[0].weight<<endl;

        cout<<ll(fractionalKnapsack(n, arr, n))<<endl;

    }
}
    
