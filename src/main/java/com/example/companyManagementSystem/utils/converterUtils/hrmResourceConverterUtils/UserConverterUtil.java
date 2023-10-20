package com.example.companyManagementSystem.utils.converterUtils.hrmResourceConverterUtils;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.example.companyManagementSystem.entity.hrmResource.User;
import com.example.companyManagementSystem.service.hrmResourceService.GetUserService;

import javax.annotation.Resource;

public class UserConverterUtil implements Converter<User> {
    @Resource
    private GetUserService getUserService;

    @Override
    public Class supportJavaTypeKey() {
        return User.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public User convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        String username = cellData.getStringValue();
        User user = getUserService.getUsersByUsername(username);
        return user;
    }

    @Override
    public CellData convertToExcelData(User user, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return new CellData<>(user.getUsername());
    }
}
