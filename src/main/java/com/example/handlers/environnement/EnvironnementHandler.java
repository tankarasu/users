package com.example.handlers.environnement;

import java.util.Locale;

public class EnvironnementHandler {
    // No-args constructor
    public EnvironnementHandler() {
    }

    public String setEnv(String name) {
        for (AvailableEnv Env : AvailableEnv.values()) {
            if (Env.name().equals(name.toUpperCase()))
                return "Successfully updated Env " +
                        "to " + name.toUpperCase();
        }
        return "Unknown environnement name";
    }
}
