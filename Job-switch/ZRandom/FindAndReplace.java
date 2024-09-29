package ZRandom;

public class FindAndReplace {

    public String findReplaceStringWrong(String s, int[] indices, String[] sources, String[] targets) {

        String[] arr = new String[targets.length];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < targets.length; i++) {
            int idx = indices[i];
            String subStringOfS = s.substring(idx, sources[i].length());
            if (subStringOfS.equals(sources[i])) {
                arr[i] = targets[i];
            } else {
                arr[i] = subStringOfS;
            }
        }
        for (String ts : arr) {
            sb.append(ts);
        }
        return sb.toString();
    }

}