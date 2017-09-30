package com.example.admin.mvp_retrofit_rxjava.mvp.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.fastjson.JSON;
import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.admin.mvp_retrofit_rxjava.R;
import com.example.admin.mvp_retrofit_rxjava.api.LoginPostApi;
import com.example.admin.mvp_retrofit_rxjava.bean.DefaultInfo;
import com.example.admin.mvp_retrofit_rxjava.bean.DomainChangeBean;
import com.example.admin.mvp_retrofit_rxjava.bean.JsonString;
import com.example.admin.mvp_retrofit_rxjava.bean.User;
import com.example.admin.mvp_retrofit_rxjava.mvp.contract.LoginContract;
import com.example.admin.mvp_retrofit_rxjava.mvp.fragment.EnjoyFragment;
import com.example.admin.mvp_retrofit_rxjava.mvp.fragment.HomeFragment;
import com.example.admin.mvp_retrofit_rxjava.mvp.fragment.MineFragment;
import com.example.admin.mvp_retrofit_rxjava.mvp.fragment.MoneyFragment;
import com.example.admin.mvp_retrofit_rxjava.mvp.presenter.LoginPresenterImpl;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.AbsCallback;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends RxAppCompatActivity implements LoginContract.LoginView, BottomNavigationBar.OnTabSelectedListener {


    LoginContract.LoginPresenter loginPresenter;

    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    //用来设置标签的数量
    private BadgeItem mHomeFragmentBadgeItem;

    //用来设置标签的数量
    //   private BadgeItem mMoneyFragmentBadgeItem;

    //用来设置标签的数量
    private BadgeItem mEnjoyFragmentBadgeItem;

    //用来设置标签的数量
    //  private BadgeItem mMineFragmentBadgeItem;

    private FragmentManager fragmentManager;

    private HomeFragment mHomeFragment;

    private MoneyFragment mMoneyFragment;

    private EnjoyFragment mEnjoyFragment;

    private MineFragment mMineFragment;

    private int lastSelectedPosition;

    private List<DomainChangeBean> changes = new ArrayList<>();

    private BaseQuickAdapter<User, BaseViewHolder> testAdapter;

    private List<User> mList = new ArrayList<>();

    private Handler refreshMoreHanlder = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            for (int i = 0; i < 20; i++) {
                User user = new User();
                user.setUserName("ahhahaha" + i);
                user.setPassWord("aadfaa" + i);
                mList.add(user);
            }
            testAdapter.loadMoreComplete();
        }
    };

    private static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenterImpl(this);
        activity = MainActivity.this;
        initView();
        setDefaultFragment();
        testJsonParams();
        initRecyclerView();
        //convertGson();
        //testOkGo();

    }

    private void initRecyclerView() {
        testAdapter = new BaseQuickAdapter<User, BaseViewHolder>(R.layout.item_list) {
            @Override
            protected void convert(BaseViewHolder helper, User item) {
                helper.setText(R.id.tv_userName, item.getUserName());
                helper.setText(R.id.tv_passWord, item.getPassWord());
            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(testAdapter);
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setUserName("ahhahaha" + i);
            user.setPassWord("aadfaa" + i);
            mList.add(user);
        }
        testAdapter.setNewData(mList);
        testAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                //    Toast.makeText(MainActivity.this, "正在加载更多", Toast.LENGTH_SHORT).show();
                refreshMoreHanlder.sendEmptyMessageDelayed(0, 3000);
            }
        }, recyclerView);
    }

    private void testJsonParams() {
        changes.add(new DomainChangeBean("10", "1", "1010", "www.888.com"));
        changes.add(new DomainChangeBean("20", "0", "1011", "www.aaa.com"));
        changes.add(new DomainChangeBean("15", "0", "1012", "www.bbb.com"));
        changes.add(new DomainChangeBean("18", "0", "1013", "www.ccc.com"));
        changes.add(new DomainChangeBean("22", "0", "1014", "www.ddd.com"));
        Map<String, Object> paramData = new HashMap<>();
        paramData.put("changes", changes);
        Map<String, Object> params = new HashMap<>();
        params.put("uri", "/updateDomainMapper");
        params.put("token", "");
        params.put("paramData", paramData);
        String s = new Gson().toJson(params);
        Log.e("cww", "hahah" + s);
    }

    private void testOkGo() {
        OkGo.post("http://119.9.107.44:9999/getVersionHost").execute(new AbsCallback<String>() {
            @Override
            public void onSuccess(String s, Call call, Response response) {

            }

            @Override
            public String convertSuccess(Response response) throws Exception {
                String json = response.body().string();
                Log.e("cww", "json数据1：" + json);
                return json;
            }


        });
    }

    private void convertGson() {
        User user = new User();
        user.setUserName("xiaobai");
        user.setPassWord("xiaohei");
        DefaultInfo info = new DefaultInfo();
        info.setOc("mac");
        info.setKey("asdfj;lasd35s4df54as5df4afd1s21");
        user.setInfo(info);
        JsonString jsonString = new JsonString();
        jsonString.setA("aaaaaaaaaaaaaaa");
        jsonString.setB("bbbb");
        user.setJsonString(JSON.toJSONString(jsonString));
        String jS = JSON.toJSONString(user);
        Log.e("cww", "user:" + jS);
        //Map<String, String> defaultInfo = new HashMap<>();
        //defaultInfo.put("userName", "xiaobai");
        //defaultInfo.put("password", "xiaohei");
        //Map<String, String> params = new HashMap<>();
        // params.put("os", "mac");
        //params.put("key", "asdfj;lasd35s4df54as5df4afd1s21");
        //Log.e("cww", "params:" + new Gson().toJson(params));
    }

    private void initView() {
        /**
         *添加标签的消息数量
         */
        mHomeFragmentBadgeItem = new BadgeItem()
                .setBorderWidth(2)
                .setBackgroundColor(Color.RED)
                .setText("")
                .setHideOnSelect(false); // TODO 控制便签被点击时 消失 | 不消失


        /**
         *添加标签的消息数量
         */
        mEnjoyFragmentBadgeItem = new BadgeItem()
                .setBorderWidth(2)
                .setBackgroundColor(Color.RED)
                .setText("99+")
                .setHideOnSelect(true);

        //设置模式
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);

        //设置背景颜色
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);

        bottomNavigationBar.setTabSelectedListener(this);

        //添加Tab

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.home_table3, "Home").setActiveColorResource(R.color.orange).setBadgeItem(mHomeFragmentBadgeItem))
                .addItem(new BottomNavigationItem(R.drawable.home_table4, "Books").setActiveColorResource(R.color.teal))
                .addItem(new BottomNavigationItem(R.drawable.home_table5, "Music").setActiveColorResource(R.color.blue).setBadgeItem(mEnjoyFragmentBadgeItem))
                .addItem(new BottomNavigationItem(R.drawable.home_table6, "Favorite").setActiveColorResource(R.color.brown))
                .setFirstSelectedPosition(lastSelectedPosition)
                .initialise();

        // TODO 设置 BadgeItem 默认隐藏 注意 这句代码在添加 BottomNavigationItem 之后
        mHomeFragmentBadgeItem.hide();


    }

    private void setDefaultFragment() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        mHomeFragment = new HomeFragment();
        transaction.add(R.id.tb, mHomeFragment);
        transaction.commit();

    }

    private void hideFragment(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mMoneyFragment != null) {
            transaction.hide(mMoneyFragment);
        }
        if (mEnjoyFragment != null) {
            transaction.hide(mEnjoyFragment);
        }
        if (mMineFragment != null) {
            transaction.hide(mMineFragment);
        }
    }

    @Override
    public void startLoginPost() {
        LoginPostApi loginPostApi = new LoginPostApi();
        loginPresenter.login(this, loginPostApi);
    }

    @Override
    public void onLoginNext(String result, String method) {
        Log.e("cww", "获得的数据为" + result);
    }

    @Override
    public void onLoginError(ApiException e) {
        Log.e("cww", "出错的原因" + e.getMessage());
    }

    public void getData(View view) {
        startLoginPost();
        new MaterialDialog.Builder(this).title("Welcome boys and girls！").content("It is party time,having a good time!").positiveText("DO WELL IN")
                .negativeText("GIVE UP").show();
    }

    public void openUrl(View view) {
//        Uri uri = Uri.parse("https://www.baidu.com");
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        Intent intent = new Intent("com.wanhaohui.www.html");
        intent.putExtra("HTML5", "http://www.whh7788.com/api/pages/activity.php?id=0");
        startActivity(intent);
    }

    public void signIn(View view) {
        View content_view = LayoutInflater.from(this).inflate(R.layout.bg_dialog, null);
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
//        alertDialog.setView(content_view)
//                .setCancelable(true);
//        alertDialog.show();
        final PopupWindow pop = new PopupWindow(content_view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                true);
        pop.setBackgroundDrawable(new ColorDrawable(0xffffff));//支持点击Back虚拟键退出
        pop.showAtLocation(getCurrentFocus(), Gravity.NO_GRAVITY, 0, 0);
        content_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop.dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onTabSelected(int position) {
        lastSelectedPosition = position;

        //开启事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction);

        /**
         * fragment 用 add + show + hide 方式
         * 只有第一次切换会创建fragment，再次切换不创建
         *
         * fragment 用 replace 方式
         * 每次切换都会重新创建
         *
         */
        switch (position) {
            case 0:
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    transaction.add(R.id.tb, mHomeFragment);
                } else {
                    transaction.show(mHomeFragment);
                }
//                transaction.replace(R.id.tb, mHomeFragment);
                break;
            case 1:
                if (mMoneyFragment == null) {
                    mMoneyFragment = new MoneyFragment();
                    transaction.add(R.id.tb, mMoneyFragment);
                } else {
                    transaction.show(mMoneyFragment);
                }
//                transaction.replace(R.id.tb, mBookFragment);
                break;
            case 2:
                if (mEnjoyFragment == null) {
                    mEnjoyFragment = new EnjoyFragment();
                    transaction.add(R.id.tb, mEnjoyFragment);
                } else {
                    transaction.show(mEnjoyFragment);
                }
//                transaction.replace(R.id.tb, mMusicFragment);
                break;
            case 3:
                if (mMineFragment == null) {
                    mMineFragment = new MineFragment();
                    transaction.add(R.id.tb, mMineFragment);
                } else {
                    transaction.show(mMineFragment);
                }
//                transaction.replace(R.id.tb, mFavoriteFragment);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }


    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
