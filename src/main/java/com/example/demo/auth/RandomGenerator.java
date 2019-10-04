package com.example.demo.auth;

public class RandomGenerator {
    String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";

    String get(int n) {
        String ans = "";
        for (int i = 0; i < n; i++) {


            int index = (int) (AlphaNumericString.length()
                    * Math.random());

            ans += AlphaNumericString.charAt(index);
        }
        return ans;

    }
}
