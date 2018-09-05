package com.xz.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xz.ui.bean.WaitPayGoodsEntity;
import com.xz.ui.bean.WaitPayLikeEntity;
import com.xz.ui.bean.WaitPayLikeTitleEntity;
import com.xz.ui.bean.WaitPayTypeEntity;
import com.xz.ui.dto.BrandNameDto;
import com.xz.ui.dto.LikeListDto;
import com.xz.ui.dto.LikeResponseDto;
import com.xz.ui.dto.ProductDetailsDto;
import com.xz.ui.dto.WaitPayResponseDto;
import com.xz.ui.dto.WaitPayDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2018/8/30
 * 待付款
 */

public class WaitPayFragment extends Fragment {

    private WaitPayAdapter mAdapter;

    public static WaitPayFragment newInstance() {

        Bundle args = new Bundle();

        WaitPayFragment fragment = new WaitPayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_wait_pay, container, false);

        initView(contentView);
        initData();

        return contentView;
    }

    private void initView(View view) {

        RecyclerView recyclerView = view.findViewById(R.id.fw_rv);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (mAdapter.getItemViewType(position) == WaitPayAdapter.ITEM_LIKE) {
                    return 1;
                } else {
                    return 2;
                }
            }
        });

        recyclerView.setLayoutManager(gridLayoutManager);
        mAdapter = new WaitPayAdapter();
        recyclerView.setAdapter(mAdapter);

        /**
         * item内容中点击
         */
        mAdapter.setWaitPayAdapterListener(new WaitPayAdapter.OnWaitPayTvClickListener() {

            @Override
            public void onSubmitClick() {
                //确认支付
            }

            @Override
            public void onCancelClick() {
                //取消支付
            }
        });

    }

    private void initData() {
        //待付款数据
        String json = "{\"code\":0,\"msg\":\"请求成功!\",\"data\":[{\"brandName\":[{\"brandName\":\"联想\",\"productDetails\":[{\"buySum\":10,\"id\":\"dsaddsada\",\"imgUrl\":\"http://192.168.10.198:8080/tianbamalllong.png\",\"price\":100.0000,\"productName\":\"测试A\",\"specAName\":\"王测试\",\"specBName\":\"dasdas\"},{\"buySum\":20,\"id\":\"huang125422\",\"imgUrl\":\"http://192.168.10.198:8080/tianbamallupdate.png\",\"price\":200.0000,\"productName\":\"测试\",\"specAName\":\"颜色\",\"specBName\":\"尺码\"}]}],\"createTime\":902505600000,\"deliveryTime\":-3515472000000,\"id\":\"3526C173-FE41-426E-936D-1129816CE51A\",\"payAmount\":1.0000,\"payTime\":\"1888-08-08 00:00:00\",\"payWay\":1,\"receiptTime\":902505600000,\"status\":0},{\"brandName\":[{\"brandName\":\"范德萨分\",\"productDetails\":[{\"buySum\":10,\"id\":\"ioudjsaiod112\",\"imgUrl\":\"http://192.168.10.198:8080/tianbamalllong.png\",\"price\":100.0000,\"productName\":\"测试A\",\"specAName\":\"王测试\",\"specBName\":\"大\"}]}],\"createTime\":902505600000,\"deliveryTime\":-3515472000000,\"id\":\"C4B2E658-B040-41EA-92AB-68EF181024CD\",\"payAmount\":1.0000,\"payTime\":\"1888-08-08 00:00:00\",\"payWay\":1,\"receiptTime\":902505600000,\"status\":2},{\"brandName\":[],\"createTime\":902505600000,\"deliveryTime\":-3515472000000,\"id\":\"ddadw223\",\"payAmount\":1.0000,\"payTime\":\"1888-08-08 00:00:00\",\"payWay\":1,\"receiptTime\":902505600000,\"status\":1},{\"brandName\":[],\"createTime\":902505600000,\"deliveryTime\":-3515472000000,\"id\":\"dsdr1sd23as1d\",\"payAmount\":1.0000,\"payTime\":\"1888-08-08 00:00:00\",\"payWay\":1,\"receiptTime\":902505600000,\"status\":0},{\"brandName\":[],\"createTime\":902505600000,\"deliveryTime\":-3515472000000,\"id\":\"iuyiy5441f6sd\",\"payAmount\":1.0000,\"payTime\":\"1888-08-08 00:00:00\",\"payWay\":1,\"receiptTime\":902505600000,\"status\":0},{\"brandName\":[],\"createTime\":902505600000,\"deliveryTime\":-3515472000000,\"id\":\"rsrsdf5211d1d\",\"payAmount\":1.0000,\"payTime\":\"1888-08-08 00:00:00\",\"payWay\":1,\"receiptTime\":902505600000,\"status\":0},{\"brandName\":[],\"createTime\":902505600000,\"deliveryTime\":-3515472000000,\"id\":\"wangxiaouya123\",\"payAmount\":1.0000,\"payTime\":\"1888-08-08 00:00:00\",\"payWay\":1,\"receiptTime\":902505600000,\"status\":0}]}";
        WaitPayResponseDto responseDto = GsonUtil.jsonStringToObject(json, WaitPayResponseDto.class);

        List<Object> lists = new ArrayList<>();
        //处理json，把各个对象转换

        //获取 待付款列表
        List<WaitPayDto> data = responseDto.getData();
        for (WaitPayDto wpd : data) {
            //获取 品牌列表
            List<BrandNameDto> brandName = wpd.getBrandName();
            for (BrandNameDto bnd : brandName) {
                //把品牌实体放进去
                lists.add(new WaitPayTypeEntity(bnd.getBrandName()));
                //获取 商品列表
                List<ProductDetailsDto> productDetails = bnd.getProductDetails();
                for (ProductDetailsDto pdd : productDetails) {
                    //把品牌对应的商品放进去
                    lists.add(WaitPayGoodsEntity.newInstance(pdd));
                }
            }
        }
        lists.add(new WaitPayLikeTitleEntity("猜你喜欢"));
        //猜你喜欢数据
        String likeJson="{\"code\":\"成功!\",\"data\":[{\"id\":\"safsadfdsfsd\",\"img\":\"http://192.168.10.238:8080/tianbamall/upload/uploadFile/201809/2d07822fc64a48fd906ae0e3ab8ad3a3.jpg\",\"name\":\"优衣库XX\",\"originalPrice\":33,\"price\":332},{\"id\":\"safsadfdsfsd\",\"img\":\"http://192.168.10.238:8080/tianbamall/upload/uploadFile/201809/2d07822fc64a48fd906ae0e3ab8ad3a3.jpg\",\"name\":\"优衣库XX\",\"originalPrice\":33,\"price\":332}]}";
        //解析数据，生成对应的实体,也可以直接dto类,这里为了做区分，故意分开
        LikeResponseDto likeResponseDto = GsonUtil.jsonStringToObject(likeJson, LikeResponseDto.class);
        for(LikeListDto lld:likeResponseDto.getData()){
            lists.add(WaitPayLikeEntity.newInstance(lld));
        }

        mAdapter.setDatas(lists, true);
    }
}
