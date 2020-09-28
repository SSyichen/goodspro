package com.luka.goodspro.service.impl;

import com.luka.goodspro.mapper.SupplierMapper;
import com.luka.goodspro.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public void insert(Supplier supplier) {
        supplierMapper.insert(supplier);
    }
}
