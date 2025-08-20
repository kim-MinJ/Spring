package org.myclass.myboard.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.myclass.myboard.dto.CommentsDto;

@Mapper
public interface CommentsMapper {
    int cmtInsert(CommentsDto dto);

    int cmtDelete(int idx);
}
