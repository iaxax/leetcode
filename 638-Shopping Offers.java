class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shoppingOffers(price, special, needs, 0);
    }
    
    private int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int start) {
        if (start == special.size()) {
            int sum = 0, size = needs.size();
            for (int i = 0; i < size; ++i) {
                sum += needs.get(i) * price.get(i);
            }
            return sum;
        }
        
        int sum = 0, size = needs.size();
        int minPrice = shoppingOffers(price, special, needs, start + 1);
        List<Integer> specialOffer = special.get(start);
        while (useOffer(specialOffer, needs)) {
            List<Integer> temp = new ArrayList<>(size);
            for (int i = 0; i < size; ++i) {
                temp.add(needs.get(i) - specialOffer.get(i));
            }
            sum += specialOffer.get(specialOffer.size() - 1);
            int p = sum + shoppingOffers(price, special, temp, start + 1);
            minPrice = Math.min(minPrice, p);
            needs = temp;
        }
        return minPrice;
    }
    
    private boolean useOffer(List<Integer> offer, List<Integer> needs) {
        int size = needs.size();
        for (int i = 0; i < size; ++i) {
            if (needs.get(i) < offer.get(i)) return false;
        }
        return true;
    }
}
