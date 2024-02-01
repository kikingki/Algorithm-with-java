import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Country implements Comparable<Country> {
        int number;
        int gold;
        int silver;
        int bronze;
        int rank;

        public Country(int number, int gold, int silver, int bronze, int rank) {
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.rank = rank;
        }

        @Override
        public int compareTo(Country c) {
            if(this.gold == c.gold) {
                if (this.silver == c.silver) return c.bronze - this.bronze;
                return c.silver - this.silver;
            }
            return c.gold - this.gold;
        }

        public boolean equals(Country obj) {
            return this.gold == obj.gold && this.silver == obj.silver && this.bronze == obj.bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Country> countryList = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());       // 국가의 수
        int k = Integer.parseInt(st.nextToken());       // 등수를 알고 싶은 국가

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            countryList.add(new Country(num, g,s,b, 0));
        }

        Collections.sort(countryList);

        countryList.get(0).rank = 1;

        for (int i = 1; i < countryList.size(); i++) {
            Country prev = countryList.get(i - 1);
            Country current = countryList.get(i);

            if (prev.number == k) {
                System.out.println(prev.rank);
                return;
            }

            if (current.equals(prev)) {
                current.rank = prev.rank;
            } else {
                current.rank = i+1;
            }
        }

        if(countryList.get(n-1).number == k) {
            System.out.println(countryList.get(n-1).rank);
        }
    }
}
