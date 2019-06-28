##  **2018**
 - Layout, Button, TextView, ImageView
 - Login
 - TicTacToe
 - AsyncTask
 - Retrofit
 - RecyclerView & ListView
 - Broadcast Receiver
 - ProgressBar

# **2019**
## FirstWeek
**layout, Theme, Style, Color** 관련 속성 설명

 - Constraint Layout
 - Linear Layout
 - Frame Layout

**[HomeWork]**
Zeplin의 디자인 참고하여 로그인 Activity Layout 만들어오기


##  SecondWeek
**Activity & Fragment**
Activity와 Fragment 생명주기의 차이 비교

[Android Developers - Activity Lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle?hl=ko)

[Android Developers - Fragment](https://developer.android.com/guide/components/fragments?hl=ko)


Fragment 정의, FragmentManager 코드리뷰

    FragmentManager fragmentManager =  getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    
    ExampleFragment fragment =  new  ExampleFragment();
    fragmentTransaction.add(R.id.fragment_container, fragment);
    fragmentTransaction.commit();    
    
