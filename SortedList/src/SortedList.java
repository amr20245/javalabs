package sortedlist;           // ←-- change or delete if you aren’t using packages

import java.util.Arrays;

/**
 * A minimal resizable array that keeps its String elements
 * in ascending lexicographic order at all times.
 */
public class SortedList {

    private String[] data = new String[10];
    private int size = 0;

    /* ---------- public API ---------- */

    /** Adds the value, keeping the list sorted. */
    public void add(String value) {
        if (size == data.length)
            grow();

        int idx = binarySearch(value);
        if (idx < 0)                       // convert insertion point
            idx = -(idx + 1);

        // shift elements to open a slot
        System.arraycopy(data, idx, data, idx + 1, size - idx);
        data[idx] = value;
        size++;
    }

    /** Returns a message saying where the value is (or would be). */
    public String search(String value) {
        int idx = binarySearch(value);
        if (idx >= 0)
            return "\"" + value + "\" found at index " + idx;
        int insertPos = -(idx + 1);
        return "\"" + value + "\" not found; would be at index " + insertPos;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) return "[empty]";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++)
            sb.append(i).append(": ").append(data[i]).append('\n');
        return sb.toString();
    }

    /* ---------- private helpers ---------- */

    /** Standard binary search; returns index or -insertionPoint-1. */
    private int binarySearch(String target) {
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;          // same as (low+high)/2
            int cmp = target.compareToIgnoreCase(data[mid]);
            if (cmp == 0) return mid;
            if (cmp < 0)  high = mid - 1;
            else          low  = mid + 1;
        }
        return -(low + 1);
    }

    /** Doubles the internal array. */
    private void grow() {
        data = Arrays.copyOf(data, data.length * 2);
    }
}
