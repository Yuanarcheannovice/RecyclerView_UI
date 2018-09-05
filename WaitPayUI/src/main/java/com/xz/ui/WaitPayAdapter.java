package com.xz.ui;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.xz.ui.bean.WaitPayGoodsEntity;
import com.xz.ui.bean.WaitPayLikeEntity;
import com.xz.ui.bean.WaitPayLikeTitleEntity;
import com.xz.ui.bean.WaitPayNoOrderEntity;
import com.xz.ui.bean.WaitPayTypeEntity;
import com.xz.xadapter.XRvPureDataAdapter;
import com.xz.xadapter.xutil.XRvViewHolder;

/**
 * @author Administrator
 * @date 2018/8/30
 * 根据不同实体显示不同的item   Layout
 */

public class WaitPayAdapter extends XRvPureDataAdapter<Object> {
    /**
     * 分类
     */
    private static final int ITEM_TYPE = 111;

    /**
     * 商品
     */
    private static final int ITEM_GOODS = 222;


    /**
     * 猜你喜欢头部
     */
    private static final int ITEM_LIKE_TITLE = 333;

    /**
     * 猜你喜欢一般条目
     */
    static final int ITEM_LIKE = 444;

    /**
     * 没有订单
     */
    static final int ITEM_NO_ORDER = 555;

    private OnWaitPayTvClickListener onWaitPayTvClickListener;

    public void setWaitPayAdapterListener(OnWaitPayTvClickListener listener) {
        this.onWaitPayTvClickListener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        if (getItem(position) instanceof WaitPayTypeEntity) {
            return ITEM_TYPE;
        } else if (getItem(position) instanceof WaitPayGoodsEntity) {
            return ITEM_GOODS;
        } else if (getItem(position) instanceof WaitPayLikeTitleEntity) {
            return ITEM_LIKE_TITLE;
        } else if (getItem(position) instanceof WaitPayLikeEntity) {
            return ITEM_LIKE;
        } else if (getItem(position) instanceof WaitPayNoOrderEntity) {
            return ITEM_NO_ORDER;
        } else {
            return 0;
        }
    }

    @Override
    public int getItemLayout(int viewType) {
        if (viewType == ITEM_TYPE) {
            return R.layout.item_wait_pay_type;
        } else if (viewType == ITEM_GOODS) {
            return R.layout.item_wait_pay_goods;
        } else if (viewType == ITEM_LIKE_TITLE) {
            return R.layout.item_wait_pay_like_title;
        } else if (viewType == ITEM_LIKE) {
            return R.layout.item_wait_pay_like;
        } else if (viewType == ITEM_NO_ORDER) {
            return R.layout.item_wait_pay_no_order;
        } else {
            return 0;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull XRvViewHolder holder, int position) {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.iwpg_submit_tv:
                        if (onWaitPayTvClickListener != null) {
                            onWaitPayTvClickListener.onSubmitClick();
                        }
                        break;
                    case R.id.iwpg_cancel_tv:
                        if (onWaitPayTvClickListener != null) {
                            onWaitPayTvClickListener.onCancelClick();
                        }
                        break;
                    default:
                        break;
                }
            }
        };

        if (getItemViewType(position) == ITEM_TYPE) {
            TextView typeTv = holder.getView(R.id.iwpt_tv);
            typeTv.setText(((WaitPayTypeEntity) mDatas.get(position)).getType());

        } else if (getItemViewType(position) == ITEM_GOODS) {
            ImageView goodsIv = holder.getView(R.id.iwpg_goods_iv);
            TextView goodsName = holder.getView(R.id.iwpg_goods_name);
            TextView goodsContent = holder.getView(R.id.iwpg_goods_content);
            TextView goodsPrice = holder.getView(R.id.iwpg_goods_price);
            TextView goodsTotalPrice = holder.getView(R.id.iwpg_goods_total_price);
            TextView goodsSubmitTv = holder.getView(R.id.iwpg_submit_tv);
            TextView goodsCancelTv = holder.getView(R.id.iwpg_cancel_tv);
            goodsSubmitTv.setOnClickListener(onClickListener);
            goodsCancelTv.setOnClickListener(onClickListener);
            //
            WaitPayGoodsEntity wpge = ((WaitPayGoodsEntity) mDatas.get(position));
            goodsName.setText(wpge.getProductName());
            goodsContent.setText(wpge.getSpecAName());
            goodsPrice.setText("￥" + wpge.getPrice());
            goodsTotalPrice.setText("￥" + wpge.getBuySum());

//            Glide.with(goodsIv).load(wpge.getImgUrl()).apply(new RequestOptions().centerCrop().error(R.drawable.ic_launcher_background)).into(goodsIv);
        } else if (getItemViewType(position) == ITEM_LIKE_TITLE) {
            holder.setText(R.id.iwplt_tv, ((WaitPayLikeTitleEntity) mDatas.get(position)).getLikeTitleStr());

        } else if (getItemViewType(position) == ITEM_LIKE) {
            ImageView likeIv = holder.getView(R.id.iwpl_iv);
            TextView likeName = holder.getView(R.id.iwpl_name);
            TextView likeNewPrice = holder.getView(R.id.iwpl_new_price);
            TextView likeOldPrice = holder.getView(R.id.iwpl_old_price);
            likeOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG); // 设置中划线并加清晰
            //
            WaitPayLikeEntity wple = ((WaitPayLikeEntity) mDatas.get(position));
            Glide.with(likeIv).load(wple.getImg()).apply(new RequestOptions().centerCrop().error(R.drawable.ic_launcher_background)).into(likeIv);
            likeName.setText(wple.getName());
            likeNewPrice.setText("￥"+wple.getPrice());
            likeOldPrice.setText("￥"+wple.getOriginalPrice());
        } else if (getItemViewType(position) == ITEM_NO_ORDER) {


        } else {
        }

    }


    public interface OnWaitPayTvClickListener {
        /**
         * 确认支付点击
         */
        void onSubmitClick();

        /**
         * 取消点击
         */
        void onCancelClick();
    }

}
