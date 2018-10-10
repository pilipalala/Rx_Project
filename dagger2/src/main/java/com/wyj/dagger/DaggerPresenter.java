package com.wyj.dagger;

/**
 * @author yujie
 * @date on 2018/7/27
 * @describe TODO
 **/
public class DaggerPresenter {
    DaggerActivity activity;
    User user;

    public DaggerPresenter(DaggerActivity activity, User user) {
        this.user = user;
        this.activity = activity;
    }

    public void showUserName() {
        activity.showUserName(user.getName());
    }
}
