# JPA 入门基础集合


> 本演示代码搭配语雀JPA入门文档食用。 [JPA入门文档](https://www.yuque.com/adong-d5rq6/dxlx9e/eb0b4imolyakwsqh)


### 示例演示

[复合主键示例](composite-key) 一份表格的多个字段组成的复合主键。

[embedded嵌入式实体演示](embedd-embeddable)：嵌套一份带有`@Embeddabled`实体至另一份`@Entity`实体中，并用`@Embedded`
标注实体属性，在映射时`@Entity`实体会附带另一份实体的字段。

[多表映射演示](multitable-mapping)：涉及`@SecondaryTable`注解，单个实体映射至多个表格。

[一对多多对一，双向关联](one2many-many2one)：涉及`@ManyToOne` `@OneToMany` `@JoinColumn` 等注解，双向关联为相互关系维护的一种方式。

[一对一](one2one)：表与表之间的一种外键维护关系。

[查询方法](query-method)：涉及 方法名查询，自定义查询方法，`@Query`创建SQL查询，Example动态查询，排序与分页查询。

