package software.ulpgc.kata3.arquitecture.io;

import software.ulpgc.kata3.arquitecture.model.Game;

import java.io.IOException;
import java.util.List;

public interface GameLoader {
    List<Game> load() throws IOException;
}
