package WalmartAssessment;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/*
You have n processes with priorities priority[i].

Find the maximum priority p that appears at least twice.
If no such priority or p = 0, stop.
Choose the two processes with smallest indexes having priority p.
Remove the first process.
Update the second process priority → floor(p / 2).
Repeat.

n = 4

priority = [4,4,2,1]
after first iteration
[2,2,1]
after second iteration
[1,1]
after third iteration
[0]


priority = [7,7,5,5,3]
after first iteration
[3,5,5,3]
after second iteration
[3,2,3]
after third iteration
[2,1]


 */
public class Test {
    public static void main(String[] args) {
        int [] priority = {4,4,2,1};

        int n= priority.length;

        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            map.computeIfAbsent(priority[i], k -> new TreeSet<>()).add(i);
        }

        while(true){
            Integer p = null;

            for(Map.Entry<Integer,TreeSet<Integer>> entry : map.entrySet()){
                if(entry.getValue().size()>=2){
                    p= entry.getKey();
                    break;
                }
            }

            if(p==null||p==0){
                break;
            }

            TreeSet<Integer> indices = map.get(p);

            int first = indices.pollFirst();
            int second = indices.pollFirst();

            int newPriority =p/2;

            priority[second] = newPriority;


            map.computeIfAbsent(newPriority, k -> new TreeSet<>()).add(second);

            if(indices.isEmpty()){
                map.remove(p);
            } else{
                map.put(p,indices);
            }
        }

        System.out.println("Final priorities:");
        for(Map.Entry<Integer, TreeSet<Integer>> entry : map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Map.Entry<Integer, TreeSet<Integer>> entry = map.firstEntry();
        System.out.println("Maximum priority left: "+ entry.getKey());
    }
}
