public class OffByOne<T> implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        int absDiff = Math.abs(diff);
        return absDiff == 1;
    };
}
