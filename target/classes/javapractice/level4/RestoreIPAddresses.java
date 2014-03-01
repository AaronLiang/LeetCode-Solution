/**
 * 
 */
package java.practice.level4;

import java.util.ArrayList;

/**
 * Source: LeetCode
 * 
 * @author Aaron
 * 
 *         Given a string containing only digits, restore it by returning all
 *         possible valid IP address combinations.
 * 
 *         For example: Given "25525511135",
 * 
 *         return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIPAddresses {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        if (s == null || "".equals(s.trim()) || s.trim().length() < 4) {
            return result;
        }
        return IPHelper(s, 4);
    }

    public static ArrayList<String> IPHelper(String s, int n) {
        ArrayList<String> res = new ArrayList<String>();

        if (s == null || s.length() < n || s.length() > 3 * n || n > 4 || n < 1) {
            return res;
        }
        for (int i = 0; i < Math.min(3, s.length()); i++) {
            String temp = s.substring(0, i + 1);
            if ((i > 0 && s.charAt(0) == '0') || Integer.parseInt(temp) > 255) {
                break;
            } else if (n == 1 && i == s.length() - 1) {
                res.add(temp);// why add temp?
            }
            // if(i + 1 == s.length() ) break;
            ArrayList<String> list = IPHelper(s.substring(i + 1), n - 1);
            if (list == null)
                continue;// why is continue not break;

            for (String str : list) {
                res.add(temp + "." + str);
            }
        }
        return res;
    }

    public static boolean isInvalid(String s) {
        return s.charAt(0) < '0' || Integer.parseInt(s) > 255;
    }

    // ***************************************************************
    public ArrayList<String> restoreIpAddresses1(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = restoreIPAddresses1(s, 4);
        if (res == null)
            res = new ArrayList<String>();
        return res;
    }

    public ArrayList<String> restoreIPAddresses1(String s, int k) {
        assert (k <= 4 && k >= 1);
        if (s == null || s.length() < k || s.length() > 3 * k)
            return null;
        ArrayList<String> res = new ArrayList<String>();

        for (int i = 0; i < Math.min(s.length(), 3); i++) {
            String num = s.substring(0, i + 1);
            if ((i == 0 || num.charAt(0) > '0') && Integer.parseInt(num) <= 255) {
                if (k == 1) {
                    if (i == s.length() - 1)
                        res.add(num);
                } else {
                    ArrayList<String> remain = restoreIPAddresses1(
                            s.substring(i + 1), k - 1);
                    if (remain != null) {
                        for (String r : remain) {
                            String temp = num + '.' + r;
                            res.add(temp);
                        }
                    }
                }
            } else
                break;
        }
        return res;
    }
}
