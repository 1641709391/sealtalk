package cn.rongcloud.im.model;

/**
 * Created by 皓旭 on 2017/10/8.
 */

public class JianzhiInfo {
    private int jianzhiId;
    private int userId;
    private String jianzhijianjie;
    private String jianzhixiangqing;
    private String jianzhibiaoti;
    private String creattime;

    public JianzhiInfo(int jianzhiId, int userId, String jianzhijianjie, String jianzhixiangqing, String jianzhibiaoti, String creattime) {
       setJianzhiId(jianzhiId);
        setUserId(userId);
        setJianzhijianjie(jianzhijianjie);
        setJianzhixiangqing(jianzhixiangqing);
        setJianzhibiaoti(jianzhibiaoti);
        setCreattime(creattime);
    }

    public int getJianzhiId() {
        return jianzhiId;
    }

    public void setJianzhiId(int jianzhiId) {
        this.jianzhiId = jianzhiId;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public String getJianzhibiaoti() {
        return jianzhibiaoti;
    }

    public void setJianzhibiaoti(String jianzhibiaoti) {
        this.jianzhibiaoti = jianzhibiaoti;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getJianzhijianjie() {
        return jianzhijianjie;
    }

    public void setJianzhijianjie(String jianzhijianjie) {
        this.jianzhijianjie = jianzhijianjie;
    }

    public String getJianzhixiangqing() {
        return jianzhixiangqing;
    }

    public void setJianzhixiangqing(String jianzhixiangqing) {
        this.jianzhixiangqing = jianzhixiangqing;
    }
}
