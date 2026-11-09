public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        if (i == j) {
            return 0;
        }
        int[] distance = new int[m.length];
        for (int k = 0; k < m.length; k++) {
            distance[k] = -1;
        }
        distance[j] = 0;
        int layer = 0;
        boolean layerExists = true;
        while (layerExists) {
            layerExists = false;
            for (int k = 0; k < m.length; k++) {
                if (distance[k] == layer) {
                    layerExists = true;
                    for (int l = 0; l < m.length; l++) {
                        if (m[l][k] == 1 && distance[l] == -1) {
                            distance[l] = layer + 1;
                            if (l == i) {
                                return distance[l];
                            }
                        }
                    }
                }
            }
            layer++;
        }
        return -1;
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