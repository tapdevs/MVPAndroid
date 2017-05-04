package com.tapdevs.mvpandroid.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tapdevs.mvpandroid.R;
import com.tapdevs.mvpandroid.models.User;
import com.tapdevs.mvpandroid.view.fragments.UsersFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by  Jan Shair on 08/02/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UsersHolder> {

    private List<User> userArrayList;
    private UsersFragment context;

    public UserAdapter(UsersFragment context, List<User> androidList) {
        this.context=context;
        userArrayList = androidList;

    }

    public void setItems(List<User> posts) {
        userArrayList = posts;
        notifyDataSetChanged();
    }

    @Override
    public UsersHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View commentBinding = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.user_row,
                parent,
                false);
        return new UsersHolder(commentBinding);
    }

    @Override
    public void onBindViewHolder(UsersHolder holder, int position) {

        User user=userArrayList.get(position);
        holder.name.setText(user.getLogin());
        holder.url.setText(user.getLogin());
        Glide.with(context)
                .load(user.getAvatar_url())
                .placeholder(R.drawable.ic_no_internet)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public class UsersHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_avatar)
        ImageView avatar;


        @BindView(R.id.tv_name)
        TextView name;


        @BindView(R.id.tv_url)
        TextView url;

        public UsersHolder(View view) {
            super(view);
            ButterKnife.bind(this,itemView);
        }

    }

}
