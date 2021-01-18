import java.io.*;
import java.util.*;

public class DijkstraPep {
    // Pep
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair> {
        int v;
        int wsf;
        String psf;

        Pair(int v, int wsf, String psf) {
            this.v = v;
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[vtces];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0, src + ""));

        while (!pq.isEmpty()) {
            // rm*wa*
            Pair rem = pq.remove();

            // m*

            if (!visited[rem.v]) {
                visited[rem.v] = true;
                // w
                System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf);
                // a*
                for (Edge e : graph[rem.v]) {
                    if (!visited[e.nbr]) {
                        pq.add(new Pair(e.nbr, e.wt + rem.wsf, rem.psf + e.nbr));
                    }
                }

            } else {
                continue;
            }
        }

    }
}