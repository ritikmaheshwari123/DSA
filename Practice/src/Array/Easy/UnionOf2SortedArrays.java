package Array.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class UnionOf2SortedArrays {
    public static void main(String[] args) {
        int n = 10, m = 7;
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {2, 3, 4, 4, 5, 11, 12};
        ArrayList<Integer> Union = FindUnion(arr1, arr2, n, m);
        System.out.println("Union of arr1 and arr2 is ");
        for (int val: Union)
            System.out.print(val+" ");
    }

    private static ArrayList<Integer> FindUnion(int[] arr1, int[] arr2, int n, int m) {
        int i = 0, j = 0; // pointers
        ArrayList<Integer > Union=new ArrayList<>(); // Union
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) // Case 1 and 2
            {
                if (Union.isEmpty() || Union.getLast() != arr1[i])
                    Union.add(arr1[i]);
                i++;
            } else // case 3
            {
                if (Union.isEmpty() || Union.getLast() != arr2[j])
                    Union.add(arr2[j]);
                j++;
            }
        }
        while (i < n) // IF any element left in arr1
        {
            if (Union.getLast() != arr1[i])
                Union.add(arr1[i]);
            i++;
        }
        while (j < m) // If any elements left in arr2
        {
            if (Union.getLast() != arr2[j])
                Union.add(arr2[j]);
            j++;
        }
        return Union;
    }

    static ArrayList<Integer> FindUnionUsingSet(int[] arr1, int[] arr2, int n, int m) {
        HashSet<Integer> s=new HashSet<>();
        for (int i = 0; i < n; i++)
            s.add(arr1[i]);
        for (int i = 0; i < m; i++)
            s.add(arr2[i]);
        return new ArrayList<>(s);
    }

    static ArrayList<Integer> FindUnionUsingMap(int[] arr1, int[] arr2, int n, int m) {
        HashMap<Integer,Integer > freq=new HashMap<>();
        for (int i = 0; i < n; i++)
            freq.put(arr1[i],freq.getOrDefault(arr1[i],0)+1);

        for (int i = 0; i < m; i++)
            freq.put(arr2[i],freq.getOrDefault(arr2[i],0)+1);
        return new ArrayList<>(freq.keySet());
    }
}
