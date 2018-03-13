import org.jetbrains.annotations.NotNull;

import java.util.*;
public class OrientedGraph {
    private ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
    private ArrayList<String> vertexNameList = new ArrayList<>();


     public void addVertex(String newVertex) {
         vertexNameList.add(newVertex.toLowerCase());
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
         ArrayList subList = matrix.get(vertexNumber);
         matrix.remove(subList);
         vertexNameList.remove(nameOfVertex);
         for (int i = 0; i < vertexNameList.size(); i++) {
             matrix.get(i).remove(vertexNumber);
         }
     }

     public void deleteArc (String start, String end) {
         matrix.get(nameToNumber(start.toLowerCase())).set(nameToNumber(end.toLowerCase()), 0);
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
         Integer pos = nameToNumber(name);
         for (int i = 0; i < vertexNameList.size(); i++) {
             if (matrix.get(pos).get(i) != 0) count++;
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

     public Integer getWeight (String start, String end) {
         ArrayList<Integer> subList = matrix.get(nameToNumber(start));
         return subList.get(nameToNumber(end));
     }

}
