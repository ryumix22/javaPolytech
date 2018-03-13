import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
public class OrientedGraph {
    private ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
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
        int vertexNumber = nameToNumber(nameOfVertex.toLowerCase());
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
        if (matrix.get(nameToNumber(start)).get(nameToNumber(end)).equals(0))
            throw new IllegalArgumentException("no way");
         matrix.get(nameToNumber(start)).set(nameToNumber(end), newWeight);
     }

     public ArrayList<String> listOfIngoing (String name) {
         ArrayList<String> list = new ArrayList<>();
         int pos = nameToNumber(name);
         for (int i = 0; i < vertexNameList.size(); i++) {
             if (matrix.get(i).get(pos) != 0) {
                 list.add("from " + vertexNameList.get(i) + " " + Integer.toString(matrix.get(i).get(pos)));
             }
         }
         if (list.isEmpty()) {
             list.add("no arcs");
             return list;
         }
         else
         return list;
     }

     public ArrayList<String> listOfOutgoing (String name) {
        ArrayList<String> list = new ArrayList<>();
        int pos = nameToNumber(name);
        for (int i = 0; i < vertexNameList.size(); i++) {
            if (matrix.get(pos).get(i) != 0)
                list.add("into " + vertexNameList.get(i) + " " + Integer.toString(matrix.get(pos).get(i)));
        }
        if (list.isEmpty()) {
            list.add("no arcs");
            return list;
         }
        else
            return list;
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrientedGraph that = (OrientedGraph) o;

        if (matrix != null ? !matrix.equals(that.matrix) : that.matrix != null) return false;
        return vertexNameList != null ? vertexNameList.equals(that.vertexNameList) : that.vertexNameList == null;
    }

    @Override
    public int hashCode() {
        int result = matrix != null ? matrix.hashCode() : 0;
        result = 31 * result + (vertexNameList != null ? vertexNameList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrientedGraph{" +
                "matrix=" + matrix +
                ", vertexNameList=" + vertexNameList +
                '}';
    }


}
