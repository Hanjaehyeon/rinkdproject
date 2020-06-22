# rinkdproject

![logo-removebg-preview](https://user-images.githubusercontent.com/62926717/85275378-376d1080-b4bb-11ea-8bf9-30b39bdbd201.png)


### rinkdproject
## rinkdproject

>인용이다

하기싫다 ~~하기싫다~~


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
 중간에 글자를 넣을 수 있나?
 
 ```java
 @Override
    protected void onStart() {
        super.onStart ();
        if(ref != null){
            ref.addValueEventListener ( new ValueEventListener () {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists ()){
                        list=new ArrayList<>();

                        for(DataSnapshot ds : dataSnapshot.getChildren ()){
                            list.add(ds.getValue (Deal.class));
                        }
                        AdapterClass adapterClass = new AdapterClass(list);
                        recyclerView.setAdapter ( adapterClass );
                    }
                }
```
