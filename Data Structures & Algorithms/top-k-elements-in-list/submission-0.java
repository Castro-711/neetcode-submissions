class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        Integer[] keys = map.keySet().toArray(new Integer[]{});
        for (int y = 0; y < map.size(); y++) {
            for (int x = keys.length - 1; x > y; x--) {
                if (map.get(keys[x]) > map.get(keys[x - 1])) {
                    int temp = keys[x];
                    keys[x] = keys[x - 1];
                    keys[x - 1] = temp;
                }
            }
        }

        return Arrays.copyOfRange(Arrays.stream(keys).mapToInt(Integer::intValue).toArray(), 0, k);
    }
}
