public class Graph {
    private class Node {
        private int data;
        private Node next;
        public Node(int dt, Node n) {
            data = dt;
            next = n;
        }
        public int getDt() {
            return data;
        }
        public Node getNext() {
            return next;
        }
    }
    private Node[] node;
    private int jNode;
    public Graph(int n) {
        jNode = n;
        node = new Node[jNode];
    }
    public void addAdj(int head, int adj) {
    //Code here
        Node n = new Node(adj, node[head]);
        node[head] = n;
    }
    public void print(String message) {
    //Code here
        System.out.println(message);
        for(int i = 0; i < jNode; i++) {
            System.out.print("["+i+"]");
            Node n = node[i];
            while (n!=null){
                System.out.print("->"+n.getDt());
                n = n.getNext();
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addAdj(0, 3);
        g.addAdj(0, 1);
        g.addAdj(1, 4);
        g.addAdj(1, 2);
        g.addAdj(2, 4);
        g.addAdj(2, 1);
        g.addAdj(4, 3);
        g.print("Graph");
    }
}