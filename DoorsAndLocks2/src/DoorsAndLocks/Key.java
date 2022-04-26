package DoorsAndLocks;

import java.util.UUID;

public class Key implements Cloneable, Comparable<Key> {
    //default constructor
    public UUID key = UUID.randomUUID();
    private Keyshape shape = Keyshape.Unknown;

    public Key() {
        key = UUID.randomUUID();
    }

    public Key(Keyshape shape) {
        this();
        this.shape = shape;
    }

    // copy constructor
    public Key(Key original) {
        key = original.key;
    }

    public Keyshape shape() {
        return shape;
    }

    public Object clone() {
        return new Key(this);
    }

    @Override
    public String toString() {
        // return "Key [key= " + key +
        return key.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (!getClass().isInstance(obj)) return false;
        Key other = (Key)obj;
        return key.equals(other.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public int compareTo(Key o) {
        return key.compareTo(o.key);
    }

}
