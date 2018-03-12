import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.*;
public class OrientedGraph {
    private ArrayList<ArrayList<Integer>> matrix;
    private ArrayList<String> vertexNameList;


     public void addVertex(String newVertex) {
         vertexNameList.add(newVertex);
         int numberOfVertex = vertexNameList.size();
         ArrayList newList = new ArrayList();
         for (int i = 0; i < numberOfVertex - 1; i++) {
             newList.add(0);
             ArrayList sideList = matrix.get(i);
             sideList.add(0);
         }
         matrix.add(newList);
     }

     public void addArc(ArrayList<Integer> newArc) {

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