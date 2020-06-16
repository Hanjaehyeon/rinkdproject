package com.example.rinkdproject.ui.drink;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rinkdproject.beverage.choco.ChocolateLatteActivity;
import com.example.rinkdproject.coffee.americano.AmericanoIceActivity;
import com.example.rinkdproject.R;
import com.example.rinkdproject.coffee.cafelatte.CafelatteActivity;
import com.example.rinkdproject.coffee.cafuchino.CafuchinoActivity;
import com.example.rinkdproject.coffee.caramelmachiato.CaramelActivity;
import com.example.rinkdproject.coffee.cafemocha.MochaActivity;
import com.example.rinkdproject.coffee.vanilalatte.VanilaActivity;

import java.util.ArrayList;
import java.util.HashMap;

//ICE탭을 보여주기 위한 프래그먼트1
//Expandablelistview를 추가한 xml 파일을 만들어준다.
public class FirstFragment extends Fragment {
    private RecyclerView recyclerview;
    ExpandableListView listMain;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fistfragment, container, false);

        //부모 리스트와 자식 리스트를 선언해준다.
        ArrayList<HashMap<String,String>> groupData = new ArrayList<>();
        ArrayList<ArrayList<HashMap<String,String>>> childData = new ArrayList<>();

        //부모 리스트에 들어갈 요소들을 추가해준다.
        HashMap<String,String> groupA = new HashMap<>();
        groupA.put("group","COFFEE");
        HashMap<String,String> groupB = new HashMap<>();
        groupB.put("group","BEVERAGE");
        HashMap<String,String> groupC = new HashMap<>();
        groupC.put("group","TEA");
        HashMap<String,String> groupD = new HashMap<>();
        groupD.put("group","SMOOTHIE & FRAPPE");
        HashMap<String,String> groupE = new HashMap<>();
        groupE.put("group","ADE & JUICE");
        HashMap<String,String> groupF = new HashMap<>();
        groupF.put("group","BUBBLE TEA");

        groupData.add(groupA);
        groupData.add(groupB);
        groupData.add(groupC);
        groupData.add(groupD);
        groupData.add(groupE);
        groupData.add(groupF);

        //자식 리스트에 들어갈 요소들을 추가해준다.
        ArrayList<HashMap<String,String>>childListA = new ArrayList<>();

        HashMap<String,String> childAA = new HashMap<>();
        childAA.put("group","COFFEE");
        childAA.put("name", "아메리카노");
        childListA.add(childAA);

        HashMap<String,String> childAB = new HashMap<>();
        childAB.put("group","COFFEE");
        childAB.put("name", "카페라떼");
        childListA.add(childAB);

        HashMap<String,String> childAC = new HashMap<>();
        childAC.put("group","COFFEE");
        childAC.put("name", "카페모카");
        childListA.add(childAC);

        HashMap<String,String> childAD = new HashMap<>();
        childAD.put("group","COFFEE");
        childAD.put("name", "바닐라라떼");
        childListA.add(childAD);

        HashMap<String,String> childAE = new HashMap<>();
        childAE.put("group","COFFEE");
        childAE.put("name", "카라멜 마끼아또");
        childListA.add(childAE);

        HashMap<String,String> childAF = new HashMap<>();
        childAF.put("group","COFFEE");
        childAF.put("name", "카푸치노");
        childListA.add(childAF);

        HashMap<String,String> childAO = new HashMap<>();
        childAO.put("group","COFFEE");
        childAO.put("name", "아인슈패너");
        childListA.add(childAO);

        HashMap<String,String> childAJ = new HashMap<>();
        childAJ.put("group","COFFEE");
        childAJ.put("name", "아포가토");
        childListA.add(childAJ);

        HashMap<String,String> childAL= new HashMap<>();
        childAL.put("group","COFFEE");
        childAL.put("name", "디카페인");
        childListA.add(childAL);

       /* HashMap<String,String> childAN = new HashMap<>();
        childAN.put("group","COFFEE");
        childAN.put("name", "디카페인");
        childListA.add(childAN);*/

        childData.add(childListA);

        ArrayList<HashMap<String,String>> childListB = new ArrayList<>();

        HashMap<String, String> childBA = new HashMap<>();
        childBA.put("group", "BEVERAGE");
        childBA.put("name", "초콜릿 라떼");
        childListB.add(childBA);

        HashMap<String, String> childBB = new HashMap<>();
        childBB.put("group", "BEVERAGE");
        childBB.put("name", "그린티 라떼");
        childListB.add(childBB);

        HashMap<String, String> childBC = new HashMap<>();
        childBC.put("group", "BEVERAGE");
        childBC.put("name", "고구마 라떼");
        childListB.add(childBC);

        HashMap<String, String> childBD = new HashMap<>();
        childBD.put("group", "BEVERAGE");
        childBD.put("name", "토피넛 & 곡물 라떼");
        childListB.add(childBD);

        HashMap<String, String> childBE = new HashMap<>();
        childBE.put("group", "BEVERAGE");
        childBE.put("name", "슈가 라떼");
        childListB.add(childBE);

        HashMap<String, String> childBF = new HashMap<>();
        childBF.put("group", "BEVERAGE");
        childBF.put("name", "카라멜 라떼");
        childListB.add(childBF);

        HashMap<String, String> childBG = new HashMap<>();
        childBG.put("group", "BEVERAGE");
        childBG.put("name", "과일 라떼");
        childListB.add(childBG);

       /* HashMap<String, String> childBH = new HashMap<>();
        childBH.put("group", "BEVERAGE");
        childBH.put("name", "카라멜 라떼");
        childListB.add(childBH);

        HashMap<String, String> childBI = new HashMap<>();
        childBI.put("group", "BEVERAGE");
        childBI.put("name", "흑당 라떼");
        childListB.add(childBI);*/

        childData.add(childListB);

        ArrayList<HashMap<String,String>>childListC = new ArrayList<>();

        HashMap<String,String> childCA = new HashMap<>();
        childCA.put("group","TEA");
        childCA.put("name", "오리지널 티 ");
        childListC.add(childCA);

        HashMap<String,String> childCB = new HashMap<>();
        childCB.put("group","TEA");
        childCB.put("name", "후르츠 티");
        childListC.add(childCB);

        HashMap<String,String> childCC = new HashMap<>();
        childCC.put("group","TEA");
        childCC.put("name", "밀크티");
        childListC.add(childCC);

        HashMap<String,String> childCD = new HashMap<>();
        childCD.put("group","TEA");
        childCD.put("name", "믹스블렌딩 티");
        childListC.add(childCD);

       /* HashMap<String,String> childCE = new HashMap<>();
        childCE.put("group","TEA");
        childCE.put("name", "유자차");
        childListC.add(childCE);

        HashMap<String,String> childCF = new HashMap<>();
        childCF.put("group","TEA");
        childCF.put("name", "자몽티");
        childListC.add(childCF);

        HashMap<String,String> childCG = new HashMap<>();
        childCG.put("group","TEA");
        childCG.put("name", "레몬티");
        childListC.add(childCG);

        HashMap<String,String> childCH = new HashMap<>();
        childCH.put("group","TEA");
        childCH.put("name", "아이스티");
        childListC.add(childCH);

        HashMap<String,String> childCI = new HashMap<>();
        childCI.put("group","TEA");
        childCI.put("name", "그린티");
        childListC.add(childCI);

        HashMap<String,String> childCJ = new HashMap<>();
        childCJ.put("group","TEA");
        childCJ.put("name", "밀크티");
        childListC.add(childCJ);

        HashMap<String,String> childCK = new HashMap<>();
        childCK.put("group","TEA");
        childCK.put("name", "귤차 & 석류");
        childListC.add(childCK);

        HashMap<String,String> childCL = new HashMap<>();
        childCL.put("group","TEA");
        childCL.put("name", "보이차 & 꿀차");
        childListC.add(childCL);*/

        childData.add(childListC);

        ArrayList<HashMap<String,String>>childListD = new ArrayList<>();

        HashMap<String,String> childDA = new HashMap<>();
        childDA.put("group","SMOOTHIE & FRAPPE");
        childDA.put("name", "스무디");
        childListD.add(childDA);

        HashMap<String,String> childDD = new HashMap<>();
        childDD.put("group","SMOOTHIE & FRAPPE");
        childDD.put("name", "과일 스무디");
        childListD.add(childDD);

        HashMap<String,String> childDB = new HashMap<>();
        childDB.put("group","SMOOTHIE & FRAPPE");
        childDB.put("name", "쉐이크");
        childListD.add(childDB);

        HashMap<String,String> childDC = new HashMap<>();
        childDC.put("group","SMOOTHIE & FRAPPE");
        childDC.put("name", "프라페");
        childListD.add(childDC);

        /*HashMap<String,String> childDD = new HashMap<>();
        childDD.put("group","SMOOTHIE & FRAPPE");
        childDD.put("name", "믹스");
        childListD.add(childDD);

        HashMap<String,String> childDE = new HashMap<>();
        childDE.put("group","SMOOTHIE & FRAPPE");
        childDE.put("name", "프라페");
        childListD.add(childDE);

        HashMap<String,String> childDF = new HashMap<>();
        childDF.put("group","SMOOTHIE & FRAPPE");
        childDF.put("name", "쉐이크");
        childListD.add(childDF);

        HashMap<String,String> childDG = new HashMap<>();
        childDG.put("group","SMOOTHIE & FRAPPE");
        childDG.put("name", "요거트");
        childListD.add(childDG);

        HashMap<String,String> childDH = new HashMap<>();
        childDH.put("group","SMOOTHIE & FRAPPE");
        childDH.put("name", "블루베리");
        childListD.add(childDH);

        HashMap<String,String> childDI = new HashMap<>();
        childDI.put("group","SMOOTHIE & FRAPPE");
        childDI.put("name", "수박");
        childListD.add(childDI);

        HashMap<String,String> childDJ = new HashMap<>();
        childDJ.put("group","SMOOTHIE & FRAPPE");
        childDJ.put("name", "유자 & 메론");
        childListD.add(childDJ);

        HashMap<String,String> childDK = new HashMap<>();
        childDK.put("group","SMOOTHIE & FRAPPE");
        childDK.put("name", "초코");
        childListD.add(childDK);

        HashMap<String,String> childDL = new HashMap<>();
        childDL.put("group","SMOOTHIE & FRAPPE");
        childDL.put("name", "커피");
        childListD.add(childDL);

        HashMap<String,String> childDM = new HashMap<>();
        childDM.put("group","SMOOTHIE & FRAPPE");
        childDM.put("name", "그린티");
        childListD.add(childDM);

        HashMap<String,String> childDN = new HashMap<>();
        childDN.put("group","SMOOTHIE & FRAPPE");
        childDN.put("name", "커피 프라페");
        childListD.add(childDN);*/

        childData.add(childListD);

        ArrayList<HashMap<String,String>>childListE = new ArrayList<>();

        HashMap<String,String> childEA = new HashMap<>();
        childEA.put("group","ADE & JUICE");
        childEA.put("name", "스파클링");
        childListE.add(childEA);

        HashMap<String,String> childEB = new HashMap<>();
        childEB.put("group","ADE & JUICE");
        childEB.put("name", "주스");
        childListE.add(childEB);

       /* HashMap<String,String> childEC = new HashMap<>();
        childEC.put("group","ADE & JUICE");
        childEC.put("name", "요구르트");
        childListD.add(childEC);

        HashMap<String,String> childED = new HashMap<>();
        childED.put("group","ADE & JUICE");
        childED.put("name", "스파클링");
        childListD.add(childED);

        HashMap<String,String> childEA = new HashMap<>();
        childEA.put("group","ADE & JUICE");
        childEA.put("name", "스파클링");
        childListD.add(childEA);*/

        childData.add(childListE);

        ArrayList<HashMap<String,String>>childListF = new ArrayList<>();

        HashMap<String,String> childFA = new HashMap<>();
        childFA.put("group","BUBBLE TEA");
        childFA.put("name", "타로버블티");
        childListF.add(childFA);

        HashMap<String,String> childFB = new HashMap<>();
        childFB.put("group","BUBBLE TEA");
        childFB.put("name", "초코 버블티");
        childListF.add(childFB);

        HashMap<String,String> childFC = new HashMap<>();
        childFC.put("group","BUBBLE TEA");
        childFC.put("name", "커피 버블티");
        childListF.add(childFC);

       HashMap<String,String> childFD = new HashMap<>();
        childFD.put("group","BUBBLE TEA");
        childFD.put("name", "녹차 버블티");
        childListF.add(childFD);

        HashMap<String,String> childFE = new HashMap<>();
        childFE.put("group","BUBBLE TEA");
        childFE.put("name", "밀크 버블티");
        childListF.add(childFE);

        childData.add(childListF);

        listMain = (ExpandableListView) view.findViewById(R.id.expandableListView);
        listMain.setOnChildClickListener(new ExpandableListView.OnChildClickListener(){
            public boolean onChildClick(ExpandableListView parent,View v, int groupPosition, int childPosition, long id){
                if(groupPosition==0){
                    switch (childPosition){
                        case 0:
                            Intent intent = new Intent(getActivity(), AmericanoIceActivity.class);
                            startActivity(intent);
                            break;
                        case 1:
                            Intent intent2 = new Intent(getActivity(), CafelatteActivity.class);
                            startActivity(intent2);
                            break;
                        case 2:
                            Intent intent3 = new Intent(getActivity(), MochaActivity.class);
                            startActivity(intent3);
                            break;
                        case 3:
                            Intent intent4 = new Intent(getActivity(), VanilaActivity.class);
                            startActivity(intent4);
                            break;
                        case 4:
                            Intent intent5 = new Intent(getActivity(), CaramelActivity.class);
                            startActivity(intent5);
                            break;
                        case 5:
                            Intent intent6 = new Intent(getActivity(), CafuchinoActivity.class);
                            startActivity(intent6);
                            break;
                        case 6:
                            Intent intent7 = new Intent(getActivity(), EspressoActivity.class);
                            startActivity(intent7);
                            break;
                        case 7:
                            Intent intent8 = new Intent(getActivity(), ColdbrewActivity.class);
                            startActivity(intent8);
                            break;
                        case 8:
                            Intent intent9 = new Intent(getActivity(), EspressoActivity.class);
                            startActivity(intent9);
                            break;
                        default:
                            break;
                    }
                } else if(groupPosition==1){
                    switch (childPosition) {
                        case 0:
                            Intent intent = new Intent(getActivity(), ChocolateLatteActivity.class);
                            startActivity(intent);
                            break;
                        default:
                            break;
                    }

                }
               // Intent intent = new Intent(getActivity(), AmericanoIceActivity.class);
               // startActivity(intent);
                return false;
            }
        });

        // 부모, 자식 리스트들 포함한 Adapter 를 생성한다.
        SimpleExpandableListAdapter adapter  = new SimpleExpandableListAdapter(
                getContext(), groupData,android.R.layout.simple_expandable_list_item_1,
                new String[] {"group"},new int[] {android.R.id.text1},
                childData, android.R.layout.simple_expandable_list_item_2,new String[] {"name","group"},new int[]
                {android.R.id.text1,android.R.id.text2});

        //ExpandableListView에 생성한 Adapter를 설정한다.
        ExpandableListView listView = (ExpandableListView) view.findViewById(R.id.expandableListView);
        listView.setAdapter(adapter);




        return view;
    }



}
