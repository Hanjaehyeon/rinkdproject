# rinkdproject

![logo-removebg-preview](https://user-images.githubusercontent.com/62926717/85275378-376d1080-b4bb-11ea-8bf9-30b39bdbd201.png)


### rinkdproject
## rinkdproject

>인용이다

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        ref = FirebaseDatabase.getInstance ().getReference ().child ("Deal").child ( "rana" );
        recyclerView = findViewById ( R.id.rv );
        searchView = findViewById ( R.id.searchView );
    }
    
```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        ref = FirebaseDatabase.getInstance ().getReference ().child ("Deal").child ( "rana" );
        recyclerView = findViewById ( R.id.rv );
        searchView = findViewById ( R.id.searchView );
    }
    ```
    
    
    ~~하기싫다~~
