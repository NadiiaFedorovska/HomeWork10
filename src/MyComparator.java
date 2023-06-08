import java.util.Comparator;
import java.util.Map;

class MyComparator implements Comparator<String> {
    Map<String, Integer> map;

    public MyComparator(Map<String, Integer> map) {
        this.map = map;
    }

    @Override
    public int compare(String a, String b) {
        if (map.get(a) >= map.get(b)) {
            return -1;
        } else {
            return 1;
        }
    }
}