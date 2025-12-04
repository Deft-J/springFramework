package com.coder.mapper;

import com.coder.entity.ChangeRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordMapper {
    // 新增充值|消费记录
    void saveRecord(ChangeRecord changerecord);
}
