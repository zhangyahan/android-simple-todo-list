package com.example.android_simple_todo_list;

import android.os.Bundle;

import com.example.android_simple_todo_list.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 获取页面绑定对象
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // 设置内容视图
        setContentView(binding.getRoot());

        // 设置支持的 action bar
        setSupportActionBar(binding.toolbar);

        // 应用导航展示的布局, 元素属性内部定义了包含到页面信息和初始化信息.
        NavController navController = Navigation
                .findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        navController.addOnDestinationChangedListener((@NonNull NavController controller,
                                                       @NonNull NavDestination destination,
                                                       @Nullable Bundle arguments) -> {
            if (destination.getId() == R.id.TodoListFragment) {
                binding.fab.setVisibility(View.VISIBLE);
            }
        });

        // 浮动按钮的点击事件
        binding.fab.setOnClickListener(view -> {
            NavController controller = Navigation
                    .findNavController(this, R.id.nav_host_fragment_content_main);
            controller.navigate(R.id.action_TodoListFragment_to_AddTodoFragment);
            view.setVisibility(View.GONE);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 填充菜单内容, 添加元素到菜单中.
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 处理标题栏菜单点击时间函数
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this,
                R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}