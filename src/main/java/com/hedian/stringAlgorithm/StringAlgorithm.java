package com.hedian.stringAlgorithm;

import org.junit.Test;

public class StringAlgorithm {

    @Test
    public void testStringBm() {
        String targ = "12314151";
        String pattern = "15";
        Integer pStartIndexInT = this.stringBm(targ, pattern);
        System.out.println(pStartIndexInT);
    }

    private Integer stringBm(String targ, String pattern) {
        int patternLength = pattern.length();
        int errorCharIndex = patternLength - 1;
        char errChar = targ.charAt(errorCharIndex);
        int patternCurrrentIndex = patternLength - 1;
        int targCurrentIndex = patternCurrrentIndex;

        int tagLastCharIndex = patternLength - 1;
        while (tagLastCharIndex <= targ.length() - 1) {
            targCurrentIndex = tagLastCharIndex;
            for (int count = 0; count <= patternLength - 1; count++) {
                if (targ.charAt(targCurrentIndex) != pattern.charAt(patternCurrrentIndex)) {
                    int errorCharIndexInPattern = pattern.lastIndexOf(errChar);
                    errChar = targ.charAt(targCurrentIndex);
                    tagLastCharIndex += (patternLength - errorCharIndexInPattern - 1);
                    break;
                } else {
                    if (count == patternLength - 1) {
                        return targCurrentIndex;
                    }
                    targCurrentIndex -= count;
                    patternCurrrentIndex -= count;
                }
            }
        }
        System.out.println("1");
        System.out.println("2");
        return -1;
    }

}
