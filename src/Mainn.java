public class Mainn {
    public static void main(String[] args) {
        OrientedGraph graph = new OrientedGraph();
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addArc("c", "b", 3);
        graph.addArc("b", "c", 4);
        System.out.print(graph.countOfIngoing("b"));
    }
}
