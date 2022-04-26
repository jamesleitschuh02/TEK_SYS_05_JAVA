package main.java.doorsAndLocks;

public class Keychain {
    private Set<Key> keys = new TreeSet<Key>();

    private Keychain() {}

    public Keychain(collection<Key> keys) {
        for (Key k: keys) {
            addKey(k);
        }
    }

    public boolean addKey(Key key) {
        if (!keys.containsKey(key.shape())) keys.put(key.shape(),
        new ArrayList<Key>());
        keys.get(key.shape()).add(key);
        return true;
    }

    public boolean removeKey(Key key) {
        if (keys.containsKey(key.shape())) return keys.get(key.shape()).remove(key);
        return false;
    }

    public int keyCount() {
        int keyCount = 0;
        for (Keyshape keyshape: keys.keySet()) {
            keyCount += keys.get(keyshape).size();
        }
        return keyCount;
    }

    public boolean lock(Door door) {
        if (door.isLocked()) return true;
        if (!door.hasKey()) return false;
        if (!keys.containsKey(door.key().shape())) return false;
        for (Key K : keys.get(door.key().shape())) {
            if (door.unlock(K)) return true;
        }
        return false;
    }

    public boolean unlock(Door door) {
        if (!door.isLocked()) return true;
        if (!door.hasKey()) return true;
        if (!keys.containsKey(door.key().shape())) return false;
        for (Key K : keys.get(door.key().shape())) {
            if (door.unlock(K)) return true;
        }
        return false;
    }


}
