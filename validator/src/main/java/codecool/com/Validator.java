package codecool.com;

public class Validator {

    private int getLetterValue(String letter) throws IllegalStateException {
        int value = switch (letter) {
            case "A" -> 10;
            case "B" -> 11;
            case "C" -> 12;
            case "D" -> 13;
            case "E" -> 14;
            case "F" -> 15;
            case "G" -> 16;
            case "H" -> 17;
            case "I" -> 18;
            case "J" -> 19;
            case "K" -> 20;
            case "L" -> 21;
            case "M" -> 22;
            case "N" -> 23;
            case "O" -> 24;
            case "P" -> 25;
            case "Q" -> 26;
            case "R" -> 27;
            case "S" -> 28;
            case "T" -> 29;
            case "U" -> 30;
            case "V" -> 31;
            case "W" -> 32;
            case "X" -> 33;
            case "Y" -> 34;
            case "Z" -> 35;
            default -> throw new IllegalStateException("Unexpected value: " + letter);
        };
        return value;
    }


    public boolean isCorrect(String id) {

        System.out.println("Correct length : " + checkLength(id));

        System.out.println("Correct first tree letters : " + checkFirstThreeChars(id));

        System.out.println("Correct 6 last chars are a numbers : " + checkLastSixChars(id));

        System.out.println("Correct ID number : " + checkControlNumber(id));
        return checkLength(id) && checkFirstThreeChars(id) && checkLastSixChars(id) && checkControlNumber(id);
    }

    public boolean checkLength(String id) {
        return id.length() == 9;
    }

    public boolean checkFirstThreeChars(String id) {
        for(int i =0; i< 3; i++) {
            if(getLetterValue(id.substring(i, i+1)) < 10) {
                return false;
            }
        }
        return true;
    }

    public boolean checkLastSixChars(String id) {

        for(int i =3; i< 9; i++) {
            Integer n = Integer.parseInt(id.substring(i, i+1));
            if(!(n instanceof Number)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkControlNumber(String id) {
        int sum;
//        System.out.println(getLetterValue(id.substring(0, 1)));
//        System.out.println(getLetterValue(id.substring(1, 2)));
//        System.out.println(getLetterValue(id.substring(2, 3)));
//        System.out.println(Integer.parseInt(id.substring(3, 4)));
//        System.out.println(Integer.parseInt(id.substring(4, 5)));
//        System.out.println(Integer.parseInt(id.substring(5, 6)));
//        System.out.println(Integer.parseInt(id.substring(6, 7)));
//        System.out.println(Integer.parseInt(id.substring(8, 9)));

        sum = 7 * getLetterValue(id.substring(0, 1));
        sum += 3 * getLetterValue(id.substring(1, 2));
        sum += 1 * getLetterValue(id.substring(2, 3));
        sum += 9 * Integer.parseInt(id.substring(3, 4));
        sum += 7 * Integer.parseInt(id.substring(4, 5));
        sum += 3 * Integer.parseInt(id.substring(5, 6));
        sum += 1 * Integer.parseInt(id.substring(6, 7));
        sum += 7 * Integer.parseInt(id.substring(7, 8));
        sum += 3 * Integer.parseInt(id.substring(8, 9));
        sum %= 10;

        return sum == 0;
    }
}
