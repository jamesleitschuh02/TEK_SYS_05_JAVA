package DoorsAndLocks;

import java.util.Set;
import java.util.TreeSet;

public class Warehouse {
    private Set<Door> doors = new TreeSet<Door>();

    public Warehouse() {
        int i = 0;
        for (; i < 100; i++) {
            if (i < 10) {
                Door d = new Door(null);
                doors.add(d);
            }
            else {
                int num = (int)Math.random() * 4;
                Keyshape shape;

                switch(num) {
                    case 0:
                        shape = Keyshape.Square;
                        break;
                    case 1:
                        shape = Keyshape.Circular;
                        break;
                    case 2:
                        shape = Keyshape.Oval;
                        break;
                    case 3:
                        shape = Keyshape.TrapezoidDown;
                        break;
                    default:
                        shape = Keyshape.Square;
                        break;
                }

                Key k = new Key(shape);
                Door d = new Door(k);
                doors.add(d);
            }

        }
    }

}
