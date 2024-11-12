package java_pr;

import java.util.PriorityQueue;

public class optimalmergepattern {

    public static int optimalMerge(int[] files){
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for(int fileSize : files){
            minheap.add(fileSize);
        }
        // initial total cost =0
        int totalCost = 0;

        while(minheap.size()>1){
            int firstmin = minheap.poll();
            int secondmin = minheap.poll();

            int mergecost = firstmin+ secondmin;
            totalCost= totalCost+ mergecost;

            minheap.add(mergecost);

        }
        return totalCost;
    }
    public static void main(String[] args){
        int[] files = {4,3,2,6};
        // calc min merge cost
        int minCost = optimalMerge(files);
        System.out.println("Min cost is "+ minCost);
    }       
}
