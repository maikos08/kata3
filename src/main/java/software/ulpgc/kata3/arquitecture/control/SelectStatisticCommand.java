package software.ulpgc.kata3.arquitecture.control;

import software.ulpgc.kata3.arquitecture.io.BarchartLoader;
import software.ulpgc.kata3.arquitecture.view.BarchartDisplay;
import software.ulpgc.kata3.arquitecture.view.SelectStatisticDialog;

public class SelectStatisticCommand implements Command{
    private final SelectStatisticDialog dialog;
    private final BarchartDisplay display;
    private final BarchartLoader loader;

    public SelectStatisticCommand(SelectStatisticDialog dialog, BarchartDisplay display, BarchartLoader loader) {
        this.dialog = dialog;
        this.display = display;
        this.loader = loader;
    }

    @Override
    public void execute() {
        display.show(loader.load(dialog.getSelection()));
    }
}
