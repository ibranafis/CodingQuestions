/*      You are in an infinite 2D grid where you can move in any of the 8 directions

        (x,y) to
        (x+1, y),
        (x - 1, y),
        (x, y+1),
        (x, y-1),
        (x-1, y-1),
        (x+1,y+1),
        (x-1,y+1),
        (x+1,y-1)

        You are given a sequence of points and the order in which you need to cover the points.
        Give the minimum number of steps in which you can achieve it. You start from the first point.
*/
public class MinStepsInInfiniteGrid {
    public static void main(String args[])
    {
        int x[]={0,1,2};
        int y[]={0,1,1};
        System.out.println(findMinimumSteps(x,y));
    }

    private static int findMinimumSteps(int[] x, int[] y) {
        int count=0;
        for(int i=0; i<x.length-1; i++)
            count+=getShortestPath(x[i], y[i], x[i+1], y[i+1]);
        return count;
    }

    private static int getShortestPath(int x, int y, int x1, int y1) {
        int dx= Math.abs(x1-x);
        int dy= Math.abs(y1-y);
        return Math.max(dx,dy);
    }
}
