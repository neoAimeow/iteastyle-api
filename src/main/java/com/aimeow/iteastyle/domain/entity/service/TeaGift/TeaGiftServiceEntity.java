package com.aimeow.iteastyle.domain.entity.service.TeaGift;

import com.aimeow.domain.BaseEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaGift.Souvenir.TeaGiftSouvenirEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaGift.drinkWay.TeaGiftWayEntity;
import com.aimeow.iteastyle.domain.entity.service.TeaGift.mind.TeaGiftMindEntity;
import lombok.Data;

@Data
public class TeaGiftServiceEntity extends BaseEntity {
    private TeaGiftSouvenirEntity souvenir;
    private TeaGiftWayEntity way;
    private TeaGiftMindEntity mind;
}
