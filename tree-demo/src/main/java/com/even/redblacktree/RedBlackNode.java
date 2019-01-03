package com.even.redblacktree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2019/1/3 0003.
 *
 * @author even
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RedBlackNode {
    /**
     * 数据
     */
    private int data;
    /**
     * 左节点
     */
    private RedBlackNode left;
    /**
     * 右节点
     */
    private RedBlackNode right;
    /**
     * 颜色
     */
    private boolean color;
}
