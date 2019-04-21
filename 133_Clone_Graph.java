/*
133. Clone Graph
Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node output = null;
        HashSet<Node> visited = new HashSet<>();
        while(!q.isEmpty()){
            Node temp = q.poll();
            int val = temp.val;
            List<Node> neighbors = new ArrayList<>();
            for(Node n: temp.neighbors){
                neighbors.add(n);
                if(!visited.contains(n)){
                    q.add(n);
                }
            }
            Node current = new Node(val, neighbors);
            if(output == null){
                output = current;
            }
            visited.add(temp);
        }
        return output;
    }
}