package graph;


import java.util.HashMap;
import java.util.Map;

public class DijkstraShortPath {
    private static final int N = 1000;
    private static int[][] graph = {
            {0, 7, 9, N, N, 14},
            {7, 0, 10, 15, N, N},
            {9, 10, 0, 11, N, 2},
            {N, 15, 11, 0, 6, N},
            {N, N, N, 6, 0, 9},
            {14, N, 2, N, 9, 0}
    };

    private static void dijkstra(int vstart, int[][] graph) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visit = new boolean[n];
        int[] prev = new int[n];
        Map<Integer, String> path = new HashMap<Integer, String>();
        int vnear = vstart;

        //初始化
        for (int i = 0; i < n; i++) {
            dist[i] = graph[vstart][i];
            visit[i] = false;
            prev[i] = vstart;
        }

        visit[vstart] = true;


        for (int i = 1; i < n; i++) {
            int min = N;
            //寻找最近的节点
            for (int j = 0; j < n; j++) {
                if (!visit[j] && dist[j] < min) {
                    min = dist[j];
                    vnear = j;
                }
            }

            visit[vnear] = true;

            //更新dist,记录前一执行节点
            for (int k = 0; k < n; k++) {
                int minDist = min + graph[vnear][k];
                if (!visit[k] && minDist < dist[k]) {
                    dist[k] = minDist;
                    prev[k] = vnear;
                }
            }
        }

        //打印最短路径
        for (int i = 0; i < n; i++) {
            int preprev = prev[i];
            path.put(i,Integer.toString(i));
            while (preprev != vstart) {
                String oldpath = path.get(i);
                path.put(i, preprev + "->" + oldpath);
                preprev = prev[preprev];
            }

            String oldpath = path.get(i);
            path.put(i,  vstart +"->" + oldpath);
        }

        //System.out.println(Arrays.toString(dist));
        for (int i = 0; i < n; i++) {
            //System.out.println("v" + vstart + "...v" + prev[i] + "->v" + i + ", s=" + dist[i]);
            System.out.println(path.get(i)  + ", s=" + dist[i]);
        }

    }


    public static void main(String[] args) {
        dijkstra(3, graph);
    }
}
