public class test {
    
    private static String decodeMessage(String message, String key) {
        StringBuilder decodedMessage = new StringBuilder();
        int keyIndex = 0;
        int index = 0;

        while (index < message.length()) {
            char ch = message.charAt(index);
            int repeat = 1;
            if(keyIndex < key.length()){
                repeat = Character.getNumericValue(key.charAt(keyIndex));

            }
            decodedMessage.append(ch);
            index += repeat;
            keyIndex++;
        }

        return decodedMessage.toString();
    }

    public boolean checkCharPresent(String message, int repeatInt){

    }

    private static String encodeMessage(String message, String key) {
        StringBuilder encodedMessage = new StringBuilder();
        int keyIndex = 0;

        for (char ch : message.toCharArray()) {

            int repeat = 1;
            if(keyIndex < key.length())
                repeat = Character.getNumericValue(key.charAt(keyIndex));
            encodedMessage.append(repeatCharacters(ch, Math.max(0, repeat)));
            keyIndex ++; // Wrap around the key if needed
        }

        return encodedMessage.toString();
    }

    private static String repeatCharacters(char ch, int count) {
        StringBuilder repeatedChars = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeatedChars.append(ch);
        }
        return repeatedChars.toString();
    }

    public static void main(String[] args) {

        
        String ans = decodeMessage("Oppeeened", "12");
        // Opeeened
        System.out.println(ans);


        String key = "13452";
        int  keyIndex = (1 + 1) % key.length();
        System.out.println(keyIndex);
        System.out.println(key);
    }
}
