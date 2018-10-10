package com.wyj.dagger;

import dagger.Component;

/**
 * @author yujie
 * @date on 2018/7/27
 * @describe TODO
 **/
@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(DaggerActivity daggerActivity);
}
