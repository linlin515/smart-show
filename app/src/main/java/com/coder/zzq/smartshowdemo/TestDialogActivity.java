package com.coder.zzq.smartshowdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.coder.zzq.smartshow.dialog.ChooseListDialog;
import com.coder.zzq.smartshow.dialog.ChooseResult;
import com.coder.zzq.smartshow.dialog.ClickListDialog;
import com.coder.zzq.smartshow.dialog.DialogBtnClickListener;
import com.coder.zzq.smartshow.dialog.EnsureDialog;
import com.coder.zzq.smartshow.dialog.InputTextDialog;
import com.coder.zzq.smartshow.dialog.LoadingDialog;
import com.coder.zzq.smartshow.dialog.NotificationDialog;
import com.coder.zzq.smartshow.dialog.SmartDialog;
import com.coder.zzq.smartshow.toast.SmartToast;

import java.util.Arrays;

public class TestDialogActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dialog);
        mListView = findViewById(R.id.list_view);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                onShowNotificationDialog();
                break;
            case 1:
                onShowEnsureDialog();
                break;
            case 2:
                onShowEnsureDelayDialog();
                break;
            case 3:
                onShowInputDialog();
                break;
            case 4:
                onShowClickListDialog();
                break;
            case 5:
                onShowSingleChooseDialog();
                break;
            case 6:
                onShowMultipleChooseDialog();
                break;
            case 7:
                onShowMultipleChooseWithCubeCheckedMarkDialog();
                break;
            case 8:
                onShowLargeLoading();
                break;
            case 9:
                onShowMiddleLoading();
                break;
            case 10:
                onShowSmallLoading();
                break;
        }
    }


    private LoadingDialog mSmallLoadingDialog;

    private void onShowSmallLoading() {
        if (mSmallLoadingDialog == null) {
            mSmallLoadingDialog = new LoadingDialog()
                    .small();
        }
        mSmallLoadingDialog.showInActivity(this);
    }

    private LoadingDialog mMiddleLoadingDialog;

    private void onShowMiddleLoading() {
        if (mMiddleLoadingDialog == null) {
            mMiddleLoadingDialog = new LoadingDialog()
                    .middle()
                    .withMsg(true)
                    .message("正在加载");
        }
        mMiddleLoadingDialog.showInActivity(this);
    }

    private LoadingDialog mLargeLoadingDialog;

    private void onShowLargeLoading() {
        if (mLargeLoadingDialog == null) {
            mLargeLoadingDialog = new LoadingDialog()
                    .large()
                    .withMsg(true)
                    .message("正在加载");
        }
        mLargeLoadingDialog.showInActivity(this);
    }

    private ChooseListDialog mMultipleChooseListWithCubeMarkDialog;

    private void onShowMultipleChooseWithCubeCheckedMarkDialog() {
        if (mMultipleChooseListWithCubeMarkDialog == null) {
            mMultipleChooseListWithCubeMarkDialog = new ChooseListDialog()
                    .title("你喜欢哪个城市")
                    .useCubeMarkWhenMultipleChoice(true)
                    .defaultChoosePos(0, 1)
                    .choiceMode(ChooseListDialog.CHOICE_MODE_MULTIPLE)
                    .keepChosenPosByLast(true)
                    .items(new String[]{
                            "上海",
                            "北京",
                            "广州",
                            "深圳",
                            "杭州",
                            "青岛",
                            "苏州"
                    })
                    .confirmBtn("选好了", new DialogBtnClickListener() {
                        @Override
                        public void onBtnClick(SmartDialog dialog, int which, Object data) {
                            dialog.dismiss();
                            ChooseResult chooseResult = (ChooseResult) data;
                            String showMsg = "pos:" + Arrays.toString(chooseResult.getChoosePositions())
                                    + "\n\n"
                                    + "items:" + Arrays.toString(chooseResult.getChooseItems());
                            SmartToast.show(showMsg);
                        }
                    });
        }
        mMultipleChooseListWithCubeMarkDialog.showInActivity(this);
    }

    private ChooseListDialog mMultipleChooseListDialog;

    private void onShowMultipleChooseDialog() {
        if (mMultipleChooseListDialog == null) {
            mMultipleChooseListDialog = new ChooseListDialog()
                    .title("你喜欢哪个城市")
                    .defaultChoosePos(0, 1)
                    .choiceMode(ChooseListDialog.CHOICE_MODE_MULTIPLE)
                    .keepChosenPosByLast(true)
                    .items(new String[]{
                            "上海",
                            "北京",
                            "广州",
                            "深圳",
                            "杭州",
                            "青岛",
                            "苏州"
                    })
                    .confirmBtn("选好了", new DialogBtnClickListener() {
                        @Override
                        public void onBtnClick(SmartDialog dialog, int which, Object data) {
                            dialog.dismiss();
                            ChooseResult chooseResult = (ChooseResult) data;
                            String showMsg = "pos:" + Arrays.toString(chooseResult.getChoosePositions())
                                    + "\n\n"
                                    + "items:" + Arrays.toString(chooseResult.getChooseItems());
                            SmartToast.show(showMsg);
                        }
                    });
        }
        mMultipleChooseListDialog.showInActivity(this);
    }

    private ChooseListDialog mSingleChooseListDialog;

    private void onShowSingleChooseDialog() {
        if (mSingleChooseListDialog == null) {
            mSingleChooseListDialog = new ChooseListDialog()
                    .title("请选择语言")
                    .defaultChoosePos(0)
                    .checkMarkPos(Gravity.LEFT)
                    .checkMarkColorRes(R.color.colorPrimaryDark)
                    .choiceMode(ChooseListDialog.CHOICE_MODE_SINGLE)
                    .keepChosenPosByLast(true)
                    .items(new String[]{
                            "Java",
                            "Kotlin",
                            "C",
                            "C++",
                            "C#",
                            "Html"
                    })
                    .confirmBtn("确定", new DialogBtnClickListener() {
                        @Override
                        public void onBtnClick(SmartDialog dialog, int which, Object data) {
                            dialog.dismiss();
                            ChooseResult chooseResult = (ChooseResult) data;
                            String showMsg = "pos:" + Arrays.toString(chooseResult.getChoosePositions())
                                    + "\n\n"
                                    + "items:" + Arrays.toString(chooseResult.getChooseItems());
                            SmartToast.show(showMsg);
                        }
                    });
        }
        mSingleChooseListDialog.showInActivity(this);
    }

    private ClickListDialog mClickListDialog;

    private void onShowClickListDialog() {
        if (mClickListDialog == null) {
            mClickListDialog = new ClickListDialog()
                    .itemCenter(true)
                    .items(new String[]{
                            "回复",
                            "转发",
                            "私信回复",
                            "复制",
                            "举报"
                    })
                    .itemClickListener(new ClickListDialog.OnItemClickListener() {
                        @Override
                        public void onItemClick(ClickListDialog dialog, int position, Object data) {
                            dialog.dismiss();
                            SmartToast.show(data.toString());
                        }
                    });
        }

        mClickListDialog.showInActivity(this);
    }

    private InputTextDialog mInputTextDialog;

    private void onShowInputDialog() {
        if (mInputTextDialog == null) {
            mInputTextDialog = new InputTextDialog()
                    .title("输入")
                    .textOfDefaultFill("默认填充的文本")
                    .hint("请输入建议")
                    .inputAtMost(50)
                    .clearInputPerShow(true)
                    .confirmBtn("确定", new DialogBtnClickListener() {
                        @Override
                        public void onBtnClick(SmartDialog dialog, int which, Object data) {
                            if (data.toString().length() > 50) {
                                SmartToast.show("最多输入50个字");
                            } else {
                                dialog.dismiss();
                                SmartToast.show("输入的内容为：" + data.toString());
                            }
                        }
                    });
        }
        mInputTextDialog.showInActivity(this);
    }

    private EnsureDialog mEnsureDelayDialog;

    private void onShowEnsureDelayDialog() {
        if (mEnsureDelayDialog == null) {
            mEnsureDelayDialog = new EnsureDialog()
                    .message("确定启用开发者模式？")
                    .secondsDelayConfirm(5)
                    .confirmBtn("确定", new DialogBtnClickListener() {
                        @Override
                        public void onBtnClick(SmartDialog dialog, int which, Object data) {
                            dialog.dismiss();
                            SmartToast.show("开启成功");
                        }
                    });
        }
        mEnsureDelayDialog.showInActivity(this);
    }

    private EnsureDialog mEnsureDialog;

    private void onShowEnsureDialog() {
        if (mEnsureDialog == null) {
            mEnsureDialog = new EnsureDialog()
                    .message("确定不再关注此人？")
                    .confirmBtn("确定", new DialogBtnClickListener() {
                        @Override
                        public void onBtnClick(SmartDialog dialog, int which, Object data) {
                            dialog.dismiss();
                            SmartToast.show("取消成功");
                        }
                    });
        }
        mEnsureDialog.showInActivity(this);
    }

    private NotificationDialog mNotificationDialog;

    private void onShowNotificationDialog() {
        if (mNotificationDialog == null) {
            mNotificationDialog = new NotificationDialog()
                    .message("重置成功");
        }
        mNotificationDialog.showInActivity(this);
    }
}
