import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;




public class Tests {
    OrientedGraph graph = new OrientedGraph();
    OrientedGraph graph2 = new OrientedGraph();
    OrientedGraph graph3 = new OrientedGraph();


    @Test
    public void addVertex() {
        graph.addVertex("Moscow");
        graph.addVertex("Spb");
        assertEquals("OrientedGraph{matrix=[[0, 0], [0, 0]], vertexNameList=[moscow, spb]}", graph.toString());
        graph.addVertex("Kiev");
        assertEquals("OrientedGraph{matrix=[[0, 0, 0], [0, 0, 0], [0, 0, 0]], " +
                        "vertexNameList=[moscow, spb, kiev]}",
                graph.toString());
    }

    @Test
    public void addArc() {
        graph.addVertex("Moscow");
        graph.addVertex("Spb");
        graph.addVertex("Kiev");
        graph.addArc("moscow", "spb", 800);
        graph.addArc("moscow", "kiev", 1300);
        graph.addArc("spb", "kiev", 1400);
        assertEquals("OrientedGraph{matrix=[[0, 800, 1300], [0, 0, 1400], [0, 0, 0]], " +
                        "vertexNameList=[moscow, spb, kiev]}",
                graph.toString());
        graph.addArc("kiev", "spb", 2000);
        assertEquals("OrientedGraph{matrix=[[0, 800, 1300], [0, 0, 1400], [0, 2000, 0]], " +
                        "vertexNameList=[moscow, spb, kiev]}",
                graph.toString());
    }

    @Test
    public void deleteVertex() {
        graph.addVertex("Moscow");
        graph.addVertex("Spb");
        graph.addVertex("Kiev");
        graph.addArc("moscow", "spb", 800);
        graph.addArc("moscow", "kiev", 1300);
        graph.addArc("spb", "kiev", 1400);
        graph.deleteVertex("kiev");
        assertEquals("OrientedGraph{matrix=[[0, 800], [0, 0]], " +
                        "vertexNameList=[moscow, spb]}",
                graph.toString());
        graph.deleteVertex("spb");
        assertEquals("OrientedGraph{matrix=[[0]], " +
                        "vertexNameList=[moscow]}",
                graph.toString());
    }

    @Test
    public void deleteArc() {
        graph.addVertex("Moscow");
        graph.addVertex("Spb");
        graph.addVertex("Kiev");
        graph.addArc("moscow", "spb", 800);
        graph.addArc("moscow", "kiev", 1300);
        graph.addArc("spb", "kiev", 1400);
        graph.deleteArc("moscow", "spb");
        assertEquals("OrientedGraph{matrix=[[0, 0, 1300], [0, 0, 1400], [0, 0, 0]], " +
                        "vertexNameList=[moscow, spb, kiev]}",
                graph.toString());
        graph.deleteArc("spb", "kiev");
        assertEquals("OrientedGraph{matrix=[[0, 0, 1300], [0, 0, 0], [0, 0, 0]], " +
                        "vertexNameList=[moscow, spb, kiev]}",
                graph.toString());
    }

    @Test
    public void renameVertex() {
        graph.addVertex("Moscow");
        graph.addVertex("Spb");
        graph.addVertex("Kiev");
        graph.renameVertex("spb", "krasnodar");
        assertEquals("OrientedGraph{matrix=[[0, 0, 0], [0, 0, 0], [0, 0, 0]], " +
                        "vertexNameList=[moscow, krasnodar, kiev]}",
                graph.toString());
        graph.renameVertex("moscow", "voronezh");
        assertEquals("OrientedGraph{matrix=[[0, 0, 0], [0, 0, 0], [0, 0, 0]], " +
                        "vertexNameList=[voronezh, krasnodar, kiev]}",
                graph.toString());
    }

    @Test
    public void changeWeight() {
        graph.addVertex("Moscow");
        graph.addVertex("Spb");
        graph.addVertex("Kiev");
        graph.addArc("moscow", "spb", 800);
        graph.addArc("moscow", "kiev", 1300);
        graph.addArc("spb", "kiev", 1400);
        graph.changeWeight("moscow", "spb", 1000);
        assertEquals("OrientedGraph{matrix=[[0, 1000, 1300], [0, 0, 1400], [0, 0, 0]], " +
                        "vertexNameList=[moscow, spb, kiev]}",
                graph.toString());
        graph.changeWeight("moscow", "kiev", 1333);
        assertEquals("OrientedGraph{matrix=[[0, 1000, 1333], [0, 0, 1400], [0, 0, 0]], " +
                        "vertexNameList=[moscow, spb, kiev]}",
                graph.toString());
    }

    @Test
    public void countOfIngoing() {
        graph.addVertex("Moscow");
        graph.addVertex("Spb");
        graph.addVertex("Kiev");
        graph.addVertex("voronezh");
        graph.addArc("moscow", "spb", 800);
        graph.addArc("moscow", "kiev", 1300);
        graph.addArc("spb", "kiev", 1400);
        graph.addArc("moscow", "voronezh", 400);
        graph.addArc("kiev", "voronezh", 500);
        graph.addArc("voronezh", "spb", 1100);
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> noArc = new ArrayList<>();
        noArc.add("no arcs");
        Collections.addAll(list1, "from moscow 800", "from voronezh 1100");
        assertEquals(noArc , graph.listOfIngoing("moscow"));
        assertEquals(list1, graph.listOfIngoing("spb"));
    }

    @Test
    public void countOfOutgoing() {
        graph.addVertex("Moscow");
        graph.addVertex("Spb");
        graph.addVertex("Kiev");
        graph.addVertex("voronezh");
        graph.addArc("moscow", "spb", 800);
        graph.addArc("moscow", "kiev", 1300);
        graph.addArc("spb", "kiev", 1400);
        graph.addArc("moscow", "voronezh", 400);
        graph.addArc("kiev", "voronezh", 500);
        graph.addArc("voronezh", "spb", 1100);
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> noArc = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        noArc.add("no arc");
        Collections.addAll(list1, "into spb 800", "into kiev 1300", "into voronezh 400");
        Collections.addAll(list2, "into kiev 1400");
        assertEquals(list1, graph.listOfOutgoing("moscow"));
        assertEquals(list2, graph.listOfOutgoing("spb"));
    }

    @Test
    public void equals() {
        graph.addVertex("Moscow");
        graph.addVertex("Spb");
        graph.addVertex("Kiev");
        graph.addArc("moscow", "spb", 800);
        graph.addArc("moscow", "kiev", 1300);
        graph.addArc("spb", "kiev", 1400);
        graph2.addVertex("Moscow");
        graph2.addVertex("Spb");
        graph2.addVertex("Kiev");
        graph2.addArc("moscow", "spb", 800);
        graph2.addArc("moscow", "kiev", 1300);
        graph2.addArc("spb", "kiev", 1400);
        assertEquals(true, graph.equals(graph2));
        graph3.addVertex("Moscow");
        graph3.addVertex("Spb");
        graph3.addVertex("Kiev");
        graph3.addArc("moscow", "spb", 80);
        graph3.addArc("moscow", "kiev", 200);
        graph3.addArc("spb", "kiev", 1);
        assertEquals(false, graph.equals(graph3));


    }
}