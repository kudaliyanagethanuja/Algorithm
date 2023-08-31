//  K.L.T Sathsara
//  20210083


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DirectedGraph {
    private int[][] adjMatrix;

    public DirectedGraph(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    public int findSink() {
        int candidate = 0;
        for (int i = 1; i < adjMatrix.length; i++) {
            if (adjMatrix[candidate][i] == 1) {
                candidate = i;
            }
        }
        for (int i = 0; i < adjMatrix.length; i++) {
            if (i != candidate && (adjMatrix[candidate][i] == 1 || adjMatrix[i][candidate] == 0)) {
                return -1;
            }
        }
        return candidate;
    }

    public void removeVertex(int vertex) {
        for (int i = 0; i < adjMatrix.length; i++) {
            adjMatrix[vertex][i] = 0;
            adjMatrix[i][vertex] = 0;
        }
    }

    public void printEdges() {
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[0].length; j++) {
                if (adjMatrix[i][j] == 1) {
                    System.out.println(i + " -> " + j);
                }
            }
        }
    }

    public static DirectedGraph parseGraphInputFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        int maxVertex = -1;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\s+");
            int vertex1 = Integer.parseInt(parts[0]);
            int vertex2 = Integer.parseInt(parts[1]);
            maxVertex = Math.max(maxVertex, Math.max(vertex1, vertex2));
        }
        reader.close();

        int[][] adjMatrix = new int[maxVertex + 1][maxVertex + 1];
        reader = new BufferedReader(new FileReader(filename));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\s+");
            int vertex1 = Integer.parseInt(parts[0]);
            int vertex2 = Integer.parseInt(parts[1]);
            adjMatrix[vertex1][vertex2] = 1;
        }
        reader.close();

        return new DirectedGraph(adjMatrix);
    }

    //public static void main(String[] args) {
      //  if (args.length < 1) {
        //    System.out.println("Usage: java DirectedGraph <input_file>");
          //  System.exit(1);
        //}

        //String inputFile = args[0];
//
  //      try {
    //        DirectedGraph graph = DirectedGraph.parseGraphInputFile(inputFile);
      //      graph.printEdges();
        ///} catch (IOException e) {
           // System.out.println("Error reading input file: " + e.getMessage());
            //System.exit(1);
        //}
    }
//}