package InfosysAssessment;

public class FirstNonRepetetiveCharacterInString {
    public static void main(String[] args) {
        String str = "RRittik";

        char [] charsArr = str.toCharArray();
        int count = 0;
        for(int i=0;i<charsArr.length;i++){
            for(int j=0;j< charsArr.length;j++){
                if(charsArr[i]==charsArr[j]){
                    count++;
                }
            }
            if (count == 1){
                System.out.println(charsArr[i]);
                break;
            }
            count = 0;
        }
    }
}
