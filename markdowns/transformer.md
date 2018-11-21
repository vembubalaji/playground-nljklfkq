# Mapping Non-managed entities via result transformer

*	Until now, we have been mapping result sets to specific entities, what if we want to map the result set directly onto a JavaBean rather than an entity. For this, we can us the Result transformer
*	Here again, we have implicit transformer, explicit transformers. 
*	For Implicit transformation, we would use the Transformers.aliasToBean method. Here the understanding is that the columns returned from the result set have the same naming convention with that of the mapped JavaBean. In this case, the CustomDTO’s attributes.
*	In case the columns returned from the result set names does not match the names on the mapped JavaBean attributes, and then we opt for the explicit transformation. 


@[A quick sample. Check out the JAVA class and SQL file]({"stubs": ["src/main/java/com/tu/nativesqlsample/ResutlSetConstructionTransformer.java","src/main/resources/schema.sql"], "command": "com.tu.nativesqlsample.ResultSetConstructionTest#testtransformer"})

