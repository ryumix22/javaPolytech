import org.jetbrains.annotations.NotNull;

import java.util.*;
public class OrientedGraph {
    private ArrayList<ArrayList<Integer>> matrix;
    private ArrayList<String> vertexNameList;


     public void addVertex(String newVertex) {
         vertexNameList.add(newVertex);
         int numberOfVertex = vertexNameList.size();
         ArrayList<Integer> newList = new ArrayList<>();
         newList.add(0);
         if (numberOfVertex == 1) {
             matrix.add(newList);
         } else {
             for (int i = 0; i < numberOfVertex - 1; i++) {
                 newList.add(0);
                 matrix.get(i).add(0);
             }
             matrix.add(newList);
         }
     }

     @NotNull
     private Integer nameToNumber(String name) {
         if (vertexNameList.contains(name)) return vertexNameList.indexOf(name.toLowerCase());
         else throw new IllegalArgumentException("wrong name");
     }

     public void addArc(String start, String end, Integer wight) {
         ArrayList<Integer> subList = matrix.get(nameToNumber(start.toLowerCase()));
         subList.set(nameToNumber(end.toLowerCase()), wight);
         matrix.set(nameToNumber(start.toLowerCase()), subList);
     }

     public void deleteVertex (String nameOfVertex) {
         Integer vertexNumber = nameToNumber(nameOfVertex.toLowerCase());
         matrix.remove(vertexNumber);
         for (int i = 0; i < vertexNameList.size() - 1; i++) {
             matrix.get(i).remove(vertexNumber);
         }
     }

     public void deleteArc (String start, String end) {
         matrix.get(nameToNumber(start.toLowerCase())).remove(nameToNumber(end.toLowerCase()));
     }

     public void renameVertex (String oldVertex, String newVertex) {
         vertexNameList.remove(nameToNumber(oldVertex));
         vertexNameList.set(nameToNumber(oldVertex), newVertex);
      }

     public void changeWeight (String start, String end, Integer newWeight) {
         matrix.get(nameToNumber(start)).set(nameToNumber(end), newWeight);
     }

     public Integer countOfOutgoing (String name) {
         Integer count = 0;
         for (int i = 0; i < vertexNameList.size(); i++) {
             if (matrix.get(nameToNumber(name)).get(i) != 0) count++;
         }
         return count;
     }

     public Integer countOfIngoing (String name) {
         Integer count = 0;
         for (int i = 0; i < vertexNameList.size(); i++) {
             if (matrix.get(i).get(nameToNumber(name)) != 0) count++;
         }
         return count;
     }

}
