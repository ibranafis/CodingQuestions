import java.util.LinkedList;
import java.util.Queue;

public class CourseswithPrerequisites {
    public static void main(String args[])
    {
        int n=2;
        int arr[][]={{1,0}};
        System.out.println(findPrerequisites(n,arr));
        int ans[]=findOrder(n, arr);
        for(int a: ans)
            System.out.print(a+" ");
    }

    private static boolean findPrerequisites(int numCourses, int[][] prereq) {
        int n=prereq.length;
        if(numCourses==0 || n==0)
            return false;
        int indegree[]=new int[numCourses];
        for(int pre[]: prereq)
            indegree[pre[0]]++;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<numCourses; i++)
            if(indegree[i]==0)
                q.add(i);
        int count=q.size();
        while(!q.isEmpty())
        {
            int p=q.poll();
            for(int pre[]: prereq)
            {
                if(pre[1]==p)
                {
                    indegree[pre[0]]--;
                    if(indegree[pre[0]]==0)
                    {
                        q.add(pre[0]);
                        count++;
                    }
                }
            }
        }
        return count==numCourses;
    }


    static int[] findOrder(int numCourses, int prereq[][])
    {
        if(numCourses==0)
            return null;
        int indegree[]=new int[numCourses];
        int order[]=new int[numCourses];
        int index=0;
        for(int pre[]: prereq)
            indegree[pre[0]]++;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(indegree[i]==0)
            {
                order[index++]=i;
                q.add(i);
            }
        }
         while(!q.isEmpty())
         {
             int p=q.poll();
             for(int pre[]: prereq)
             {
                 if(pre[1]==p)
                 {
                     indegree[pre[0]]--;
                     if(indegree[pre[0]]==0)
                     {
                         q.add(pre[0]);
                         order[index++]=pre[0];
                     }
                 }
             }
         }
         return index==numCourses?order:new int[0];
    }
}










