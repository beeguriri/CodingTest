package com.study.codingtest.programmers.level2;

// 루트 노드를 먼저 찾자!
// 루트 노드 기준 나가는 간선이 2개 => 8자 그래프
// 루트 노드 기준 나가는 간선이 0개 => 막대 그래프
// 나가는 간선이 자기자신으로 돌아오면 => 도넛 그래프

import java.util.*;

public class P_81 {

    static List<List<Integer>> nodes = new ArrayList<>();
    static boolean [] visited;
    static int [] inEdge; //들어 오는 간선의 수
    static int totalGraph;

    public static void initGraph (int [][] edges) {

        Set<Integer> set = new HashSet<>();

        //노드의 번호 중 제일 큰 번호를 구한다.
        for (int[] edge : edges) {
            set.add(edge[0]);
            set.add(edge[1]);
        }

        int maxNode = set.stream().mapToInt(i -> i).max().orElse(0);

        //배열 초기화
        visited = new boolean[maxNode+1];
        inEdge = new int [maxNode+1];

        for(int i=0; i<=maxNode; i++)
            nodes.add(new ArrayList<>());

        //없는 노드 파악
        for(int i=0; i<=maxNode; i++)
            if(!set.contains(i)) visited[i] = true;

        //전체 그래프와, 들어오는 노드의 개수 파악
        //나가는 개수는 List에 저장되니까 들어오는거만 따로 파악해두면 됨.
        for(int[] edge : edges) {
            nodes.get(edge[0]).add(edge[1]);
            inEdge[edge[1]]++;
        }
    }

    public static int [] findGraphs () {

        int rootNode = 0;
        int countBar = 0;
        int countEight = 0;

        for(int i=1; i<nodes.size(); i++) {

            if(visited[i]) continue;

            if(nodes.get(i).size()>=2 && inEdge[i]==0){
                rootNode = i;
                totalGraph = nodes.get(i).size();
                continue;
            }

            if(nodes.get(i).isEmpty()) countBar++;

            else if (nodes.get(i).size()==2) countEight++;

        }
        return new int [] {rootNode, countBar, countEight};
    }

    //이 그래프들과 무관한 정점을 하나 생성한 뒤, (루트노드)
    // 각 도넛 모양 그래프, 막대 모양 그래프, 8자 모양 그래프의 임의의 정점 하나로 향하는 간선들을 연결
    // 그래프가 2개 이상이라고 했으므로 루트노드는 들어오는 간선 0, 나가는 간선 2 이상
//    public static int findRootNode() {
//
//        int node = 0;
//
//        for (int i=1; i<nodes.size(); i++) {
//            if (inEdge[i] == 0 && nodes.get(i).size() >= 2) {
//                node = i;
//                break;
//            }
//        }
//
//        // 루트노드와 연결 된 간선 제거해서 독립적인 그래프 만들기
//        totalGraph = nodes.get(node).size();
//        visited[node] = true;
//
//        for (int i : nodes.get(node))
//            inEdge[i]--;
//
//        return node;
//    }

    //나가는 간선 0
//    public static int findBar() {
//        int countBar = 0;
//        for(int i=1; i<nodes.size(); i++) {
//            if(visited[i]) continue; //시작정점
//
//            if(nodes.get(i).isEmpty()) {
//                countBar++;
//                visited[i] = true;
//            }
//        }
//        return countBar;
//    }

    //나가는 간선 2개
//    public static int findEight() {
//        int countEight = 0;
//        for(int i=1; i<nodes.size(); i++) {
//            if(visited[i]) continue;
//
//            if(nodes.get(i).size()==2) {
//                countEight++;
//                visited[i] = true;
//            }
//        }
//        return countEight;
//    }

    public static int[] solution(int[][] edges) {
        int[] answer = new int [4];
        initGraph(edges);

        int [] findAnswer = findGraphs();
        //루트노드 찾기
        answer[0] = findAnswer[0];

        //막대
        answer[2] = findAnswer[1];

        //8자
        answer[3] = findAnswer[2];

        //도넛
        answer[1] = totalGraph - (answer[2] + answer[3]);

        return answer;
    }

    public static void main(String[] args) {
        int [][] edges = new int [][] {{2, 3}, {4, 3}, {1, 1}, {2, 1}};
        int [][] edges2 = new int [][] {
                {4, 11}, {1, 12}, {8, 3},
                {12, 7}, {4, 2}, {7, 11},
                {4, 8}, {9, 6}, {10, 11},
                {6, 10}, {3, 5}, {11, 1},
                {5, 3}, {11, 9}, {3, 8}
        };
        System.out.println(Arrays.toString(solution(edges2)));
    }
}
