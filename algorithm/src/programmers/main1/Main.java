package programmers.main1;

public class Main {
    //퍼즐 게임 챌린지
    public int solution(int[] diffs, int[] times, long limit) {
        long L = 1;
        long R = limit;
        long ans = 0;
        while(L <=R) {
            long mid = (L+R)/2;
            if(determinated(diffs,times,limit,mid)) {
                ans = mid;
                R = mid -1;
            } else {
                L = mid +1;
            }
        }
        return (int)ans;
    }

    public static boolean determinated(int[] diffs, int[] times, long limit,long mid) {
        long count = times[0];
        for(int i = 1 ; i < diffs.length; i++) {
            if(diffs[i] > mid) {
                count += (times[i]+times[i-1])*(diffs[i]-mid) +(times[i]);
            } else {
                count += times[i];
            }
        }
        if(count <= limit) {
            return true;
        }
        return false;
    }

}
