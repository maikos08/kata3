package software.ulpgc.kata3.arquitecture.model;

public record Game(
        int ranking,
        String name,
        Platform platform,
        int year,
        Genre genre,
        String publisher,
        double naSales,
        double euSales,
        double jpSales,
        double otherSales,
        double globalSales
) {
    public enum Platform {
        NES,
        _2600,     // 2600
        GB,
        PC,
        DS,
        _3DS,   // 3DS
        _3DO,   // 3DO
        X360,
        PS,
        PS2,
        PS3,
        PS4,
        PSP,
        SNES,
        GBA,
        N64,
        XB,
        XOne,
        GC,
        Wii,
        WiiU,
        GEN,
        DC,
        PSV,
        SAT,
        SCD,
        WS,
        NG,
        TG16,
        GG,
        PCFX;

        @Override
        public String toString() {
            String name = super.toString();

            return (name.startsWith("_")) ?
                    name.substring(1):
                    name;
        }
    }

    public enum Genre {
        Puzzle,
        Platform,
        Shooter,
        Action,
        Sports,
        Misc,
        Fighting,
        Adventure,
        Racing,
        Simulation,
        RolePlaying,    // Role-Playing
        Strategy
    }
}