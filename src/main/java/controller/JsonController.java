package controller;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JsonController {
    public String getListJSON( List Inlist) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("MapStr", Inlist);
        list.add(map);
        String JsonStr = JSON.toJSONString(list);
        return JsonStr;
    }

    public void SendData(HttpServletResponse response, String Str) throws IOException {
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(Str);
            writer.flush();
            writer.close();
    }
}
