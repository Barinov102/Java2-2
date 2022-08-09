package Lesson2_Java2;

public class Main {
    public class Converter {

        public static int strConverter(String[][] strArray)
                throws MyArraySizeException, MyArrayDataException {

            int sum = 0;

            if (4 != strArray.length) throw new MyArraySizeException();

            for (int i = 0; i < strArray.length; i++) {

                if (4 != strArray[i].length) throw new MyArraySizeException();

                for (int k = 0; k < strArray[i].length; k++) {

                    try {
                        sum += Integer.parseInt(strArray[i][k]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, k);
                    }
                }
            }

            return sum;
        }
    }


    public class CustomException extends Exception {

        public CustomException(String message) {
            super(message);
        }
    }


    public class Main {
        public static void main(String[] args) {
            String[][] correctMatrix = {
                    {"3", "2", "3", "3"},
                    {"3", "6", "1", "4"},
                    {"0", "2", "7", "2"},
                    {"0", "2", "7", "2"}
            };
            String[][] wrongSizeMatrix = {
                    {"3", "2", "3", "3"},
                    {"6", "1"},
                    {"0", "2", "7", "3"},
                    {"0", "2", "7", "3"}
            };
            String[][] wrongChar = {
                    {"3", "2", "3", "3"},
                    {"6", "1", "", "3"},
                    {"0", "2", "7", "3"},
                    {"0", "2", "7", "3"}
            };

            try {
                System.out.println(Converter.strConverter(correctMatrix));
            } catch (CustomException e) {
                e.getMessage();
            }


            try {
                System.out.println(Converter.strConverter(wrongSizeMatrix));
            } catch (CustomException e) {
                System.err.println(e.getMessage());
            }

            try {
                System.out.println(Converter.strConverter(wrongChar));
            } catch (CustomException e) {
                System.err.println(e.getMessage());
            }
        }
    }


    public class MyArrayDataException extends CustomException {

        public MyArrayDataException(int row, int col) {
            super(String.format("Parse to int exception in array[%d, %d]", row, col));
        }
    }


    public class MyArraySizeException extends CustomException {

        public MyArraySizeException() {
            super("The matrix must be of size 4x4");
        }
    }

}
