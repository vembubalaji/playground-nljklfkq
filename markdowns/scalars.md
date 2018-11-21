# Adding scalars

*	To avoid the overhead of using ResultSetMetadata, or simply to be more explicit in what is returned, we use scalars while creating Native Queries

@[A quick sample. Check out the JAVA class and SQL file]({"stubs": ["src/main/java/com/tu/nativesqlsample/NativeQueryScalars.java","src/main/resources/schema.sql"], "command": "com.tu.nativesqlsample.NativeQueryNativeScalarsTest#testAddScalar"})

*	In this case, only domain_id and domainName would be returned back, though, we have requested for * from the table. 
*	Also, we would still be returned with an array of Object – List<Object[]>, but now it will not use the ResultSetMetadata to determine the type of columns, but will instead explicitly get the domain_id, and domainName column as respectively a Integer, and a String from the underlying resultset. 
*	Adding scalars to native Queries is preferable, considering the reduced overhead on the ResultSetmetaData and a marginal improvement on the performance. 