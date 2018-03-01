package com.example.laer.hellorn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.shell.MainReactPackage;


public class MainActivity extends AppCompatActivity implements DefaultHardwareBackBtnHandler {
    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mReactRootView = new ReactRootView(this);
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                //这里需要注意，官方文档setJSMainModuleName在新版本中找不到，替换为setJSMainModulePath
//                .setJSMainModuleName("index.android")
                //这里的路径是相对于根目录的，填入index.android即可
                .setJSMainModulePath("index.android")
                .addPackage(new MainReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        //注意这里的`moduleName`参数必须和工程名字，也是就是在`index.android.js`中AppRegistry.registerComponent（）注册的名字一样
        mReactRootView.startReactApplication(mReactInstanceManager, "HelloRN", null);

        setContentView(mReactRootView);
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }
}
