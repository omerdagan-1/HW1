public class Assignment01Q05 {
    // Time complexity: O(n^2), where n is the number of vertices
    // Each layer scans the distance array, and each vertex's column is scanned once
    // Auxiliary space: O(n) for the distance array
    public static int findShortestPath(int[][] m, int i, int j) {
        if (i == j) {
            return 0;
        }
        // distance[k] is the shortest distance from k to j
        // -1 marks vertices that have not been discovered yet
        int[] distance = new int[m.length];
        for (int k = 0; k < m.length; k++) {
            distance[k] = -1;
        }
        distance[j] = 0;
        int layer = 0; // Search backwards from the destination, one distance layer at a time
        boolean layerExists = true;
        while (layerExists) {
            layerExists = false;
            // Find all vertices at the current distance from j
            for (int k = 0; k < m.length; k++) {
                if (distance[k] == layer) {
                    layerExists = true;
                    // Scan column k to find incoming edges l -> k
                    for (int l = 0; l < m.length; l++) {
                        if (m[l][k] == 1 && distance[l] == -1) {
                            // First discovery gives the shortest distance
                            // Marking vertices prevents revisits, including cycles
                            distance[l] = layer + 1;
                            if (l == i) {
                                return distance[l];
                            }
                        }
                    }
                }
            }
            layer++; // Newly discovered vertices are processed in the next layer
        }
        return -1; // An empty layer means the search is exhausted without reaching i
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}