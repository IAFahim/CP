package com.company;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class FindMaxTest {
    @Test
    public void shouldReturn() throws Exception{
        FindMax.TreeNode left = FindMax.TreeNode.leaf(50).withLeaves(-100, -10);
        FindMax.TreeNode right = FindMax.TreeNode.leaf(40);
        FindMax.TreeNode root = FindMax.TreeNode.join(6, left, right);
        int actual=root.findMax(root);
        Assert.assertEquals(actual,30);
    }

}