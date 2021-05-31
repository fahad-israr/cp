// https://leetcode.com/problems/merge-intervals
// Merge Overlapping Internvals
class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length<=1) //Corner Case
            return intervals;
        Arrays.sort(intervals, (i1,i2)->(i1[0]-i2[0]));
        
        List<int[]> res = new ArrayList<int[]>();
        
        int b = intervals[0][0] ;
        int e = intervals[0][1] ;
        
        for(int i=1; i<intervals.length ; i++){
            
            // Partial Overlap
            if(intervals[i][0]<=e && e<=intervals[i][1])
                e = intervals[i][1] ;
            else 
            /*
                Check e<=intervals[i][1] to see if there is not a complete Overlap
                Example TestCase: [[1,4],[2,3]]
            */    
            if(e<=intervals[i][1]){
               res.add(new int[]{b,e});
               b = intervals[i][0];
               e = intervals[i][1];
            }
            
            if(i == intervals.length-1)
            {
                res.add(new int[]{b,e});
            }
            
        }
        
        int[][] answer = new int[res.size()][2];
        
        for(int i = 0; i<res.size();i++)
            answer[i] = res.get(i);
        
        return answer;
        
    } // merge(args... ) ends
    
    
}