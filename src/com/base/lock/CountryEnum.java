package com.base.lock;


/**
 * @Description 六国枚举类
 * @Author Monster
 * @Date 2021/1/26 16:00
 * @Version 1.0
 */
public enum CountryEnum {
    /**
     * 枚举就相当于一个数据库，不会中断
     * 但是大量的数据放枚举，会造成OOM，因为会占据内存
     */
    ONE(1, "韩"),TWO(2, "赵"),THREE(3, "魏"),
    FOUR(4, "楚"),FIVE(5, "燕"),SIX(6,"齐");

    private Integer retCode;
    private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }

    public static CountryEnum Foreach_CountryEnum(int index){
        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum element: values) {
            if(index == element.getRetCode()){
                return element;
            }
        }
        return null;
    }

}
