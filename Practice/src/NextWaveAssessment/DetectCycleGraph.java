package NextWaveAssessment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Given N vertices numbered 1 to N of a directed graph along with edges,
//write a java program to check if there exists any cycle.
//Note- a vertex with an edge to itself is also considered a cycle
//Input T represents number of test cases
//In each test cas first line N represents number of vertices.
//N line follow.
//In each test case the nest N line contain space separated integers
//In each line , the first integer has an edge with all following integer except the last one.
//-1 at the end represents end of line
//Output yes or no
//Example:
//1
//5
//1 5 2 -1
//2 4 5 -1
//3 5 -1
//4 5 3 1 -1
//5 -1
//Output is yes

public class DetectCycleGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < N; i++) {
                int u = sc.nextInt();
                while (true) {
                    int v = sc.nextInt();
                    if (v == -1) break;
                    graph.get(u).add(v);
                }
            }

            if (hasCycle(graph, N)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        sc.close();
    }

    static boolean hasCycle(List<List<Integer>> graph, int n) {
        boolean[] visited = new boolean[n + 1];
        boolean[] recStack = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (dfs(i, graph, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean dfs(int node, List<List<Integer>> graph, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor] && dfs(neighbor, graph, visited, recStack)) {
                return true;
            } else if (recStack[neighbor]) {
                return true;
            }
        }

        recStack[node] = false;
        return false;
    }
}
