/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Jadiha
 * @author Agincourt Collegiate Institute
 * @version 1.1.1 Dec 15 2021
 */
public abstract class Headphones implements Comparable<Headphones> {

    /*My Instance Variables*/
    private String name;
    private double overall_sound_quality;
    private int intensity_level;
    private int noise_cancellation;
    private int input_power;
    private int output_power;

    /**
     * Creates New Headphone
     *
     * @param name Name of the Headphone
     * @param overall_sound_quality Overall Sound of Headphones (measured in Decibels)
     * @param intensity_level Loudness of Headphones (measured in Decibels)
     * @param noise_cancellation Value in Reduction of Surrounding Noises
     * (measured in Decibels)
     * @param input_power P2 value of Decibel equation (measured in Watts)
     * @param output_power P1 value of Decibel equation (measured in Watts)
     *
     */
    public Headphones(String name, int intensity_level, int noise_cancellation, int input_power, int output_power, double overall_sound_quality) {
        this.name = name;
        this.intensity_level = intensity_level;
        this.noise_cancellation = noise_cancellation;
        this.input_power = input_power;
        this.output_power = output_power;
        this.overall_sound_quality = overall_sound_quality;

    }

    /**
     * Getter Method for Headphone Name
     *
     * @return Headphone Name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter Method for Intensity Level
     *
     * @return Loudness of Headphone (measured in Decibels)
     */
    public int getIntensityLevel() {
        return this.intensity_level;
    }

    /**
     * Getter Method for Noise Cancellation Value
     *
     * @return Value in Reduction of Surrounding Noises (measured in Decibels)
     */
    public int getNoiseCancellation() {
        return this.noise_cancellation;
    }

    /**
     * Getter Method for P2 Value of Decibel Equation
     *
     * @return P2 value of Decibel equation (measured in Watts)
     */
    public int getInputPower() {
        return this.input_power;
    }

    /**
     * Getter Method for P1 Value of Decibel Equation
     *
     * @return P1 value of Decibel equation (measured in Watts)
     */
    public int getOutputPower() {
        return this.output_power;
    }

    /**
     * Method to Calculate Overall Sound Quality
     *
     * @return Overall Sound Quality, Calculated Using InstanceVariables (measured in Decibels)
     */
    public double overall_sound_quality_calculation() {
        overall_sound_quality = ((intensity_level - noise_cancellation) + 10 * (output_power / input_power));
        return this.overall_sound_quality;
    }

    /**
     * Comparable For Overall Sound Quality of Headphones
     *
     * @param headphones Headphones Being Compared
     * @return 0, 1 or -1 Depending On If A Headphone Has An Overall Sound
     * Quality Higher, Lower or Equal to Another Headphone
     */
    public int compareTo(Headphones headphones) {
        if (this.overall_sound_quality == headphones.overall_sound_quality_calculation()) {
            return 0;
        } else if (this.overall_sound_quality > headphones.overall_sound_quality_calculation()) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Main Method
     *
     * @param args ArrayList for Headphones, Sorted In Ascending Order of Overall Sound Quality
     */
    public static void main(String[] args) {
        ArrayList<Headphones> list = new ArrayList<Headphones>();
        list.add(new Headphones("Beats", 23, 15, 13, 5, 0) {
        });
        list.add(new Headphones("Bose", 67, 34, 10, 7, 0) {
        });
        list.add(new Headphones("JBL", 73, 23, 12, 6, 0) {
        });
        list.add(new Headphones("Sony", 53, 12, 13, 5, 0) {
        });
        list.add(new Headphones("SennHeiser", 55, 36, 12, 4, 0) {
        });
        list.add(new Headphones("SkullCandy", 78, 11, 17, 3, 0) {
        });

        Collections.sort(list);

        System.out.println("Headphones After Sorting : ");
        list.forEach((headphones) -> {
            System.out.println(headphones.getName() + ": "
                    + headphones.overall_sound_quality_calculation());
        });
    }
}
