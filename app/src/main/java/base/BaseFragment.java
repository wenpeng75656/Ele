package base;

import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Administrator on 2016/12/1.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener{
    public abstract void initHeader();

    //初始化控件
    public abstract void initWidget();

    //设置监听
    public abstract void setWidgetState();

    @Override
    public void onClick(View view) {

    }
}
