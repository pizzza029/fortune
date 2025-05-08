//this is the fortune teller class this is what I actually called back to win the controller to implement what I want to do
package com.example.fortuneteller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class fortune_teller_class {
    private ArrayList<String> fortunes = new ArrayList<>();
    private final Random rand = new Random();

    public fortune_teller_class() {
        // Initialize default fortunes
        addDefaultFortunes();
    }
//adds all the default fortunes to the list
    private void addDefaultFortunes() {
        String[] defaultFortunes = {
                "A thrilling time is in your near future.",
                "You will soon embark on a journey of great importance.",
                "A fresh start will put you on your way.",
                "Someone close to you has a secret to share.",
                "You will find unexpected wealth—of knowledge or coins.",
                "Patience is your ally; everything will come in time.",
                "A new opportunity will present itself. Say yes.",
                "You are admired more than you know.",
                "Your ability to see the big picture will lead to success.",
                "Today's struggles will shape tomorrow's strength."
        };

        fortunes.addAll(Arrays.asList(defaultFortunes));
    }
//this is the method that generates the random fortune that I call in the controller and return a string takes in nothing
    public String getRandomFortune() {
        return !fortunes.isEmpty() ?
                fortunes.get(rand.nextInt(fortunes.size())) :
                "No fortunes available.";
    }// tell if there is no more fortunes to give
//this is the method that I call in the controller to add a new Fortune by user input this is void and takes in a string
    public void addFortune(String fortune) {
        if (isValidFortune(fortune)) {
            fortunes.add(fortune.trim());
        }
    }
//this method is to check if a inputted by the user is valid returns a boolean takes in a string
    private boolean isValidFortune(String fortune) {
        return fortune != null &&
                !fortune.trim().isEmpty() &&
                !fortunes.contains(fortune.trim());
    }
//this is the method that is used in the controller to remove a fortune this is void takes in a int
    public void removeFortune(int index) {
        if (index >= 0 && index < fortunes.size()) {
            fortunes.remove(index);
        }
    }
//this just gets all the fortunes that are in the list this returns an arraylist
    public ArrayList<String> getAllFortunes() {
        return new ArrayList<>(fortunes);
    }
//method is checking if the list of Fortunes are empty this returns a boolean
    public boolean isEmpty() {
        return fortunes.isEmpty();
    }
}