package com.example.handlers.entreprise;

import org.jetbrains.annotations.NotNull;

/**
 * We can use this class for some special handling concern French
 * Administration.
 */
public class Administration {
    public Administration() {
        // No-args Constructor
    }

    /**
     * Method used to check if a SIREN or a SIRET is valid.
     *
     * @param siren the SIREN 9 digit or SIRET 14 digit to check
     * @return true if it's valid otherwise false
     */
    public Boolean isSirenOrSiretValid(@NotNull String siren) throws IllegalArgumentException {
        String[] charArray = new StringBuffer(siren)
                .reverse().toString().split("");

        int[] intArray = new int[charArray.length];
        int sum = 0;
        checkFormat(siren, charArray, intArray);

        return luhnAlgorithm(intArray, sum);
    }

    /**
     * This method check if string in argument contains no-Alpha digit. it
     * also checks that the length of the argument is 9 or 14.
     *
     * @param siren     SIREN or SIRET
     * @param charArray array containing all characters of the string
     * @param intArray  array needed to process String -> Int
     */
    private void checkFormat(@NotNull String siren, String[] charArray, int[] intArray) {
        try {
            Double.parseDouble(siren);
        } catch (IllegalArgumentException e) {
            notNumericStringError();
        }

        if (siren.length() == 9 || siren.length() == 14) {
            for (int i = 0; i < charArray.length; i++)
                intArray[i] = Integer.parseInt(charArray[i], 10);
        } else {
            notNumericStringError();
        }
    }

    /**
     * This method throws an Error when a param contains Alphabetic characters.
     */
    private void notNumericStringError() {
        throw new IllegalArgumentException(
                "must be 9 or 14 numeric digits",
                new Throwable("9 or 14 numeric digits"));
    }

    /**
     * this method use the luhnAlgorithm to process an Array of integers.
     * He's not limited to SIREN or SIRET.
     * @param intArray Array with all integers
     * @param sum the sum that will be handled
     * @return true if the array contains valid integers according the
     * criteria of the algorithm otherwise false.
     */
    private boolean luhnAlgorithm(int[] intArray, int sum) {
        for (int i = 0; i < intArray.length; i++) {
            if (i % 2 == 0) sum += intArray[i];
            else {
                if (intArray[i] * 2 > 9) sum += (intArray[i] * 2 - 9);
                else sum += (intArray[i] * 2);
            }
        }
        return sum % 10 == 0;
    }
}
