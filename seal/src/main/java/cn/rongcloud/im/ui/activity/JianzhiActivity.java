package cn.rongcloud.im.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.rongcloud.im.R;
import cn.rongcloud.im.SealConst;
import cn.rongcloud.im.model.JianzhiInfo;
import cn.rongcloud.im.ui.adapter.JianzhiAdapter;
import cn.rongcloud.im.utils.HttpUtils;

/**
 * Created by 皓旭 on 2017/10/8.
 */

public class JianzhiActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private ListView lv;
    private JianzhiAdapter adapter;
    private List<JianzhiInfo> list;
    private Handler getjianzhiHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String jsonData = (String) msg.obj;
            try {
                JSONArray jsonArray = new JSONArray(jsonData);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    int jianzhiId=object.getInt("jianzhiId");
                    int userId=object.getInt("userId");
                    String jianzhijianjie = object.getString("jianzhijianjie");
                    String jianzhixiangqing = object.getString("jianzhixiangqing");
                    String jianzhibiaoti = object.getString("jianzhibiaoti");
                    String creattime = object.getString("creattime");
                    list.add(new JianzhiInfo(jianzhiId,userId,jianzhijianjie,jianzhixiangqing,jianzhibiaoti,creattime));
                }
                adapter.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jianzhi);
        setTitle("兼职");
        lv= (ListView) findViewById(R.id.jianzhilistid);
        list=new ArrayList<JianzhiInfo>();
        adapter=new JianzhiAdapter(list,this);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        HttpUtils.getNewsJson(SealConst.SERVERphp+"/school/getjianzhi",getjianzhiHandler);
    }

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
