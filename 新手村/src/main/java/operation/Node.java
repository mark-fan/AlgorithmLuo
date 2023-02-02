package operation;


import java.util.*;

/**
 * 点结构的描述
 */
public class Node {
    public int value;   // 节点值
    public int in;      // 入度
    public int out;     // 出度
    public ArrayList<Node> nexts;  // 出集合
    public ArrayList<Edge> edges;  // 边集合

    // 点
    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    /**
     * 边
     */
    public static class Edge {
        public int weight;  // 权重
        public Node from; // 初节点
        public Node to;  // 连接点

        public Edge(int weight, Node from, Node to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }

    /**
     * 图
     */
    public static class Graph {
        public HashMap<Integer, Node> nodes;  //点集
        public HashSet<Edge> edges;     //边集

        public Graph() {
            this.nodes = new HashMap<>();
            this.edges = new HashSet<>();
        }
    }

    /**
     * 拓扑排序
     * @param graph
     * @return
     */
    // directed graph and no loop
    public static List<Node> sortedTopology(Graph graph) {
        // key :某个node
        // value :剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        // 剩余入度为0的点 进入这个队列
        Queue<Node> zeroInquene = new LinkedList<>();
        for (Node value : graph.nodes.values()) {
            inMap.put(value, value.in);
            if (value.in == 0) {
                zeroInquene.add(value);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInquene.isEmpty()) {
            Node cur = zeroInquene.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, next.in);
                if (next.in == 0) {
                    zeroInquene.add(next);
                }
            }
        }
        return result;
    }


}
