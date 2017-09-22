package com.xms.examination.pingduoduo;

/**
 * Created by xms on 2017/9/2.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Goods {
    // 商品id
    int goodsId;
    // 人气值
    int popularValue;
    // 库存
    int quantity;

    public Goods(int goodsId, int popularValue, int quantity) {
        this.goodsId = goodsId;
        this.popularValue = popularValue;
        this.quantity = quantity;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getPopularValue() {
        return popularValue;
    }

    public void setPopularValue(int popularValue) {
        this.popularValue = popularValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

class Activity {
    // 开始时间
    int startTime;
    // 结束时间
    int endTime;
    // 商品id
    int goodsId;
    // 活动数量
    int limitQuantity;
    // 活动id
    int saleId;
    // 最后卖出时间
    int saleTime;

    public Activity(int startTime, int endTime, int goodsId, int limitQuantity, int saleId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.goodsId = goodsId;
        this.limitQuantity = limitQuantity;
        this.saleId = saleId;
        this.saleTime = 0;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getLimitQuantity() {
        return limitQuantity;
    }

    public void setLimitQuantity(int limitQuantity) {
        this.limitQuantity = limitQuantity;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(int saleTime) {
        this.saleTime = saleTime;
    }
}

public class Third {

    // 商品集合
    static List<Goods> goodsList = new ArrayList<>();
    // 活动集合
    static List<Activity> activitiesList = new ArrayList<>();
    // 秒杀活动id 用于addActivity返回值
    static int saleId = 0;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        // 商品数量
        int goodsCount = cin.nextInt();
        // 请求数量
        int reqCount = cin.nextInt();
        for (int i = 0; i < goodsCount; i++) {
            for (int j = 0; j < 3; j++) {
                // 商品id
                int goodsId = cin.nextInt();
                // 人气值
                int popularValue = cin.nextInt();
                // 库存
                int quantity = cin.nextInt();
                goodsList.add(new Goods(goodsId, popularValue, quantity));
            }
        }
        // 请求,时间戳,请求类型,请求参数,时间戳已经按从小到大排序
        for (int i = 0; i < reqCount; i++) {
            String request = cin.next();
            // System.out.println(getResult(request));
            String[] reqSplit = request.split(" ");
            switch (reqSplit[1]) {
                case "add":
                    // 获取时间戳
                    int time = Integer.valueOf(reqSplit[0]);
                    // 获取开始时间
                    int startTime = Integer.valueOf(reqSplit[2]);
                    // 获取需要商品数量
                    int limitQuantity = Integer.valueOf(reqSplit[5]);
                    if (startTime < time || limitQuantity <= 0) {
                        System.out.println(-1);
                    } else {
                        // 获得结束时间 商品id
                        int endTime = Integer.valueOf(reqSplit[3]);
                        int goodsId = Integer.valueOf(reqSplit[4]);
                        System.out.println(addActivity(startTime, endTime, goodsId, limitQuantity));
                    }
                    break;
                case "buy":
                    int quantity = Integer.valueOf(reqSplit[3]);
                    if (quantity <= 0) {
                        System.out.println(-1);
                    } else {
                        int activityId = Integer.valueOf(reqSplit[2]);
                        int buyTime = Integer.valueOf(reqSplit[0]);
                        System.out.println(bugGoods(buyTime, activityId, quantity));
                    }
                    break;
                case "list":
                    int getTime = Integer.valueOf(reqSplit[0]);
                    List<Integer> activitiesResult = new ArrayList<>();
                    activitiesResult = getListActivity(getTime);
                    if (activitiesResult == null) {
                        System.out.println();
                    } else {
                        for (int j = 0; j < activitiesResult.size() - 1; j++) {
                            System.out.print(activitiesResult.get(j) + " ");
                        }
                        System.out.print(activitiesResult.get(activitiesResult.size() - 1));
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /*
     * 添加成功,返回秒杀活动id(从0开始自增) 添加失败,返回-1
     */
    private static int addActivity(int startTime, int endTime, int goodsId, int limitQuantity) {
        if (startTime < endTime) {
            return -1;
        }
        // 记录添加过的商品id
        List<Integer> goodsIdList = new ArrayList<>();
        // 若添加1次以上则失败
        if (goodsIdList.contains(goodsId)) {
            return -1;
        } else {
            goodsIdList.add(goodsId);
        }
        for (int i = 0; i < goodsList.size(); i++) {
            Goods goods = goodsList.get(i);
            int goodsIdFromList = goods.getGoodsId();
            if (goodsIdFromList == goodsId) {
                int quantity = goods.getQuantity();
                // 秒杀商品小于商品库存
                if (quantity >= limitQuantity) {
                    activitiesList.add(new Activity(startTime, endTime, goodsId, limitQuantity, saleId));
                    return saleId++;
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }

    /*
     * 购买成功 减少库存 返回0 购买数量大于库存数量 返回-1 秒杀未开始或已结束 返回-1
     */
    private static int bugGoods(int buyTime, int activityId, int quantity) {
        for (int i = 0; i < activitiesList.size(); i++) {
            Activity activity = activitiesList.get(i);
            int saleId = activity.getSaleId();
            if (saleId == activityId) {
                int startTime = activity.getStartTime();
                int endTime = activity.getEndTime();
                int limitQuantity = activity.getLimitQuantity();
                if (buyTime < startTime || buyTime > endTime || quantity > limitQuantity) {
                    return -1;
                } else {
                    limitQuantity = limitQuantity - quantity;
                    activity.setLimitQuantity(limitQuantity);
                    // activitiesList.add(activity);
                    return 0;
                }
            }
        }
        return -1;
    }

    /*
     * 获取秒杀活动列表 进行中(未售罄)>进行中(已售罄)>未开始 1 商品人气值高到低 id小到大 2最后卖出时间从晚到早 人气值高到低 id小到大
     * 3开始时间早到晚 人气值 高到低 id小到大 返回秒杀活动id列表
     */
    private static List<Integer> getListActivity(int getTime) {
        // 进行中(未售罄)
        List<Activity> resultInTimeWith = new ArrayList<>();
        // 进行中(已售罄)
        List<Activity> resultInTimeWithout = new ArrayList<>();
        // 未开始
        List<Activity> resultNo = new ArrayList<>();
        for (int i = 0; i < activitiesList.size(); i++) {
            Activity activity = activitiesList.get(i);
            int startTime = activity.getStartTime();
            int endTime = activity.getEndTime();
            int limitQuantity = activity.getLimitQuantity();
            if (getTime < startTime || getTime > endTime) {
                resultNo.add(activity);
            } else if (getTime > startTime && getTime < endTime && limitQuantity != 0) {
                resultInTimeWith.add(activity);
            } else if (getTime > startTime && getTime < endTime && limitQuantity == 0) {
                resultInTimeWithout.add(activity);
            }
        }
        Collections.sort(resultInTimeWith, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                int popularValue1 = getGoodsById(o1.getGoodsId()).getPopularValue();
                int popularValue2 = getGoodsById(o2.getGoodsId()).getPopularValue();
                int goodsId1 = getGoodsById(o1.getGoodsId()).getGoodsId();
                int goodsId2 = getGoodsById(o2.getGoodsId()).getGoodsId();
                if (popularValue1 == popularValue2) {
                    return goodsId1 - goodsId2;
                } else {
                    return popularValue1 - popularValue2;
                }
            }
        });

        Collections.sort(resultNo, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                int startTime1 = o1.getStartTime();
                int startTime2 = o2.getStartTime();
                int popularValue1 = getGoodsById(o1.getGoodsId()).getPopularValue();
                int popularValue2 = getGoodsById(o2.getGoodsId()).getPopularValue();
                int goodsId1 = getGoodsById(o1.getGoodsId()).getGoodsId();
                int goodsId2 = getGoodsById(o2.getGoodsId()).getGoodsId();
                if (startTime1 == startTime2) {
                    if (popularValue1 == popularValue2) {
                        return goodsId1 - goodsId2;
                    } else {
                        return popularValue1 - popularValue2;
                    }
                } else {
                    return startTime1 - startTime2;
                }
            }
        });
        Collections.sort(resultInTimeWithout, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                int saleTime1 = o1.getSaleTime();
                int saleTime2 = o2.getSaleTime();
                int popularValue1 = getGoodsById(o1.getGoodsId()).getPopularValue();
                int popularValue2 = getGoodsById(o2.getGoodsId()).getPopularValue();
                int goodsId1 = getGoodsById(o1.getGoodsId()).getGoodsId();
                int goodsId2 = getGoodsById(o2.getGoodsId()).getGoodsId();
                if (saleTime1 == saleTime2) {
                    if (popularValue1 == popularValue2) {
                        return goodsId1 - goodsId2;
                    } else {
                        return popularValue1 - popularValue2;
                    }
                } else {
                    return saleTime1 - saleTime2;
                }
            }
        });
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < resultInTimeWith.size(); i++) {
            result.add(resultInTimeWith.get(i).getSaleId());
        }
        for (int i = 0; i < resultInTimeWithout.size(); i++) {
            result.add(resultInTimeWithout.get(i).getSaleId());
        }
        for (int i = 0; i < resultNo.size(); i++) {
            result.add(resultNo.get(i).getSaleId());
        }
        return result;
    }

    protected static Goods getGoodsById(int goodsId) {
        for (int i = 0; i < goodsList.size(); i++) {
            Goods goods = goodsList.get(i);
            int goodsIdFromList = goods.getGoodsId();
            if (goodsIdFromList == goodsId) {
                return goods;
            }
        }
        return null;
    }
}
