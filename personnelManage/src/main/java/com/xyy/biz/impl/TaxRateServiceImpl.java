package com.xyy.biz.impl;

import com.xyy.biz.TaxRateService;
import com.xyy.dao.TaxRateMapper;
import com.xyy.model.TaxRate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/30 0030.
 */
@Service
public class TaxRateServiceImpl implements TaxRateService {

    @Resource
    private TaxRateMapper taxRateMapper;

    @Override
    public List<TaxRate> getTaxRates() {
        return taxRateMapper.getTaxRates();
    }

    @Override
    public boolean addTaxRate(TaxRate taxRate) {
        return taxRateMapper.addTaxRate(taxRate);
    }

    @Override
    public TaxRate getThisTaxRate(TaxRate taxRate) {
        return taxRateMapper.getThisTaxRate(taxRate);
    }

    @Override
    public boolean updateTaxRate(TaxRate taxRate) {
        return taxRateMapper.updateTaxRate(taxRate);
    }

    @Override
    public boolean deleteTaxRate(TaxRate taxRate) {
        return taxRateMapper.deleteTaxRate(taxRate);
    }
}
