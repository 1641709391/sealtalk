package cn.rongcloud.im.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.rongcloud.im.R;
import cn.rongcloud.im.model.JianzhiInfo;

/**
 * Created by 皓旭 on 2017/10/8.
 */

public class JianzhiAdapter extends android.widget.BaseAdapter{
    private List<JianzhiInfo> JianzhiInfolist;
    private Context context;

    public JianzhiAdapter(List<JianzhiInfo> jianzhiInfolist, Context context) {
        JianzhiInfolist = jianzhiInfolist;
        this.context = context;
    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return JianzhiInfolist.size();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return JianzhiInfolist.get(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_jianzhi_list, null);
            holder = new ViewHolder();
            holder.jianzhineirong= (TextView) convertView.findViewById(R.id.jianzhineirong);
            holder.jianzhishijian= (TextView) convertView.findViewById(R.id.jianzhishijian);
            holder.jianzhiTitle= (TextView) convertView.findViewById(R.id.jianzhiTitle);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        JianzhiInfo jianzhiInfo=JianzhiInfolist.get(position);
        holder.jianzhineirong.setText(jianzhiInfo.getJianzhixiangqing());
        holder.jianzhishijian.setText(jianzhiInfo.getJianzhijianjie());
        holder.jianzhiTitle.setText(jianzhiInfo.getJianzhibiaoti());

        return convertView;
    }
    class ViewHolder{
        TextView jianzhineirong,jianzhishijian,jianzhiTitle;
    }
}
