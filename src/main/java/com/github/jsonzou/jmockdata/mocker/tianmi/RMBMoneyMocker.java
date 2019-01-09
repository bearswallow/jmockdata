package com.github.jsonzou.jmockdata.mocker.tianmi;

import com.github.jsonzou.jmockdata.DataConfig;
import com.github.jsonzou.jmockdata.Mocker;
import com.tianmi.base.type.number.RMBMoney;

/**
 * 人民币类型自动生成器
 */
public class RMBMoneyMocker implements Mocker<RMBMoney> {
    @Override
    public RMBMoney mock(DataConfig mockConfig) {
        return new RMBMoney(mockConfig.globalConfig().getMocker(Double.class).mock(mockConfig));
    }
}
