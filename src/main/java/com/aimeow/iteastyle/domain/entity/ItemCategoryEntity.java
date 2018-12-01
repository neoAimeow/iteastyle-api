package com.aimeow.iteastyle.domain.entity;

        import com.aimeow.domain.BaseEntity;
        import lombok.Data;
        import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ItemCategoryEntity extends BaseEntity {
    private String id;
    private String name;
    private String description;
}
