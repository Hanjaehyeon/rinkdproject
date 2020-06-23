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
       - FireBase   
3-3. 음료 카테고리     
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


### 


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
> 아이템 클래스에 이미지와 이름을 받아올 생성자와 get/set 메소드를 만들어준다. (반환형 주의)



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


***

### Person Fragment (음료 필터 검색)


#### ListViewItem.java

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
> iconDrawable은 이미지, title은 음료이름, desc은 카페이름, price는 가격

> ListView의 아이템에 표시 될 데이터 클래스를 정의    
> 이미지, 함수 아이템에 get/set 메소드를 만들어준다.


#### listview_item.xml
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

> ListView 아이템에 대한 화면을 구성한다.



#### ListViewAdapter.java

Adapter가 필터링 기능을 사용할 수 있게 하기위한 필수조건은

Filterable 인터페이스를 implements 해야한다.

Filterable 인터페이스는 필터링 기능이 필요한 곳에서 사용된다.


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
>  Filterable 인터페이스를 구현한다.    

```java
@Override
    public int getCount() {
        return filteredItemList.size();
    }
```
> Adapter에 사용되는 데이터의 개수를 리턴한다.     

```java
@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
```
> position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴한다.     

```java
if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }
```
> listview_item.xml의 Layout을 inflate.    
> inflate는 xml로 정의된 view를 객체화 시킨다는 뜻이다.


```java
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1) ;
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1) ;
        TextView descTextView = (TextView) convertView.findViewById(R.id.textView2) ;
        TextView pirceTextView = (TextView) convertView.findViewById(R.id.textView3) ;
```
> 화면에 표시될(Layout이 inflate된) View로 부터 위젯에 대한 참조를 획득한다.


```java
ListViewItem listViewItem = filteredItemList.get(position);
```
> filteredItemList에서 position에 위치한 데이터를 받아온다.


```java
iconImageView.setImageDrawable(listViewItem.getIcon());
        titleTextView.setText(listViewItem.getTitle());
        descTextView.setText(listViewItem.getDesc());
        pirceTextView.setText(listViewItem.getPriceStr());

        return convertView;
    }
```
> 아이템 안에 데이터를 각 위젯에 반영한다.


```java
@Override
    public long getItemId(int position) {
        return position;
    }
```
> 지정한 위치(position)에 있는 데이터와 관계된 아이템을 가져온다.


```java
@Override
    public Object getItem(int position) {
        return filteredItemList.get(position);
    }
```
> 지정한 위치(position)에 있는 데이터를 받아온다.


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
> 아이템 데이터를 추가하기 위해 함수를 추가한다.


```java
public Filter getFilter() {
        if (listFilter == null) {
            listFilter = new ListFilter();
        }

        return listFilter;
    }
```
> 위에서 Filterable 인터페이스를 implements 했으므로, Filterable 인터페이스의   
> getFilter() 함수를 오버라이드 한다.


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
> Filter클래스의 역할에 따라, 커스텀 Adapter 내부에 커스텀 Filter 클래스를 정의하고 구현한다.


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
> 이렇게 Adapter 클래스 구현 끝



#### drink_search.xml
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
> ListView의 "textFilterEnabled"속성을 "true"로 지정해줘야한다.    
> 지정해줘야만 setFilterText() 함수를 사용해 필터링 기능을 사용할 수 있다.



#### PersonFragment.java
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
> 위에서 정의한 Adapter를 생성하여 ListView에 지정하는 코드를 작성한다.



<img width="600" height="300" alt="drawable" src="https://user-images.githubusercontent.com/62926717/85353425-2831a580-b543-11ea-99cb-271af1448e48.PNG">

> 작성 전에, 이미지 데이터를 추가해야 한다.   
> ListView 아이템의 ImageView에 들어갈 이미지를 res > drawable에 추가한다.


```java
adapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.angelinus1),
                "아메리치노 흑당라떼", "엔제리너스", "6200") ;
        adapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.angelinus2),
                "아메리치노 흑당", "엔제리너스", "5400") ;
        adapter.addItem(ContextCompat.getDrawable(getContext(), R.drawable.angelinus3),
                "오트밀 라떼", "엔제리너스", "5400") ;
```
> 추가한 데이터를 형식에 맞게끔 호출해준다.    

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
> EditText를 통해 ListView의 아이템을 필터링 할 텍스트를 입력받은 다음,    
> ListView의 setFilterText() 함수를 호출해 필터링을 수행하도록 한다.
