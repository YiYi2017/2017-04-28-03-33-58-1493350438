public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        int score = 0;
        int count = 1;
        score += getUnitScore(bowlingCode);
        for (int i = 0; i < bowlingCode.length(); i++) {
            if (count == 10)
                break;
            if (bowlingCode.charAt(i) == '|') {
                score += getUnitScore(bowlingCode.substring(i + 1));
                count++;
            }
        }
        return score;
    }

    private int getUnitScore(String subString) {
        //求这个子符串的第一个单元格的分数。
        int result = 0;
        for (int i = 0; subString.charAt(i) != '|'; i++) {
            switch (subString.charAt(i)) {
                case 'X': {
                    String string = subString.substring(i);
                    int secondNum = getSecondNum(string);
                    int thirdNum = getThirdNum(string);
                    if(secondNum != 10 && thirdNum == 10){
                        return 20;
                    }
                    return 10 + secondNum + thirdNum;
                }
                case '/': {
                    String string = subString.substring(i);
                    return 10 + getSecondNum(string);
                }
                case '-': {
                    break;
                }
                case '|': {
                    break;
                }
                default: {
                    result += Character.getNumericValue(subString.charAt(i));
                }
            }
        }
        return result;
    }

    private int getSecondNum(String subString) {
        for (int i = 1; i < subString.length(); i++) {
            switch (subString.charAt(i)) {
                case 'X': {
                    return 10;
                }
                case '-': {
                    return 0;
                }
                case '|': {
                    break;
                }
                case '/': {
                    return 10;
                }
                default: {
                    return Character.getNumericValue(subString.charAt(i));
                }
            }
        }
        return 0;
    }

    private int getThirdNum(String subString) {
        String string = null;
        for (int i = 1; i < subString.length(); i++) {
            if (subString.charAt(i) != '|') {
                string = subString.substring(i);
                break;
            }
        }
        return getSecondNum(string);
    }
}
