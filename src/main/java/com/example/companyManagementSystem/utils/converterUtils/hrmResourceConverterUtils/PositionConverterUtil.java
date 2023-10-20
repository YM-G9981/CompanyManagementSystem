package com.example.companyManagementSystem.utils.converterUtils.hrmResourceConverterUtils;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.example.companyManagementSystem.entity.hrmResource.Position;

public class PositionConverterUtil implements Converter<Position> {
    @Override
    public Class supportJavaTypeKey() {
        return Position.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Position convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        String name = cellData.getStringValue();
        Position position = new Position();
        position.setPositionName(name);
        return position;
    }

    @Override
    public CellData convertToExcelData(Position position, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return new CellData(position.getPositionName());
    }
}
