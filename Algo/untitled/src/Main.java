
//  K.L.T Sathsara
//  20210083


import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Parse input file and create DirectedGraph object
        DirectedGraph graph = null;
        try {
            System.out.print("Enter the name of the input file:\n ");
            String filename = scanner.nextLine();
            graph = DirectedGraph.parseGraphInputFile(filename);
        } catch (IOException e) {
            System.out.println("Error reading input file: " + e.getMessage());
            return;
        }

        // Menu loop
        boolean quit = false;
        while (!quit) {
            System.out.println("<<<<<<<<<<<>>>>>>>>>>>>\n");

            System.out.println("1. Find a sink vertex");
            System.out.println("2. Remove a vertex");
            System.out.println("3. Print edges");
            System.out.println("4. Quit\n");
            System.out.println("<<<<<<<<<<<<>>>>>>>>>>>>>");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    int sinkVertex = graph.findSink();
                    if (sinkVertex != -1) {
                        System.out.println("Sink vertex: " + sinkVertex);
                    } else {
                        System.out.println("No sink  found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the index of the vertex to remove: ");
                    int vertexToRemove = scanner.nextInt();
                    scanner.nextLine();  // Consume newline character
                    graph.removeVertex(vertexToRemove);
                    System.out.println("Vertex " + vertexToRemove + " removed.");
                    break;
                case 3:
                    graph.printEdges();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
