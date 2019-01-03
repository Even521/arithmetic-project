package com.even;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2019/1/3 0003.
 *
 * @author even
 * 物理机节点模拟类，保存节点的IP、名称、端口等信息
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Node {
    /**
     * ip地址
     */
    private String ip;
    /**
     * 名称
     */
    private String name;
}
