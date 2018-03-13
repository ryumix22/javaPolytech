public class Mainn {
    public static void main(String[] args) {
        OrientedGraph graph = new OrientedGraph();
        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addArc("a", "c", 2);
        graph.addArc("a", "b", 3);
        graph.addArc("b", "c", 4);
        graph.deleteVertex("a");
        graph.deleteArc("b", "c");
        System.out.println(graph.countOfIngoing("b"));
        System.out.println(graph.countOfOutgoing("b"));
        System.out.println(graph.countOfIngoing("c"));
        graph.renameVertex("b", "kek");
        System.out.println(graph.countOfIngoing("kek"));
        graph.addArc("c", "kek",  12);
        System.out.println(graph.getWeight("c", "kek"));

    }
}
