# rinkdproject

## 목차
* 하단버튼
* Home Fragment
  * 지도
* Star Fragment
* Person Fragment

***


### 하단버튼



##### bottom_nav_menu.xml
```java
<item
        android:id="@+id/navigation_home"
        android:icon="@drawable/ic_home_white"
        android:title="@string/title_home" />
```
> bottom navigation 사용 -> menu 레이아웃에서 사용할 갯수만큼 item 추가



##### BottomActivity.java
```java
 //5가지 fragment 객체 선언
    private HomeFragment homeFragment = new HomeFragment();
    private HeartFragment heartFragment = new HeartFragment();
    private PersonFragment personFragment = new PersonFragment();
    private StarFragment starFragment = new StarFragment();
    private DrinkFragment drinkFragment = new DrinkFragment();

  //처음 화면을 homefragment로 지정
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout,homeFragment).commitAllowingStateLoss();

   // 메뉴 아이템이 선택될때 호출될 리스너 등록
   // home, heart, person, star, drink 다섯가지 fragment
       navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.navigation_home:{
                        transaction.replace(R.id.frame_layout,homeFragment).commitAllowingStateLoss();
                        break;
                    }
```
> 각각의 버튼에 연결되는 fragment를 4개 생성   
> 화면을 띄울 액티비티를 생성한 후 4가지 fragment 객체를 선언   
> 메뉴 아이템이 선택될 때 호출될 리스너를 등록



##### activity_bottom.xml
```java
<FrameLayout
        android:id="@+id/frame_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginBottom="?attr/actionBarSize"/>

    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/nav_view"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="0dp"
        android:layout_marginEnd="0dp"
        android:background="?android:attr/windowBackground"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:menu="@menu/bottom_nav_menu" />
```
> 액티비티 xml 파일에는 fragment를 띄울 FrameLayout과 하단 버튼을 띄워줄   
BottomNavigationView를 생성해준다.



##### mobile_navigation.xml
```java
<fragment
        android:id="@+id/navigation_home"
        android:name="com.example.rinkdproject.ui.home.HomeFragment"
        android:label="@string/title_home"
        tools:layout="@layout/fragment_home" />
```
> navigation 레이아웃에서 5가지 item의 fragment를 선언하여 id를 부여한 후 각각의 xml을 Layout에 넣어준다.


***

### Home Fragmet(지도, 랜덤사진)
#### 지도


##### MapActivity.java
```java
//주변 카페 검색 버튼 리스트
 Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                mMap.clear();//지도 클리어
                if (previous_marker != null)
                    previous_marker.clear();//지역정보 마커 클리

                new NRPlaces.Builder()
                        .listener(MapActivity.this)

                        .key("AIzaSyCMuLQLIJiPwLDSrvqWrvOZAZTSvcWTpC8")

                        .latlng(currentPosition.latitude, currentPosition.longitude)//현재 위치

                        .radius(5000) //5000 미터 내에서 검색

                        .type(PlaceType.CAFE) //카페

                        .build()

                        .execute();
            }
        });  
```
> 버튼을 하나 생성하고 클릭 리스너로 현재 위치 주변에 있는 카페의 위치를 띄워 핀(marker)로 나타내준다.   
> 현재 위치에서 반경 5000미터 내에 있는 카페의 장소를 검색


> Google Places API키를 생성해야함       
> key("")안에 API 입력    



```java
public void onPlacesSuccess(final List<Place> places) {
        Log.i("PlacesAPI", "onPlacesSuccess()");
        runOnUiThread(new Runnable() {

            @Override

            public void run() {

                for (noman.googleplaces.Place place : places) {
                    LatLng latLng = new LatLng(place.getLatitude(), place.getLongitude());
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(latLng);
                    markerOptions.title(place.getName());
                    markerOptions.snippet(place.getVicinity());
                    Marker item = mMap.addMarker(markerOptions);
                    previous_marker.add(item);
                }
                //중복 마커 제거
                HashSet<Marker> hashSet = new HashSet<Marker>();
                hashSet.addAll(previous_marker);
                previous_marker.clear();
                previous_marker.addAll(hashSet);
            }

        });
    }
```
> 카페 위치에 마커를 띄워줄 메소드를 생성한다.


***

### Star Fragment(프랜차이즈 목록 띄우기)


##### Cafe.java

```java
String name;
    int image;
    Intent intent;
    
    public Cafe(int image, String name) {
        this.image = image;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getImage(){
        return image;
    }
    public Intent getIntent(){
        return intent;
    }
```
> 아이템 클래스(Cafe)와 어댑터 클래스(CafeAdapter)생성    
> 아이템 클래스에 이미지와 이름을 받아올 생성자와 get/set 메소드를 만들어준다. (반환형 )



##### CafeAdapter
```java
public class CafeAdapter extends RecyclerView.Adapter<CafeAdapter.ViewHolder> implements OnCafeItemClickListener {
```
> 리사이클러뷰를 상속받는 어댑터 생성    
> OnCafeItemClickListener 인터페이스 구현    


```java
ArrayList<Cafe> items = new ArrayList<Cafe>();
OnCafeItemClickListener listener;
```
> 어댑터 클래스에 아이템들을 받아줄 리스트와 클릭 리스너를 선언해준다.   


```java
public void onBindViewHolder(@NonNull ViewHolder viewholder, int position) {
        Cafe item = items.get(position);
        viewholder.setItem(item);
    }
```
> 아이템 뷰를 ViewHolder에 저장해준다.


```java
public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView, final OnCafeItemClickListener listener){
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(listener != null){
                        listener.onItemClick(ViewHolder.this,view,position);
                    }
                }
            });
        }
        public void setItem(Cafe item){
            textView.setText(item.getName());
            imageView.setImageResource(item.getImage());
        }
    }
```
> 프랜차이즈 로고 사진을 받아올 이미지뷰와 매장 이름을 표시해줄 텍스트뷰를 선언하고,    
findViewById를 사용해 xml 레이아웃에서 정의한 뷰를 참조해준다.


> 아이템 position을 받아와 아이템뷰 클릭 리스너도 설정해준다.


#### StarFragment.java
```java
RecyclerView recyclerView = view.findViewById(R.id.layout1);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(layoutManager);
```
> 아이템들을 나열해서 보여줄 리사이클러뷰를 선언한 후, 레이아웃에서 정의한 뷰를 참조하고    
> 그리드 레이아웃을 사용해 한줄에 3개씩 아이템을 나열하도록 설정해준다.


```java
final CafeAdapter adapter = new CafeAdapter();
```
> 아이템들을 받아줄 CafeAdapter 선언


```java
adapter.addItem(new Cafe(R.drawable.venti,"더 벤티"));
        adapter.addItem(new Cafe(R.drawable.bbaek,"빽다방"));
        adapter.addItem(new Cafe(R.drawable.palgong,"팔공티"));
        adapter.addItem(new Cafe(R.drawable.chayam,"차얌"));
        recyclerView.setAdapter(adapter);
```
> addItem 메소드를 사용하여 리사이클러뷰에 띄울 어댑터 이미지, 텍스트뷰를 저장해준다.    
> 이때 이미지는 drawable에 저장한 후 불러온다.


```java
adapter.setOnItemClickListener(new OnCafeItemClickListener() {
            @Override
            public void onItemClick(CafeAdapter.ViewHolder holder, View view, int position) {
                Cafe item = adapter.getItem(position);
                switch (position){
                    case 0:
                        Intent intent = new Intent(getActivity(), GongchaActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(getActivity(), EdiyaActivity.class);
                        startActivity(intent2);
                        break
```
> switch문을 이용해 클릭 이벤트를 만들어 아이템을 클릭했을 때 해당 카페의 activity로 이동하도록 설정

> position으로 아이템 구분   
> Intent 사용하여 activity로 전환


```java
public interface OnCafeItemClickListener {
    public void onItemClick(CafeAdapter.ViewHolder holder, View view, int position);
}
```
> OncafeItemClickListener 인터페이스 생성


#### Layout1.xml


```java
<androidx.cardview.widget.CardView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:cardBackgroundColor="#FFFFFFFF"
        app:cardCornerRadius="10dp"
        app:cardElevation="5dp"
        app:cardUseCompatPadding="true">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:orientation="vertical">

            <ImageView
                android:id="@+id/imageView"
                android:layout_margin="5dp"
                android:layout_width="match_parent"
                android:layout_height="90dp" />

            <TextView
                android:id="@+id/textView"
                android:layout_margin="5dp"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:gravity="center" />

        </LinearLayout>
    </androidx.cardview.widget.CardView>
```
> 프랜차이즈 로고 사진과 카페 이름을 띄울 아이템 레이아웃 생성

> CardView를 이용해 이미지뷰와 텍스트뷰를 깔끔하게 정리   
> 이때, 이미지와 텍스트는 LinearLayout vertical로 정의


#### fragment_star.xml


```java
<FrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/layout1"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

    </FrameLayout>
```
> 프래그먼트 xml 레이아웃에는 FrameLayout 안에 아이템을 나열해줄    
> 리사이클러뷰를 생성한다.
