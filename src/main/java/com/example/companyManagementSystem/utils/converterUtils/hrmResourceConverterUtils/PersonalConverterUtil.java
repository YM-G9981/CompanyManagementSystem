package com.example.companyManagementSystem.utils.converterUtils.hrmResourceConverterUtils;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.example.companyManagementSystem.entity.hrmResource.Personal;

public class PersonalConverterUtil implements Converter<Personal> {
    @Override
    public Class supportJavaTypeKey() {
        return Personal.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Personal convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        String name = cellData.getStringValue();
        Personal personal = new Personal();
        personal.setName(name);
        return personal;
    }

    @Override
    public CellData convertToExcelData(Personal personal, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return new CellData(personal.getName());
    }
}
