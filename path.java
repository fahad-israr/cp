import java.util.*;
public class path{
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int m=sc.nextInt();  
if(m==n){System.out.println(0);return;}
int t1=n;
int t2=m;

ArrayList<Integer> ar=new ArrayList<Integer>();
 while(n>1){
    for(int i=2;i<=n;i++)
    if(n%i==0){
        if(i==n){ ar.add(n);ar.add(1);}
        else
        ar.add(n/i);n/=i;
        break;
        
    }
   
 
 }
 ArrayList<Integer> ar2=new ArrayList<Integer>();
 while(m>1){
    
    for(int i=2;i<=m;i++)
    if(m%i==0){
        if(i==m){ ar2.add(m);ar2.add(1);}
        else
        ar2.add(m/i);m/=i;
        break;
        
    }
   
 }
 
 int j=0,i=0;

 if(ar.contains(t2))System.out.print(ar.indexOf(t2)+1);
 else  if(ar2.contains(t1))System.out.print(ar2.indexOf(t1)+1);
 else{
 for( i=0;i<ar.size();i++){
     if(ar2.contains(ar.get(i))){
         j=ar2.indexOf(ar.get(i));
         break;
     }
 }
 System.out.print(i+j);
 
 }
 


}


 
 
}