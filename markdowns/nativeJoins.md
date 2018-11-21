# Native Joins

*	If we would like to get data from both User and team based on the user table, we can use native joins. In this case, we are using the left outer join

({"stubs": ["src/main/java/com/tu/nativesqlsample/NativeQueryNativeJoin.java"], "command": "com.tu.nativesqlsample.NativeQueryNativeJoinTest#testNativeJoin"})

*	Notice that the returned Object List are the columns requested.
*	To ensure eager loading of associated tables we can use addJoin and addEntity.