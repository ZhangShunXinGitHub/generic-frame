package com.generic.theme.service.impl;

import com.generic.common.constant.ResponseEnum;
import com.generic.common.exception.ThemeInfoException;

import com.generic.theme.dto.ThemeInfo;
import com.generic.theme.repository.ThemeInfoRepository;
import com.generic.theme.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    private ThemeInfoRepository themeInfoRepository;
    @Override
    public ResponseEnum saveThemeInfo(ThemeInfo themeInfo) throws ThemeInfoException {
         themeInfoRepository.save(themeInfo);
        return ResponseEnum.SUCCESS;
    }

    @Override
    public Iterable<ThemeInfo> findAllThemeInfo() throws ThemeInfoException {
        return themeInfoRepository.findAll();
    }
}
