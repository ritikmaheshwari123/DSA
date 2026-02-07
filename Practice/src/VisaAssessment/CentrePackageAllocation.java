package VisaAssessment;

/*
You are given an array of integers centreCapacities,
where centerCapacities[i] is a value between 1 and 5
representing max number of packages that ith distribution centre can process before requiring maintenance.

You are also given an array of strings dailyLog, where dailyLog[i] can be
PACKAGE - a new package arrives for processing
CLOSURE <j> - the jth distribution centre temporarily closes for renovations

Packages are sent to centres in sequential order -
each centre processes as many packages as it can be based on its capacity defined
before are sent to next available centres.

After complete rotation through all centres, the capacity of all operational centres is restored to full,
but closed centres remain unavailable.
The distribution system bypass any closed centres when allocating packages.
You can assume at leat one centre remains operational throughout the process.
Return the index of distribution centre that processed most packages.
If tie than return centre with the highest index.
 */

public class CentrePackageAllocation {

    public int solution(int[] centreCapacities, String[] dailyLog) {

        int n = centreCapacities.length;

        int[] remaining = new int[n];     // remaining capacity in current rotation
        int[] processed = new int[n];     // total packages processed
        boolean[] closed = new boolean[n];

        // initialize remaining capacities
        System.arraycopy(centreCapacities, 0, remaining, 0, n);

        int currentCentre = 0;

        for (String log : dailyLog) {

            if (log.equals("PACKAGE")) {

                // If no centre has remaining capacity, reset rotation
                if (!hasAvailableCapacity(remaining, closed)) {
                    for (int i = 0; i < n; i++) {
                        if (!closed[i]) {
                            remaining[i] = centreCapacities[i];
                        }
                    }
                }

                // Find next valid centre
                while (closed[currentCentre] || remaining[currentCentre] == 0) {
                    currentCentre = (currentCentre + 1) % n;
                }

                // Process package
                remaining[currentCentre]--;
                processed[currentCentre]++;

                // Move to next centre ONLY when current is exhausted
                if (remaining[currentCentre] == 0) {
                    currentCentre = (currentCentre + 1) % n;
                }

            } else if (log.startsWith("CLOSURE")) {

                int idx = Integer.parseInt(log.split(" ")[1]);
                closed[idx] = true;
                remaining[idx] = 0;
            }
        }

        // Find centre with max processed packages
        // If tie → return highest index
        int max = -1;
        int result = -1;

        for (int i = 0; i < n; i++) {
            if (processed[i] > max ||
                    (processed[i] == max && i > result)) {
                max = processed[i];
                result = i;
            }
        }

        return result;
    }

    private boolean hasAvailableCapacity(int[] remaining, boolean[] closed) {
        for (int i = 0; i < remaining.length; i++) {
            if (!closed[i] && remaining[i] > 0) {
                return true;
            }
        }
        return false;
    }

    // ===================== MAIN METHOD =====================
    public static void main(String[] args) {

        CentrePackageAllocation sol = new CentrePackageAllocation();

        // Test case 1 (from failing example)
        int[] centreCapacities1 = {2, 3};
        String[] dailyLog1 = {"PACKAGE", "PACKAGE", "PACKAGE"};

        System.out.println("Result 1: " +
                sol.solution(centreCapacities1, dailyLog1));
        // Expected: 0

        // Test case 2 (rotation reset)
        int[] centreCapacities2 = {1, 1};
        String[] dailyLog2 = {
                "PACKAGE", "PACKAGE", "PACKAGE", "PACKAGE"
        };

        System.out.println("Result 2: " +
                sol.solution(centreCapacities2, dailyLog2));
        // Expected: 1 (tie → highest index)

        // Test case 3 (closure case)
        int[] centreCapacities3 = {2, 2, 2};
        String[] dailyLog3 = {
                "PACKAGE", "PACKAGE",
                "CLOSURE 1",
                "PACKAGE", "PACKAGE", "PACKAGE"
        };

        System.out.println("Result 3: " +
                sol.solution(centreCapacities3, dailyLog3));
        // Expected: 2
    }
}
