package ui;

import util.InputHelper;

import java.util.ArrayList;

public class Menu {

    private String menuTitle;
    private final ArrayList<String> optionList = new ArrayList<>();

    public Menu() {
    }

    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    /**
     * Add a new option to the menu
     *
     * @param newOption new option to add
     */
    public void addOption(String newOption) {
        if (!optionList.contains(newOption)) {
            optionList.add(newOption);
        }
    }

    /**
     * Print greeting to the console
     */
    public void printGreeting() {
        System.out.println("Welcome to " + menuTitle);
    }

    /**
     * Print menu to console
     */
    public void printMenu() {
        if (optionList.isEmpty()) {
            System.out.println("The list of options is empty.");
            return;
        }

        for (int i = 0; i < optionList.size(); i++) {
            System.out.println((i + 1) + ". " + optionList.get(i));
        }
    }

    /**
     * Get a user's choice from the console
     *
     * @return user's choice
     */
    public int getChoice() {
        int maxOption = getCountOption();

        String inputMsg = "Enter your choice [1-" + maxOption + "]";

        return InputHelper.readInt(inputMsg, 1, maxOption, "Your choice");
    }

    /**
     * Get the number of options in the menu
     *
     * @return The number of options
     */
    public int getCountOption() {
        return optionList.size();
    }
}
