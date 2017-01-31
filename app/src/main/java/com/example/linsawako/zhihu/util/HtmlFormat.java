package com.example.linsawako.zhihu.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by linsawako on 2017/1/22.
 */

public class HtmlFormat {

    //使图片自适应屏幕
    public static String getNewContent(String htmltext){

        Document doc= Jsoup.parse(htmltext);
        Elements elements=doc.getElementsByTag("img");
        for (Element element : elements) {
            if (!element.attr("class").equals("avatar"))
                element.attr("width","100%").attr("height","auto");
        }

        return doc.toString();
    }
}