package software.ulpgc.kata3.arquitecture.io;


import software.ulpgc.kata3.arquitecture.model.Game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileGameLoader implements GameLoader {
    private final File file;
    private final GameDeserializer deserializer;

    public FileGameLoader(File file, GameDeserializer deserializer) {
        this.file = file;
        this.deserializer = deserializer;
    }

    @Override
    public List<Game> load() throws IOException {
        List<Game> games = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine();
            while (true) {
                String line = reader.readLine();
                if (line == null)
                    break;
                games.add(deserializer.deserialize(line));
            }
        }
        return games;
    }
}

