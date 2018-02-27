import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.*;
public class OrientedGraph {
    private ArrayList<ArrayList<Integer>> matrix;
    private ArrayList<Integer> vertex;

    public ArrayList<Integer> getVertex() {
        return vertex;
    }

    public ArrayList<ArrayList<Integer>> getMatrix() {
        return matrix;
    }

    private static Integer[][] matrixOfGraph(ArrayList<ArrayList<Integer>> matrix, ArrayList<Integer> vertex) {
        Integer size = vertex.size();
        Integer[][] marx = new Integer[size][size];
        for (ArrayList<Integer> helpList : matrix) {
            marx[helpList.get(1)][helpList.get(2)] = helpList.get(3);
        }
        return marx;
    }

     public void addVertex(Integer newVertex) {
        vertex.add(newVertex);
     }

     public void addArc(ArrayList<Integer> newArc) {
        matrix.add(newArc);
     }

     public void deleteVertex(Integer oldVertex) {
        vertex.remove(oldVertex);
     }

     public void deleteArc(ArrayList<Integer> oldArc){
        matrix.remove(oldArc);
     }
      public void renameVertex(Integer position, Integer name) {

      }

    public static void main(String[] args) {
        ArrayList<Integer> newList = new ArrayList<>();
        newList.add(1);
        newList.add(2);
        newList.add(3);
        OrientedGraph lel = new OrientedGraph();
        lel.addVertex(1);
        lel.addArc(newList);

    }
}