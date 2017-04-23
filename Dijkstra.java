import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Vertex implements Comparable<Vertex>
{
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

}


class Edge
{
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}

public class Dijkstra
{
    public static void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
    vertexQueue.add(source);

    while (!vertexQueue.isEmpty()) {
        Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
        if (distanceThroughU < v.minDistance) {
            vertexQueue.remove(v);

            v.minDistance = distanceThroughU ;
            v.previous = u;
            vertexQueue.add(v);
        }
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args)
    {
        // mark all the vertices
        Vertex A = new Vertex("IIT Jodhpur");
        Vertex B = new Vertex("Sabji Mandi Link Road");
        Vertex C = new Vertex("Bhaskar Chauraha");
        Vertex D = new Vertex("Bhati Circle");
        Vertex E = new Vertex("Ratanada Circle");
        Vertex F = new Vertex("IIT Front Gate");
        Vertex G = new Vertex("MBM College");
        Vertex H = new Vertex("Circuit House Circle");
        Vertex I = new Vertex("Senapati Bhawan Circle");
        Vertex J = new Vertex("Subhash Chowk");
        Vertex K = new Vertex("Tarachand Circle");
        Vertex L = new Vertex("Nai Sarak Circle");
        Vertex M = new Vertex("Sojati Gate");
        Vertex N = new Vertex("Sardar Market");
        Vertex O = new Vertex("Ghanta Ghar");
        Vertex P = new Vertex("Ansal Royal Plaza");
        Vertex Q = new Vertex("Merti Gate");
        Vertex R = new Vertex("Paota Circle");
        Vertex S = new Vertex("Baldevram Mirdha Circle");
        Vertex T = new Vertex("Khaas Bagh");
        Vertex U = new Vertex("Hotel Jasol Heritage");
        Vertex V = new Vertex("Jaswant Sarai");
        Vertex W = new Vertex("Jalori Gate");
        Vertex X = new Vertex("Olympic Chauraha");
        Vertex Y = new Vertex("UIT Circle");
        Vertex Z = new Vertex("CrossRoads");
        Vertex Z1 = new Vertex("Bhairu Ji Circle");
        Vertex Z2 = new Vertex("Point");

        // set the edges and weight
        A.adjacencies = new Edge[]{ new Edge(B, 50),new Edge(I,50) };
        B.adjacencies = new Edge[]{ new Edge(A, 50),new Edge(F,50),new Edge(D,60),new Edge(E,60) };
        C.adjacencies = new Edge[]{ new Edge(Y, 150),new Edge(J,70),new Edge(U,90) };
        D.adjacencies = new Edge[]{ new Edge(B, 60),new Edge(U,70),new Edge(E,60),new Edge(K,170) };
        E.adjacencies = new Edge[]{ new Edge(B, 60),new Edge(D,60) };
        F.adjacencies = new Edge[]{ new Edge(B, 50),new Edge(G,50) };
        G.adjacencies = new Edge[]{ new Edge(F, 50), new Edge(J,50) };
        H.adjacencies = new Edge[]{ new Edge(D, 40),new Edge(K,170) };
        I.adjacencies = new Edge[]{ new Edge(A, 50),new Edge(G,50),new Edge(Z,150) };
        J.adjacencies = new Edge[]{ new Edge(C, 70),new Edge(U,60) };
        K.adjacencies = new Edge[]{ new Edge(H, 40),new Edge(R,100),new Edge(T,140) };
        L.adjacencies = new Edge[]{ new Edge(M, 40),new Edge(N,110),new Edge(P,50),new Edge(T,150) };
        M.adjacencies = new Edge[]{ new Edge(L, 40),new Edge(V,60),new Edge(W,120) };
        N.adjacencies = new Edge[]{ new Edge(L, 110),new Edge(O,30),new Edge(Q,60) };
        O.adjacencies = new Edge[]{ new Edge(N, 30), };
        P.adjacencies = new Edge[]{ new Edge(L, 50),new Edge(R,100) };
        Q.adjacencies = new Edge[]{ new Edge(N, 60),new Edge(S,70) };
        R.adjacencies = new Edge[]{ new Edge(P, 100),new Edge(K,100),new Edge(S,50) };
        S.adjacencies = new Edge[]{ new Edge(Q, 70),new Edge(R,50) };
        T.adjacencies = new Edge[]{ new Edge(K, 140),new Edge(L,150),new Edge(U,120) };
        U.adjacencies = new Edge[]{ new Edge(C, 90),new Edge(D,70),new Edge(T,120),new Edge(J,60) };
        V.adjacencies = new Edge[]{ new Edge(M, 60),new Edge(X,60) };
        W.adjacencies = new Edge[]{ new Edge(M, 120),new Edge(X,80) };
        X.adjacencies = new Edge[]{ new Edge(V, 60),new Edge(W,80),new Edge(Z2,90) };
        Y.adjacencies = new Edge[]{ new Edge(Z, 60),new Edge(C,150),new Edge(Z2,60) };
        Z.adjacencies = new Edge[]{ new Edge(I, 150),new Edge(Y,60),new Edge(Z1,70) };
        Z1.adjacencies = new Edge[]{ new Edge(Z, 70),new Edge(Z2,70) };
        Z2.adjacencies = new Edge[]{ new Edge(X, 90),new Edge(Y,60),new Edge(Z1,70) };

        computePaths(A); // run Dijkstra
        System.out.println("Distance to " + Z + ": " + Z.minDistance);
        List<Vertex> path = getShortestPathTo(Z);
        System.out.println("Path: " + path);
    }
}
