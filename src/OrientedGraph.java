import java.util.*;
public class OrientedGraph {
    private ArrayList<ArrayList<Integer>> matrix;
    private ArrayList<String> vertex;

    public ArrayList<String> getVertex() {
        return vertex;
    }

    public ArrayList<ArrayList<Integer>> getMatrix() {
        return matrix;
    }

    public Integer[][] matrixOfGraph(ArrayList<ArrayList<Integer>> matrix, ArrayList<String> vertex) {
        Integer size = vertex.size();
        Integer[][] marx = new Integer[size][size];
        for (ArrayList<Integer> helpList : matrix) {
            marx[helpList.get(1)][helpList.get(2)] = helpList.get(3);
        }
        return marx;
    }


    public static void main(String[] args) {

    }
}