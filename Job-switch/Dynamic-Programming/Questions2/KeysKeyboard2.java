public class KeysKeyboard2 {

    class Solution {
        private int targetLength;

        public int minSteps(int n) {
            if (n == 1)
                return 0;
            this.targetLength = n;
            return 1 + findMinSteps(1, 1);
        }

        private int findMinSteps(int currentLength, int clipboardLength) {
            if (currentLength == targetLength)
                return 0;
            if (currentLength > targetLength)
                return Integer.MAX_VALUE / 2;

            int copyAndPaste = 2 + findMinSteps(currentLength * 2, currentLength);
            int pasteOnly = 1 + findMinSteps(currentLength + clipboardLength, clipboardLength);

            return Math.min(copyAndPaste, pasteOnly);
        }
    }

    public int minSteps(int n) {
        return rec(n, 1, 1);
    }

    public int rec(int n, int count, int clipboard) {
        if (count == n)
            return 0;
        if (count > n)
            return 99999;
        int copyAndPaste = 2 + rec(n, count + count, count);
        int paste = 1 + rec(n, count + clipboard, clipboard);

        return Math.min(copyAndPaste, paste);
    }
}
