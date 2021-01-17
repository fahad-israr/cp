#include <bits/stdc++.h>
using namespace std;
typedef long long      ll;

int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL); 
    int t;
    cin>>t;
    while (t--)
    {
        string s;
        cin>>s;
        //sliding window
        set<pair<pair<int,int>,pair<int,int>>>Subset;
        for(int i=1;i<=s.size();i++)
        {
            int zero=0; 
            int one=0; 
            int tillone=0;
            int sumeven=0,sumodd=0;
            vector<int> l;
            int rt=0;
            //FOR THE WINDOW
            for(int j=0;j<i;j++)
            {
                if(s[j]=='1')
                {
                    one++;
                    l.push_back(rt);
                    rt=0;
                }   
                else
                {
                    if(one%2==0)    sumeven++;
                    else    sumodd++;
                    zero++;
                    rt++;
                }
            }
            l.push_back(rt);
            Subset.insert(make_pair(make_pair(zero,one),make_pair(sumeven,sumodd)));
            //NOW FOR  EACH WINDOW J IS THE NEW ELEMENT TO BE ADDED IN THE WINDOW
            for(int j=i;j<s.size();j++)
            {
                //REmove the element which is thrown out of the window
                if(s[j-i]=='1')
                {
                    //REVERSE HOGA YAHA PE AGAR ONE NIKLA TOH...
                    l.erase(l.begin());
                    one--;
                    swap(sumeven,sumodd);
                }   
                else
                {
                    zero--;
                    l[0]=-1;
                    sumeven--;
                    // else    sumodd--;
                }
                if(s[j]=='1')
                {
                    one++;
                    l.push_back(0);
                }   
                else
                {
                    l[l.size()-1]++;
                    if(l.size()%2==1)   sumeven++;
                    else    sumodd++;
                    zero++;
                }
                //cout<<"Start="<<j-i+1<<" End="<<j<<" SumEven="<<sumeven<<" SUmOdd="<<sumodd<<endl;
                Subset.insert(make_pair(make_pair(zero,one),make_pair(sumeven,sumodd)));
            }
            
        }
        cout<<Subset.size()<<endl;
    }
    return 0;        
}
    
