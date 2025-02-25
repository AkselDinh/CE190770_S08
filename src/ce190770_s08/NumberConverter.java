/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce190770_s08;

/**
 * S08 - Program to convert number of base-8 and base-16 to base-2 This class
 * contains utilities for converting number of base 8 and 16 to binary
 *
 * @author Dinh Cong Phuc - CE190770 - Feb 24, 2025
 */
public class NumberConverter {

    // Array of 4-bit binary representations for hex digits 0-F
    // Index corresponds to decimal value (e.g., index 10 = 'A' = "1010")
    private final String[] binaryList = {
        "0000", "0001", "0010", "0011", // 0-3
        "0100", "0101", "0110", "0111", // 4-7
        "1000", "1001", "1010", "1011", // 8-B
        "1100", "1101", "1110", "1111" // C-F
    };

    /**
     * Converts input string from specified base to binary representation
     * Supports base 8 (octal) and 16 (hexadecimal) For octal, each digit is
     * converted to 3 bits For hexadecimal, each digit is converted to 4 bits
     *
     * @param input The string to convert (octal or hexadecimal number)
     * @param base The base of the input number (8 for octal, 16 for
     * hexadecimal)
     * @return Space-separated binary representation of the input number
     */
    public String convert(String input, int base) {
        // Convert input to uppercase for consistent hex letter handling
        input = input.toUpperCase();
        String res = "";

        switch (base) {
            case 8:
                // Convert each octal digit to 3-bit binary
                for (int i = 0; i < input.length(); i++) {
                    // Convert character to integer value
                    int inputInt = Integer.parseInt(input.charAt(i) + "");
                    // Skip first bit since octal only needs 3 bits (0-7 = 000-111)
                    res += binaryList[inputInt].substring(1) + " ";
                }
                break;

            case 16:
                // Convert each hex digit to 4-bit binary
                for (int i = 0; i < input.length(); i++) {
                    String s = input.charAt(i) + "";
                    if (s.matches("[0-9]")) {
                        // Handle numeric digits 0-9
                        int inputInt = Integer.parseInt(s);
                        res += binaryList[inputInt] + " ";
                    } else if (s.matches("[A-F]")) {
                        // Handle hex letters A-F
                        // Convert A-F to values 10-15 by subtracting ASCII offset
                        char c = s.charAt(0);
                        res += binaryList[(int) c - 55] + " ";
                    }
                }
                break;
        }
        // Return result after conversion
        return res;
    }
}
