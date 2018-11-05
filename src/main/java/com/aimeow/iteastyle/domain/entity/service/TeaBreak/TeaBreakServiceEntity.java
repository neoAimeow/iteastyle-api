package com.aimeow.iteastyle.domain.entity.service.TeaBreak;

import com.aimeow.domain.BaseEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.note.TeaBreakNoteEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.order.TeaBreakOrderEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.orderMode.TeaBreakOrderModeEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.process.TeaBreakProcessEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaBreak.range.TeaBreakRangeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class TeaBreakServiceEntity extends BaseEntity {
    private TeaBreakOrderEntity order;
    private TeaBreakRangeEntity range;
    private TeaBreakProcessEntity process;
    private TeaBreakNoteEntity note;
    private TeaBreakOrderModeEntity orderMode;

}
