package com.kuehnenagel;

import java.util.*;

/**
 * Sample command line argument parser.
 * <a href="https://oshanoshu.github.io/2021-02-23-Simple-Java-Command-Line-Argument-Parser-Implementation/">source</a>
 * It is modified according to the project.
 */
public class CommandLineParser {
    private final HashMap<String, List<String>> map = new HashMap<>();
    private final Set<String> flags = new HashSet<>();
    private List<String> args;

    public CommandLineParser(String[] arguments) {
        this.args = Arrays.asList(arguments);
        map();
    }

    /**
     * @return argument names
     */
    public Set<String> getArgumentNames() {
        Set<String> argumentNames = new HashSet<>();
        argumentNames.addAll(flags);
        argumentNames.addAll(map.keySet());
        return argumentNames;
    }

    public boolean existFlag(String flagName) {
        return flags.contains(flagName);
    }

    /**
     * @param argumentName argument name
     * @return argument values, if it does not exist, return null.
     */
    public String[] getArgumentValue(String argumentName) {
        if (map.containsKey(argumentName)) {
            return map.get(argumentName).toArray(new String[0]);
        } else {
            return null;
        }
    }

    // Map the flags and argument names with the values
    private void map() {
        for (String arg : args) {
            if (arg.startsWith("-")) {
                if (args.indexOf(arg) == (args.size() - 1)) {
                    flags.add(arg.replace("-", ""));
                } else if (args.get(args.indexOf(arg) + 1).startsWith("-")) {
                    flags.add(arg.replace("-", ""));
                } else {
                    //List of values (can be multiple)
                    List<String> argumentValues = new ArrayList<>();
                    int i = 1;
                    while (args.indexOf(arg) + i != args.size() && !args.get(args.indexOf(arg) + i).startsWith("-")) {
                        argumentValues.add(args.get(args.indexOf(arg) + i));
                        i++;
                    }
                    map.put(arg.replace("-", ""), argumentValues);
                }
            }
        }
    }
}
