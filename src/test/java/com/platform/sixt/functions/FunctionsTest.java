package com.platform.sixt.functions;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionsTest {
    Functions functions = new Functions();

    @Test
    public void isAnagram() {
        Assert.assertTrue(functions.isAnagram("omar", "roma"));
        Assert.assertTrue(functions.isAnagram("Dormitory", "dirty room"));
        Assert.assertFalse(functions.isAnagram("juan", "najuan"));
        Assert.assertFalse(functions.isAnagram("Real funn", "funeral"));

    }

    @Test
    public void isAnagramBestOption() {
        Assert.assertTrue(functions.isAnagramBestOption("omar", "roma"));
        Assert.assertTrue(functions.isAnagramBestOption("Dormitory", "dirty room"));
        Assert.assertFalse(functions.isAnagramBestOption("juan", "najuan"));
        Assert.assertFalse(functions.isAnagramBestOption("Real funn", "funeral"));

    }
}