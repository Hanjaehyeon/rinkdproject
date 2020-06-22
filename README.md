# rinkdproject

## 목차
* 하단버튼
* Home Fragment
  * 지도
* Star Fragment
* Person Fragment

***


### 하단버튼

bottom navigation 사용 -> menu 레이아웃에서 사용할 갯수만큼 item 추가


###### bottom_nav_menu.xml
```java
<item
        android:id="@+id/navigation_home"
        android:icon="@drawable/ic_home_white"
        android:title="@string/title_home" />
```


>각각의 버튼에 연결되는 fragment를 4개 생성   
>화면을 띄울 액티비티를 생성한 후 4가지 fragment 객체를 선언   
>메뉴 아이템이 선택될 때 호출될 리스너를 등록




###### BottomActivity.java
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
>액티비티 xml 파일에는 fragment를 띄울 FrameLayout과 하단 버튼을 띄워줄
BottomNavigationView를 생성해준다.



###### activity_bottom.xml
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
>navigation 레이아웃에서 5가지 item의 fragment를 선언하여 id를 부여한 후 각각의 xml을 Layout에 넣어준다.



###### mobile_navigation.xml
```java
<fragment
        android:id="@+id/navigation_home"
        android:name="com.example.rinkdproject.ui.home.HomeFragment"
        android:label="@string/title_home"
        tools:layout="@layout/fragment_home" />
```

***

### Home Fragmet(지도, 랜덤사진)
#### 지도


버튼을 하나 생성하고 클릭 리스너로 현재 위치 주변에 있는 카페의 위치를 띄워 핀(marker)로 나타내준다.

Google Places API키를 생성해야함

현재 위치에서 반경 5000미터 내에 있는 카페의 장소를 검색

key("")안에 API 입력


###### MapActivity.java
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
>카페 위치에 마커를 띄워줄 메소드를 생성한다.


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

***

### Star Fragment(프랜차이즈 목록 띄우기)



아이템 클래스(Cafe)와 어댑터 클래스(CafeAdapter)생성

아이템 클래스에 이미지와 이름을 받아올 생성자와 get/set 메소드를 만들어준다.

반환형 주의

###### Cafe.java
