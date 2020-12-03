package com.example.mysql2es.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: admin
 * @Description: sentinel资源定义
 * @BelongsProject: mysql2es
 * @BelongsPackage: com.example.mysql2es.sentinel
 * @CreateTime: 2020-12-01 14:17:07
 */
public class CustomSentinelDemo {

    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("hello sentinel");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 设置QPS为20
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

    public static void main(String[] args) {
        // 配置规则
        initFlowRules();

        Entry entry = null;
        while (true) {
            try {
                entry = SphU.entry("HelloSentinel");
                // 被保护的逻辑-开始
                System.out.println("---hello sentinel---");
                // 被保护的逻辑-结束
            } catch (BlockException ex) {
                // 处理被流控的逻辑-开始
                System.out.println("sentinel blocked!");
                // 处理被流控的逻辑-结束
            } finally {
                if (entry != null) {
                    entry.exit();
                }
            }
        }

    }


}
