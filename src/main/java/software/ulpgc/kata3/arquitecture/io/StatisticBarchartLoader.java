package software.ulpgc.kata3.arquitecture.io;

import software.ulpgc.kata3.arquitecture.model.Barchart;

import java.util.Map;

public class StatisticBarchartLoader implements BarchartLoader{
    private final Map<String, Integer> platformsCount;
    private final Map<String, Integer> gamesPerYear;

    public StatisticBarchartLoader(Map<String, Integer> platformsCount, Map<String, Integer> gamesPerYear) {
        this.platformsCount = platformsCount;
        this.gamesPerYear = gamesPerYear;
    }

    @Override
    public Barchart load(int id) {
        return switch (id) {
            case 0 -> barcharLoaderOf(platformsCount, "Platforms Count", "Platforms", "Count");
            case 1 -> barcharLoaderOf(gamesPerYear, "Games per Year", "Years", "Count");
            default -> null;
        };
    }

    private Barchart barcharLoaderOf(Map<String, Integer> map, String title, String xAxis, String yAxis) {
        return new Barchart(map, title, xAxis, yAxis);
    }
}
