# Welcome!

•	In case the columns returned from the result set names does not match the names on the mapped JavaBean attributes, and then we opt for the explicit transformation. 

@[A quick sample. Check out the JAVA class and SQL file]({"stubs": ["src/main/java/com/tu/nativesqlsample/NativeQueryParameterBinding.java","src/main/resources/schema.sql","src/main/java/com/tu/hibernate/CustomResultTransformer.java"], "command": "com.tu.nativesqlsample.NativeQueryParameterBindingTest#testCustomTransformer"})


•	Here, we would implement ResultTransformer interface and override the transformTuple and transformList methods. 
•	The actual object building logic is present in the transformTuple method. The input argument for the method are an object array of the column alias (aliases) and respective column values (tuple). 
•	Please note, this has been depreciated since hibernate v5.2, with no new approach being proposed- https://discourse.hibernate.org/t/hibernate-resulttransformer-is-deprecated-what-to-use-instead/232