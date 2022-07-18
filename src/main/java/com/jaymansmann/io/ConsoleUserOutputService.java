package com.jaymansmann.io;

public class ConsoleUserOutputService implements UserOutputService {
    private enum Colors {

        BLACK("\033[0;30m"),   // BLACK
        RED("\033[0;31m"),     // RED
        GREEN("\033[0;32m"),   // GREEN
        YELLOW("\033[0;33m"),  // YELLOW
        BLUE("\033[0;34m"),    // BLUE
        PURPLE("\033[0;35m"),  // PURPLE
        CYAN("\033[0;36m"),    // CYAN
        WHITE("\033[0;37m"),
        BLACK_BOLD("\033[1;30m"),  // BLACK
        RED_BOLD("\033[1;31m"),    // RED
        GREEN_BOLD("\033[1;32m"),  // GREEN
        YELLOW_BOLD("\033[1;33m"), // YELLOW
        BLUE_BOLD("\033[1;34m"),   // BLUE
        PURPLE_BOLD("\033[1;35m"), // PURPLE
        CYAN_BOLD("\033[1;36m"),   // CYAN
        WHITE_BOLD("\033[1;37m"),
        BLACK_UNDERLINED("\033[4;30m"),  // BLACK
        RED_UNDERLINED("\033[4;31m"),    // RED
        GREEN_UNDERLINED("\033[4;32m"),  // GREEN
        YELLOW_UNDERLINED("\033[4;33m"), // YELLOW
        BLUE_UNDERLINED("\033[4;34m"),   // BLUE
        PURPLE_UNDERLINED("\033[4;35m"), // PURPLE
        CYAN_UNDERLINED("\033[4;36m"),   // CYAN
        WHITE_UNDERLINED("\033[4;37m"),  // WHITE

        // Background
        BLACK_BACKGROUND("\033[40m"),
        RED_BACKGROUND("\033[41m"),
        GREEN_BACKGROUND("\033[42m"),
        YELLOW_BACKGROUND("\033[43m"),
        BLUE_BACKGROUND("\033[44m"),
        PURPLE_BACKGROUND("\033[45m"),
        CYAN_BACKGROUND("\033[46m"),
        WHITE_BACKGROUND("\033[47m"),

        // High Intensity
        BLACK_BRIGHT("\033[0;90m"), // BLACK
        RED_BRIGHT("\033[0;91m"),   // RED
        GREEN_BRIGHT("\033[0;92m"), // GREEN
        YELLOW_BRIGHT("\033[0;93m"),// YELLOW
        BLUE_BRIGHT("\033[0;94m"),  // BLUE
        PURPLE_BRIGHT("\033[0;95m"),// PURPLE
        CYAN_BRIGHT("\033[0;96m"),  // CYAN
        WHITE_BRIGHT("\033[0;97m"), // WHITE

        // Bold High Intensity
        BLACK_BOLD_BRIGHT("\033[1;90m"),// BLACK
        RED_BOLD_BRIGHT("\033[1;91m"),  // RED
        GREEN_BOLD_BRIGHT("\033[1;92m"),// GREEN
        YELLOW_BOLD_BRIGHT("\033[1;93m"),// YELLOW
        BLUE_BOLD_BRIGHT("\033[1;94m"), // BLUE
        PURPLE_BOLD_BRIGHT("\033[1;95m"),// PURPLE
        CYAN_BOLD_BRIGHT("\033[1;96m"), // CYAN
        WHITE_BOLD_BRIGHT("\033[1;97m"),// WHITE

        // High Intensity backgrounds
        BLACK_BACKGROUND_BRIGHT("\033[0;100m"),// BLACK
        RED_BACKGROUND_BRIGHT("\033[0;101m"),// RED
        GREEN_BACKGROUND_BRIGHT("\033[0;102m"),// GREEN
        YELLOW_BACKGROUND_BRIGHT("\033[0;103m"),// YELLOW
        BLUE_BACKGROUND_BRIGH("\033[0;104m"),// BLUE
        PURPLE_BACKGROUND_BRIGHT("\033[0;105m"), // PURPLE
        CYAN_BACKGROUND_BRIGHT("\033[0;106m"),  // CYAN
        WHITE_BACKGROUND_BRIGHT("\033[0;107m"),   // WHITE
        RESET("\033[0m");
        private String ansi;

        private Colors(String ansi) {
            this.ansi = ansi;
        }

        public String getAnsi() {
            return ansi;
        }

        @Override
        public String toString() {
            return getAnsi();
        }


    }

    @Override
    public void displayText(String text) {
        System.out.println(text);
    }

    @Override
    public void displayErrorText(String text) {
        System.out.println(ConsoleUserOutputService.Colors.WHITE_BACKGROUND.getAnsi() + ConsoleUserOutputService.Colors.RED_BOLD.getAnsi() + text + ConsoleUserOutputService.Colors.RESET.getAnsi());
    }


}
