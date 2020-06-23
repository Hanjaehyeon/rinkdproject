# rinkdproject

# [목차]   
## 1.소개     
1-1. 어플 소개    
1-2. 어플의 기능    
1-3. 주제 선정 이유    
1-4. 개발 툴 & 개발 언어

   
## 2.주차별 계획표
   

## 3.기능 구현    
3-1. 홈 카테고리   
       - Google API   
3-2. 프랜차이즈 카테고리    
3-3. 음료 카테고리    
       - FireBase    
3-4. 검색 카테고리


## 4.구현 사진


## 5.마무리     
5-1. 맡은 부분    
5-2. 개선 방안     
5-3. 프로젝트 소감

***


### 어플 소개

* 프랜차이즈 카페의 종류, 메뉴를 한눈에 볼 수 있는 어플


***


### 어플의 기능   
1. 메뉴 결정이 어려운 소비자를 위한 음료 추천   


2. 내 주변에 있는 카페의 위치를 알 수 있음  


3. 프랜차이즈 카페마다 어떤 메뉴가 있는지 보기 쉽게 정리    


4. 카테고리별로 음료를 분류해 보기 쉽게 정리       


5. 어떤 음료와 프랜차이즈가 있는지 검색


***

### 주제 선정 이유


> 점점 늘어가는 프랜차이즈 카페, 그만큼 카페의 종류도 음료의 종류도 매우 많아져   
    소비자 스스로 메뉴를 일일히 검색해봐야하는 불편함    

> 프랜차이즈 카페마다 어떤 음료가 있는지 궁금하지만 한눈에 보기 어려움    

> 어떤 음료를 마실지 고민되지만 음료에 대해 잘 모르는 소비자를 위한 어플


***

### 개발 툴

* 안드로이드 스튜디오
![android_studio_logo](https://user-images.githubusercontent.com/62926717/85362786-5078ce80-b55a-11ea-85de-b7971ccfe7f2.png)


* 파이어베이스   
![firebase_logo](https://user-images.githubusercontent.com/62926717/85362928-ad748480-b55a-11ea-96a2-cbc86549d3fb.jpg)


### 개발 언어

* JAVA   
![java_logo](https://user-images.githubusercontent.com/62926717/85363139-1a881a00-b55b-11ea-9d70-aeae08cfe0d0.png)


***

## 주차 별 프로젝트 계획표

<img width="800" alt="grayshakeitya" src="https://user-images.githubusercontent.com/62926717/85366240-e6fcbe00-b561-11ea-90e5-f1587d0347d3.PNG">


***


## 코드



#### Google API키 발급받기

<https://console.developers.google.com/apis/dashboard?project=rinkd-281206&folder=&organizationId=>

프로젝트 이름을 정하고 생성한 뒤, 위의 링크로 접속하여 구글API키를 발급 받아야한다.


1. 프로젝트 만들기를 클릭한다.     
<img width="746" alt="googleApi1-1" src="https://user-images.githubusercontent.com/62926717/85369303-d7807380-b567-11ea-8697-bea73517731c.png">    


2. 원하는 프로젝트 이름을 작성한 뒤, '만들기'를 클릭한다.      
<img width="654" alt="googleApi2" src="https://user-images.githubusercontent.com/62926717/85369449-17dff180-b568-11ea-8f35-ad9b2d2fc2af.PNG">     


3. 생성된 프로젝트에서 'API 및 서비스 사용 설정'을 클릭한다.     
<img width="634" alt="googleApi3-1" src="https://user-images.githubusercontent.com/62926717/85369614-5d042380-b568-11ea-8956-c816042a6ee8.png">     


4. 검색창에 'google maps android'를 검색하고 Maps SDK for Android를 클릭한다.     
<img width="723" alt="googleApi5" src="https://user-images.githubusercontent.com/62926717/85369778-b1a79e80-b568-11ea-95d0-64c75aefa19e.PNG">     



5. '사용'을 클릭해 활성화한다.     
<img width="481" alt="googleApi6" src="https://user-images.githubusercontent.com/62926717/85369913-e9aee180-b568-11ea-8503-af16d7e35101.PNG">      


6. 인증 설정을 위해 '사용자 인증 정보 만들기'를 클릭한다.     
<img width="656" alt="googleApi8-1" src="https://user-images.githubusercontent.com/62926717/85370431-ad2fb580-b569-11ea-92ce-eb90c222c825.png">


7. 앞에서 생성된 API 키에 사용 제한을 둘 수 있는 웹페이지에서 '키 제한'을 클릭한다.
<img width="394" alt="googleApi9-1" src="https://user-images.githubusercontent.com/62926717/85370603-e8ca7f80-b569-11ea-94e8-8bc40c55cd84.png">


8. 애플리케이션 제한사항에서 'Android앱'을 선택한다.    
<img width="274" alt="googleApi10" src="https://user-images.githubusercontent.com/62926717/85370657-00096d00-b56a-11ea-94bb-7871f80edef5.PNG">


9. 여기서, 패키지 이름과 SHA-1 인증서 지문을 필요로 하는데   패키지 이름은 현재 만든 프로젝트의 MainActivity.java의 프로젝트를 말한다.     
<img width="264" alt="googleApi11" src="https://user-images.githubusercontent.com/62926717/85370772-31823880-b56a-11ea-884f-b2c886530f04.PNG">


10. SHA-1 인증서 지문을 받아오기 위해 윈도우 키 + R을 눌러 cmd을 입력하고 명령 프롬프트 창을 불러온다.    
<img width="300" alt="googleApi12" src="https://user-images.githubusercontent.com/62926717/85370892-668e8b00-b56a-11ea-83c6-74cca4a62e9b.PNG">


11. 윈도우에서는 다음 명령으로 SHA-1 인증서 지문을 획득할 수 있다.    

```
"C:\Program Files\Android\Android Studio\jre\bin\keytool" -list -v -keystore "%USERPROFILE%\.android\debug.keystore" -alias androiddebugkey -storepass android -keypass android
```


12. 사진에서 하얗게 표시한 부분인 SHA-1 옆에 있는 문자열을 복사한다.    
<img width="850" alt="googleApi13" src="https://user-images.githubusercontent.com/62926717/85371413-28de3200-b56b-11ea-9390-b0707cbf2362.PNG">


13. '완료'를 클릭한 뒤 '저장'을 클릭해준다.    
<img width="251" alt="googleApi14 완료 누르고 저장" src="https://user-images.githubusercontent.com/62926717/85371538-57f4a380-b56b-11ea-889c-6bdb067cf6ca.PNG">


14. Place API를 사용하는 경우에도 똑같은 방법으로 방금 복사한 SHA-1의 문자열을 입력하고 저장해준다.


15. 그리고 마지막으로 AndroidManifest.xml 파일에서 다음과 같이 코드를 추가한다.
```
<meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="API 키"/>
```


출처 : 멈춤보단 천천히라도      
https://webnautes.tistory.com/647

***



#### 하단버튼 만들기

##### bottom_nav_menu.xml


* bottom navigation을 사용한다.
* menu 레이아웃에서 사용할 갯수만큼 item을 추가한다.
```java
<item
        android:id="@+id/navigation_home"
        android:icon="@drawable/ic_home_white"
        android:title="@string/title_home" />
```




##### BottomActivity.java

* 각각의 Button에 연결되는 4개의 Fragment를 생성한다.
* 화면을 띄울 Activity를 생성한 후, Fragment 객체를 선언한다.
* menu 아이템이 선택될 때 호출될 Listener를 등록한다.
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



##### activity_bottom.xml

* activity_bottom.xml 파일에는 Fragment를 띄울 FrameLayout과 하단 Button을 띄워줄    
BottomNavigationView를 생성해준다.
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



##### mobile_navigation.xml

* navigation 레이아웃에서 5가지 아이템의 Fragment를 선언하여 id를 부여한 후    
각각의 xml을 Layout에 넣어준다.
```java
<fragment
        android:id="@+id/navigation_home"
        android:name="com.example.rinkdproject.ui.home.HomeFragment"
        android:label="@string/title_home"
        tools:layout="@layout/fragment_home" />
```


***

본격적으로 차근차근히 코드를 구현해보자.


***

### 홈 카테고리(지도, 추천 음료)
#### 지도


##### MapActivity.java

* Button을 하나 생성하고, ClickListener로 현재 위치 주변의 카페 위치를 Marker로 나타내준다.    
* Google Places API키를 생성해야 한다.    
* 현재 위치에서 반경 5000미터 내 카페 장소를 검색해준다.   
* key("")안에 발급받은 API를 입력한다.
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

* 검색된 카페 위치에 Marker를 띄워줄 메소드를 생성한다.


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

### 프랜차이즈 카테고리(프랜차이즈 목록 띄우기)

##### Cafe.java

* 아이템 클래스(Cafe.java)와 어댑터 클래스(CafeAdapter.java)를 생성한다.    
* 아이템 클래스에 이미지, 이름을 받아올 생성자와 get/set 메소드를 만들어준다. (*반환형 주의*)

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


##### CafeAdapter

* recyclerView를 상속받기 전에, build.gradle > Module:app에 다음과 같이 코드를 추가하고 Sync해준다.

```
implementation 'androidx.recyclerview:recyclerview:1.1.0'
```

* recyclerView를 상속받는 Adapter를 생성해준다.   
* OnCafeItemClickListener 인터페이스를 구현한다.


```java
public class CafeAdapter extends RecyclerView.Adapter<CafeAdapter.ViewHolder> implements OnCafeItemClickListener {
``` 

* Adapter 클래스에 아이템들을 받아줄 ArrayList와 CilckListener를 선언해준다.


```java
ArrayList<Cafe> items = new ArrayList<Cafe>();
OnCafeItemClickListener listener;
``` 

* 아이템 뷰를 ViewHolder에 저장해준다.     
```java
public void onBindViewHolder(@NonNull ViewHolder viewholder, int position) {
        Cafe item = items.get(position);
        viewholder.setItem(item);
    }
```

* 프랜차이즈 로고 사진을 받아올 imageView와 매장 이름을 표시해줄 TextView를 선언한다.    
* findViewById를 사용해 xml레이아웃에서 정의한 view를 참조해준다.   
* 아이템 position을 받아와 아이템 뷰 ClickListener도 설정해준다.


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




#### StarFragment.java

* 아이템들을 나열해서 보여줄 recyclerView를 선언한 후 레이아웃에서 정의한 view를 참조한다.    
* GridLayout을 사용해 한줄에 3개씩 아이템을 나열하도록 설정해준다.


```java
RecyclerView recyclerView = view.findViewById(R.id.layout1);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(layoutManager);
```


* 아이템들을 받아줄 CafeAdapter를 선언한다.


```java
final CafeAdapter adapter = new CafeAdapter();
```


* addItem 메소드를 사용하여 recyclerView에 띄울 Adapter에 image,textview를 저장해준다.    
* 이때 카페 로고의 이미지는 drawable에 저장한 후 불러온다.


```java
adapter.addItem(new Cafe(R.drawable.venti,"더 벤티"));
        adapter.addItem(new Cafe(R.drawable.bbaek,"빽다방"));
        adapter.addItem(new Cafe(R.drawable.palgong,"팔공티"));
        adapter.addItem(new Cafe(R.drawable.chayam,"차얌"));
        recyclerView.setAdapter(adapter);
```


* switch문을 사용해 ClickEvent를 만들고 아이템을 클릭했을 때 해당 Cafe.java Activity로 이동하도록 설정한다.    
* position으로 아이템 구분   
* Intent 사용하여 Activity로 전환한다.


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

* OnCafeItemClickListener 인터페이스를 생성한다.
```java
public interface OnCafeItemClickListener {
    public void onItemClick(CafeAdapter.ViewHolder holder, View view, int position);
}
```



#### Layout1.xml

* 프랜차이즈 로고 사진과 카페 이름을 띄워줄 아이템 레이아웃을 생성한다.   
* CardView를 사용해 imageview와 textview를 깔끔하게 정리한다.    
* 이때 image와 text는 LinearLayout vertical로 정의한다.


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


#### fragment_star.xml

* Fragment의 xml 레이아웃에는 FrameLayout 안에 아이템을 나열해줄 recyclerview를 생성한다.


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



***


### 음료 카테고리

#### Firebase 연결

1. build.gradle > Moduel:app에 다음 코드를 추가하고 Sync한다.
```
implementation 'com.google.firebase:firebase-database:19.3.1'
implementation 'com.google.firebase:firebase-storage:19.1.1'
implementation 'com.firebaseui:firebase-ui-storage:3.2.2'
implementation 'com.github.bumptech.glide:glide:4.10.0'
annotationProcessor 'com.github.bumptech.glide:compiler:4.10.0'
```

2. 안드로이드 스튜디오에서 상단바에 있는 Tools을 선택하고 Firebase를 클릭한다.
<img width="600" alt="firebase2" src="https://user-images.githubusercontent.com/62926717/85379095-567ca880-b576-11ea-8825-dafc6c9bc30b.PNG">

3. Firebase assistant창 에서 firebase와 연동하기 위해 'Realtime Database'를 선택하고 Save and retrieve data를 클릭한다.
<img width="600" alt="firebase3" src="https://user-images.githubusercontent.com/62926717/85379925-474a2a80-b577-11ea-8652-93f7f065d86a.PNG">


4. 1,2번 둘 다 연결이 되지않은 상태이므로 차례대로 1번 'Connect to Firebase'를 클릭한다.
<img width="600" alt="firebase4" src="https://user-images.githubusercontent.com/62926717/85380786-4a91e600-b578-11ea-8cbd-bc41b7a8c97d.PNG">


5. Connect to Firebase를 클릭한다.
<img width="600" alt="firebase5" src="https://user-images.githubusercontent.com/62926717/85384197-dce7b900-b57b-11ea-8779-73b25c7c364c.PNG">


6. 잠깐의 시간이 지나면 1번이 연결되는데 성공한다.
<img width="600" alt="firebase7" src="https://user-images.githubusercontent.com/62926717/85384335-03a5ef80-b57c-11ea-99da-6a5b600fd243.PNG">


7. 2번도 눌러서 마저 연결해준다.
<img width="600" alt="firebase8" src="https://user-images.githubusercontent.com/62926717/85384534-3354f780-b57c-11ea-969a-8fe2f5f3a9ea.PNG">


8. 1,2번 모두 사진처럼 성공적으로 연결이 되었다면
<img width="600" alt="firebase9" src="https://user-images.githubusercontent.com/62926717/85384834-8169fb00-b57c-11ea-9bc1-858ba3fd2c04.PNG">


9. 검색창에 '구글 파이어베이스 콘솔'을 검색하고 사이트에 접속한다.
<img width="600" alt="firebase10" src="https://user-images.githubusercontent.com/62926717/85384968-b5452080-b57c-11ea-851e-e782d4696e57.PNG">


10. 파이어베이스에 연결한 프로젝트 명으로 들어간다.
<img width="600" alt="firebase11" src="https://user-images.githubusercontent.com/62926717/85385169-f0dfea80-b57c-11ea-8780-dcfaf2c6be3f.PNG">


11. Database를 클릭한다.
<img width="300" alt="firebase12" src="https://user-images.githubusercontent.com/62926717/85385220-005f3380-b57d-11ea-8b51-73c680cee9a7.PNG">

12. '데이터베이스 만들기'를 클릭, 테스터 모드로 시작하고 '사용 설정'을 클릭한다.
<img width="600" alt="firebase14" src="https://user-images.githubusercontent.com/62926717/85385644-854a4d00-b57d-11ea-814c-3e3b2158bc97.PNG">

13. 파이어베이스에 (예시)다음 사진과 같이 DB를 추가한다.
<img width="600" alt="firebase15" src="https://user-images.githubusercontent.com/62926717/85385794-add24700-b57d-11ea-9ca4-71ca1e009fcb.PNG">


***

### 검색 카테고리 (음료 필터 검색)


#### ListViewItem.java

* iconDrawable은 이미지, title은 음료이름, desc은 카페이름이며 price는 가격이다.   
* ListView의 아이템에 표시될 데이터 클래스를 정의한다.    
* 이미지, 함수 아이템에 get/set 메소드를 지정해준다.


```java
private Drawable iconDrawable ;
    private String titleStr ;
    private String descStr ;
    private String priceStr;

    public Drawable getIcon() {
        return this.iconDrawable ;
    }
    public void setIcon(Drawable icon) {
        iconDrawable = icon ;
    }

    public String getTitle() {
        return this.titleStr ;
    }
    public void setTitle(String title) {
        titleStr = title ;
    }

    public String getDesc() {
        return this.descStr ;
    }
    public void setDesc(String desc) {
        descStr = desc ;
    }

    public String getPriceStr() {
        return  this.priceStr ;
    }
    public void setPriceStr(String price) {
        priceStr=price ;
    }
```



#### listview_item.xml

* ListView 아이템에 대한 화면을 구성한다.


```java
<LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <ImageView
            android:id="@+id/imageView1"
            android:layout_width="149dp"
            android:layout_height="80dp"
            android:layout_weight="3" />

        <LinearLayout
            android:orientation="vertical"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="4">

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="New Text"
                android:id="@+id/textView1"
                android:textSize="24dp"
                android:textColor="#000000"
                android:gravity="center_vertical"
                android:layout_weight="2" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="New Text"
                android:id="@+id/textView2"
                android:textSize="16dp"
                android:textColor="#666666"
                android:layout_weight="1" />
            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="New Text"
                android:id="@+id/textView3"
                android:textSize="16dp"
                android:textColor="#666666"
                android:layout_weight="1" />
        </LinearLayout>

    </LinearLayout>
```



#### ListViewAdapter.java

Adapter가 필터링 기능을 사용할 수 있게 하기위한 필수조건은

Filterable 인터페이스를 implements 해야한다.

Filterable 인터페이스는 필터링 기능이 필요한 곳에서 사용된다.

* Filterable 인터페이스를 구현한다.


```java
public class ListViewAdapter extends BaseAdapter implements Filterable {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();
    // 필터링된 결과 데이터를 저장하기 위한 ArrayList
    private ArrayList<ListViewItem> filteredItemList = listViewItemList;

    Filter listFilter;


    public ListViewAdapter() {
    }
```


* Adapter에 사용되는 데이터의 갯수를 리턴해준다.
```java
@Override
    public int getCount() {
        return filteredItemList.size();
    }
```


* position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴한다.    


```java
@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
```

* listview_item.xml의 Layout을 inflate   
* inflate는 xml로 정의된 view를 객체화 시킨다는 뜻이다.
```java
if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }
```


* 화면에 표시될(Layout이 inflate된) View로 부터 위젯에 대한 참조를 획득한다.
```java
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1) ;
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1) ;
        TextView descTextView = (TextView) convertView.findViewById(R.id.textView2) ;
        TextView pirceTextView = (TextView) convertView.findViewById(R.id.textView3) ;
```


* filteredItemList에서 position에 위치한 데이터를 받아온다.


```java
ListViewItem listViewItem = filteredItemList.get(position);
```


* 아이템 안에 데이터를 각 위젯에 반영한다.


```java
iconImageView.setImageDrawable(listViewItem.getIcon());
        titleTextView.setText(listViewItem.getTitle());
        descTextView.setText(listViewItem.getDesc());
        pirceTextView.setText(listViewItem.getPriceStr());

        return convertView;
    }
```


* 지정한 위치(position)에 있는 데이터와 관계된 아이템을 가져온다.


```java
@Override
    public long getItemId(int position) {
        return position;
    }
```


* 지정한 위치(position)에 있는 데이터를 받아온다.
```java
@Override
    public Object getItem(int position) {
        return filteredItemList.get(position);
    }
```


* 아이템 데이터를 추가하기 위해 함수를 추가한다.


```java
public void addItem(Drawable icon, String title, String desc, String price) {
        ListViewItem item = new ListViewItem();

        item.setIcon(icon);
        item.setTitle(title);
        item.setDesc(desc);
        item.setPriceStr(price);

        listViewItemList.add(item);
    }
```

* 위에서 Filterable 인터페이스를 implements 했으므로, Filterable 인터페이스의 getFilter() 함수를 오버라이드 한다.
```java
public Filter getFilter() {
        if (listFilter == null) {
            listFilter = new ListFilter();
        }

        return listFilter;
    }
```


* Filter클래스의 역할에 따라, 커스텀 Adapter 내부에 커스텀 Filter 클래스를 정의하고 구현한다.


```java
private class ListFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults() ;

            if (constraint == null || constraint.length() == 0) {
                results.values = listViewItemList ;
                results.count = listViewItemList.size() ;
            } else {
                ArrayList<ListViewItem> itemList = new ArrayList<ListViewItem>() ;

                for (ListViewItem item : listViewItemList) {

                    if (item.getTitle().toUpperCase().contains(constraint.toString().toUpperCase()) ||
                            item.getDesc().toUpperCase().contains(constraint.toString().toUpperCase()))
                    {
                        itemList.add(item) ;
                    }
                }

                results.values = itemList ;
                results.count = itemList.size() ;
            }
            return results;
        }
```



* 이렇게 Adapter 클래스 구현 끝


```java
@Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredItemList=(ArrayList<ListViewItem>)results.values;

            if(results.count>0){
                notifyDataSetChanged();
            }
            else{
                notifyDataSetInvalidated();
            }
        }
    }
}
```




#### drink_search.xml

* ListView의 "textFilterEnabled"속성을 "true"로 지정해줘야한다.    
* 지정해줘야만 setFilterText() 함수를 사용해 필터링 기능을 사용할 수 있다.


```java
<TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="26sp"
        android:layout_marginRight="8dp"
        android:id="@+id/textView1"
        android:text="Filter Text" />

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_toRightOf="@id/textView1"
        android:id="@+id/editTextFilter"/>

    <ListView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_below="@id/editTextFilter"
        android:textFilterEnabled="true"
        android:id="@+id/listview1"/>
```



#### PersonFragment.java
* 위에서 정의한 Adapter를 생성하여 ListView에 지정하는 코드를 작성한다.


```java
public class PersonFragment extends Fragment {
    ListView listView=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.drink_search, container, false);

        ListViewAdapter adapter;

        //Adapter 생성
        adapter=new ListViewAdapter();

        //리스트뷰 참조 및 adapter 달기
        listView=(ListView)view.findViewById(R.id.listview1);
        listView.setAdapter(adapter);
```


* 작성 전에, 밑의 사진처럼 이미지 데이터를 추가해야 한다.    
* ListView 아이템의 ImageView에 들어갈 이미지를 res > drawable에 추가한다.
<img width="600" height="300" alt="drawable" src="https://user-images.githubusercontent.com/62926717/85353425-2831a580-b543-11ea-99cb-271af1448e48.PNG">



* 추가한 데이터를 형식에 맞게끔 호출해준다.
```java
adapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.angelinus1),
                "아메리치노 흑당라떼", "엔제리너스", "6200") ;
        adapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.angelinus2),
                "아메리치노 흑당", "엔제리너스", "5400") ;
        adapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.angelinus3),
                "오트밀 라떼", "엔제리너스", "5400") ;
```


* EditText를 통해 ListView의 아이템을 필터링 할 텍스트를 입력받은 다음    
* ListView의 setFilterText() 함수를 호출해 필터링을 수행하도록 한다.


```java
EditText editTextFilter=(EditText)view.findViewById(R.id.editTextFilter);
        editTextFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable edit) {
                String filterText=edit.toString();
                ((ListViewAdapter)listView.getAdapter()).getFilter().filter(filterText);
            }
        });
```

***
