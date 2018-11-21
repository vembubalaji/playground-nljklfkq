# Welcome!

Hibernate provide option to execute native SQL queries through the use of SQLQuery object. Hibernate SQL Query is very handy when we have to execute database vendor specific queries that are not supported by Hibernate API. For example query hints or the CONNECT keyword in Oracle Database.

Considering the below entity relationship. We would be discussing the below points;

![Alt text](markdowns/ERDDiagram.png)

**1**	&nbsp;Creating Native queries with createNativeQuery<br/>
**2**	&nbsp;Use parameter binding in native SQL queries.<br/>
**3**	&nbsp;Adding scalars <br/>
**4**	&nbsp;Joins <br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.1	Native Joins<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.2	Adding joins with entity mapping. This is for adding entity via eager loading<br/>
**5**	&nbsp;Iterating through the result set and constructing the Beans<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5.1	Querying with Entity mapping<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5.2	basic Result set mapping using @SqlResultSetMapping<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5.3	Mapping Non-managed entities via result transformer<br/>
**6**	&nbsp;Using @NamedNativeQuery<br/>
