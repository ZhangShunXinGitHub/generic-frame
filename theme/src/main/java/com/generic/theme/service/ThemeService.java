package com.generic.theme.service;


import com.generic.common.constant.ResponseEnum;
import com.generic.common.exception.ThemeInfoException;
import com.generic.theme.dto.ThemeInfo;

public interface ThemeService {
    ResponseEnum saveThemeInfo(ThemeInfo themeInfo) throws ThemeInfoException;
    Iterable<ThemeInfo> findAllThemeInfo() throws ThemeInfoException;
}
