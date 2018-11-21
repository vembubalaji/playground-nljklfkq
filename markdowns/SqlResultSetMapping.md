# Basic Result set mapping using @SqlResultSetMapping

@[A quick sample. Check out the JAVA class and SQL file]({"stubs": ["src/main/java/com/tu/nativesqlsample/ResutlSetConstructionSqlResultSetMapping.java","src/main/resources/schema.sql","src/main/java/com/tu/hibernate/entity/Domain.java"], "command": "com.tu.nativesqlsample.ResultSetConstructionTest#testSqlResultSetMapping"})

*	If the column names of the query result does not match the column names of the entity mapping, then we would have to map the two manually. We can do this using the @SqlResultSetmapping, which specifies the mapping for each attribute. 
*	As we can see from the above code, the @SqlResultSetMapping constitutes of a name attribute and a @EntityResult annotation that defines the mapping to the entity.
*	Now, we need to specify the class of the entity and a set of @FieldResult annotation that defines the mapping between the result set column and the entity attribute.
*	To utilize this mapping in the createNativeQuery method we can provide its name as the second parameter. Check the above code snip.
