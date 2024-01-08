import java.util.HashMap;

public class StringEncoding {
    static String secureChannel(int operation, String message, String key) {
        try {
            if (operation == 1) {
                return encodeMessage(message, key);
            } else if (operation == 2) {
                return decodeMessage(message, key);
            } else {
                return "-1"; // Return -1 for invalid operation
            }
        } catch (Exception e) {
            return "-1"; // Return -1 in case of exceptions
        }
    }

    private static String encodeMessage(String message, String key) {
        StringBuilder encodedMessage = new StringBuilder();
        int keyIndex = 0;

        for (char ch : message.toCharArray()) {
            if (!Character.isDigit(key.charAt(keyIndex))) {
                return "-1"; // If the key contains non-digit characters, return -1
            }

            int repeat = Character.getNumericValue(key.charAt(keyIndex));
            encodedMessage.append(repeatCharacters(ch, Math.max(0, repeat)));
            keyIndex = (keyIndex + 1) % key.length(); // Wrap around the key if needed
        }

        return encodedMessage.toString();
    }

    
    // Oppeeened , 12
    // Opeen
    // Opeeened

    private static String decodeMessage(String message, String key) {
        StringBuilder decodedMessage = new StringBuilder();
        int keyIndex = 0;
        int index = 0;

        while (index < message.length()) {
            char ch = message.charAt(index);

            int repeat = Character.getNumericValue(key.charAt(keyIndex));
            decodedMessage.append(ch);
            index += repeat;
            keyIndex = (keyIndex + 1) % key.length(); // Wrap around the key if needed
        }

        return decodedMessage.toString();
    }

    private static String repeatCharacters(char ch, int count) {
        StringBuilder repeatedChars = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeatedChars.append(ch);
        }
        return repeatedChars.toString();
    }

        public class Main {
            public static void main(String[] args) {
                // Test case 1: Encoding
                int operationEncode = 1;
                String messageEncode = "Open";
                String keyEncode = "123";
                String encodedMessage = secureChannel(operationEncode, messageEncode, keyEncode);
                System.out.println("Encoded message: " + encodedMessage);
        
                // Test case 2: Decoding
                int operationDecode = 2;
                String messageDecode = "Oppeeen";
                String keyDecode = "123";
                String decodedMessage = secureChannel(operationDecode, messageDecode, keyDecode);
                System.out.println("Decoded message: " + decodedMessage);
            }
        }
        
    
}
