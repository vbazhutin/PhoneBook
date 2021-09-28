package phonebook;

public class Hash {
    private static class TableEntry<T> {
        private final int key;
        private final T value;
        private boolean removed;

        public TableEntry(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

    }

    static class HashTable<T> {
        private int size;
        private TableEntry[] table;

        public HashTable(int size) {
            this.size = size;
            table = new TableEntry[size];
        }

        public boolean put(int key, T value) {
            int hash = findKey(key);

            if (hash == -1) {
                rehash();
            }
            hash = findKey(key);
            table[hash] = new TableEntry(key, value);
            return true;
        }

        public T get(int key) {
            int index = findKey(key);

            if (index == -1 || table[index] == null) {
                return null;
            }
            return (T) table[index].getValue();
        }

        int findKey(int key) {
            int hash = key % size;

            while (!(table[hash] == null || table[hash].getKey() == key)) {
                hash = (hash + 1) % size;

                if (hash == key % size) {
                    return -1;
                }
            }
            return hash;
        }

        private void rehash() {
            this.size = size * 2;
            TableEntry[] oldTable = this.table;
            this.table = new TableEntry[size];
            for (TableEntry entry:
                    oldTable) {
                if (!(entry == null)) {
                    put(entry.getKey(), (T) entry.getValue());
                }
            }
        }
    }
}
