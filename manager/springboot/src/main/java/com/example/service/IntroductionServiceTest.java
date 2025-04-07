package com.example.service;

import com.example.entity.Introduction;
import com.example.mapper.IntroductionMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IntroductionServiceTest {

    @Mock
    private IntroductionMapper introductionMapper;

    @InjectMocks
    private IntroductionService introductionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void add() {
        Introduction introduction = new Introduction();
        introduction.setName("Test Name");

        introductionService.add(introduction);

        verify(introductionMapper, times(1)).insert(introduction);
    }

    @Test
    void deleteById() {
        Integer id = 1;

        introductionService.deleteById(id);

        verify(introductionMapper, times(1)).deleteById(id);
    }

    @Test
    void deleteBatch() {
        List<Integer> ids = Arrays.asList(1, 2, 3);

        introductionService.deleteBatch(ids);

        verify(introductionMapper, times(3)).deleteById(anyInt());
    }

    @Test
    void updateById() {
        Introduction introduction = new Introduction();
        introduction.setId(1);
        introduction.setName("Updated Name");

        introductionService.updateById(introduction);

        verify(introductionMapper, times(1)).updateById(introduction);
    }

    @Test
    void selectById() {
        Introduction expectedIntroduction = new Introduction();
        expectedIntroduction.setId(1);
        expectedIntroduction.setName("Test Name");

        when(introductionMapper.selectById(1)).thenReturn(expectedIntroduction);

        Introduction result = introductionService.selectById(1);

        assertEquals(expectedIntroduction, result);
        verify(introductionMapper, times(1)).selectById(1);
    }

}