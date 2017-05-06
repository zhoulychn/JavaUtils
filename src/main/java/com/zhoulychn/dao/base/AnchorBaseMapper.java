package com.zhoulychn.dao.base;

import com.zhoulychn.bean.entity.AnchorBase;
import com.zhoulychn.bean.entity.AnchorBaseExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AnchorBaseMapper {
    long countByExample(AnchorBaseExample example);

    int deleteByExample(AnchorBaseExample example);

    int deleteByPrimaryKey(String url);

    int insert(AnchorBase record);

    int insertSelective(AnchorBase record);

    List<AnchorBase> selectByExampleWithRowbounds(AnchorBaseExample example, RowBounds rowBounds);

    List<AnchorBase> selectByExample(AnchorBaseExample example);

    AnchorBase selectByPrimaryKey(String url);

    int updateByExampleSelective(@Param("record") AnchorBase record, @Param("example") AnchorBaseExample example);

    int updateByExample(@Param("record") AnchorBase record, @Param("example") AnchorBaseExample example);

    int updateByPrimaryKeySelective(AnchorBase record);

    int updateByPrimaryKey(AnchorBase record);
}
