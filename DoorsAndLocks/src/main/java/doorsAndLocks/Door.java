package main.java.doorsAndLocks;

public class Door {
    private Key key;
    private boolean isLocked;
    public door(Key key) {
        this.key = key;
        isLocked = key != null;
    }

    public Key key() {
        return key;
    }

    public boolean hasKey() {
        return key != null;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public boolean lock(Key key) {
        if (this.key == null || this.key.equals(key)) {
            isLocked = true;
        }
        return isLocked;
    }

    public boolean unlock(Key key) {
        if (this.key == null || this.key.equals(key)) {
            isLocked = false;
        }
        return !isLocked;
    }
}