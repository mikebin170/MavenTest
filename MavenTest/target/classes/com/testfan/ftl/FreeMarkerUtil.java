package com.testfan.ftl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerUtil {
    /**
     * 获取模板
     * 
     * @param name
     * @return
     */
    public static Template getTemplate(String name) {
        try {
            // 通过FreeMarker的Configuration读取相应的ftl
            Configuration cfg = new Configuration();
            // 设定去哪里读取相应的ftl模板文件
            cfg.setClassForTemplateLoading(FreeMarkerUtil.class,"/");
            // 在模板文件目录中找到名称为name的文件
            Template temp = cfg.getTemplate(name);
            return temp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 输出到控制台
     * 
     * @param name
     *            模板文件名
     * @param root
     */
    public static void print(String name, Map<String, Object> root) {
        try {
            // 通过Template可以将模板文件输出到相应的流
            Template temp = getTemplate(name);
            temp.process(root, new PrintWriter(System.out));
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出到文件
     * 
     * @param name
     * @param root
     * @param outFile
     */
    public static void fprint(String name, Map<String, Object> root, String outFile) {
        FileWriter out = null;
        try {
            // 通过一个文件输出流，就可以写到相应的文件中
            out = new FileWriter(new File(outFile));
            Template temp = getTemplate(name);
            temp.process(root, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
    	Map<String,Object> map = new HashMap<String, Object>();
    	
    	String strValue = "this is String";
		Date myDate  = new Date();
		Object[] objectArray = new Object[]{1,"str",1.2};
		Set<Object> setData = new HashSet<Object>();
		setData.add("dataValue1");
		setData.add("dataValue2");
		setData.add("dataValue3");
		
		List<String> strList = new ArrayList<String>();
		strList.add("字符串1");
		strList.add("字符串2");
		strList.add("字符串3");
		
		Map<String, Object> paramMp = new HashMap<String, Object>();
		paramMp.put("key1", "value1");
		paramMp.put("key2", "value2");
		paramMp.put("key3", "value3");
		
		map.put("strValue", strValue);
		map.put("objectArray", objectArray);
		map.put("strList", strList);
		map.put("paramMp", paramMp);
		map.put("myDate", myDate);
		map.put("setData", setData);
	    String path=	System.getProperty("user.dir")+File.separator+"jmx"+File.separator+"test.xml";
    	
	   // fprint("test.ftl", map,"test.xml");
	    fprint("test.ftl", map,path);
    	print("test.ftl", map);
	}
}