package com.zjitc.layui.utils.baidu;



public class Main {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20190402000283771";
    private static final String SECURITY_KEY = "fqp33YmdgrrdozKREYg_";

    public static void main(String[] args) {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String query = "<div class=\"layui-form-item\">"+"<label class=\"layui-form-label\">出生日期</label>" +
                "<div class=\"layui-input-inline\">" +
                "<input type=\"text\" name=\"birthday\" id=\"date\" lay-verify=\"date\" placeholder=\"yyyy-MM-dd\" autocomplete=\"off\" class=\"layui-input\">" +
                "</div>" +
                "</div>";
        System.out.println(api.getTransResult(query, "zh", "en"));
    }

}
