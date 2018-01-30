package com.example.ch_wangling.retrofittest002.get2;

import java.util.List;

/**
 * Created by CH_WangLing on 2018/1/9.
 * 下面是json数据的原始格式
 * {
      "currentPage": 1,
      "list": [
            {
                "id": 1,
                "imgUrl": "http://7mno4h.com2.z0.glb.qiniucdn.com/s_recommend_55c1e8f7N4b99de71.jpg",
                "name": "联想（Lenovo）拯救者14.0英寸游戏本（i7-4720HQ 4G 1T硬盘 GTX960M 2G独显 FHD IPS屏 背光键盘）黑",
                "price": 5979.0,
                "sale": 8654
            }
              ],
      "pageSize": 1,
      "totalCount": 28,
      "totalPage": 28
    }
 */

//创建服务器返回数据的类
public class Computer {

    private String copyright;
    private int currentPage;
    private int pageSize;
    private int totalCount;
    private int totalPage;
    private List<Bean> list;


    public String getCopyright(){
        return copyright;
    }
    public void setCopyright(String copyright){
        this.copyright = copyright;
    }

    public int getCurrentPage(){
        return currentPage;
    }
    public void setCurrentPage(int currentPage){
        this.currentPage = currentPage;
    }

    public int getPageSize(){
        return pageSize;
    }
    public void setPageSize(int pageSize){
        this.pageSize =pageSize;
    }

    public int getTotalCount(){
        return totalCount;
    }
    public void setTotalCount(int totalCount){
        this.totalCount = totalCount;
    }

    public int getTotalPage(){
        return totalPage;
    }
    public void setTotalPage(int totalPage){
        this.totalPage = totalPage;
    }


    public List<Bean> getList(){
        return list;
    }
    public void setList(List<Bean> list){
        this.list = list;
    }

    public static class Bean{

        public int id;
        public int categoryId;
        public int campaignId;
        public String name;
        public String imgUrl;
        public double price;
        public int sale;

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        public int getCategoryId(){
            return categoryId;
        }
        public void setCategoryId(int categoryId){
            this.categoryId = categoryId;
        }

        public int getCampaignId(){
            return campaignId;
        }
        public void setCampaignId(int campaignId){
            this.campaignId = campaignId;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getImgUrl() {
            return imgUrl;
        }
        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public double getPrice() {
            return price;
        }
        public void setPrice(double price) {
            this.price = price;
        }

        public int getSale() {
            return sale;
        }
        public void setSale(int sale) {
            this.sale = sale;
        }

    }
}
