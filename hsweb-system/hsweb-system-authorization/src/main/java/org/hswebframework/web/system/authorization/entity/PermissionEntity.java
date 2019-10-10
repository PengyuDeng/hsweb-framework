package org.hswebframework.web.system.authorization.entity;

import lombok.Getter;
import lombok.Setter;
import org.hswebframework.ezorm.rdb.mapping.annotation.ColumnType;
import org.hswebframework.ezorm.rdb.mapping.annotation.Comment;
import org.hswebframework.ezorm.rdb.mapping.annotation.JsonCodec;
import org.hswebframework.web.crud.entity.GenericEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.sql.JDBCType;
import java.util.List;
import java.util.Map;

@Table(name = "s_permission")
@Getter
@Setter
public class PermissionEntity  extends GenericEntity<String> {

    @Column
    @Comment("权限名称")
    private String name;

    @Column
    @Comment("说明")
    private String describe;

    @Column
    @Comment("状态")
    private Byte status;

    @Column
    @ColumnType(jdbcType = JDBCType.LONGVARCHAR)
    @JsonCodec
    @Comment("可选操作")
    private List<ActionEntity> actions;

    @Column(name = "optional_fields")
    @ColumnType(jdbcType = JDBCType.LONGVARCHAR)
    @JsonCodec
    @Comment("可操作的字段")
    private List<OptionalField> optionalFields;

    @Column
    @ColumnType(jdbcType = JDBCType.LONGVARCHAR)
    @JsonCodec
    @Comment("关联权限")
    private List<ParentPermission> parents;

    @Column
    @ColumnType(jdbcType = JDBCType.LONGVARCHAR)
    @JsonCodec
    @Comment("其他配置")
    private Map<String, Object> properties;

}