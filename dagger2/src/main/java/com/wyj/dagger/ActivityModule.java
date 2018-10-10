package com.wyj.dagger;

import dagger.Module;
import dagger.Provides;

/**
 * @author yujie
 * @date on 2018/7/27
 * @describe TODO
 **/
@Module
public class ActivityModule {
    private DaggerActivity activity;

    public ActivityModule(DaggerActivity activity) {
        this.activity = activity;
    }

    @Provides
    public DaggerActivity provideActivity() {
        return activity;
    }

    @Provides
    public User provideUser() {
        return new User("user form ActivityModule");
    }

    @Provides
    public DaggerPresenter provideDaggerPresenter(DaggerActivity activity, User user) {
        return new DaggerPresenter(activity, user);
    }
}
