public class IsGraphBipartite {
    //2 colour graph: dfs
    public static void main(String args[])
    {
        int arr[][]={{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite(arr));
    }

    private static boolean isBipartite(int[][] graph) {
        int colours[]=new int[graph.length];
        for(int i=0; i<colours.length; i++)
            if(!validColor(graph, colours, 1, i) && colours[i]==0)
                return false;
        return true;
    }

    private static boolean validColor(int[][] graph, int[] colours, int colour, int i) {
        if(colours[i]!=0)
            return colours[i]==colour;
        colours[i]=colour;
        for(int adj: graph[i])
            if(!validColor(graph, colours, -colour, adj))
                return false;
        return true;
    }
}