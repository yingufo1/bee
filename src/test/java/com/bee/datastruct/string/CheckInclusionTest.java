package com.bee.datastruct.string;

import org.junit.Assert;
import org.junit.Test;

class CheckInclusionTest {
    @Test
    public void test(){
        CheckInclusion checkInclusion = new CheckInclusion();
        boolean res = checkInclusion.checkInclusion("ab","eidbaooo");
        Assert.assertTrue(res);

        res = checkInclusion.checkInclusion("ab","eidboaoo");
        Assert.assertFalse(res);
    }
}