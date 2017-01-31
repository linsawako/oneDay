package com.example.linsawako.zhihu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.linsawako.zhihu.R;
import com.example.linsawako.zhihu.bean.Comment;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by linsawako on 2017/1/26.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    private Context mContext;
    private List<Comment.CommentsBean> commentsList;
    private static final String TAG = "CommentAdapter";

    public CommentAdapter(List<Comment.CommentsBean> commentsList) {
        this.commentsList = commentsList;
        Log.d(TAG, "CommentAdapter: " + commentsList);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView commentImage;
        TextView commentName;
        TextView commentContent;
        TextView likeNumber;

        public ViewHolder(View itemView) {
            super(itemView);
            commentImage = (ImageView) itemView.findViewById(R.id.comment_image);
            commentName = (TextView) itemView.findViewById(R.id.comment_name);
            commentContent = (TextView) itemView.findViewById(R.id.comment_content);
            likeNumber = (TextView) itemView.findViewById(R.id.like_number);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.comment_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Comment.CommentsBean commentsBean = commentsList.get(position);
        Log.d(TAG, "onBindViewHolder: " + position);
        holder.commentName.setText(commentsBean.getAuthor() + " ");
        holder.commentContent.setText(commentsBean.getContent());
        holder.likeNumber.setText(commentsBean.getLikes() + "");
        Glide.with(mContext).load(commentsBean.getAvatar()).into(holder.commentImage);
    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }
}
