package utils;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class ReaderHtml {

    @Test
    public void reader() {
        try {
            //String exceptionShow="http://www.biquge.com.tw/4_4029/9005830.html";
            //String xiuzhen="https://www.xs.la/36_36007/2683541.html";
            //Document document = Jsoup.connect("https://www.xxbiquge.com/2_2368/" + "4165401.html").get();
            //System.out.println(document.location());
            String kingPeople="http://www.biqukan.com/17_17939/6673639.html";
            Document document = Jsoup.connect(kingPeople).get();

            System.out.print(document.title());
            Elements elements = document.getAllElements();
            String text = document.getElementById("content").text();

            if (text == null) {
                System.out.println("页面获取失败!");

            } else {
                int splitnum;
                String[] texts = text.split("\\。|\\n|\\.|\\？|\\！");
                for (String s : texts) {
                    /*splitnum=s.length()/100+1;//字符

                    分割行数
                    if(splitnum==1){
                        System.out.println(s);
                    }else{
                        for (int i=0;i<=splitnum;i++){
                            System.out.println(s.length()-100*i);
                            System.out.println(100*i);
                            System.out.println(i);
                            System.out.println(s.substring(100*i,s.length()-100*i));
                        }
                    }*/

                    System.out.println(s);
                }

                String nextPage="#wrapper > div.book.reader > div.content > div.page_chapter > ul > li:nth-child(3) > a";
                String nextPage1="#wrapper > div.content_read > div > div.bottem2 > a:nth-child(4)";
                Elements elements1 = document.select(nextPage);
                for (Element element : elements1) {
                    //System.out.println(element);
                    System.out.println(element.attr("href").split("/")[2]);
                }

               /* System.out.println(document.getElementById("pager_next").attr("href"));*/
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println(ioException.getMessage());

        }
    }


    /***
     * pag=6_1-6_330
     */
    //@Test
    public static List getSort(){
        List<String> lines=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        String linkAdress="http://m.banzhuxs.com";
        try{
            String sort="/sort/6_01/";
            Document document;
            document = Jsoup.connect(linkAdress+sort).get();
            System.out.println(document.location());
            Elements elements=document.getElementsByClass("xsm").select("a");

            Map<Integer,String> linksFlag=new HashMap<Integer,String>();

            for(int i=0;i<=elements.size()-1;i++){
                linksFlag.put(i,linkAdress+elements.get(i).attr("href"));
            }

            System.out.println("输入");

            int link=scanner.nextInt();
            System.out.println(linksFlag.get(link));
            document=Jsoup.connect(linksFlag.get(link)).get();
            String creadLink=document.getElementsContainingOwnText("点击阅读").select("a").attr("href");

            document = Jsoup.connect(linkAdress+creadLink).get();
            String text=document.getElementById("nr").text();
            System.out.println(document.location());
            System.out.println(text);
            lines.add(text);
            String endFlag="下一章";
            Elements elements1 = document.select("#zj > section.zj > div:nth-child(5) > a.dise.rt");
            while (elements1.size()>0){
                document = Jsoup.connect(linkAdress+elements1.get(0).attr("href")).get();
                Element element1=document.getElementById("nr");
                if(element1!=null){
                    text=element1.text();
                    lines.add(text);
                    //System.out.println(document.location());
                    System.out.print(text);
                    elements1 = document.select("#zj > section.zj > div:nth-child(5) > a.dise.rt");
                }else {
                   /* System.out.println("jieshu");*/
                    break;
                }
            }
        }catch (IOException io){
            io.printStackTrace();
        }
        return lines;

    }


    @Test
    public void getbook(){
        try{
            Document document;
            document = Jsoup.connect("https://www.zhihu.com/question/264243956").get();
            //String text=document.getElementById("nr").text();
            System.out.println(document.location());
            System.out.println(document.html());

        }catch (IOException io){
            io.printStackTrace();
        }

    }


    public static void main(String[] args)throws IOException{
        List<String> lines=getSort();
        FileUtils.writeLines(new File("D:\\持仓异常截图\\开端"+lines.size()+".txt"),lines,true);

    }
}
