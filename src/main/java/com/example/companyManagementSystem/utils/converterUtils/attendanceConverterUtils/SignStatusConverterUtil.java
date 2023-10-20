package com.example.companyManagementSystem.utils.converterUtils.attendanceConverterUtils;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

public class SignStatusConverterUtil implements Converter<Integer> {
    @Override
    public Class supportJavaTypeKey() {
        return Integer.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Integer convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        String state = cellData.getStringValue();
        switch (state) {
            case "签到正常":
                return 1;
            case "迟到":
                return 2;
            case "早退":
                return 3;
            default:
                return 0;
        }
    }

    @Override
    public CellData convertToExcelData(Integer integer, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        switch (integer) {
            case 1:
                return new CellData("签到正常");
            case 2:
                return new CellData("迟到");
            case 3:
                return new CellData("早退");
            default:
                return new CellData("");
        }
    }
}
