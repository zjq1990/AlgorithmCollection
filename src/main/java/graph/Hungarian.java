package graph;

import java.util.Arrays;

public class Hungarian {
    private static int[][] G ={
            {1,0,1,0},
            {1,0,0,0},
            {1,1,0,0},
            {0,0,1,1}
    };

    private static boolean[] visit = new boolean[G.length];
    private static int[] matchingx = new int[G.length];//保存结果 x集合对应y集合中的元素标号
    private static int[] matchingy = new int[G.length];//y集合对应x集合中的元素标号

    //深度优先搜索
    private static boolean dfs(int u){//从u点出发寻找增广路
        for(int v = 0;v < G.length;v++){
            if(!visit[v] && G[u][v] == 1){
                visit[v] = true;
                if(matchingy[v] == -1 || dfs(matchingy[v])){
                    matchingx[u] = v;
                    matchingy[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Arrays.fill(matchingx,-1);
        Arrays.fill(matchingy,-1);

        for(int u = 0; u < G.length;u++){
            if(matchingx[u] == -1){
                Arrays.fill(visit,false);
                dfs(u);
            }
        }
        System.out.println(Arrays.toString(matchingx));
        System.out.println(Arrays.toString(matchingy));
    }
}
