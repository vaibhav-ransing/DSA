public static String addTabsAtBeginning(String input, int n) {
    StringBuilder output = new StringBuilder();
    String[] lines = input.split("\\r?\\n"); // Split input by lines

    for (String line : lines) {
        // Add n tab spaces at the beginning of each line
        for (int i = 0; i < n; i++) {
            output.append("\t");
        }
        output.append(line).append(System.lineSeparator()); // Append the line with system-dependent line separator
    }

    return output.toString();
}
