package com.vince.easyprint.base.fragment

import android.os.Bundle
import android.view.View
import com.vince.easyprint.base.BasePresenter

/**
 * <p>作者：黄思程  2018/5/22 18:46
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：带网络请求的懒加载Fragment
 */
abstract class MvpLazyFragment<P : BasePresenter<*>> : BaseLazyFragment() {
    protected lateinit var mvpPresenter: P

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mvpPresenter = createPresenter()

        super.onViewCreated(view, savedInstanceState)
    }

    /**
     * @return 创建Presenter
     * */
    protected abstract fun createPresenter(): P

    override fun onDestroyView() {
        super.onDestroyView()

        mvpPresenter.detachView()
    }
}