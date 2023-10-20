package com.example.companyManagementSystem.utils.converterUtils.hrmResourceConverterUtils;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.example.companyManagementSystem.entity.hrmResource.Department;

public class DepartmentConverterUtil implements Converter<Department> {

    @Override
    public Class supportJavaTypeKey() {
        return Department.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Department convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        String departmentName = cellData.getStringValue();
        Department department = new Department();
        department.setDepartmentName(departmentName);
        return department;
    }

    @Override
    public CellData convertToExcelData(Department department, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return new CellData<>(department.getDepartmentName());
    }
}
