# rinkdproject

## 목차
* 하단버튼
* Home Fragment
  * 지도
* Star Fragment
* Person Fragment

***


#### 하단버튼

bottom navigation 사용 -> menu 레이아웃에서 사용할 갯수만큼 item 추가


###### bottom_nav_menu.xml
```java
<item
        android:id="@+id/navigation_home"
        android:icon="@drawable/ic_home_white"
        android:title="@string/title_home" />
```

각각의 버튼에 연결되는 fragment를 4개 생성
화면을 띄울 액티비티를 생성한 후 4가지 fragment 객체를 선언
메뉴 아이템이 선택될 때 호출될 리스너를 등록
