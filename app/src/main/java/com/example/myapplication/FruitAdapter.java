package com.example.myapplication;
import android.view.View;
import android.content.Context;
import java.util.List;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit f = getItem(position);
        View view;
        ViewHolder viewHolder;
        // convertView 不存在的时候进行缓存
        if(convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            // 类似前端操作 DOM 消耗性能
            TextView text = view.findViewById(R.id.fruit_name);
            // ViewHolder 进行缓存
            viewHolder = new ViewHolder();
            viewHolder.FruitName = text;
            // viewHolder 存储在 View 中
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.FruitName.setText(f.getName());
        return view;
    }
    class ViewHolder {
        TextView FruitName;
    }

}
