package org.myclass.myboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.myclass.myboard.dto.ComunityDto;
import org.myclass.myboard.dto.ComunitySearchDto;

@Mapper
public interface ComunityMapper {
    List<ComunityDto> selectAll();

    List<ComunityDto> searchAll(ComunitySearchDto dto);

    int insert(ComunityDto dto);

    int update(ComunityDto dto);

    int delete(int idx);

}
