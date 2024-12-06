package software.ulpgc.kata3.arquitecture.model;

import java.util.Map;
import java.util.Set;

public class Barchart {
    private final Map<String, Integer> map;
    private final String title;
    private final String xAxis;
    private final String yAxis;

    public Barchart(Map<String, Integer> map, String title, String xAxis, String yAxis) {
        this.map = map;
        this.title = title;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public String getTitle() {
        return title;
    }

    public String getxAxis() {
        return xAxis;
    }

    public String getyAxis() {
        return yAxis;
    }

    public Integer get(Object key) {
        return map.get(key);
    }

    public void put(String key, Integer value) {
        map.put(key, value);
    }

    public Set<String> keySet() {
        return map.keySet();
    }
}
