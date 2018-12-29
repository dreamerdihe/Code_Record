class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs, 0);
    }
    
    
    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int start) {      
        int cost = directPurchase(price, needs);
        for(int i = start; i < special.size(); i ++) {
            List<Integer> offer = special.get(i);
            if(!isValid(needs, offer)) {
                continue;
            }
            
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < needs.size(); j ++) {
                temp.add(needs.get(j) - offer.get(j));
            }
            
            cost = Math.min(cost, offer.get(offer.size() - 1) + dfs(price, special, temp, i));
        }
        
        return cost;
    }
    
    private boolean isValid(List<Integer> needs, List<Integer> offer) {
        for(int i = 0; i < needs.size(); i ++) {
            if(needs.get(i) - offer.get(i) < 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private int directPurchase(List<Integer> price, List<Integer> needs) {
        int cost = 0;
        for(int i = 0; i < needs.size(); i ++) {
            cost += price.get(i) * needs.get(i);
        }
        
        return cost;
    }
}