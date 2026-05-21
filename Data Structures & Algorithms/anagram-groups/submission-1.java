class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Integer, ArrayList<String>> map = new HashMap<>();

        for (String str : strs) {
            int count[] = new int[26];
            for (char c : str.toLowerCase().toCharArray()) count[c - 'a']++;
            int key = Arrays.hashCode(count);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                map.put(key, new ArrayList<>());
                map.get(key).add(str);
            }
        }

        for (int key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

}
