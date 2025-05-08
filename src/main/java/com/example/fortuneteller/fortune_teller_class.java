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

    public String getRandomFortune() {
        return !fortunes.isEmpty() ?
                fortunes.get(rand.nextInt(fortunes.size())) :
                "No fortunes available.";
    }// tell if there is no more fortunes to give

    public void addFortune(String fortune) {
        if (isValidFortune(fortune)) {
            fortunes.add(fortune.trim());
        }
    }

    private boolean isValidFortune(String fortune) {
        return fortune != null &&
                !fortune.trim().isEmpty() &&
                !fortunes.contains(fortune.trim());
    }

    public void removeFortune(int index) {
        if (index >= 0 && index < fortunes.size()) {
            fortunes.remove(index);
        }
    }

    public ArrayList<String> getAllFortunes() {
        return new ArrayList<>(fortunes);
    }

    public boolean isEmpty() {
        return fortunes.isEmpty();
    }
}