package com.xyy.biz;

import com.xyy.model.TaxRate;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/30 0030.
 */
public interface TaxRateService {
    List<TaxRate> getTaxRates();

    boolean addTaxRate(TaxRate taxRate);

    TaxRate getThisTaxRate(TaxRate taxRate);

    boolean updateTaxRate(TaxRate taxRate);

    boolean deleteTaxRate(TaxRate taxRate);
}
