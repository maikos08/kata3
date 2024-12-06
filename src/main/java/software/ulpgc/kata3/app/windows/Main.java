package software.ulpgc.kata3.app.windows;

import software.ulpgc.kata3.arquitecture.control.SelectStatisticCommand;
import software.ulpgc.kata3.arquitecture.io.CsvGameDeserializer;
import software.ulpgc.kata3.arquitecture.io.FileGameLoader;
import software.ulpgc.kata3.arquitecture.io.StatisticBarchartLoader;
import software.ulpgc.kata3.arquitecture.model.Game;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\User\\Universidad\\3º\\IS2\\Practicas\\kata2\\Videogames sales dataset\\vgsales.csv");
        List<Game> games = new FileGameLoader(file, new CsvGameDeserializer()).load();

        TreeMap<String, Integer> platformsCount = games.stream()
                .collect(Collectors.toMap(
                        game -> game.platform().toString(),
                        game -> 1,
                        Integer::sum,
                        TreeMap::new
                ));
        TreeMap<String, Integer> gamesPerYear = games.stream()
                .collect(Collectors.toMap(
                        game -> String.valueOf(game.year()),
                        game -> 1,
                        Integer::sum,
                        TreeMap::new
                ));


        MainFrame mainFrame = new MainFrame();
        StatisticBarchartLoader loader = new StatisticBarchartLoader(platformsCount, gamesPerYear);
        mainFrame.put("select", new SelectStatisticCommand(
                mainFrame.getDialog(), mainFrame.getDisplay(), loader
                ));
        mainFrame.getDisplay().show(loader.load(0));
        mainFrame.setVisible(true);


    }
}
