/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce190770_s08;

/**
 * S08 - Program to convert number of base-8 and base-16 to base-2 This class
 * contains the main operating codes and UI
 *
 * @author Dinh Cong Phuc - CE190770 - Feb 24, 2025
 */
public class UI {

    // Number converter instance for performing conversions
    NumberConverter nc = new NumberConverter();

    /**
     * Main program loop Displays welcome message and handles continuous
     * conversion operations Continues until program is terminated
     */
    public void loop() {
        // Start infinite loop for continuous conversions
        do {
            // Display welcome message
            welcome();
            // Perform conversion operation
            convert();
            // Display continue message
            System.out.println("Press any key to continue converting.");
            // Wait for user input before continuing
            InputValidation.sc.nextLine();
            // Continue loop indefinitely    
        } while (true);
    }

    /**
     * Displays welcome message to the user Introduces the program's
     * functionality
     */
    public void welcome() {
        // Print welcome message to console
        System.out.println("Convert Hexadecimal number / Octal number to Binary program");
    }

    /**
     * Handles the conversion process Gets input from user, validates it, and
     * displays the result Continues prompting until valid input is received
     */
    public void convert() {
        // Label for breaking out of nested loops
        OUTER:
        // Start loop for input validation
        while (true) {
            // Display prompt for user input
            System.out.print("Enter a Hexadecimal (h) / Octal (q) number: ");
            // Get user input
            String input = input();
            // Extract the number part (everything except last character)
            String number = input.substring(0, input.length() - 1);
            // Extract the base indicator (last character)
            char base = input.charAt(input.length() - 1);

            // Check which base was specified
            switch (base) {
                case 'h': // Hexadecimal case
                    // Validate if input is valid hexadecimal
                    if (!InputValidation.chkValidOctHex(number, 16)) {
                        // Display error message for invalid hex input
                        System.out.println("Input is not a valid Hexadecimal, please only enter [0-9a-f]");
                        // Continue the loop for new input
                        break;
                    } else {
                        // Convert and display valid hex input
                        printRes(nc.convert(number, 16));
                    }
                    // Exit the OUTER loop
                    break OUTER;

                case 'q': // Octal case
                    // Validate if input is valid octal
                    if (!InputValidation.chkValidOctHex(number, 8)) {
                        // Display error message for invalid octal input
                        System.out.println("Input is not a valid Octal, please only enter [0-7]");
                        // Continue the loop for new input
                        break;
                    } else {
                        // Convert and display valid octal input
                        printRes(nc.convert(number, 8));
                    }
                    // Exit the OUTER loop
                    break OUTER;

                default: // Invalid base indicator case
                    // Display error message for invalid base indicator
                    System.out.println("Please end input with 'h' for Hexadecimal, 'q' for Octal, try again");
                    // Continue the loop for new input
                    break;
            }
        }
    }

    /**
     * Gets user input as non-empty string
     *
     * @return The validated non-empty string input
     */
    public String input() {
        // Get non-empty string input using InputValidation utility
        String input = InputValidation.getSingleStringNonEmpty();
        // Return the validated input
        return input;
    }

    /**
     * Prints the conversion result
     *
     * @param res The binary number result to display
     */
    public void printRes(String res) {
        // Print the binary result with formatting
        System.out.printf("Binary number: %s\n", res);
    }
}
