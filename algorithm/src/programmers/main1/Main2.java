package programmers.main1;

import java.util.LinkedList;
import java.util.Queue;

public class Main2 {

    //게임 맵 최단거리
    class Solution {
        static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        static int[][] dist;
        static int count=0;
        public int solution(int[][] maps) {
            int answer = 0;
            dist = new int[maps.length][maps[0].length];
            bfs(maps,0,0);
            answer = dist[maps.length-1][maps[0].length-1];
            return answer;
        }

        private static void bfs(int[][] maps,int x , int y) {
            for(int i = 0 ; i <maps.length ; i++){
                for(int j = 0 ; j < maps[0].length ; j++){
                    dist[i][j] = -1;
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(x);
            queue.add(y);
            dist[x][y] = 1;
            while(!queue.isEmpty()) {
                x = queue.poll();
                y = queue.poll();
                for(int k = 0 ; k < 4; k++) {
                    int nx = x+dir[k][0];
                    int ny = y+dir[k][1];
                    if(nx < 0 || ny < 0 || nx >=maps.length || ny >= maps[0].length) {
                        continue;
                    }
                    if(dist[nx][ny]>-1) continue;
                    if(maps[nx][ny] == 0) continue;
                    queue.add(nx);
                    queue.add(ny);
                    dist[nx][ny] = dist[x][y]+1;
                }
            }
        }
    }

}
