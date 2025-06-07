class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        int n = senate.length();
        for(int i=0;i<n;i++){
            if(senate.charAt(i) == 'R') radiant.add(i);
            else dire.add(i);
        }
        while(!dire.isEmpty() && !radiant.isEmpty()){
            int indR = radiant.poll();
            int indD = dire.poll();

            if(indR > indD) dire.add(indD + n);
            else radiant.add(indR + n);
        }
        return dire.isEmpty() ? "Radiant" : "Dire";
    }
}