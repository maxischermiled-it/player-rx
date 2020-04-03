package me.antoniocaccamo.player.rx.model;


import java.time.LocalTime;

/**
 * @author antoniocaccamo on 07/02/2020
 */
public abstract class Model {



    public enum Location {
        LOCAL,
        REMOTE
    }

    public enum Type {
        VIDEO,
        PHOTO
    }
}
