package MyHashMap;

/**
 * Моя кастомная мапа
 * @param <K>
 * @param <V>
 */
public class HashMapImpl<K, V>  {
    private float loadfactor = 0.75f;
    private int capacity = 100;
    private int size = 0;
    private Entry<K, V> table[] = new Entry[capacity];


    /**
     * Метод котоpый по хешкоду ключа находит место в массиве
     * @param hashCode
     * @return int
     */
    private int Hashing(int hashCode) {
        int location = hashCode % capacity;
        System.out.println("Location:" + location);
        return location;
    }

    /**
     * Вернет количество занятых якеек массива
     * @return int
     */
    public int size() {
        return this.size;
    }

    /**
     * Провеяет пустая ли мапа
     * @return boolean
     */
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Проверяет наличие Конкретного ключа
     * @param key
     * @return boolean
     */
    public boolean containsKey(Object key) {
        if (key == null) {
            if (table[0].getKey() == null) {
                return true;
            }
        }
        int location = Hashing(key.hashCode());
        Entry e = null;
        try {
            e = table[location];
        } catch (NullPointerException ex) {

        }
        if (e != null && e.getKey() == key) {
            return true;
        }
        return false;
    }

    /**
     * Проверяет мапу на наличие конкретного значения
     * @param value
     * @return boolean
     */
    public boolean containsValue(Object value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i].getVal() == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * геттер для значений которые хранятся в мапе
     * @param key
     * @return V
     */
    public V get(K key) {
        V ret = null;
        if (key == null) {
            Entry<K, V> e = null;
            try {
                e = table[0];
            } catch (NullPointerException ex) {

            }
            if (e != null) {
                return (V) e.getVal();
            }
        } else {
            int location = Hashing(key.hashCode());
            Entry<K, V> e = null;
            try {
                e = table[location];
            } catch (NullPointerException ex) {

            }
            if (e != null && e.getKey() == key) {
                return (V) e.getVal();
            }
        }
        return ret;
    }

    /**
     * Кладем значения под определенным ключем в мапу
     * @param key
     * @param val
     * @return V
     */
    public V put(K key, V val) {
        V ret = null;
        if (key == null) {
            ret = putForNullKey(val);
            return ret;
        } else {
            int location = Hashing(key.hashCode());
            if (location >= capacity) {
                System.out.println("Rehashing required");
                return null;
            }
            Entry<K, V> e = null;
            try {
                e = table[location];
            } catch (NullPointerException ex) {

            }
            if (e != null && e.getKey() == key) {
                ret = (V) e.getVal();
            } else {
                Entry<K, V> eNew = new Entry<K, V>();
                eNew.setKey(key);
                eNew.setVal(val);
                table[location] = eNew;
                size++;
            }
        }
        return ret;
    }

    private V putForNullKey(V val) {
        Entry<K, V> e = null;
        try {
            e = table[0];
        } catch (NullPointerException ex) {

        }
        V ret = null;
        if (e != null && e.getKey() == null) {
            ret = (V) e.getVal();
            e.setVal(val);
            return ret;
        } else {
            Entry<K, V> eNew = new Entry<K, V>();
            eNew.setKey(null);
            eNew.setVal(val);
            table[0] = eNew;
            size++;
        }
        return ret;
    }

    /**
     * Удаление элемента под определнным ключем из мапы
     * @param key
     * @return V
     */
    public void remove(K key) {
        int location = Hashing(key.hashCode());

        if (table[location].getKey() == key) {
            table[location] = null;
        }
    }
}