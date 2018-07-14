class Solution {
    
    private static HashMap<Integer, String> map = new HashMap<>();
    
    static {
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        map.put(100, "Hundred");
        map.put(1000, "Thousand");
        map.put(1000000, "Million");
        map.put(1000000000, "Billion");
    }
    
    public String numberToWords(int num) {
        if (map.containsKey(num)) {
            return num < 100 ? map.get(num) : "One " + map.get(num);
        }
        
        String result = "";
        int key = 1;
        while (num > 0) {
            int n = num % 1000;
            if (n > 0) {
                String temp = numberBelowThousandToWords(n);
                if (key >= 1000) {
                    temp += " " + map.get(key);
                }
                if (!result.isEmpty()) {
                    temp += " ";
                }
                result = temp + result;
            }
            key *= 1000;
            num /= 1000;
        }
        return result;
    }
    
    private String numberBelowThousandToWords(int num) {
        if (map.containsKey(num)) {
            return num < 100 ? map.get(num) : "One " + map.get(num);
        }
        
        if (num >= 100) {
            String result = map.get(num / 100) + " Hundred";
            if (num % 100 != 0) {
                result += " " + numberBelowHundredToWords(num % 100);
            }
            return result;
                
        } else {
            return numberBelowHundredToWords(num);
        }
    }
    
    private String numberBelowHundredToWords(int num) {
        if (map.containsKey(num)) {
            return num < 100 ? map.get(num) : "One " + map.get(num);
        }
        
        return map.get(num / 10 * 10) + " " + map.get(num % 10);
    }
}