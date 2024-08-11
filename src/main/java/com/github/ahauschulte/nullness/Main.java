package com.github.ahauschulte.nullness;

import org.jspecify.annotations.Nullable;

import java.time.LocalDate;
import java.util.Map;

/**
 * The Main class demonstrates the combined use of JSpecify annotations, specifically {@code @Nullable},
 * and NullAway to enforce null-safety in a simple Java application.
 */
public class Main {

    /**
     * A map containing the birthdays of certain individuals.
     */
    private static final Map<String, LocalDate> BIRTHDAYS = Map.of(
            "Joe", LocalDate.parse("1982-03-04"),
            "Jane", LocalDate.parse("1986-05-06")
    );

    /**
     * The birthday used for comparison purposes in the age calculation.
     */
    private static final LocalDate REFERENCE_BIRTHDAY = LocalDate.parse("1985-07-01");

    /**
     * Recognizes an individual by their name and provides a greeting.
     * If the name is found in the {@code BIRTHDAYS} map, it provides additional information about the person's age.
     *
     * @param name the name of the individual to be recognized; can be {@code null}.
     */
    private static void recognize(@Nullable final String name) {
        if (name == null) {
            System.out.println("Oh, come on. That's not your real name, is it?");
            return;
        }

        System.out.println("Hello, " + name + "!");

        final LocalDate birthday = BIRTHDAYS.get(name);

        if (birthday != null) {
            System.out.println("Oh, I think we've met before. Isn't your birthday " + birthday + "?");

            // This might raise a NullPointerException without the previous null check, highlighting the importance of
            // proper null handling with JSpecify.
            if (birthday.isAfter(REFERENCE_BIRTHDAY)) {
                System.out.println("So, you are actually younger than me.");
            }
        } else {
            System.out.println("Nice to meet you.");
        }
        
        System.out.println();
    }

    /**
     * The main method of the application. It calls the {@code recognize} method for several names,
     * including a {@code null} value to demonstrate null-safety handling.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        recognize("Joe");
        recognize("Jane");
        recognize("Paul");

        recognize(null);
    }

}