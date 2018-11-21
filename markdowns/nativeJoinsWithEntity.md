# Adding joins with entity mapping.

*	We can also use addEntity() and addJoin() methods to fetch the data from associated table using tables join. The above query can be re-written as following;

@[A quick sample. Check out the JAVA class and SQL file]({"stubs": ["src/main/java/com/tu/nativesqlsample/NativeQueryNativeJoinWithEntity.java","src/main/resources/schema.sql"], "command": "com.tu.nativesqlsample.NativeQueryNativeJoinWithEntityTest#testNativeJoinWithEntity"})

*	Notice the second query, which fetches the Domain details. This is the eager Loading of the requested object
*	[aliasname].* is used to return all properties of an entity. When we use addEntity() and addJoin() with join queries like above it returns both the objects, as shown above.