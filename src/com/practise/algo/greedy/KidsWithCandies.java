class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int gn = 0;
        for(int num : candies){
            if(num > gn){
                gn = num;
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int num : candies){
            if(gn <= num+extraCandies){
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
