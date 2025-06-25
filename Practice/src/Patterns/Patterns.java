package Patterns;

import java.util.concurrent.ThreadLocalRandom;

public class Patterns {
    public static void main(String[] args) {
        /*
          1. * * *
             * * *
             * * *

          2. *
             * *
             * * *

          3. 1
             1 2
             1 2 3

          4. 1
             2 2
             3 3 3

          5. * * *
             * *
             *

          6. 1 2 3
             1 2
             1

          7.   *
              ***
             *****

          8. *****
              ***
               *

          9.   *
              ***
             *****
             *****
              ***
               *

          10. *
              **
              ***
              **
              *

          11. 1
              0 1
              1 0 1

          12. 1         1
              1 2     2 1
              1 2 3 3 2 1

          13. 1
              2 3
              4 5 6

          14. A
              A B
              A B C

          15. A B C
              A B
              A

          16. A
              B B
              C C C

          17.     A
                A B A
              A B C B A

          18. C
              B C
              A B C

          19. * * * * * *
              * *     * *
              *         *
              *         *
              * *     * *
              * * * * * *

          20. *         *
              * *     * *
              * * * * * *
              * *     * *
              *         *

          21. ****
              *  *
              *  *
              ****

          22. 4444444
              4333334
              4322234
              4321234
              4322234
              4333334
              4444444
        * */

        int pattern = ThreadLocalRandom.current().nextInt(1, 22);
        int n=4;
        switch(pattern){
            case 1:
                patter1(n);
                break;
            case 2:
                patter2(n);
                break;
            case 3:
                patter3(n);
                break;
            case 4:
                patter4(n);
                break;
            case 5:
                patter5(n);
                break;
            case 6:
                patter6(n);
                break;
            case 7:
                patter7(n);
                break;
            case 8:
                patter8(n);
                break;
            case 9:
                patter9(n);
                break;
            case 10:
                patter10(n);
                break;
            case 11:
                patter11(n);
                break;
            case 12:
                patter12(n);
                break;
            case 13:
                patter13(n);
                break;
            case 14:
                patter14(n);
                break;
            case 15:
                patter15(n);
                break;
            case 16:
                patter16(n);
                break;
            case 17:
                patter17(n);
                break;
            case 18:
                patter18(n);
                break;
            case 19:
                patter19(n);
                break;
            case 20:
                patter20(n);
                break;
            case 21:
                patter21(n);
                break;
            case 22:
                patter22(n);
                break;
            default:
                System.out.println("Give a valid pattern!");
        }
    }

    public static void patter1( int n){
        for (int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void patter2( int n){
        for (int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void patter3( int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void patter4( int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static void patter5( int n){
        for(int i=1;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void patter6( int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i+1;j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void patter7( int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patter8( int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i-1;j++){
                System.out.print(" ");
            }
            for(int j=1;j<2*(n-i+1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patter9( int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=1;i<=n;i++){
            for(int j=2;j<=i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*(n-i)+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patter10( int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void patter11( int n){
        int flag;
        for (int i=1;i<=n;i++){
            if(i%2==0){
                flag = 0;
            } else {
                flag = 1;
            }
            for(int j=1;j<=i;j++){
                if(flag ==1){
                    System.out.print("1 ");
                    flag = 0;
                } else{
                    System.out.print("0 ");
                    flag = 1;
                }
            }
            System.out.println();
        }
    }

    public static void patter12( int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j + " ");
            }
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void patter13( int n){
        int count =1;
        for(int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }

    public static void patter14( int n){
        for(int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                System.out.print((char)('A'+j-1)+ " ");
            }
            System.out.println();
        }
    }

    public static void patter15( int n){
        for(int i=1;i<=n;i++){
            for (int j=1;j<=n-i+1;j++){
                System.out.print((char)('A'+j-1)+ " ");
            }
            System.out.println();
        }
    }

    public static void patter16( int n){
        for(int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                System.out.print((char)('A'+i-1)+ " ");
            }
            System.out.println();
        }
    }

    public static void patter17( int n){
        for(int i=1;i<=n;i++){
            for (int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for (int j=1;j<=i;j++){
                System.out.print((char)('A'+j-1)+ " ");
            }
            for(int j=i;j>1;j--){
                System.out.print((char)('A'+j-2)+ " ");
            }
            System.out.println();
        }
    }

    public static void patter18( int n){
        for(int i=1;i<=n;i++){
            for(int j=n-i+1;j<=n;j++){
                System.out.print((char)('A'+j-1)+ " ");
            }
            System.out.println();
        }
    }

    public static void patter19( int n){
        for(int i=0;i<n;i++){
            for(int j=n;j>i;j--){
                System.out.print("* ");
            }
            for(int j=0;j<2*i;j++){
                System.out.print("  ");
            }
            for(int j=n;j>i;j--){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=n-1;i>=0;i--){
            for(int j=n;j>i;j--){
                System.out.print("* ");
            }
            for(int j=0;j<2*i;j++){
                System.out.print("  ");
            }
            for(int j=n;j>i;j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void patter20( int n){
        for (int i=0; i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            for(int j=0;j<2*(n-i-1); j++){
                System.out.print("  ");
            }
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i=n-2; i>=0;i--){
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            for(int j=0;j<2*(n-i-1); j++){
                System.out.print("  ");
            }
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void patter21( int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0 || i==n-1) {
                    System.out.print("*");
                }else{
                    if(j==0 || j==n-1){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void patter22( int n){
        int count = n;
        int count2 = 2;
        for(int i=0;i<n;i++){
            for(int j=n;j>0;j--){
                if(j>count){
                    System.out.print(j);
                }
                if(j<=count){
                    System.out.print(count);
                }
            }
            for(int j=2;j<=n;j++){
                if(j>count){
                    System.out.print(j);
                }
                if(j<=count){
                    System.out.print(count);
                }
            }
            count = count - 1;
            System.out.println();
        }
        for(int i=n-1;i>0;i--){
            for(int j=n;j>0;j--){
                if(j>count2){
                    System.out.print(j);
                }
                if(j<=count2){
                    System.out.print(count2);
                }
            }
            for(int j=2;j<=n;j++){
                if(j>count2){
                    System.out.print(j);
                }
                if(j<=count2){
                    System.out.print(count2);
                }
            }
            count2 = count2 + 1;
            System.out.println();
        }
    }

}
