/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        if(node == null || node.neighbors == null || node.neighbors.isEmpty()){
            return node == null ? null : new Node(node.val, new ArrayList<>(node.neighbors));
        }
        
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> originalNodeToCopyNodeMap = new HashMap<>();
        
        Node copyNode = new Node(node.val, new ArrayList<>(node.neighbors));
        
        Queue<Node> q = new LinkedList<>();
        originalNodeToCopyNodeMap.put(node, copyNode);
        q.add(copyNode);
        visited.add(copyNode);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            //System.out.println(curr.val);
            List<Node> copiedNeighbourList = new ArrayList<>();
            for(Node neighbourNode : curr.neighbors){
                //System.out.println("neighbourNode: "+neighbourNode.val);
                Node copyNeighbourNode;
                if(originalNodeToCopyNodeMap.containsKey(neighbourNode)){
                    //System.out.println("orignal Map has the value");
                    copyNeighbourNode = originalNodeToCopyNodeMap.get(neighbourNode);
                } else {
                    copyNeighbourNode = new Node(neighbourNode.val, new ArrayList<>(neighbourNode.neighbors));
                    originalNodeToCopyNodeMap.put(neighbourNode, copyNeighbourNode);
                }
                
                copiedNeighbourList.add(copyNeighbourNode);

                if(!visited.contains(copyNeighbourNode))
                {
                    q.add(copyNeighbourNode);
                    visited.add(copyNeighbourNode);
                }
            }
            curr.neighbors = copiedNeighbourList;
        }
        //System.out.println(copyNode.val);
        copyNode.neighbors.forEach(obj -> System.out.println(obj.val));
        return copyNode;
    }
}