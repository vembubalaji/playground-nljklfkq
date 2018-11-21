# Use parameter binding in native SQL queries.

From JPA 2.1 onwards, to create native Queries, we can use the org.hibernate.Session object’s createNativeQuery method to create and execute Native Queries
```java
List<Object[]> users1 = session.createNativeQuery(
	"SELECT user_Id,name,username,isadmin,region_id,team_id,domain_id FROM user").list();
			
users1.stream().forEach(objects -> {
				Integer id = (Integer) objects[0];
				String name = (String) objects[1];
				if (logger.isLoggable(Level.INFO)) {
					logger.info(String.format("User[ %d, %s ]", id, name));
				}
			});
```

In the above query, if there needs to be a where case, the same can be done via parameter binding

@[A quick sample. Check out the JAVA class and SQL file]({"stubs": ["src/main/java/com/tu/nativesqlsample/NativeQueryParameterBinding.java","src/main/java/com/tu/hibernate/schema.sql"], "command": "com.tu.nativesqlsample.NativeQueryParameterBindingTest#testParameterBinding"})

* Here, we filter the query based on the user_id. In the query, the ‘?’ acts as a place-holder for setting the parameter and the .setParameter(1,1) sets the value to the place-holder. In the setParameter, the first parameter is the placeholder position and the send parameter is the value for the placeholder.
* Hibernate uses the ResultSetMetadata to deduce the type of the columns returned by the query. 
