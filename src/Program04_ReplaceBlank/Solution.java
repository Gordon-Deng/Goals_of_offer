package Program04_ReplaceBlank;

public class Solution {
    public String replaceSpace(StringBuffer str) {
        if (str == null){
            return null;
        }

        int numberOfBlank = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                numberOfBlank++;
            }
        }

        int originIndex = str.length()-1;
        int newIndex = originIndex + numberOfBlank*2;

        //防止下标越界
        str.setLength(newIndex+1);

        while (originIndex >= 0 && originIndex <= newIndex){
            if (str.charAt(originIndex) == ' '){
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            }

            else {
                str.setCharAt(newIndex--, str.charAt(originIndex));
            }

            originIndex--;

        }

        return str.toString();

    }
}
